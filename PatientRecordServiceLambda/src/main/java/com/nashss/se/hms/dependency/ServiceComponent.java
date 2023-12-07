package com.nashss.se.hms.dependency;
import com.nashss.se.hms.activity.*;



import dagger.Component;
import javax.inject.Singleton;

/**
 * Dagger component for providing dependency injection in the Music Playlist Service.
 */
@Singleton
@Component(modules = {DaoModule.class, MetricsModule.class})
public interface ServiceComponent {

    /**
     * Provides the relevant activity.
     * @return AddPatientToPatientsActivity
     */
    AddPatientToPatientsActivity provideAddPatientToPatientsActivity();
    SearchPatientByNameActivity provideSearchPatientByNameActivity();

    CreatePatientDiagnosisActivity provideCreatePatientDiagnosisActivity();

    CreatePatientMedicationActivity provideCreatePatientMedicationActivity();

    GetPatientByPatientIdActivity provideGetPatientByPatientIdActivity();

    GetDiagnosisDetailsActivity provideGetDiagnosisDetailsActivity();

    GetMedicationDetailsActivity provideGetMedicationDetailsActivity();

    DeletePatientActivity provideDeletePatientActivity();

    DeleteDiagnosisActivity provideDeleteDiagnosisActivity();

    DeleteMedicationActivity provideDeleteMedicationActivity();

    UpdatePatientActivity provideUpdatePatientActivity();

    UpdateMedicationActivity provideUpdateMedicationActivity();
    UpdateDiagnosisActivity provideUpdateDiagnosisActivity();


}
