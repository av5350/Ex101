package com.example.ex101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder msgDialog;
    LinearLayout layout;
    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout)findViewById(R.id.layout);

        rnd = new Random();
    }

    /**
     * Part 1 - open alert dialog with 1 message
     *
     * @param view the view
     */
    public void startMsgDialog(View view) {
        msgDialog = new AlertDialog.Builder(this);

        msgDialog.setMessage("Hi there!");

        AlertDialog ad = msgDialog.create();
        ad.show();
    }

    /**
     * Part 2 - open alert dialog with 1 message and icon
     *
     * @param view the view
     */
    public void startIconDialog(View view) {
        msgDialog = new AlertDialog.Builder(this);

        msgDialog.setMessage("Hi there!");
        msgDialog.setTitle("There is an error!");
        msgDialog.setIcon(R.drawable.close);

        AlertDialog ad = msgDialog.create();
        ad.show();
    }

    /**
     * Part 3 - open alert dialog with 1 messag, icon
     *          and a closer dialog button
     *
     * @param view the view
     */
    public void startBtnDialog(View view) {
        msgDialog = new AlertDialog.Builder(this);

        msgDialog.setMessage("Hi there!");
        msgDialog.setTitle("There is an error!");
        msgDialog.setIcon(R.drawable.close);
        msgDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = msgDialog.create();
        ad.show();
    }

    /**
     * Part 4 - open alert dialog with 1 message and 2 buttons:
     *          1 - for change background layout changer (with an random rgb value)
     *          2 - for close the dialog
     *
     * @param view the view
     */
    public void startTwoBtnDialog(View view) {
        msgDialog = new AlertDialog.Builder(this);

        msgDialog.setMessage("You can change your background color!");
        msgDialog.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Set new RGB random color to layout
                layout.setBackgroundColor(
                        Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });
        msgDialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = msgDialog.create();
        ad.show();
    }

    /**
     * Part 5 - open alert dialog with 1 message and 3 buttons:
     *          1 - for change background layout changer (with an random rgb value)
     *          2 - rest layout background to white
     *          3 - close dialog
     *
     * @param view the view
     */
    public void startThreeBtnDialog(View view) {
        msgDialog = new AlertDialog.Builder(this);

        msgDialog.setMessage("You can change your background color!");
        msgDialog.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Set new RGB random color to layout
                layout.setBackgroundColor(
                        Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });
        msgDialog.setNeutralButton("rest", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Rest background color to white
                layout.setBackgroundColor(Color.WHITE);
            }
        });
        msgDialog.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = msgDialog.create();
        ad.show();
    }

    /**
     * Create the options menu
     *
     * @param menu the menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * go to credits activity if it was clicked at the menu
     *
     * @param item the item in menu that was clicked
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        // go to credits activity
        if (id == R.id.creadits)
        {
            Intent si = new Intent(this, CreaditsActivity.class);
            startActivity(si);
        }

        return true;
    }
}