package com.example.amelrekkab.mygopigo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StreamCorruptedException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Amel Rekkab on 21/12/2016.
 */

public class stat extends MainActivity {


    int port = 8080;
    String ip = "192.168.43.39";
    TextView tempText;
    TextView lumText ;
    TextView disText;
    String msg1 = "";
    String msg2 = "";
    String msg3 = "";
    ObjectOutputStream out;
    ObjectInputStream in;
    ServerSocket s = null;
    boolean click = false;
    boolean stop = false ;
    Socket soc ;
    MediaPlayer son;
    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stat);
        lumText =(TextView)findViewById(R.id.lumText);
        tempText = (TextView)findViewById(R.id.tempText);
        disText  = (TextView)findViewById(R.id.disText);
        Button btnStat =(Button)findViewById(R.id.btnStat);
        Button btnStop =(Button)findViewById(R.id.btnStop);
        Button btnGraph=(Button)findViewById(R.id.button5);
        Button btnData = (Button)findViewById(R.id.btnData);
        btnGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(stat.this, Graph.class);
                startActivity(i);
            }
        });

        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(stat.this, TestDatabaseActivity.class);
                startActivity(i);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stop = true;
                Log.d("Status == ","Stopped ! ");
            }
        });
        btnStat.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                stop = false;
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        while (true && stop == false)
                        {


                            Log.d("Preparing ",".. OK");

                            try {
                                if (click == false)
                                {
                                    s = new ServerSocket(port);
                                    click = true;
                                }
                                soc = s.accept();


                                Log.d("Status ","Accepted ... ");
                                out = new ObjectOutputStream(soc.getOutputStream());
                                out.flush();
                                out.writeObject("BONJOUR ! ");
                                out.flush();
                                in = new ObjectInputStream(soc.getInputStream());
                                Log.d("Status ","Declared ... ");
                                //msg=null;
                                for(i=0;i<3;i++){
                                    if (i == 0)msg1 = in.readObject().toString();

                                    if (i == 1)msg2 = in.readObject().toString();

                                    if (i == 2)msg3 = in.readObject().toString();
                                }
                                Log.d("Status ","Readed ... ");
                                runOnUiThread(new Runnable(){
                                    @Override
                                    public void run(){

                                        tempText.setText(msg1);
                                        lumText.setText(msg2);
                                        disText.setText(msg3);
                                        if(Double.parseDouble(msg1)>8 )
                                        {
                                            Toast.makeText(getBaseContext(), "Attention !! Temp�rature �lev�e ..", Toast.LENGTH_SHORT).show();
                                            son.start();

                                        }


                                    }

                                });
                                Log.d("finish == ","finish");
                                try {
                                    Thread.sleep(10);
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }

                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } catch (ClassNotFoundException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                        }
                    }}).start();	;

            }
        });
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.about){

            return true;
        }
        if (id == R.id.other) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void change(String a)
    {
        tempText.setText(a);
    }





}
