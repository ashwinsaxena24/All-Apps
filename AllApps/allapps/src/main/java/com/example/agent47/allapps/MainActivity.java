package com.example.agent47.allapps;

import android.app.WallpaperManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<AppList> appLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWallpaper();
        GridView installedApps = (GridView) findViewById(R.id.installed_apps_list);
        appLists = getInstalledApps();
        AppAdapter adapter = new AppAdapter(this,appLists);
        installedApps.setAdapter(adapter);
        installedApps.setOnItemClickListener(this);
    }

    private List<AppList> getInstalledApps() {
        List<AppList> installedApps = new ArrayList<>();
        List<PackageInfo> packages = getPackageManager().getInstalledPackages(0);
        for(PackageInfo pack:packages) {
            if(!isSystemPackage(pack)) {
                String name = pack.applicationInfo.loadLabel(getPackageManager()).toString();
                Drawable icon = pack.applicationInfo.loadIcon(getPackageManager());
                installedApps.add(new AppList(name,icon,pack));
            }
        }
        Collections.sort(installedApps);
        return installedApps;
    }

    private boolean isSystemPackage(PackageInfo packageInfo) {
        return ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0);
    }

    private void setWallpaper() {
        WallpaperManager manager = WallpaperManager.getInstance(this);
        Drawable wallpaper = manager.getFastDrawable();
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.main);
        layout.setBackground(wallpaper);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        AppList pack = appLists.get(position);
        ApplicationInfo app = pack.getPackageInfo().applicationInfo;
        startActivity(getPackageManager().getLaunchIntentForPackage(app.packageName));
    }
}
