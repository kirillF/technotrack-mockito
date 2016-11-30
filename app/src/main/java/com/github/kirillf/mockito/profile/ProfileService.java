package com.github.kirillf.mockito.profile;

/**
 * Created by kirillf on 11/29/16.
 */

public interface ProfileService {

    void registerAccount(Profile profile, RegistrationCallback callback);

}
