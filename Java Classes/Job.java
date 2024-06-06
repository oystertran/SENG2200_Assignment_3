import java.util.Random;

public class Job implements Comparable<Job>{
    private Stage processingStage;//reference to the locatin that event occur
    private double T1;//time event start
    private double M; //average processing time
    private double N; //range of processing time
    private double P; //processing time
    private double d; //random number [0, 1]
    private double time = 0.0;

    public Job(Stage processingStage, double T1){
        this.T1 = T1;
        this.processingStage = processingStage;
        calcP(processingStage.getName());
    }

    @Override
    public int compareTo(Job job){
        if (this.T1 > job.T1){
            return 1;
        }else{
            return 0;
        }
    }
    /*
     * Method to calculate processing time of a stage
     */
    public void calcP(String name){
        Random r = new Random();
        d = r.nextDouble();
        switch (name){
            case "s0a":
                P = 2*M + 2*N * (d - 0.5);
            case "s3a":
                P = 2*M + 2*N * (d - 0.5);
            case "s3b":
                P = 2*M + 2*N * (d - 0.5);
            case "s5a":
                P = 2*M + 2*N * (d - 0.5);
            case "s5b":
                P = 2*M + 2*N * (d - 0.5);
            default:
                P = M + N * (d - 0.5);
        }
    }

    public void setM(double M){
        this.M = M;
    }
    public void setN(double N){
        this.N = N;
    }

    public double getM(){
        return M;
    }
    public double setN(){
        return N;
    }

    public double getT2(){
        double T2 = T1 + P;
        return T2;
    }
    public Stage getProcessingStage(){
        return processingStage;
    }
}
