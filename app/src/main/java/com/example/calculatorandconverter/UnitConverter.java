package com.example.calculatorandconverter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class UnitConverter extends AppCompatActivity
{
    DrawerLayout drawer;

    public Spinner spinnerlength1, spinnerlength2, spinnervolume1, spinnervolume2, spinnertemp1, spinnertemp2, spinnermass1, spinnermass2, spinnernumeric1, spinnernumeric2;

    public ArrayAdapter<CharSequence> adapter_length1, adapter_length2;
    public ArrayAdapter<CharSequence>  adapter_volume1, adapter_volume2;
    public ArrayAdapter<CharSequence> adapter_temp1, adapter_temp2;
    public ArrayAdapter<CharSequence>  adapter_mass1, adapter_mass2;
    public ArrayAdapter<CharSequence> adapter_numeric1, adapter_numeric2;

    public EditText input_length1;
    public EditText input_volume1;
    public EditText input_temp1;
    public EditText input_mass1;
    public EditText input_numeric1;

    public TextView output_length;
    public TextView output_volume;
    public TextView output_temp;
    public TextView output_mass;

    public TextView output_numeric;

    public Button length_convert;
    public Button volume_convert;
    public Button temp_convert;

    public Button mass_convert;
    public Button numeric_convert;


    public String input_unit_length;
    public String input_unit_volume;
    public String input_unit_temp;
    public String input_unit_mass;
    public String input_unit_numeric;


    public String output_unit_length;
    public String output_unit_volume;
    public String output_unit_temp;
    public String output_unit_mass;
    public String output_unit_numeric;

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
        Intent intent = new Intent(UnitConverter.this, BasicCalculator.class);
        startActivity(intent);
    }


    public void UnitConverterClick(View view)
    {
        recreate();
    }

    public void AboutUsClick(View view)
    {
        Intent intent = new Intent(UnitConverter.this, AboutUs.class);
        startActivity(intent);
    }

    public void init()
    {
        spinnerlength1 = findViewById(R.id.length1);
        spinnerlength2 = findViewById(R.id.length2);
        output_length = findViewById(R.id.output_length2);

        length_convert = findViewById(R.id.length_button);

        length_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    double input_length = Double.parseDouble(input_length1.getText().toString());
                    double result = lengthConverter(input_unit_length, output_unit_length, input_length);
                    output_length.setText(String.valueOf(result));
                    //System.out.println("Maverick & APKA_");
                }
                catch(Exception E)
                {
                    length_convert.setText("!!");
                    System.out.println("Something went wrong.");
                }
            }
        });

        adapter_length1 = ArrayAdapter.createFromResource(this,R.array.length1_list, android.R.layout.simple_spinner_item);
        adapter_length1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerlength1.setAdapter(adapter_length1);

        adapter_length2 = ArrayAdapter.createFromResource(this,R.array.length2_list, android.R.layout.simple_spinner_item);
        adapter_length2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerlength2.setAdapter(adapter_length2);

        input_length1 = (EditText)findViewById(R.id.input_length1);


        spinnerlength1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                input_unit_length = spinnerlength1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //input_unit_length = " ";
            }
        });


        spinnerlength2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                output_unit_length = spinnerlength2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //output_unit_length = " ";
            }
        });

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        spinnervolume1 = findViewById(R.id.volume1);
        spinnervolume2 = findViewById(R.id.volume2);
        output_volume = findViewById(R.id.output_volume2);

        volume_convert = findViewById(R.id.volume_button);

        volume_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    double volume_length = Double.parseDouble(input_volume1.getText().toString());
                    double result = VolumeConverter(input_unit_volume, output_unit_volume, volume_length);
                    output_volume.setText(String.valueOf(result));
                }
                catch(Exception E)
                {
                    volume_convert.setText("!!");
                    System.out.println("Something went wrong.");
                }
            }
        });

        adapter_volume1 = ArrayAdapter.createFromResource(this,R.array.volume1_list, android.R.layout.simple_spinner_item);
        adapter_volume1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnervolume1.setAdapter(adapter_volume1);

        adapter_volume2 = ArrayAdapter.createFromResource(this,R.array.volume2_list, android.R.layout.simple_spinner_item);
        adapter_volume2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnervolume2.setAdapter(adapter_volume2);

        input_volume1 = (EditText)findViewById(R.id.input_volume1);

        spinnervolume1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                input_unit_volume = spinnervolume1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //input_unit_volume = " ";
            }
        });

        spinnervolume2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                output_unit_volume = spinnervolume2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //output_unit_volume = " ";
            }
        });

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        spinnertemp1 = findViewById(R.id.temp1);
        spinnertemp2 = findViewById(R.id.temp2);
        output_temp = findViewById(R.id.output_temp2);

        temp_convert = findViewById(R.id.temp_button);

        temp_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    double input_temp = Double.parseDouble(input_temp1.getText().toString());
                    double result = TemperatureConverter(input_unit_temp, output_unit_temp, input_temp);
                    output_temp.setText(String.valueOf(result));
                }
                catch(Exception E)
                {
                    length_convert.setText("!!");
                    System.out.println("Something went wrong.");
                }
            }
        });

        adapter_temp1 = ArrayAdapter.createFromResource(this,R.array.temp1_list, android.R.layout.simple_spinner_item);
        adapter_volume1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertemp1.setAdapter(adapter_temp1);

        adapter_temp2 = ArrayAdapter.createFromResource(this,R.array.temp2_list, android.R.layout.simple_spinner_item);
        adapter_temp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertemp2.setAdapter(adapter_temp2);

        input_temp1 = (EditText)findViewById(R.id.input_temp1);

        spinnertemp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                input_unit_temp = spinnertemp1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //input_unit_temp = " ";
            }
        });

        spinnertemp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                output_unit_temp = spinnertemp2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //output_unit_temp = " ";

            }
        });

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        spinnermass1 = findViewById(R.id.mass1);
        spinnermass2 = findViewById(R.id.mass2);
        output_mass = findViewById(R.id.output_mass2);

        mass_convert = findViewById(R.id.mass_button);

        mass_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {
                    double input_mass = Double.parseDouble(input_mass1.getText().toString());
                    double result = MassConverter(input_unit_mass, output_unit_mass, input_mass);
                    output_mass.setText(String.valueOf(result));
                }
                catch(Exception E)
                {
                    length_convert.setText("!!");
                    System.out.println("Something went wrong.");
                }
            }
        });

        adapter_mass1 = ArrayAdapter.createFromResource(this,R.array.mass1_list, android.R.layout.simple_spinner_item);
        adapter_mass1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnermass1.setAdapter(adapter_mass1);

        adapter_mass2 = ArrayAdapter.createFromResource(this,R.array.mass2_list, android.R.layout.simple_spinner_item);
        adapter_mass2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnermass2.setAdapter(adapter_mass2);

        input_mass1 = (EditText)findViewById(R.id.input_mass1);

        spinnermass1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                input_unit_mass = spinnermass1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //input_unit_mass = " ";
            }
        });

        spinnermass2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                output_unit_mass = spinnermass2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //output_unit_mass = " ";
            }
        });
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        spinnernumeric1 = findViewById(R.id.numeric1);
        spinnernumeric2 = findViewById(R.id.numeric2);
        output_numeric = findViewById(R.id.output_numeric2);

        numeric_convert = findViewById(R.id.numeric_button);

        numeric_convert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    String input_numeric= input_numeric1.getText().toString();
                    String result = NumericConverter(input_unit_numeric, output_unit_numeric, input_numeric);
                    output_numeric.setText(result);
                }
                catch(Exception E)
                {
                    numeric_convert.setText("!!");
                    System.out.println("Something went wrong.");
                }
            }
        });

        adapter_numeric1 = ArrayAdapter.createFromResource(this,R.array.numeric1_list, android.R.layout.simple_spinner_item);
        adapter_numeric1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnernumeric1.setAdapter(adapter_numeric1);

        adapter_numeric2 = ArrayAdapter.createFromResource(this,R.array.numeric2_list, android.R.layout.simple_spinner_item);
        adapter_numeric2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnernumeric2.setAdapter(adapter_numeric2);

        input_numeric1 = (EditText)findViewById(R.id.input_numeric1);

        spinnernumeric1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                input_unit_numeric = spinnernumeric1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //input_unit_numeric = " ";
            }
        });

        spinnernumeric2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                output_unit_numeric = spinnernumeric2.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //output_unit_numeric = " ";
            }
        });
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static double lengthConverter(String unit1, String unit2, double value)
    {
        double result = 0;
        Map<String, Double> length_dict = new HashMap<String, Double>();
        // 1 metre
        length_dict.put("mm", 1000.0);
        length_dict.put("cm", 100.0);
        length_dict.put("dm", 10.0);
        length_dict.put("m", 1.0);
        length_dict.put("dam", 0.1);
        length_dict.put("hm", 0.01);
        length_dict.put("km", 0.001);
        length_dict.put("yard",1.093);
        length_dict.put("mile",0.000621);
        length_dict.put("seamile", 0.000539);
        length_dict.put("inch", 39.37);
        length_dict.put("lightyear", 1.57 * Math.pow(10, -16));
        length_dict.put("AU", 6.68 * Math.pow(10, -12));

        if(length_dict.containsKey(unit1) && length_dict.containsKey(unit2))
        {
            double metre_val = 1 * value / (length_dict.get(unit1));
            result = metre_val * length_dict.get(unit2);
        }

        return result;
    }


    public static double TemperatureConverter(String fromUnit, String toUnit, double temperature)
    {
        if (fromUnit.equalsIgnoreCase("Kelvin"))
        {
            if (toUnit.equalsIgnoreCase("Celcius"))
            {
                return temperature - 273.15;
            }
            else if (toUnit.equalsIgnoreCase("Fahrenheit"))
            {
                return temperature * 9 / 5 - 459.67;
            }
            else if (toUnit.equalsIgnoreCase("Rankine"))
            {
                return temperature * 9 / 5;
            }
            else
            {
                return temperature;
            }

        }
        else if (fromUnit.equalsIgnoreCase("Celcius")) {
            if (toUnit.equalsIgnoreCase("Kelvin")) {
                return temperature + 273.15;
            } else if (toUnit.equalsIgnoreCase("Fahrenheit")) {
                return temperature * 9 / 5 + 32;
            } else if (toUnit.equalsIgnoreCase("Rankine")) {
                return (temperature + 273.15) * 9 / 5;
            } else {
                return temperature;
            }
        } else if (fromUnit.equalsIgnoreCase("Fahrenheit")) {
            if (toUnit.equalsIgnoreCase("Kelvin")) {
                return (temperature + 459.67) * 5 / 9;
            } else if (toUnit.equalsIgnoreCase("Celcius")) {
                return (temperature - 32) * 5 / 9;
            } else if (toUnit.equalsIgnoreCase("Rankine")) {
                return temperature + 459.67;
            } else {
                return temperature;
            }
        } else if (fromUnit.equalsIgnoreCase("Rankine")) {
            if (toUnit.equalsIgnoreCase("Kelvin")) {
                return temperature * 5 / 9;
            } else if (toUnit.equalsIgnoreCase("Celcius")) {
                return (temperature - 491.67) * 5 / 9;
            } else if (toUnit.equalsIgnoreCase("Fahrenheit")) {
                return temperature - 459.67;
            } else {
                return temperature;
            }
        } else {
            return temperature;
        }
    }

    public static double MassConverter(String mass1, String mass2, double value)
    {
        Map<String, Double> mass_dict = new HashMap<String, Double>();
        mass_dict.put("mg", 1000.0);
        mass_dict.put("g", 1.0);
        mass_dict.put("kg", 0.001);
        mass_dict.put("ton", 0.000001);
        mass_dict.put("ons", 0.0352);
        mass_dict.put("pound", 0.0022046);
        mass_dict.put("karat", 5.0);
        mass_dict.put("okka", 0.00078);

        double gram_val = 1 * value / mass_dict.get(mass1);
        return gram_val * mass_dict.get(mass2);
    }

    public static double VolumeConverter(String volume1, String volume2, Double value)
    {
        Map<String, Double> volume_dict = new HashMap<String, Double>();
        // 1 dm3 cinsinden
        volume_dict.put("mm3", Math.pow(10, 6));
        volume_dict.put("cm3", 1000.0);
        volume_dict.put("dm3", 1.0);
        volume_dict.put("m3", 0.001);
        volume_dict.put("litre", 1.0);
        volume_dict.put("ml", 1000.0);
        volume_dict.put("cl", 100.0);
        volume_dict.put("gallon", 0.264172);

        double dm3_val = 1.0 * value / volume_dict.get(volume1);
        return dm3_val * volume_dict.get(volume2);
    }

    public static String NumericConverter(String inputBase, String outputBase, String inputNum) {
        int decimalValue;
        switch (inputBase.toLowerCase()) {
            case "binary":
                decimalValue = Integer.parseInt((inputNum), 2);
                break;
            case "octal":
                decimalValue = Integer.parseInt((inputNum), 8);
                break;
            case "decimal":
                decimalValue = Integer.parseInt(inputNum);
                break;
            case "hexadecimal":
                decimalValue = Integer.parseInt((inputNum), 16);
                break;
            default:
                throw new IllegalArgumentException("Invalid input base");
        }

        switch (outputBase.toLowerCase()) {
            case "binary":
                return Integer.toBinaryString(decimalValue);
            case "octal":
                return Integer.toOctalString(decimalValue);
            case "decimal":
                return String.valueOf(decimalValue);
            case "hexadecimal":
                return Integer.toHexString(decimalValue);
            default:
                throw new IllegalArgumentException("Invalid output base");
        }
    }

    public void ExitClick(View view)
    {
        AlertDialog.Builder exit_window = new AlertDialog.Builder(UnitConverter.this);

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
        setContentView(R.layout.activity_unit_converter);
        drawer = findViewById(R.id.drawer_background);

        init();
    }
}