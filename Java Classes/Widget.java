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
    private double T1; //starting time
    private double T2; //completion time

    public Widget(String name){
        ID singleton = ID.getInstance();//get the singleton object ID
        String x = singleton.getID();//get the ID of the object
        if(name.equals("SOa")){
            serial = x+"A";
        }else if(name.equals("SOb")){
            serial = x+"B";
        }else{
            serial = "ERROR";
        }
    }

    public String getSerial(){
        return serial;
    }
    public double getTime(){
        return time;
    }
    public double getT1(){
        return T1;
    }
    public double getT2(){
        return T2;
    }
    public void setT1(double T1){
        this.T1 = T1;
    }
    public void setT2(double T2){
        this.T2 = T2;
    }
}
