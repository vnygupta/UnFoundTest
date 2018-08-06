package com.youedufriends.unfoundtest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.youedufriends.unfoundtest.R.id.ivVehicle;

/**
 * Created by Administrator on 06-08-2018.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
     public ArrayList<ReportList> ReportList;
     public   Context context;

public HistoryAdapter(ArrayList<ReportList> ReportList, Context context) {
        this.ReportList = ReportList;
        this.context = context;
        }


@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.history_cardview,parent,false);
        return new ViewHolder(view,context,ReportList);
        }

@Override
public void onBindViewHolder(ViewHolder holder, int position){




    ReportList reportList= ReportList.get(position);
    holder.tvVehicle.setText("  Vehicle Name: "+reportList.getVehicleName());
    holder.tvVehicleID.setText("  Vehicle ID: "+reportList.getVehicleID());
    holder.tvFrame.setText("  Frame: "+reportList.getFrame());
    holder.tvPowerTrain.setText("  PowerTrain: "+reportList.getPowerTrain());
    holder.tvWheelFrame.setText("  Wheel Frame: "+reportList.getWheelFrame());
    holder.tvWheelNumber.setText("  Wheel Number: "+reportList.getWheelNumber());
    holder.tvTimeStamp.setText("  Time Stamp: "+reportList.getTimeStamp());

    Resources res=context.getResources();
    String img=reportList.getVehicleName().toLowerCase();
    int imgid=res.getIdentifier(img,"drawable",context.getPackageName());
    Drawable imgd=res.getDrawable(imgid);
    holder.ivVehicleImage.setImageDrawable(imgd);



        }
@Override
public int getItemCount() {
        return ReportList.size();
        }

class  ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvVehicle,tvVehicleID,tvFrame,tvPowerTrain,tvWheelFrame,tvWheelNumber,tvTimeStamp;

    ImageView ivVehicleImage;

    ArrayList<ReportList> listList=new ArrayList<ReportList>();

    Context context;

    public ViewHolder(View itemView, Context context, ArrayList<ReportList> listList) {
        super(itemView);
        this.context=context;
        this.listList=listList;
        tvVehicle=(TextView)itemView.findViewById(R.id.tvVehicleName2);
        tvFrame=(TextView)itemView.findViewById(R.id.tvFrame2);
        tvPowerTrain=(TextView)itemView.findViewById(R.id.tvPowerTrain2);
        tvWheelFrame=(TextView)itemView.findViewById(R.id.tvWheelFrame2);
        tvWheelNumber=(TextView)itemView.findViewById(R.id.tvWheelNumber2);
        tvTimeStamp=(TextView)itemView.findViewById(R.id.tvTimeStamp2);
        tvVehicleID=(TextView)itemView.findViewById(R.id.tvvehicleID2);
        ivVehicleImage=(ImageView)itemView.findViewById(R.id.ivVehicle1);



    }

    @Override
    public void onClick(View view) {

    }
}

}
