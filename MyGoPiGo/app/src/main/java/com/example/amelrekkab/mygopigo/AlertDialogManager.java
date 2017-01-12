package com.example.amelrekkab.mygopigo;

/**
 * Created on 21/12/2016.
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertDialogManager {
    /**
     * Function to display simple Alert Dialog
     * @param context - application context
     * @param title - alert dialog title
     * @param message - alert message
     * @param status - success/failure (used to set icon)
     *               - pass null if you don't want icon
     * */
    public void showAlertDialog(Context context, String title, String message,
                                Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();


// Définition de la boîte de dialogue Titre
        alertDialog.setTitle(title);
     // Définition de la boîte de dialogueMessage
        alertDialog.setMessage(message);

        if(status != null)
            // Définition de la boîte de dialogue icon


            // definition  OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });

// Afficher le message d'alerte
        alertDialog.show();
    }
}
