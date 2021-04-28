package com.genet.sharedpreferencekullanimi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPref;
    Button btnSharedPreferenceYaz, getBtnSharedPreferenceOku;
EditText etAdSoyad,etSehir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAdSoyad = (EditText)findViewById(R.id.etAdSoyad);
        etSehir = (EditText)findViewById(R.id.etSehir);

        btnSharedPreferenceYaz = (Button) findViewById(R.id.btnSharedPreferenceYaz);
        getBtnSharedPreferenceOku = (Button) findViewById(R.id.btnSharedPreferenceOku);

        sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        getSharedPreferences();


        btnSharedPreferenceYaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferencesYaz = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesYaz.edit();
                editor.putString("AdSoyad", etAdSoyad.getText().toString());
                editor.putString("Sehir", etSehir.getText().toString());
                editor.apply();
            }
        });


        getBtnSharedPreferenceOku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Eğer aranılan AdSoyad sharedPreference de yok ise defValue değeri geri döndürülür.
                String AdSoyad = sharedPref.getString("AdSoyad", "NoName");
                String Sehir = sharedPref.getString("Sehir", "NoCity");
                Toast.makeText(MainActivity.this, AdSoyad, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, Sehir, Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void getSharedPreferences() {


        //Eğer aranılan AdSoyad sharedPreference de yok ise defValue değeri geri döndürülür.
        String AdSoyad = sharedPref.getString("AdSoyad", "NoName");
        String Sehir = sharedPref.getString("Sehir", "NoCity");
        Toast.makeText(MainActivity.this, AdSoyad, Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, Sehir, Toast.LENGTH_SHORT).show();
    }
}