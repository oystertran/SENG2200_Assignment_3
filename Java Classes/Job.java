import java.util.Random;
import java.util.LinkedList;

public class Job implements Comparable<Job>{
    private Stage processingStage;//reference to the locatin that event occur
    private double T1;//time event start
    private double T2;//time evend end
    private double M; //average processing time
    private double N; //range of processing time
    private double P; //processing time
    private double d; //random number [0, 1]
    private LinkedList<Widget> doneList = new LinkedList<>();

    public Job(Stage processingStage){
        calcP(processingStage.getName());
        T2 = A3.time + P;
        processingStage.incrP(P);
        this.processingStage = processingStage;
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
        return T2;
    }
    public Stage getProcessingStage(){
        return processingStage;
    }
    public LinkedList<Widget> getDoneList(){
        return doneList;
    } 

    public void dispatch(){
        if (processingStage.getName() == "s0a" || processingStage.getName() == "s0b"){//
            //at first check if the stage is blocked or not 
            if (processingStage.isBlocked()){
                processingStage.unBlock();
                processingStage.setBlockedTime(processingStage.getBlockedTime() + A3.time - processingStage.getTime());
            }
            //take an item out of the stage
            if (processingStage.getNextStorage().getSize() == processingStage.getNextStorage().getMax()){//if the current size of strage == Qmax
                processingStage.setBlock();//storage full => block stage
                processingStage.setTime(T1);
                return;
            }else{//storage has space available
                processingStage.getNextStorage().add(processingStage.getWidget());
                for (Stage stage : processingStage.getNextStage()){
                    if (stage.isStarve()){
                        dispatch();
                        break;
                    }
                }
            }
            if(processingStage.getWidget() == null){
                processingStage.setWidget(new Widget(processingStage.getName()));
            }
        }else if (processingStage.getName() == "s6"){
            if (processingStage.isStarve()){
                processingStage.unStarve();
                processingStage.setStarveTime(A3.time - processingStage.getTime());
            }
            doneList.add(processingStage.getWidget());
            if (processingStage.getPrevStorage().getSize() == 0){
                processingStage.setStarve();
                processingStage.setTime(A3.time);
            }else{
                processingStage.setWidget(processingStage.getPrevStorage().poll());
                for (Stage stage : processingStage.getPrevStage()){
                    if (stage.isBlocked()){
                        dispatch();
                        break;
                    }
                }
            }
        }else{
            if (processingStage.isBlocked()){
                processingStage.unBlock();
                processingStage.setBlockedTime(processingStage.getBlockedTime() + A3.time - processingStage.getTime());
            }
            if (processingStage.isStarve()){
                processingStage.unStarve();
                processingStage.setStarveTime(processingStage.getStarveTime() + A3.time - processingStage.getTime());
            }else{
                if (processingStage.getNextStorage().getSize() == processingStage.getNextStorage().getMax()){
                    processingStage.setBlock();
                    processingStage.setTime(A3.time);
                    return;
                }else{
                    processingStage.getNextStorage().add(processingStage.getWidget());
                    for (Stage stage : processingStage.getNextStage()){
                        if (stage.isStarve()){
                            dispatch();
                            break;
                        }
                    }
                }
            }
            if (processingStage.getPrevStorage().getSize() == 0){
                processingStage.setStarve();
                processingStage.setTime(A3.time);
            }else{
                if(processingStage.getWidget() == null){
                    processingStage.setWidget(processingStage.getPrevStorage().poll());
                }
                for (Stage stage : processingStage.getNextStage()){
                    if (stage.isStarve()){
                        dispatch();
                        break;
                    }
                }
            }
        }
    }
}
