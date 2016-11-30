package com.github.kirillf.mockito.profile;

import android.accounts.Account;
import android.accounts.AccountManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

/**
 * Created by kirillf on 11/29/16.
 */
public class ProfileDataSourceTest {
    @Mock
    private ProfileService service;
    @Mock
    private AccountManager accountManager;

    private ProfileDataSource dataSource;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        dataSource = new ProfileDataSource(service);
    }


    @Test
    public void createProfileServiceCalled() throws Exception {
        dataSource.createProfile("", "", new RegistrationCallback() {
            @Override
            public void onSuccess(Account[] accounts) {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

        verify(service).registerAccount(any(Profile.class), any(RegistrationCallback.class));
    }

    @Test
    public void createAccountSuccess() throws Exception {
        RegistrationCallback callback = mock(RegistrationCallback.class);
        final Account[] accounts = new Account[0];

        ProfileService service = new AccountServiceImpl(accountManager);
        when(accountManager.getAccountsByType(anyString())).then(new Answer<Account[]>() {
            @Override
            public Account[] answer(InvocationOnMock invocation) throws Throwable {
                return accounts;
            }
        });


        ProfileDataSource ds = new ProfileDataSource(service);
        ds.createProfile("name", "surname", callback);
        verify(callback).onSuccess(accounts);

    }
}