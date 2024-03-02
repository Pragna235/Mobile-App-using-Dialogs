package com.example.exp35j5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn_show_dialog(View v)
    {
        Log.d("PGNDIALOG","btn_show_dialog: one");
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        Log.d("PGNDIALOG","btn_show_dialog: two");
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        adb.setTitle("Pragna Dialog");
        adb.setMessage("Hi! This is the Dialog created by Pragna");
        adb.setCancelable(true);
        adb.setPositiveButton("Yippee!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this, "clicked on Yippee!", Toast.LENGTH_SHORT).show();
                
            }
        });
        adb.setNegativeButton("Nope!!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this, "Clicked on Nope!!!", Toast.LENGTH_SHORT).show();

            }
        });
        AlertDialog ad = adb.create();
        Log.d("PGNDIALOG","btn_show_dialog: three"+ad.toString());
        ad.show();
    }

    public void btn_pick_time(View v)
    {
        int dH, dMin;
        Calendar c = Calendar.getInstance();
        dH = c.get(Calendar.HOUR);
        dMin = c.get(Calendar.MINUTE);
        TimePickerDialog tpd = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                Toast.makeText(MainActivity.this, i+":"+i1+"", Toast.LENGTH_SHORT).show();

            }
        },dH,dMin,false);
        tpd.show();


    }

    public void btn_pick_date(View v)
    {
        int dYear, dMon, dDay;
        Calendar c = Calendar.getInstance();
        dYear = c.get(Calendar.YEAR);
        dMon = c.get(Calendar.MONTH);
        dDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this, i+"/"+(i1+1)+"/"+i2, Toast.LENGTH_LONG).show();
            }
        },dYear,dMon,dDay);

        dpd.setTitle("Pick a date please!");
        dpd.setMessage("Hello I'm Pragna");
        dpd.show();

    }

    public void show_cus_dialog(View v)
    {
        PgnDialog pg = new PgnDialog();
        FragmentManager fmgr = getSupportFragmentManager();
        FragmentTransaction ftrans = fmgr.beginTransaction();
        pg.show(fmgr,"PgnDialog is a CustomDialog created by Pragna");
    }

}

