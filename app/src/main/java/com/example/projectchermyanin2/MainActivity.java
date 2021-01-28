package com.example.projectchermyanin2;

import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private Spinner mLanguageSpinner;
    private Spinner mColourSpinner;
    private Button mBtnOk;
    private static @StyleRes int themeRes = R.style.AppThemeGreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initSpinnerLanguage() {
        ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLanguageSpinner.setAdapter(adapterLanguages);
    }
    private void initSpinnerColour() {
        ArrayAdapter<CharSequence> adapterColours = ArrayAdapter.createFromResource(this, R.array.colour, android.R.layout.simple_spinner_item);
        adapterColours.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mColourSpinner.setAdapter(adapterColours);
    }


    private void initViews() {
        setTheme(themeRes);
        mLanguageSpinner = findViewById(R.id.languageSpinner);
        mColourSpinner = findViewById(R.id.colourSpinner);
        mBtnOk = findViewById(R.id.btnOk);
        mBtnOk.setOnClickListener(v -> {
            if (mLanguageSpinner.getSelectedItem().toString().equals("Русский")) {
                Locale locale = new Locale("ru");
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
            if (mLanguageSpinner.getSelectedItem().toString().equals("English")) {
                Locale locale = new Locale("en");
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
            if (mColourSpinner.getSelectedItem().toString().equals("Зеленый")) {
                themeRes = R.style.AppThemeGreen;

            }
            if (mColourSpinner.getSelectedItem().toString().equals("Синий")){
                themeRes = R.style.AppThemeBlue;
            }
            if (mColourSpinner.getSelectedItem().toString().equals("Черный")){
                themeRes = R.style.AppThemeBlack;
            }
            recreate();
        });
        initSpinnerLanguage();
        initSpinnerColour();
    }
}
