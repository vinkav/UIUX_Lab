package com.example.metropicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String CUSTOM_ACTION = "android.intent.action.ListViewActivity";
    String SHARED_KEY = "mysettings";
    String STATION_KEY = "station_name";
    String selectedName = "";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_KEY, Context.MODE_PRIVATE);
        selectedName = sharedPreferences.getString(STATION_KEY, "");

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(selectedName.isEmpty()? "Оберіть станцію" : selectedName);

        Intent intent = getIntent();
        String intendAction = intent.getAction();
        Toast.makeText(this, intendAction, Toast.LENGTH_SHORT).show();
    }

    public void onButtonPressed(View v){
        Intent intent = new Intent();
        intent.setAction(CUSTOM_ACTION);
        startActivityForResult(intent , 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                selectedName = data.getStringExtra("result");
                textView = (TextView) findViewById(R.id.textView);
                textView.setText(selectedName.isEmpty()? "Оберіть станцію" : selectedName);

                saveStation(selectedName);
            }
        }
    }

    private void saveStation(String stationName){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(STATION_KEY, stationName);
        editor.commit();
    }
}