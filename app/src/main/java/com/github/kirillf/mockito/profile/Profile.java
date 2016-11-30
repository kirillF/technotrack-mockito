package com.github.kirillf.mockito.profile;

/**
 * Created by kirillf on 11/29/16.
 */

public class Profile {
    private final String name;
    private final String surname;

    public Profile(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
