package com.example.tabwidgetsample;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        String tab1indicator = res.getString(R.string.tab1_indicator);
        String tab2indicator = res.getString(R.string.tab2_indicator);
        String tab3indicator = res.getString(R.string.tab3_indicator);
        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;
        intent = new Intent().setClass(this, StudentActivity.class);
        spec = tabHost.newTabSpec("student").setIndicator(tab1indicator).setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, TeachersActivity.class);
        spec = tabHost.newTabSpec("teachers").setIndicator(tab2indicator).setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, ClassesActivity.class);
        spec = tabHost.newTabSpec("student").setIndicator(tab3indicator).setContent(intent);
        tabHost.addTab(spec);
    }
}