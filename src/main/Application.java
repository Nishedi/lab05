package main;

import controller.Controller;
import controller.Parameters;
import threads.AnimalThread;
import threads.WorkerThread;
import view.AppFrame;

import java.util.ArrayList;
import java.util.Stack;

public class Application {

    public static void main(String[] args){

        //Parameters parameters=new Parameters();
        ArrayList<Integer> stateoffood = new ArrayList<>();
        ArrayList<Integer> possitionlist = new ArrayList<>();
        ArrayList<Integer> workerfoodlist = new ArrayList<>();
        ArrayList<WorkerThread> workerThreadslist = new ArrayList<>();
        ArrayList<Integer> stamina = new ArrayList<>();
        ArrayList<Boolean> isfeeded = new ArrayList<Boolean>();
        for(int i =1; i<=10; i++){
            stateoffood.add(65);
            stamina.add(10);
        }

        for(int i = 0; i <= stateoffood.size()-1; i++)
            possitionlist.add(0);

        AppFrame Frame = new AppFrame(stateoffood, possitionlist, workerfoodlist, workerThreadslist, stamina);
        Controller controller = new Controller(Frame, stateoffood, possitionlist, stamina/*, parameters*/);
    }
}
