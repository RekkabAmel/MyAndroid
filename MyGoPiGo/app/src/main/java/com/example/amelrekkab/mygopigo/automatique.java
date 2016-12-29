package com.example.amelrekkab.mygopigo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Amel Rekkab on 21/12/2016.
 */

public class automatique extends MainActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent intentManuel = new Intent(this, MainActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.automatique);
        Button btnDisconAuto =(Button)findViewById(R.id.serrvo4);
        btnDisconAuto.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                btn_connect.setText("CONNECT");
                wifiManager.setWifiEnabled(false);
                isDisconnectCheckedButton= true;
                automatique.this.finish();
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate le menu; Cela ajoute des éléments à la barre d'action s'il est présent.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Cliquez sur l'élément de la barre d'action pour cliquer ici. La barre d'action
        // gère automatiquement les clics sur le bouton Home / Up, tant
        // lorsque vous spécifiez une activité parent dans AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.about){

            return true;
        }
        if (id == R.id.other) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
