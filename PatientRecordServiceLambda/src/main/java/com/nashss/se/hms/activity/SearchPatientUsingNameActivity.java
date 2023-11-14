package com.nashss.se.hms.activity;

import com.nashss.se.hms.activity.requests.SearchPatientUsingNameRequest;
import com.nashss.se.hms.activity.results.SearchPatientUsingNameResult;
import com.nashss.se.hms.dynamodb.PatientDAO;
import com.nashss.se.hms.dynamodb.models.Patient;

import javax.inject.Inject;

import static com.nashss.se.hms.utils.NullUtils.ifNull;

public class SearchPatientUsingNameActivity {

    private final PatientDAO patientDAO;
    /**
     * Instantiates a new SearchPatientUsingNameActivity object.
     *
     * @param patientDAO PatientDAO to access the patients table.
     */
    @Inject
    public SearchPatientUsingNameActivity(PatientDAO patientDAO) {
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
//    public SearchPatientUsingNameResult handleRequest(final SearchPatientUsingNameRequest searchPatientUsingNameRequest) {
//
//        String criteria = ifNull( searchPatientUsingNameRequest.getCriteria(), "");
//        String[] criteriaArray = criteria.isBlank() ? new String[0] : criteria.split("\\s");
//
//        Patient results = patientDAO.(criteriaArray);
//        List<PlaylistModel> playlistModels = new ModelConverter().toPlaylistModelList(results);
//
//        return SearchPlaylistsResult.builder()
//                .withPlaylists(playlistModels)
//                .build();
//    }
}



