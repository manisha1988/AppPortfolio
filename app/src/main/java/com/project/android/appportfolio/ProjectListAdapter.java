package com.project.android.appportfolio;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

/**
 * Created by ManishaKedia on 19/12/2015.
 */
class ProjectListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] projectList;

    public ProjectListAdapter(Activity context, String[] projectList){
        super(context, R.layout.row, projectList);
        this.context = context;
        this.projectList = projectList;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Log.d("CustomArrayAdapter", String.valueOf(position));
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.row, null);
        Button btnProj = (Button) rowView.findViewById(R.id.projButton);
        btnProj.setText(projectList[position]);
        if(position == projectList.length - 1)
            btnProj.setBackgroundColor(0xFFe91e63);
        return rowView;
    }
}
