package com.youedufriends.unfoundtest;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    TextView tvVehicle,tvFrame,tvPowerTrain,tvWheelFrame,tvWheelNumber,tvTimeStamp;
    Button btnReportHistory;
    ImageView ivVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        tvVehicle=(TextView)findViewById(R.id.tvVehicleName);
        tvFrame=(TextView)findViewById(R.id.tvFrame);
        tvPowerTrain=(TextView)findViewById(R.id.tvPowerTrain1);
        tvWheelFrame=(TextView)findViewById(R.id.tvWheelFrame1);
        tvWheelNumber=(TextView)findViewById(R.id.tvWheelNumber);
        tvTimeStamp=(TextView)findViewById(R.id.tvTimeStamp);
        btnReportHistory=(Button)findViewById(R.id.btnReportHistory);
        ivVehicle=(ImageView)findViewById(R.id.ivVehicle);




        Intent i=getIntent();
        String vehicle="   Vehicle Name: "+i.getStringExtra("vehicle");
        tvVehicle.setText(vehicle);

        String frame="   Frame Material: "+i.getStringExtra("frame");
        tvFrame.setText(frame);

        String powertrain="   Power Train: "+i.getStringExtra("power");

        tvPowerTrain.setText(powertrain);

        String wheelframe="   Wheel Frame: "+i.getStringExtra("wheelframe");
        tvWheelFrame.setText(wheelframe);


        String wheelnumber="   Wheel Number: "+i.getStringExtra("wheelnumber");

        tvWheelNumber.setText(wheelnumber);

        String time="   Time Stamp:"+i.getStringExtra("date");
        tvTimeStamp.setText(time);

        Resources res=getResources();
        String img=i.getStringExtra("vehicle").toLowerCase();
        int imgid=res.getIdentifier(img,"drawable",getPackageName());
        Drawable imgd=res.getDrawable(imgid);
        ivVehicle.setImageDrawable(imgd);


        btnReportHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReportActivity.this,HistoryReportActivity.class));
            }
        });

    }
}
