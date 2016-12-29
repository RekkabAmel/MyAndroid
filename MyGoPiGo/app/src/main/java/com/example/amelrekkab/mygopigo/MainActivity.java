package com.example.amelrekkab.mygopigo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends ActionBarActivity {
    AlertDialogManager alert = new AlertDialogManager();
    boolean bool_connect = false;
    WifiManager wifiManager;
    Button btn_connect;
    Button btn_manuel;
    Button btn_auto;
    Button btnReceive;
    boolean isDisconnectCheckedButton = false;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    //  MediaPlayer son;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Intent intentStat = new Intent(MainActivity.this, stat.class);

        wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_connect = (Button) findViewById(R.id.btnConnect);

        btnReceive = (Button) findViewById(R.id.Receive);


        // Gestion des boutons ..



        btn_connect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /****
                 * Lancement du module WiFi ...
                 */
                if (bool_connect) {
                    bool_connect = false;
                    btn_connect.setText("CONNECT");
                    btn_connect.setBackgroundColor(Color.GREEN);
                    wifiManager.setWifiEnabled(false);

                } else {
                    bool_connect = true;
                    btn_connect.setText("DISCONNECT");
                    btn_connect.setBackgroundColor(Color.RED);
                    if (!wifiManager.isWifiEnabled()) {
                        wifiManager.setWifiEnabled(true);
                    }
                }

            }
        });

        btnReceive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (bool_connect) {

                    startActivity(intentStat);
                } else {
                    alert.showAlertDialog(MainActivity.this,
                            "Login failed..",
                            "You have to enable your Wifi.", false);
                }
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Cliquez sur l'élément de la barre d'action pour cliquer ici. La barre d'action
        // gère automatiquement les clics sur le bouton Home / Up, tant
        // lorsque vous spécifiez une activité parent dans AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.about) {

            return true;
        }
        if (id == R.id.other) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onPause() {
        super.onPause();
// Toujours appeler la méthode superclasse en premier


    }

    public void onResume() {
        super.onResume();
// Toujours appeler la méthode superclasse en premier

        if (!isDisconnectCheckedButton) {
            btn_connect.setText("CONNECT");
            btn_connect.setBackgroundColor(Color.GREEN);
            bool_connect = false;
        }
        if (wifiManager.isWifiEnabled()) {

            bool_connect = true;
            btn_connect.setBackgroundColor(Color.RED);
            btn_connect.setText("DISCONNECT");
        }

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page")// TODO: Définit un titre pour le contenu affiché.
                // TODO: Assurez-vous que cette URL générée automatiquement est correcte.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
