package com.example.tabwidgetsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class TeachersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources res = getResources();
        String contentText = res.getString(R.string.tab2_content);
        TextView textView = new TextView(this);
        textView.setText(contentText);
        setContentView(R.layout.activity_teachers);
    }
}