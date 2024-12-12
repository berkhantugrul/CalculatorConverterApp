package com.example.calculatorandconverter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_background);
    }

    public void ClickMenu(View view)
    {
        drawer.openDrawer(GravityCompat.START);
    }


    public void ClickLogo(View view)
    {
        closeTheDrawerMenu(drawer);
    }

    public static void closeTheDrawerMenu(DrawerLayout drawer)
    {
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    public void BasicCalculatorClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, BasicCalculator.class);
        startActivity(intent);
    }


    public void UnitConverterClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, UnitConverter.class);
        startActivity(intent);
    }

    public void AboutUsClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, AboutUs.class);
        startActivity(intent);
    }


    public void ExitClick(View view)
    {
        AlertDialog.Builder exit_window = new AlertDialog.Builder(MainActivity.this);

        exit_window.setTitle("Exit");
        exit_window.setMessage("Are you sure about exit?");

        exit_window.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int i)
            {
                finishAffinity();
                System.exit(0);
            }
        });

        exit_window.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                dialogInterface.dismiss();
            }
        });

        exit_window.show();
    }

    @Override
    protected void onPause()
    {
        closeTheDrawerMenu(drawer);
        super.onPause();
    }
}

