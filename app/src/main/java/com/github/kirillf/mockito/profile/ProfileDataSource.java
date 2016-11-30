package com.github.kirillf.mockito.profile;

/**
 * Created by kirillf on 11/29/16.
 */

public class ProfileDataSource {

    private final ProfileService service;

    public ProfileDataSource(ProfileService service) {
        this.service = service;
    }

    public void createProfile(String name, String surname, RegistrationCallback callback) {
        final Profile profile = new Profile(name, surname);
        service.registerAccount(profile, callback);
    }
}
