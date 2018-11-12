package com.superhero.superhero;

import android.app.Activity;
import android.content.Intent;

public class NavigationManager {
    public void navigateTo(Activity activity, Class<?> to) {
        Intent intent = new Intent(activity, to);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
    }
}
