package com.superhero.superhero;

import com.facebook.AccessToken;

import lombok.Singleton;

@Singleton()
public class IdentityManager {
    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null && !accessToken.isExpired();

    }

    public String getIdentityId() {
        return com.facebook.Profile.getCurrentProfile().getId();
    }
}
