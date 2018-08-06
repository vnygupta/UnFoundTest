package com.youedufriends.unfoundtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryReportActivity extends AppCompatActivity {


    ArrayList<ReportList> ReportList;
    HistoryAdapter historyAdapter;
    RecyclerView rvHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_report);
        final DatabaseHandler db = new DatabaseHandler(this);

        rvHistory=(RecyclerView)findViewById(R.id.rvHistory);
        rvHistory.setHasFixedSize(true);
        rvHistory.setLayoutManager( new LinearLayoutManager(getApplicationContext()));

        ReportList =db.getReportList();

        historyAdapter=new HistoryAdapter(ReportList,getApplicationContext());
        rvHistory.setAdapter(historyAdapter);
    }
}
