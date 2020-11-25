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
 *
 *  @author		Itey Weintraub <av5350@bs.amalnet.k12.il>
 *  @version	1
 *  @since		25/11/2020
 *  short description:
 *      This activity let the user try 5 Alert Dialog's situations.
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

        msgDialog.setTitle("Error!");
        msgDialog.setMessage("Its Part 1 :)");

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

        msgDialog.setTitle("There is an error!");
        msgDialog.setMessage("Its Part 2 :)");
        msgDialog.setIcon(R.drawable.close);

        AlertDialog ad = msgDialog.create();
        ad.show();
    }

    /**
     * Part 3 - open alert dialog with 1 message, icon
     *          and a closer dialog button
     *
     * @param view the view
     */
    public void startBtnDialog(View view) {
        msgDialog = new AlertDialog.Builder(this);

        msgDialog.setTitle("There is an error!");
        msgDialog.setMessage("Its Part 3 :)");
        msgDialog.setIcon(R.drawable.close);
        msgDialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Close the dialog
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

        msgDialog.setTitle("Background change");
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

        msgDialog.setTitle("Background change");
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
     * @return ture if success
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
     * @return true - if it success
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String title = (String) item.getTitle();

        // go to credits activity if clicked
        if (title.equals("Creadits"))
        {
            Intent si = new Intent(this, CreaditsActivity.class);
            startActivity(si);
        }

        return true;
    }
}