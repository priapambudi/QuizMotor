package com.example.priapambudi.kebonkodingproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mlineLearn, mLinePractice, mLineAbout, mLineEmail; //membuat variable bertipe liner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // menyambungakan mainactivity.java denagn layout

        mlineLearn = (LinearLayout) findViewById(R.id.lineLearn);
        mLinePractice = (LinearLayout) findViewById(R.id.linePractice);
        mLineAbout = (LinearLayout) findViewById(R.id.lineAboutUs);
        mLineEmail = (LinearLayout) findViewById(R.id.lineContactUs);
        // menyambungkan mainactivity.java dengan id pada layout

        mlineLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, learn.class);
                startActivity(i);
            }
        });

        mLinePractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, practice.class);
                startActivity(i);
            }
        });

        mLineAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, aboutus.class);
                startActivity(i);
            }
        });

        // membuat pesan email
        mLineEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = "priapambudi97@gmail.com";
                String subject = "Mau Tanya";
                String message = "Apa itu android?";

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "kirim email dengan"));
            }
        });
    }

    //class baru - ingin keluar applikasi atau tidak
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Anda Yakin Ingin Keluar?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog quit = builder.create();
        quit.show();
    }
}


