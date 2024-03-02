package com.example.exp35j5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class PgnDialog extends DialogFragment {

    AlertDialog.Builder adb;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle b) {
        try {
            adb = new AlertDialog.Builder(getActivity());
            adb.setMessage("Welcome to Dialogs in Android App");
            adb.setCancelable(true);
            adb.setTitle("PgnDialog created by Pragna");
            adb.setPositiveButton("Thank you", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(adb.getContext(), "Thank you", Toast.LENGTH_SHORT).show();
                }
            });
            adb.setNegativeButton("Bye Bye", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(adb.getContext(), "Bye", Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception ex)
        {Toast.makeText(adb.getContext(),ex.getMessage(),Toast.LENGTH_LONG).show();}
        return adb.create();


    }
}


