package com.project.android.appportfolio;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Portfolio extends AppCompatActivity implements OnItemClickListener  {

    private final String[] projectList = {
            "SPOTIFY STREAMER",
            "SCORES APP",
            "LIBRARY APP",
            "BUILD IT BIGGER",
            "XYZ READER",
            "CAPSTONE: MY OWN APP"
    };

    private Toast projectToast;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);

        ListView lv = (ListView)findViewById(R.id.listView);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View header = inflater.inflate(R.layout.header, lv, false);
        lv.addHeaderView(header, null, false);

        ProjectListAdapter adapter = new ProjectListAdapter(this, projectList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

        projectToast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.action_settings:
               return true;

           default:
               return true;
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_portfolio, menu);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString().split(":")[0].toLowerCase().split(" app")[0];
        projectToast.setText("This button will launch my " + item + " app");
        projectToast.show();
    }

}
