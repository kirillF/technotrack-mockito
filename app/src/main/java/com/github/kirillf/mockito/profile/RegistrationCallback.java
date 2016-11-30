package com.github.kirillf.mockito.profile;

import android.accounts.Account;

/**
 * Created by kirillf on 11/29/16.
 */

public interface RegistrationCallback {
    void onSuccess(Account[] accounts);
    void onError(Throwable throwable);
}
