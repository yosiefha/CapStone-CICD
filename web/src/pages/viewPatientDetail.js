import PatientRecordClient from '../api/patientRecordClient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view playlist page of the website.
 */

 const SEARCH_CRITERIA_KEY = 'patientId';
 const SEARCH_RESULTS_KEY = 'search-results';

 const EMPTY_DATASTORE_STATE = {
     [SEARCH_CRITERIA_KEY]: '',
     [SEARCH_RESULTS_KEY]: [],

 };
class ViewPatientDetail extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount','addDiagnosis','showDiagnosisDetails','addMedication','showMedicationDetails'], this);
        this.dataStore = new DataStore();
        this.header = new Header(this.dataStore);

    }

    /**
     * Once the client is loaded, get the playlist metadata and song list.
     */
    async clientLoaded() {
        const urlParams = new URLSearchParams(window.location.search);
        const patientId = urlParams.get('id');
        document.getElementById('patient-name').innerText = "Loading Patient Details ...";
       const patient = await this.client.getPatient(patientId , (error)=>{
                                                    errorMessageDisplay.innerText = `Error: ${error.message}`;
                                                            errorMessageDisplay.classList.remove('hidden');
                                                            });
       document.getElementById('patient-full-name').innerText = patient.firstName+" "+patient.lastName;

    }



    /**
     * Add the header to the page and load the MusicPlaylistClient.
     */
    mount() {
        document.getElementById('add-diagnosis').addEventListener('click', this.addDiagnosis);
        document.getElementById('Show-Diagnosis-details').addEventListener('click', this.showDiagnosisDetails);
        document.getElementById('add-medication').addEventListener('click', this.addMedication);
        document.getElementById('Show-Medication-details').addEventListener('click', this.showMedicationDetails);
        this.header.addHeaderToPage();

        this.client = new PatientRecordClient();
        this.clientLoaded();
    }


    /**
     * When the songs are updated in the datastore, update the list of songs on the page.
     */
//    addSongsToPage() {
//        const songs = this.dataStore.get('songs')
//
//        if (songs == null) {
//            return;
//        }
//
//        let songHtml = '';
//        let song;
//        for (song of songs) {
//            songHtml += `
//                <li class="song">
//                    <span class="title">${song.title}</span>
//                    <span class="album">${song.album}</span>
//                </li>
//            `;
//        }
//        document.getElementById('songs').innerHTML = songHtml;
//    }

    /**
     * Method to run when the add song playlist submit button is pressed. Call the MusicPlaylistService to add a song to the
     * playlist.
     */
    async showDiagnosisDetails(evt) {
        evt.preventDefault();
        const errorMessageDisplay = document.getElementById('error-message');
        errorMessageDisplay.innerText = ``;
        errorMessageDisplay.classList.add('hidden');

        const showButton = document.getElementById('Show-Diagnosis-details');
        const origButtonText = showButton.innerText;
        showButton.innerText = 'Adding...';

        const urlParams = new URLSearchParams(window.location.search);
        const searchCriteria = urlParams.get('id');
        const previousSearchCriteria = this.dataStore.get(SEARCH_CRITERIA_KEY);

         if (previousSearchCriteria === searchCriteria ) {
                    return;
         }

         if(searchCriteria){

            const results = await this.client.getPatientDiagnosis(searchCriteria, (error)=>{
                           errorMessageDisplay.innerText = `Error: ${error.message}`;
                           errorMessageDisplay.classList.remove('hidden');
                           } );

            this.dataStore.setState({
                                [SEARCH_CRITERIA_KEY]: searchCriteria,
                                [SEARCH_RESULTS_KEY]: results,
                            });
         }else{
              this.dataStore.setState(EMPTY_DATASTORE_STATE);
         }
         showButton.innerText = 'Show Medication'
        const searchResultsDisplay = document.getElementById('diagnosis-details');
        this.displaySearchResults(searchResultsDisplay);

    }

      async showMedicationDetails(evt) {
            evt.preventDefault();
            const errorMessageDisplay = document.getElementById('error-message');
            errorMessageDisplay.innerText = ``;
            errorMessageDisplay.classList.add('hidden');

            const showButton = document.getElementById('add-medication');
            const origButtonText = showButton.innerText;
            showButton.innerText = 'Adding...';

            const urlParams = new URLSearchParams(window.location.search);
            const searchCriteria = urlParams.get('id');
            const previousSearchCriteria = this.dataStore.get(SEARCH_CRITERIA_KEY);

             if (previousSearchCriteria === searchCriteria ) {
                        return;
             }

             if(searchCriteria){

                const results = await this.client.getPatientDiagnosis(searchCriteria, (error)=>{
                               errorMessageDisplay.innerText = `Error: ${error.message}`;
                               errorMessageDisplay.classList.remove('hidden');
                               } );

                this.dataStore.setState({
                                    [SEARCH_CRITERIA_KEY]: searchCriteria,
                                    [SEARCH_RESULTS_KEY]: results,
                                });
             }else{
                  this.dataStore.setState(EMPTY_DATASTORE_STATE);
             }
            const searchResultsDisplay = document.getElementById('medication-details');
            this.displaySearchResults(searchResultsDisplay);

        }

    /**
         * Pulls search results from the datastore and displays them on the html page.
         */
        displaySearchResults(searchResultsDisplay) {
            const searchCriteria = this.dataStore.get(SEARCH_CRITERIA_KEY);
            const searchResults = this.dataStore.get(SEARCH_RESULTS_KEY);

           // const searchResultsDisplay = document.getElementById('diagnosis-details');

            if (searchCriteria === '') {
                searchResultsDisplay.innerHTML = '';
            } else {
              searchResultsDisplay.innerHTML = this.getHTMLForSearchResults(searchResults);
            }
        }

          getHTMLForSearchResults(searchResults) {
                if (searchResults.length === 0) {
                    return '<h4>No results found</h4>';
                }

                let html = '<table><tr><th>diagnosisId</th><th>healthcareProfessionalId</th><th>Date Created</th><th>description</th></tr>';
                let i = 0;

                for (const res of searchResults) {


                    html += `
                    <tr>
                        <td>${res.diagnosisId}</td>
                        <td>${res.healthcareProfessionalId}</td>
                        <td>${res.dateCreated}</td>
                        <td>${res.description}</td>

                    </tr>`;
                    i+=1;
                }
                html += '</table>';



                return html;
            }

    async addDiagnosis(evt) {
            evt.preventDefault();
            const errorMessageDisplay = document.getElementById('error-message');
            errorMessageDisplay.innerText = ``;
            errorMessageDisplay.classList.add('hidden');

            const addButton = document.getElementById('add-diagnosis');
            const origButtonText = addButton.innerText;
            addButton.innerText = 'Adding...';

            const urlParams = new URLSearchParams(window.location.search);
            const patientId = urlParams.get('id');
            const description = document.getElementById('description').value;


            const diagnosisResult = await this.client.addDiagnosis(patientId,description, (error) => {
                addButton.innerText = origButtonText;
                errorMessageDisplay.innerText = `Error: ${error.message}`;
                errorMessageDisplay.classList.remove('hidden');
            });

            this.dataStore.set('diagnoses', diagnosisResult);
            addButton.innerText = 'Add diagnosis'

        }

        async addMedication(evt) {
                    evt.preventDefault();
                    const errorMessageDisplay = document.getElementById('error-message');
                    errorMessageDisplay.innerText = ``;
                    errorMessageDisplay.classList.add('hidden');

                    const addButton = document.getElementById('add-medication');
                    const origButtonText = addButton.innerText;
                    addButton.innerText = 'Adding...';

                    const urlParams = new URLSearchParams(window.location.search);
                    const patientId = urlParams.get('id');
                    const medicationName = document.getElementById('medicationName').value;
                    const dosage = document.getElementById('dosage').value;
                    const startDate = document.getElementById('startDate').value;
                    const endDate = document.getElementById('endDate').value;
                    const instruction = document.getElementById('instruction').value;


                    const medicationResult = await this.client.addMedication(medicationName,dosage,startDate,endDate,instruction,patientId, (error) => {
                        addButton.innerText = origButtonText;
                        errorMessageDisplay.innerText = `Error: ${error.message}`;
                        errorMessageDisplay.classList.remove('hidden');
                    });

                    this.dataStore.set('medication', medicationResult);
                    addButton.innerText = 'Add Medication'

                }

}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const viewPatientDetail = new ViewPatientDetail();
    viewPatientDetail.mount();
};

window.addEventListener('DOMContentLoaded', main);
