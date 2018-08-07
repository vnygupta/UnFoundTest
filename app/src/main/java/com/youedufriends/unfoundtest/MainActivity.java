package com.youedufriends.unfoundtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvFrameMaterial,tvPowerTrain,tvWheelFrame;
    Spinner spnFrameMaterial,spnPowerTrain,spnWheelNumber,spnWheelFrame;
    Button btnSaveData,btnPastReport;

    ArrayList<String> FrameMaterial = new ArrayList<>();
    ArrayList<String> PowerTrain = new ArrayList<>();
    ArrayList<String> WheelFrame = new ArrayList<>();
    ArrayList<String> WheelNumber = new ArrayList<>();
    String Vehicle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvFrameMaterial=(TextView)findViewById(R.id.tvFrameMaterial);
        tvPowerTrain=(TextView)findViewById(R.id.tvPowerTrain);
        tvWheelFrame=(TextView)findViewById(R.id.tvWheelFrame);

        spnFrameMaterial=(Spinner)findViewById(R.id.spnFrameMaterial);
        spnPowerTrain=(Spinner)findViewById(R.id.spnPowerTrain);
        spnWheelFrame=(Spinner)findViewById(R.id.spnWheelFrame);
        spnWheelNumber=(Spinner)findViewById(R.id.spnWheelNumber);
        btnSaveData=(Button)findViewById(R.id.btnSaveData);
        btnPastReport=(Button)findViewById(R.id.btnPastReport);

        final DatabaseHandler db = new DatabaseHandler(this);

        FrameMaterial.add("Plastic");
        FrameMaterial.add("Metal");

        PowerTrain.add("Human");
        PowerTrain.add("Internal Combustion");
        PowerTrain.add("Bernouli");

        WheelFrame.add("Plastic");
        WheelFrame.add("Metal");
        WheelFrame.add("None");

        WheelNumber.add("0");
        WheelNumber.add("2");
        WheelNumber.add("3");
        WheelNumber.add("4");

        ArrayAdapter<String> FrameMaterialAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, FrameMaterial);
        spnFrameMaterial.setAdapter(FrameMaterialAdapter);

        ArrayAdapter<String> PowerTrainAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PowerTrain);
        spnPowerTrain.setAdapter(PowerTrainAdapter);


        ArrayAdapter<String> WheelFrameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,WheelFrame);
        spnWheelFrame.setAdapter(WheelFrameAdapter);

        ArrayAdapter<String> WheelNumberAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, WheelNumber);
        spnWheelNumber.setAdapter(WheelNumberAdapter);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        java.util.Date date = new java.util.Date();
        final String date1 = sdf.format(date);


        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  String frameMaterial=(String) spnFrameMaterial.getSelectedItem();

                  String powertrain=(String)spnPowerTrain.getSelectedItem();
                  String wheelnumber=(String)spnWheelNumber.getSelectedItem();
                  String wheelframe=(String)spnWheelFrame.getSelectedItem();
                  Vehicle=db.getVehicle(frameMaterial,powertrain,wheelframe,wheelnumber,date1);
                Toast.makeText(MainActivity.this," Vehicle="+Vehicle,Toast.LENGTH_LONG).show();




                if(Vehicle.equals("Unknown")){
                    Toast.makeText(MainActivity.this," Inavlid Input\n Please select appropriate option ",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, ReportActivity.class);
                    intent.putExtra("frame", frameMaterial);
                    intent.putExtra("power", powertrain);
                    intent.putExtra("wheelnumber", wheelnumber);
                    intent.putExtra("wheelframe", wheelframe);
                    intent.putExtra("vehicle", Vehicle);
                    intent.putExtra("date", date1);
                    startActivity(intent);
                }




            }
        });


        btnPastReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,HistoryReportActivity.class));
            }
        });



    }

}
