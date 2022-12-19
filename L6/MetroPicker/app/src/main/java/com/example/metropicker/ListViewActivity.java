package com.example.metropicker;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources r = getResources();
        String[] stationsArray = r.getStringArray(R.array.station);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.list_item, stationsArray);
        setListAdapter(aa);

        Intent intent = getIntent();
        String intendAction = intent.getAction();
        Toast.makeText(this, intendAction, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        CharSequence text = ((TextView) v).getText();
        Intent intent = new Intent();
        intent.putExtra("result", text);
        setResult(RESULT_OK, intent);
        this.finish();
        super.onBackPressed();
    }
}