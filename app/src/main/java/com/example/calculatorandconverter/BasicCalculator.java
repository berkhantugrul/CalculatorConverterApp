package com.example.calculatorandconverter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BasicCalculator extends AppCompatActivity
{
    DrawerLayout drawer;

    public Button one, two, three, four, five, six, seven, eight, nine, zero;
    public  Button plus, minus, product, divide, mod, expotention, equal, ac, backspace, dot;
    public  TextView input, output;
    boolean bool_plus, bool_minus, bool_divide, bool_product, bool_mod, bool_expotention;
    float value1, value2;

    public void init()
    {
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = findViewById(R.id.zero);

        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        product = (Button) findViewById(R.id.product);
        divide = (Button) findViewById(R.id.divide);
        mod = (Button) findViewById(R.id.mod);
        expotention = (Button) findViewById(R.id.expotention);
        equal = (Button) findViewById(R.id.equal);
        ac = (Button) findViewById(R.id.ac);
        backspace = (Button) findViewById(R.id.backspace);
        dot = (Button) findViewById(R.id.dot);


        one.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                input.setText(input.getText()+"1");
                output.setText(input.getText());
            }
        });

        two.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                input.setText(input.getText()+"2");
                output.setText(input.getText());
            }
        });

        three.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                input.setText(input.getText()+"3");
                output.setText(input.getText());
            }
        });

        four.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                input.setText(input.getText()+"4");
                output.setText(input.getText());
            }
        });

        five.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                input.setText(input.getText()+"5");
                output.setText(input.getText());
            }
        });

        six.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                input.setText(input.getText()+"6");
                output.setText(input.getText());
            }
        });

        seven.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                input.setText(input.getText()+"7");
                output.setText(input.getText());
            }
        });

        eight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                input.setText(input.getText()+"8");
                output.setText(input.getText());
            }
        });

        nine.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                input.setText(input.getText()+"9");
                output.setText(input.getText());
            }
        });

        zero.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                input.setText(input.getText()+"0");
                output.setText(input.getText());
            }
        });

        ac.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                input.setText("0");
                output.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                input.setText("0");
            }
        });

        dot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                input.setText(input.getText()+".");
                output.setText(input.getText());
            }
        });

        plus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(input==null)
                {
                    input.setText("");
                }

                else
                {
                    value1 = Float.parseFloat(input.getText()+"");
                    bool_plus = true;
                    input.setText(null);
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                value1 = Float.parseFloat(input.getText()+"");
                bool_minus=true;
                input.setText(null);
            }
        });

        product.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                value1 = Float.parseFloat(input.getText()+"");
                bool_product=true;
                input.setText(null);
            }
        });

        divide.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                value1 = Float.parseFloat(input.getText()+"");
                bool_divide=true;
                input.setText(null);
            }
        });

        mod.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                value1 = Float.parseFloat(input.getText()+"");
                bool_mod=true;
                input.setText(null);
            }
        });


        expotention.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                value1 = Float.parseFloat(input.getText()+"");
                bool_expotention=true;
                input.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                value2 = Float.parseFloat(input.getText()+"");

                if(bool_plus==true)
                {
                    input.setText(value1 + value2 + "");
                    output.setText(value1+"+"+value2);
                    bool_plus=false;
                }
                else if (bool_minus==true)
                {
                    input.setText(value1 - value2 + "");
                    output.setText(value1+"-"+value2);
                    bool_minus=false;
                }
                else if(bool_divide==true)
                {
                    input.setText(value1 / value2 + "");
                    output.setText(value1+"/"+value2);
                    bool_divide=false;
                }
                else if(bool_product==true)
                {
                    input.setText(value1 * value2 + "");
                    output.setText(value1+"*"+value2);
                    bool_product=false;
                }
                else if(bool_mod==true)
                {
                    input.setText(value1 % value2 + "");
                    output.setText(value1+"^"+value2);
                    bool_mod=false;
                }
                else if(bool_expotention==true)
                {
                    input.setText(Math.pow(value1, value2)+"");
                    output.setText(value1+"^"+value2);
                    bool_expotention=false;
                }

            }
        });
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
        recreate();
    }


    public void UnitConverterClick(View view)
    {
        Intent intent = new Intent(BasicCalculator.this, UnitConverter.class);
        startActivity(intent);
    }


    public void AboutUsClick(View view)
    {
        Intent intent = new Intent(BasicCalculator.this, AboutUs.class);
        startActivity(intent);
    }


    public void ExitClick(View view)
    {
        AlertDialog.Builder exit_window = new AlertDialog.Builder(BasicCalculator.this);

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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);
        drawer = findViewById(R.id.drawer_background);

        init();

    }
}