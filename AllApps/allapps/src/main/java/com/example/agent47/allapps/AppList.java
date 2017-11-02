package com.example.agent47.allapps;

import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;

/**
 * Created by agent47 on 24/10/17.
 */

public class AppList implements Comparable<AppList> {
    private String name;
    private Drawable icon;
    private PackageInfo pm;

    public AppList(String name, Drawable icon, PackageInfo pm) {
        this.name = name;
        this.icon = icon;
        this.pm = pm;
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

    public PackageInfo getPackageInfo() {
        return this.pm;
    }
}
