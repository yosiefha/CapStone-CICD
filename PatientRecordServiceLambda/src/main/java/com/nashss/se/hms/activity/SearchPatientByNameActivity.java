package com.nashss.se.hms.activity;

import com.nashss.se.hms.activity.requests.SearchPatientByNameRequest;
import com.nashss.se.hms.activity.results.AddPatientToPatientsResult;
import com.nashss.se.hms.activity.results.SearchPatientByNameResult;
import com.nashss.se.hms.converters.ModelConverter;
import com.nashss.se.hms.dynamodb.PatientDAO;
import com.nashss.se.hms.dynamodb.models.Patient;
import com.nashss.se.hms.models.PatientModel;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static com.nashss.se.hms.utils.NullUtils.ifNull;

public class SearchPatientByNameActivity {

    private final PatientDAO patientDAO;
    /**
     * Instantiates a new SearchPatientUsingNameActivity object.
     *
     * @param patientDAO PatientDAO to access the patients table.
     */
    @Inject
    public SearchPatientByNameActivity(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    /**
     * This method handles the incoming request by searching for playlist from the database.
     * <p>
     * It then returns the matching playlists, or an empty result list if none are found.
     *
     * @param searchPatientUsingNameRequest request object containing the search criteria
     * @return searchPlaylistsResult result object containing the playlists that match the
     * search criteria.
     */
    public SearchPatientByNameResult handleRequest(final SearchPatientByNameRequest searchPatientUsingNameRequest) {

        String firstName = searchPatientUsingNameRequest.getFirstName();
        String lastName = searchPatientUsingNameRequest.getLastName();
        List<Patient> patientlist = patientDAO.searchPatient(firstName,lastName);
        List<PatientModel> patientModelList = new ArrayList<>();
        for(Patient patient: patientlist){
            patientModelList.add(new ModelConverter().toPatientModel(patient));

        }
        return SearchPatientByNameResult.builder()
                .withPatientList(patientModelList)
                .build();


    }
}



