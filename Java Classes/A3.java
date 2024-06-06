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
        //initalize variables from cmd input
        M = Integer.parseInt(args[0]);
        N = Integer.parseInt(args[1]);
        Qmax = Integer.parseInt(args[2]);

        //create inter-stage storage
        Storage q01 = new Storage("q01", Qmax);
        Storage q12 = new Storage("q12", Qmax);
        Storage q23 = new Storage("q23", Qmax);
        Storage q34 = new Storage("q34", Qmax);
        Storage q45 = new Storage("q45", Qmax);
        Storage q56 = new Storage("q56", 99999);// final stage have infinite sized warehouse

        //create all stages
        Stage s0a = new Beginning("s0a", q01);
        Stage s0b = new Beginning("s0b", q01);
        Stage s1 = new Middle("s1", q01, q12);
        Stage s2 = new Middle("s2", q12, q23);
        Stage s3a = new Middle("s3a", q23, q34);
        Stage s3b = new Middle("s3b", q23, q34);
        Stage s4 = new Middle("s4", q34, q45);
        Stage s5a = new Middle("s5a", q45, q56);
        Stage s5b = new Middle("s5b", q45, q56);
        Stage s6 = new Final("s6", q56);
        
        while (time < 10000000){
            
        }

    }
}
