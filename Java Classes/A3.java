import java.util.LinkedList;
import java.util.PriorityQueue;
@SuppressWarnings("unchecked")
public class A3 {
    private static int Qmax; //capacity
    private static double M; //average processing time
    private static double N; //range of processing time
    public static double time = 0.0;
    private static PriorityQueue<Job> jobs = new PriorityQueue<>(5);
    private static LinkedList<Stage> stages = new LinkedList<>();
    
    public static void main (String[] args){
        //initalize variables from cmd input
        M = Integer.parseInt("3");
        N = Integer.parseInt("3");
        Qmax = Integer.parseInt("3");

        //create inter-stage storage
        Storage<Widget> q01 = new Storage<>("q01", Qmax);
        Storage<Widget> q12 = new Storage<>("q12", Qmax);
        Storage<Widget> q23 = new Storage<>("q23", Qmax);
        Storage<Widget> q34 = new Storage<>("q34", Qmax);
        Storage<Widget> q45 = new Storage<>("q45", Qmax);
        Storage<Widget> q56 = new Storage<>("q56");// final stage have infinite sized warehouse

        //create all stages with inter-stage storage associated to them
        Stage s0a = new Stage("s0a", q01);
        stages.add(s0a);
        Stage s0b = new Stage("s0b", q01);
        stages.add(s0b);
        Stage s1 = new Stage("s1", q01, q12);
        stages.add(s1);
        Stage s2 = new Stage("s2", q12, q23);
        stages.add(s2);
        Stage s3a = new Stage("s3a", q23, q34);
        stages.add(s3a);
        Stage s3b = new Stage("s3b", q23, q34);
        stages.add(s3b);
        Stage s4 = new Stage("s4", q34, q45);
        stages.add(s4);
        Stage s5a = new Stage("s5a", q45, q56);
        stages.add(s5a);
        Stage s5b = new Stage("s5b", q45, q56);
        stages.add(s5b);
        Stage s6 = new Stage("s6", q56);
        stages.add(s6);

        //begining stages
        s0a.setNext(s1);
        s0b.setNext(s1);
        //stage 1
        s1.setNext(s2);
        s1.setPrev(s0a);
        s1.setPrev(s0b);
        //stage 2
        s2.setNext(s3a);
        s2.setNext(s3b);
        s2.setPrev(s1);
        //satage 3
        s3a.setNext(s4);
        s3b.setNext(s4);
        s3a.setPrev(s2);
        s3b.setPrev(s2);
        //stage 4
        s4.setNext(s5a);
        s4.setNext(s5b);
        s4.setPrev(s3a);
        s4.setPrev(s3b);
        //stage 5
        s5a.setNext(s6);
        s5b.setNext(s6);
        s5a.setPrev(s4);
        s5b.setPrev(s4);
        //stage 6
        s6.setPrev(s5a);
        s6.setPrev(s5b);

        jobs.add(new Job(s0a));
        jobs.add(new Job(s0b));
        jobs.add(new Job(s1));
        jobs.add(new Job(s2));
        jobs.add(new Job(s2));
        jobs.add(new Job(s3a));
        jobs.add(new Job(s3b));
        jobs.add(new Job(s4));
        jobs.add(new Job(s4));
        jobs.add(new Job(s5a));
        jobs.add(new Job(s5b));

        while (time < 5){
            Job current = jobs.poll();
            time = current.getT2();
            current.dispatch();
        }

    }

    private static boolean checkEmpty(){
        int counter = 0;
        for(Stage stage: stages){
            if (stage == null && counter == stages.size()){
                return true;
            }else{
                counter++;
            }
        }
        return false;
    }
}
