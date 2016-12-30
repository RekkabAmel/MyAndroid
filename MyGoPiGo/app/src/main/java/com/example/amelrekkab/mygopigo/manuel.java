package com.example.amelrekkab.mygopigo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Amel Rekkab on 21/12/2016.
 */

public class manuel extends MainActivity {

    Socket client ;
    ServerSocket serverSocket;
    int port = 8080;
    String ip = "192.168.43.39";
    PrintWriter printwriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent intentManuel = new Intent(manuel.this, MainActivity.class);
        final Intent intentStat = new Intent(this, stat.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.manuel);

        Button btnDisconMan =(Button)findViewById(R.id.btnConnectMan);
        Button btn1Plus = (Button)findViewById(R.id.btn1Plus);
        Button btn1Moins = (Button)findViewById(R.id.btn1Moins);
        Button btn2Plus = (Button)findViewById(R.id.btn2Plus);
        Button btn2Moins = (Button)findViewById(R.id.btn2Moins);
        Button btn3Plus = (Button)findViewById(R.id.btn3Plus);
        Button btn3Moins = (Button)findViewById(R.id.btn3Moins);
        Button btn4Plus = (Button)findViewById(R.id.btn4Plus);
        Button btn4Moins = (Button)findViewById(R.id.btn4Moins);
        Button btn5Plus = (Button)findViewById(R.id.btn5Plus);
        Button btn5Moins = (Button)findViewById(R.id.btn5Moins);
        Button btn6Plus = (Button)findViewById(R.id.btn6Plus);
        Button btn6Moins = (Button)findViewById(R.id.btn6Moins);

        Button btnReceive = (Button)findViewById(R.id.ButtonReceive);




        btn1Plus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        try{
                            client = new Socket(ip,port);
                            printwriter = new PrintWriter(client.getOutputStream());
                            printwriter.write("1");
                            Log.d("Data sented","Succes");
                            printwriter.flush();
                            printwriter.close();
                            client.close();
                        }catch(UnknownHostException e){
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }).start();	;

            }
        });
        btnDisconMan.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                btn_connect.setText("CONNECT");
                wifiManager.setWifiEnabled(false);
                isDisconnectCheckedButton= true;
                manuel.this.finish();
            }
        });
        btn1Moins.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        try{
                            client = new Socket(ip,port);
                            printwriter = new PrintWriter(client.getOutputStream());
                            printwriter.write("-1");
                            Log.d("Data sented","Succes");
                            printwriter.flush();
                            printwriter.close();
                            client.close();
                        }catch(UnknownHostException e){
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }).start();	;

            }
        });
        btn2Plus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        try{
                            client = new Socket(ip,port);
                            printwriter = new PrintWriter(client.getOutputStream());
                            printwriter.write("2");
                            Log.d("Data sented","Succes");
                            printwriter.flush();
                            printwriter.close();
                            client.close();
                        }catch(UnknownHostException e){
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }).start();	;

            }
        });
        btn2Moins.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        try{
                            client = new Socket(ip,port);
                            printwriter = new PrintWriter(client.getOutputStream());
                            printwriter.write("-2");
                            Log.d("Data sented","Succes");
                            printwriter.flush();
                            printwriter.close();
                            client.close();
                        }catch(UnknownHostException e){
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }).start();	;

            }
        });
        btn3Plus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        try{
                            client = new Socket(ip,port);
                            printwriter = new PrintWriter(client.getOutputStream());
                            printwriter.write("3");
                            Log.d("Data sented","Succes");
                            printwriter.flush();
                            printwriter.close();
                            client.close();
                        }catch(UnknownHostException e){
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }).start();	;

            }
        });
        btn3Moins.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        try{
                            client = new Socket(ip,port);
                            printwriter = new PrintWriter(client.getOutputStream());
                            printwriter.write("-3");
                            Log.d("Data sented","Succes");
                            printwriter.flush();
                            printwriter.close();
                            client.close();
                        }catch(UnknownHostException e){
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }).start();	;

            }
        });
        btn4Plus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        try{
                            client = new Socket(ip,port);
                            printwriter = new PrintWriter(client.getOutputStream());
                            printwriter.write("4");
                            Log.d("Data sented","Succes");
                            printwriter.flush();
                            printwriter.close();
                            client.close();
                        }catch(UnknownHostException e){
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }).start();	;

            }
        });
        btn4Moins.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        try{
                            client = new Socket(ip,port);
                            printwriter = new PrintWriter(client.getOutputStream());
                            printwriter.write("-4");
                            Log.d("Data sented","Succes");
                            printwriter.flush();
                            printwriter.close();
                            client.close();
                        }catch(UnknownHostException e){
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }).start();	;

            }
        });
        btn5Plus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        try{
                            client = new Socket(ip,port);
                            printwriter = new PrintWriter(client.getOutputStream());
                            printwriter.write("5");
                            Log.d("Data sented","Succes");
                            printwriter.flush();
                            printwriter.close();
                            client.close();
                        }catch(UnknownHostException e){
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }).start();	;

            }
        });
        btn5Moins.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        try{
                            client = new Socket(ip,port);
                            printwriter = new PrintWriter(client.getOutputStream());
                            printwriter.write("-5");
                            Log.d("Data sented","Succes");
                            printwriter.flush();
                            printwriter.close();
                            client.close();
                        }catch(UnknownHostException e){
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }).start();	;

            }
        });
        btn6Plus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        try{
                            client = new Socket(ip,port);
                            printwriter = new PrintWriter(client.getOutputStream());
                            printwriter.write("6");
                            Log.d("Data sented","Succes");
                            printwriter.flush();
                            printwriter.close();
                            client.close();
                        }catch(UnknownHostException e){
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }).start();	;

            }
        });
        btn6Moins.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        try{
                            client = new Socket(ip,port);
                            printwriter = new PrintWriter(client.getOutputStream());
                            printwriter.write("-6");
                            Log.d("Data sented","Succes");
                            printwriter.flush();
                            printwriter.close();
                            client.close();
                        }catch(UnknownHostException e){
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                }).start();	;

            }
        });
        btnReceive.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                startActivity(intentStat);
                ;}

        });

    }



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



