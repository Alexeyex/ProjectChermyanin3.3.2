package com.example.projectchermyanin2;

import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private Spinner mLanguageSpinner;
    private Spinner mColourSpinner;
    private Spinner mMarginSpinner;
    private Button mBtnOk;
    private static @StyleRes int themeRes = R.style.AppThemeGreen;
    private static @StyleRes int themeRes1 = R.style.Margin3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(themeRes);
        setTheme(themeRes1);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initSpinnerLanguage() {
        ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLanguageSpinner.setAdapter(adapterLanguages);
    }
    private void initSpinnerMargin() {
        ArrayAdapter<CharSequence> adapterMargins = ArrayAdapter.createFromResource(this, R.array.margin, android.R.layout.simple_spinner_item);
        adapterMargins.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMarginSpinner.setAdapter(adapterMargins);
    }
    private void initSpinnerColour() {
        ArrayAdapter<CharSequence> adapterColours = ArrayAdapter.createFromResource(this, R.array.colour, android.R.layout.simple_spinner_item);
        adapterColours.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mColourSpinner.setAdapter(adapterColours);
    }


    private void initViews() {
        mLanguageSpinner = findViewById(R.id.languageSpinner);
        mColourSpinner = findViewById(R.id.colourSpinner);
        mMarginSpinner = findViewById(R.id.marginSpinner);
        mBtnOk = findViewById(R.id.btnOk);
        mBtnOk.setOnClickListener(v -> {

            switch (mLanguageSpinner.getSelectedItem().toString()) {
                case "Русский":
                    Locale locale = new Locale("ru");
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                    break;
                case "English":
                    locale = new Locale("en");
                    config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                    break;
            }


            switch (mColourSpinner.getSelectedItem().toString()) {
                case "Зеленый":
                    themeRes = R.style.AppThemeGreen;
                    break;
                case "Синий":
                    themeRes = R.style.AppThemeBlue;
                    break;
                case "Черный":
                    themeRes = R.style.AppThemeBlack;
                    break;
            }

            switch (mMarginSpinner.getSelectedItem().toString()) {
                case "Мелкие":
                    themeRes1 = R.style.Margin1;
                    break;
                case "Средние":
                    themeRes1 = R.style.Margin2;
                    break;
                case "Большие":
                    themeRes1 = R.style.Margin3;;
                    break;
            }

            recreate();

        });
        initSpinnerLanguage();
        initSpinnerColour();
        initSpinnerMargin();
    }
}
