package com.superhero.superhero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NavigationManager navigator = new NavigationManager();

        if (new IdentityManager().isLoggedIn()) {
            navigator.navigateTo(this, HelpActivity.class);
        } else {
            navigator.navigateTo(this, MainActivity.class);
        }
    }
}
