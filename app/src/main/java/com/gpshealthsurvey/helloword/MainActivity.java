package com.gpshealthsurvey.helloword;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.MenuItem;

import com.gpshealthsurvey.helloword.MenuListItem;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MenuListItem> menuItems = new ArrayList<MenuListItem>();
        MenuListItem markWaypoint = new MenuListItem("Mark House","mark a household with GPS","mark");
        MenuListItem sync = new MenuListItem("Sync","upload and download data","sync");
        MenuListItem navigate = new MenuListItem("Navigate","navigate to a household","nav");
        menuItems.add(markWaypoint);
        menuItems.add(sync);
        menuItems.add(navigate);

        MenuAdaptor adaptor = new MenuAdaptor(menuItems);
        ListView menuView = (ListView) findViewById(R.id.menuList);
        menuView.setAdapter(adaptor);
        menuView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent markIntent = new Intent(parent.getContext(),MarkHouse.class);
                    startActivity(markIntent);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this,SettingsActivity.class);
            startActivity(settingsIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}
