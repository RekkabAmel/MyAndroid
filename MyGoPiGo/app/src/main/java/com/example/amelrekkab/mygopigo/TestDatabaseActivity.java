package com.example.amelrekkab.mygopigo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import org.w3c.dom.Comment;

import java.util.List;
import java.util.Random;

/**
 * Created by Amel Rekkab on 30/12/2016.
 */

public class TestDatabaseActivity extends ListActivity {
    private statitDataSource datasource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        datasource = new statitDataSource(this);
       // datasource.open();
        List<statit> values = datasource.getAllstatit();

        // utilisez SimpleCursorAdapter pour afficher les
        // éléments dans une ListView
        ArrayAdapter<statit> adapter = new ArrayAdapter<statit>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    // Sera appelée par l'attribut onClick
    // des boutons déclarés dans main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<statit> adapter = (ArrayAdapter<statit>) getListAdapter();
        statit comment = null;
        switch (view.getId()) {
            case R.id.add:
                String[] statit = new String[] { "Cool", "Very nice", "Hate it" };
                int nextInt = new Random().nextInt(3);
                // enregistrer le nouveau commentaire dans la base de données
               // comment = datasource.createstatit(statit[nextInt]);
                //adapter.add(statit);
                break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                   // statit = (statit) getListAdapter().getItem(0);
                   // datasource.deletestatit(statit);
                    adapter.remove(comment);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
       // datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }
}
