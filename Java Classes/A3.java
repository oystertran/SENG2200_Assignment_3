public class A3 {
    private int Qmax; //capacity
    private double M; //average processing time
    private double N; //range of processing time
    private double P; //procesisng time
    private double T1; //starting time
    private double T2; //completion time
    private double d; //random number [0, 1]
    private double time = 0.0;
    
    public void main (String[] args){
        //initalize variables
        M = Integer.parseInt(args[0]);
        N = Integer.parseInt(args[1]);
        Qmax = Integer.parseInt(args[2]);

        //initialize stages
        Stage s0a = new Beginning();
        Stage s0b = new Beginning();
        Stage s1 = new Middle();
        Stage s2 = new Middle();
        Stage s3a = new Middle();
        Stage s3b = new Middle();
        Stage s4 = new Middle();
        Stage s5a = new Middle();
        Stage s5b = new Middle();
        Stage s6 = new Final();

        //create inter-stage storage
        Storage q01 = new Storage(null, Qmax);
        Storage q12 = new Storage(null, Qmax);
        Storage q23 = new Storage(null, Qmax);
        Storage q34 = new Storage(null, Qmax);
        Storage q45 = new Storage(null, Qmax);
        Storage q56 = new Storage(null, Qmax);

    }
}
