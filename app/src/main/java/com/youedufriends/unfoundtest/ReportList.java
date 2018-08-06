package com.youedufriends.unfoundtest;

/**
 * Created by Administrator on 06-08-2018.
 */

public class ReportList {

    String VehicleName;
    String VehicleID;
    String Frame;
    String PowerTrain;
    String WheelNumber;
    String WheelFrame;
    String TimeStamp;

    public ReportList(String vehicleName, String vehicleID, String frame, String powerTrain, String wheelNumber, String wheelFrame, String timeStamp) {
        VehicleName = vehicleName;
        VehicleID = vehicleID;
        Frame = frame;
        PowerTrain = powerTrain;
        WheelNumber = wheelNumber;
        WheelFrame = wheelFrame;
        TimeStamp = timeStamp;
    }

    public String getVehicleName() {
        return VehicleName;
    }

    public void setVehicleName(String vehicleName) {
        VehicleName = vehicleName;
    }

    public String getVehicleID() {
        return VehicleID;
    }

    public void setVehicleID(String vehicleID) {
        VehicleID = vehicleID;
    }

    public String getFrame() {
        return Frame;
    }

    public void setFrame(String frame) {
        Frame = frame;
    }

    public String getPowerTrain() {
        return PowerTrain;
    }

    public void setPowerTrain(String powerTrain) {
        PowerTrain = powerTrain;
    }

    public String getWheelNumber() {
        return WheelNumber;
    }

    public void setWheelNumber(String wheelNumber) {
        WheelNumber = wheelNumber;
    }

    public String getWheelFrame() {
        return WheelFrame;
    }

    public void setWheelFrame(String wheelFrame) {
        WheelFrame = wheelFrame;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        TimeStamp = timeStamp;
    }
}
