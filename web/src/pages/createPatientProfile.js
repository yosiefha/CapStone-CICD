import PatientRecordClient from '../api/patientRecordClient';
import Header from '../components/header';
import BindingClass from '../util/bindingClass';
import DataStore from '../util/DataStore';

/**
 * Logic needed for the create playlist page of the website.
 */
class CreatePatientProfile extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'submit', 'redirectToViewPlaylist'], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.redirectToViewPlaylist);
        this.header = new Header(this.dataStore);
    }

    /**
     * Add the header to the page and load the MusicPlaylistClient.
     */
    mount() {
        document.getElementById('create').addEventListener('click', this.submit);

        this.header.addHeaderToPage();

        this.client = new PatientRecordClient();
    }

    /**
     * Method to run when the create playlist submit button is pressed. Call the MusicPlaylistService to create the
     * playlist.
     */
    async submit(evt) {
        evt.preventDefault();

        const errorMessageDisplay = document.getElementById('error-message');
        errorMessageDisplay.innerText = ``;
        errorMessageDisplay.classList.add('hidden');

        const createButton = document.getElementById('create');
        const origButtonText = createButton.innerText;
        createButton.innerText = 'Loading...';

        const firstName = document.getElementById('firstName').value;
        const lastName = document.getElementById('lastName').value;
        const contactNumber = document.getElementById('contactNumber').value;
        const dob = document.getElementById('dob').value;
        const emailAddress = document.getElementById('emailAddress').value;
        const address = document.getElementById('address').value;



        const patients = await this.client.addPatient(firstName, lastName, contactNumber,dob ,emailAddress ,address , (error) => {
            createButton.innerText = origButtonText;

            errorMessageDisplay.innerText = `Error: ${error.message}`;
            errorMessageDisplay.classList.remove('hidden');

        });
        this.dataStore.set('patients', patients);
         createButton.innerText = 'create patient profile';
    }

    /**
     * When the playlist is updated in the datastore, redirect to the view playlist page.
     */
    redirectToViewPlaylist() {
        const playlist = this.dataStore.get('playlist');
        if (playlist != null) {
            window.location.href = `/playlist.html?id=${playlist.id}`;
        }
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const createPatientProfile = new CreatePatientProfile();
    createPatientProfile.mount();
};

window.addEventListener('DOMContentLoaded', main);
