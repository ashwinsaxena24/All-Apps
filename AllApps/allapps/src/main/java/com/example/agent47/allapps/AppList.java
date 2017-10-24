package com.example.agent47.allapps;

import android.graphics.drawable.Drawable;

/**
 * Created by agent47 on 24/10/17.
 */

public class AppList implements Comparable<AppList> {
    private String name;
    private Drawable icon;

    public AppList(String name,Drawable icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return this.name;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int compareTo(AppList app) {
        return this.name.compareTo(app.getName());
    }
}
