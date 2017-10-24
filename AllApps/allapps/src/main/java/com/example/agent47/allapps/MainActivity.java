package com.example.agent47.allapps;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView installedApps = (ListView)findViewById(R.id.installed_apps_list);
        List<AppList> appLists = getInstalledApps();
        AppAdapter adapter = new AppAdapter(this,appLists);
        installedApps.setAdapter(adapter);

    }



    private List<AppList> getInstalledApps() {
        List<AppList> installedApps = new ArrayList<>();
        List<PackageInfo> packages = getPackageManager().getInstalledPackages(0);
        for(PackageInfo pack:packages) {
            if(!isSystemPackage(pack)) {
                String name = pack.applicationInfo.loadLabel(getPackageManager()).toString();
                Drawable icon = pack.applicationInfo.loadIcon(getPackageManager());
                installedApps.add(new AppList(name,icon));
            }
        }
        Collections.sort(installedApps);
        return installedApps;
    }

    private boolean isSystemPackage(PackageInfo packageInfo) {
        return ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0);
    }
}
