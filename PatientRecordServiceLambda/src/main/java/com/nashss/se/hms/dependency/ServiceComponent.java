package com.nashss.se.hms.dependency;
import com.nashss.se.hms.activity.AddPatientToPatientsActivity;


import com.nashss.se.hms.activity.CreateGoalActivity;
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
    CreateGoalActivity provideCreateGoalActivity();


}
