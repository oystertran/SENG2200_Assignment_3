/*
 * This is the widget class that represent a widget object that store
 * simulation time values
 * Student Name: Nguyen Quang Hao Tran
 * SID: c3409773
 * Date Created: May 30, 2024
 * Last Modified: May 30, 2024
 */
public class Widget {
    private String serial;
    private double time;

    public Widget(String stage, double time){
        ID singleton = ID.getInstance();//get the singleton object ID
        String x = singleton.getID();//get the ID of the object
        if(stage.equals("SOa")){
            serial = x+"A";
        }else if(stage.equals("SOb")){
            serial = x+"B";
        }else{
            serial = "ERROR";
        }
        this.time = time;
    }

    public String getSerial(){
        return serial;
    }

    public double getTime(){
        return time;
    }
}
