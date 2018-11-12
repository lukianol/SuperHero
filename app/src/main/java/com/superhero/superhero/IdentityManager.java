package com.superhero.superhero;

import com.facebook.AccessToken;

public class IdentityManager {
    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null && !accessToken.isExpired();
    }
}
