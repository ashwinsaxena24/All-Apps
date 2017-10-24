package com.example.agent47.allapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by agent47 on 24/10/17.
 */

public class AppAdapter extends BaseAdapter {

    static class ViewHolder {
        TextView text;
        ImageView icon;
    }

    private LayoutInflater layoutInflater;
    private List<AppList> appLists;

    public AppAdapter(Context context,List<AppList> appLists) {
        layoutInflater = (LayoutInflater.from(context));
        this.appLists = appLists;
    }

    @Override
    public int getCount() {
        return appLists.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public Object getItem(int position) {
        return appLists.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder listViewHolder;
        if(convertView == null) {
            listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.installed_apps_list,parent,false);

            listViewHolder.text = convertView.findViewById(R.id.list_app_name);
            listViewHolder.icon = convertView.findViewById(R.id.app_icon);
            convertView.setTag(listViewHolder);
        }
        else {
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.text.setText(appLists.get(position).getName());
        listViewHolder.icon.setImageDrawable(appLists.get(position).getIcon());
        return convertView;
    }
}
