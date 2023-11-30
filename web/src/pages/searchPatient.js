
import PatientRecordClient from '../api/patientRecordClient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/*
The code below this comment is equivalent to...
const EMPTY_DATASTORE_STATE = {
    'search-criteria': '',
    'search-results': [],
};

...but uses the "KEY" constants instead of "magic strings".
The "KEY" constants will be reused a few times below.
*/

const SEARCH_CRITERIA_KEY = 'firstName';
const SEARCH_CRITERIA_KEY1 = 'lastName';
const SEARCH_RESULTS_KEY = 'search-results';
const EMPTY_DATASTORE_STATE = {
    [SEARCH_CRITERIA_KEY]: '',
    [SEARCH_CRITERIA_KEY1]: '',
    [SEARCH_RESULTS_KEY]: [],
};


/**
 * Logic needed for the view playlist page of the website.
 */
class SearchPatient extends BindingClass {
    constructor() {
        super();

        this.bindClassMethods(['mount', 'search', 'displaySearchResults', 'getHTMLForSearchResults'], this);

        // Create a enw datastore with an initial "empty" state.
        this.dataStore = new DataStore(EMPTY_DATASTORE_STATE);
        this.header = new Header(this.dataStore);
        this.dataStore.addChangeListener(this.displaySearchResults);
        console.log("searchPatient constructor");
    }

    /**
     * Add the header to the page and load the MusicPlaylistClient.
     */
    mount() {
        // Wire up the form's 'submit' event and the button's 'click' event to the search method.
        document.getElementById('search-patient-form').addEventListener('submit', this.search);
        document.getElementById('search-btn').addEventListener('click', this.search);

        this.header.addHeaderToPage();

        this.client = new PatientRecordClient();
        this.s
    }

    /**
     * Uses the client to perform the search,
     * then updates the datastore with the criteria and results.
     * @param evt The "event" object representing the user-initiated event that triggered this method.
     */
    async search(evt) {
             evt.preventDefault();

             const errorMessageDisplay = document.getElementById('error-message');
             errorMessageDisplay.innerText = "";
             errorMessageDisplay.classList.add('hidden');

            const searchCriteria = document.getElementById('firstName').value;
            const searchCriteria1 = document.getElementById('lastName').value;
            const previousSearchCriteria = this.dataStore.get(SEARCH_CRITERIA_KEY);
            const previousSearchCriteria1 = this.dataStore.get(SEARCH_CRITERIA_KEY1);

    if (previousSearchCriteria === searchCriteria && previousSearchCriteria1 === searchCriteria1) {
            return;
        }
      if (searchCriteria && searchCriteria1) {
                const results = await this.client.search(searchCriteria, searchCriteria1, (error)=>{
                errorMessageDisplay.innerText = `Error: ${error.message}`;
                errorMessageDisplay.classList.remove('hidden');
                } );


                this.dataStore.setState({
                    [SEARCH_CRITERIA_KEY]: searchCriteria,
                    [SEARCH_CRITERIA_KEY1]: searchCriteria1,
                    [SEARCH_RESULTS_KEY]: results,
                });
            } else {
                this.dataStore.setState(EMPTY_DATASTORE_STATE);
            }

        this.displaySearchResults();

    }

    /**
     * Pulls search results from the datastore and displays them on the html page.
     */
    displaySearchResults() {
        const searchCriteria = this.dataStore.get(SEARCH_CRITERIA_KEY);
        const searchCriteria1 = this.dataStore.get(SEARCH_CRITERIA_KEY1);
        const searchResults = this.dataStore.get(SEARCH_RESULTS_KEY);

        const searchResultsContainer = document.getElementById('search-results-container');
        const searchCriteriaDisplay = document.getElementById('search-criteria-display');
        const searchResultsDisplay = document.getElementById('search-results-display');

        if (searchCriteria === '' && searchCriteria1 === '') {
            searchResultsContainer.classList.add('hidden');
            searchCriteriaDisplay.innerHTML = '';
            searchResultsDisplay.innerHTML = '';
        } else {
            searchResultsContainer.classList.remove('hidden');
            searchCriteriaDisplay.innerHTML = `"${searchCriteria}  ${searchCriteria1}"`;

            searchResultsDisplay.innerHTML = this.getHTMLForSearchResults(searchResults);
        }
    }

    /**
     * Create appropriate HTML for displaying searchResults on the page.
     * @param searchResults An array of playlists objects to be displayed on the page.
     * @returns A string of HTML suitable for being dropped on the page.
     */
   getHTMLForSearchResults(searchResults) {
        if (searchResults.length === 0) {
            return '<h4>No results found</h4>';
        }

        let html = '<table><tr><th>PatientId</th><th>First Name</th><th>Last Name</th><th>Date of Birth</th><th>Contact Number</th><th>emailAddress</th><th>Address</th></tr>';
        let i = 0;

        for (const res of searchResults) {


            html += `
            <tr>
                <td>
                    <a href="viewPatientHistory.html?id=${res.patientId}">${res.patientId}</a>
                </td>
                <td>${res.firstName}</td>
                <td>${res.lastName}</td>
                <td>${res.dob}</td>
                <td>${res.contactNumber}</td>
                <td>${res.emailAddress}</td>
                <td>${res.address}</td>
            </tr>`;
            i+=1;
        }
        html += '</table>';



        return html;
    }



}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const searchPatient = new SearchPatient();
    searchPatient.mount();

};

window.addEventListener('DOMContentLoaded', main);
