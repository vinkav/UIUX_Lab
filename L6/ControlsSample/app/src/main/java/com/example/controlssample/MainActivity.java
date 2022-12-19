package com.example.controlssample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String SHARED_KEY = "mysettings";
    String CHECKBOX_KEY = "checkbox_value";
    String TOGGLE_KEY = "toggle_value";
    String RADIO_BUTTON_KEY = "radio_button_value";
    String TEXT_EDIT_KEY = "text_edit_value";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_KEY, Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText userName = (EditText) findViewById(R.id.user_name);
        userName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    CharSequence name = userName.getText();
                    Toast.makeText(getApplicationContext(), userName.getText(), Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(TEXT_EDIT_KEY, name.toString());
                    editor.commit();
                    return true;
                }
                return false;
            }
        });
        restoreSettings();
    }

    public void onButtonClicked(View v) {
        Toast.makeText(this, "Button pressed", Toast.LENGTH_SHORT).show();
    }

    public void onCheckboxClicked(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_KEY, Context.MODE_PRIVATE);
        if (((CheckBox) v).isChecked()) {
            Toast.makeText(this, "Noted", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(CHECKBOX_KEY, true);
            editor.commit();
        } else {
            Toast.makeText(this, "Will not notice", Toast.LENGTH_SHORT).show();
        }
    }

    public void onToggleClciked(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_KEY, Context.MODE_PRIVATE);
        if (((ToggleButton) v).isChecked()) {
            Toast.makeText(this, "Enabled", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(TOGGLE_KEY, true);
            editor.commit();
        } else {
            Toast.makeText(this, "Disabled", Toast.LENGTH_SHORT).show();
        }
    }

    public void obRadioButtonClicked(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_KEY, Context.MODE_PRIVATE);
        RadioButton rb = (RadioButton) v;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(RADIO_BUTTON_KEY, rb.getText().toString());
        editor.commit();
        Toast.makeText(this, "Chosen animal: " + rb.getText(), Toast.LENGTH_SHORT).show();
    }

    private void restoreSettings() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_KEY, Context.MODE_PRIVATE);
        boolean isCheckBox = sharedPreferences.getBoolean(CHECKBOX_KEY, false);
        boolean isToggle = sharedPreferences.getBoolean(TOGGLE_KEY, false);
        String isRadio = sharedPreferences.getString(RADIO_BUTTON_KEY, "");
        String name = sharedPreferences.getString(TEXT_EDIT_KEY, "");

        if(isCheckBox){
            CheckBox checkBox = (CheckBox) findViewById(R.id.my_checkbox);
            checkBox.setChecked(true);
        }
        if(isToggle){
            ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggle);
            toggleButton.setChecked(true);
        }
        switch (isRadio){
            case "Dog":
                RadioButton bogButton = (RadioButton) findViewById(R.id.radio_dog);
                bogButton.setChecked(true);
                break;
            case "Cat":
                RadioButton catButton = (RadioButton) findViewById(R.id.radio_cat);
                catButton.setChecked(true);
                break;
            case "Rabbit":
                RadioButton RabbitButton = (RadioButton) findViewById(R.id.radio_rabbit);
                RabbitButton.setChecked(true);
                break;
            default:
                break;
        }
        final EditText userName = (EditText) findViewById(R.id.user_name);
        userName.setText(name);
    }
}