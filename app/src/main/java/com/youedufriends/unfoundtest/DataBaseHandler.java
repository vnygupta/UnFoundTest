package com.youedufriends.unfoundtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 05-08-2018.
 */

class DatabaseHandler extends SQLiteOpenHelper {

    Context context;
    SQLiteDatabase db;
    ContentValues values= new ContentValues();

     DatabaseHandler(Context context) {
        super(context, "Unfound", null,2);
        this.context = context;
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql1 = "create table Vehicle(type string primary key,frame string,powerTrain string,wheelNumber string,wheelMaterial string)";
        db.execSQL(sql1);
        String row1 = "insert into Vehicle values('Big_Wheel','Plastic','Human',3,'Plastic')";
        db.execSQL(row1);

        String row2 = "insert into Vehicle values('Bicycle','Metal','Human',2,'Metal')";
        db.execSQL(row2);

        String row3 = "insert into Vehicle values('Motorcycle','Metal','Internal Combustion',2,'Metal')";
        db.execSQL(row3);

        String row4 = "insert into Vehicle values('Hang_Glider','Plastic','Bernouli',0,'None')";
        db.execSQL(row4);

        String row5 = "insert into Vehicle values('Car','Metal','Internal Combustion',4,'Metal')";
        db.execSQL(row5);

        String sqlreport = "create table Report(id integer primary key autoincrement,vehicleName string,frame string,powerTrain string,wheelNumber string,wheelMaterial string,date date)";
        db.execSQL(sqlreport);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

 public String getVehicle(String framematerial,String powertrain,String wheelframe,String wheelnumber,String date)
 {
     String vehicle="Unknown";
     String[] col={"type"};
     String selection=" frame = ? AND powerTrain = ? AND wheelNumber = ? AND wheelMaterial = ?";

     String[] parameter={framematerial,powertrain,wheelnumber,wheelframe};
     Cursor cursor=db.query("Vehicle",col,selection,parameter,null,null,null);
     Cursor cursor1=db.rawQuery("select type from Vehicle where frame=? AND powerTrain=? AND wheelNumber=? AND wheelMaterial=?",parameter,null);

     Toast.makeText(context,cursor1.getCount()+" Records Found ",Toast.LENGTH_LONG).show();
     if(cursor1.getCount()>0) {
         cursor1.moveToFirst();
         do {
             vehicle = cursor1.getString(0);

         }while (cursor.moveToNext());

         values.put("vehicleName",vehicle);
         values.put("frame",framematerial);
         values.put("powerTrain",powertrain);
         values.put("wheelNumber",wheelnumber);
         values.put("wheelMaterial",wheelframe);
         values.put("date",date);

         long rid=db.insert("Report",null,values);
         if(rid<0)
         {
             Toast.makeText(context,"insert issue",Toast.LENGTH_LONG).show();
         }
         else
         {
             Toast.makeText(context,"insert success",Toast.LENGTH_LONG).show();
         }
     }
     cursor.close();


     return vehicle;
 }

 ArrayList<ReportList> getReportList(){

     ArrayList<ReportList> reportList=new ArrayList<>();

     Cursor cursor=db.query("Report",null,null,null,null,null,null);
     Toast.makeText(context, +cursor.getCount()+"  Records Found", Toast.LENGTH_LONG).show();

     if(cursor.getCount()>0) {
         cursor.moveToFirst();
         do {
             String VehicleId = cursor.getString(0);
             String VehicleName = cursor.getString(1);
             String frame = cursor.getString(2);
             String powertrain = cursor.getString(3);
             String wheelnumber = cursor.getString(4);
             String wheelframe = cursor.getString(5);
             String timestamp = cursor.getString(6);
             reportList.add(new ReportList(VehicleName,VehicleId,frame,powertrain,wheelnumber,wheelframe,timestamp));

         }while (cursor.moveToNext());
     }



     return reportList;

 }

}
