package com.github.kirillf.mockito.profile;

import android.accounts.Account;
import android.accounts.AccountManager;

/**
 * Created by kirillf on 11/29/16.
 */

public class AccountServiceImpl implements ProfileService {
    private AccountManager accountManager;

    public AccountServiceImpl(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    @Override
    public void registerAccount(Profile profile, RegistrationCallback callback) {
        if (profile.getName() == null || profile.getSurname() == null) {
            callback.onError(new Exception());
            return;
        }
        Account[] accounts = accountManager.getAccountsByType("");
        callback.onSuccess(accounts);
    }
}
