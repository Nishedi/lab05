package main;

import controller.Controller;
import threads.AnimalThread;
import threads.WorkerThread;
import view.AppFrame;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args){


        ArrayList<Integer> stateoffood = new ArrayList<>();
        ArrayList<Integer> possitionlist = new ArrayList<>();
        ArrayList<Integer> workerfoodlist = new ArrayList<>();
        ArrayList<WorkerThread> workerThreadslist = new ArrayList<>();
        for(int i =1; i<=10; i++){
            stateoffood.add(65);
        }

        for(int i = 0; i <= stateoffood.size()-1; i++)
            possitionlist.add(0);

        AppFrame Frame = new AppFrame(stateoffood, possitionlist, workerfoodlist, workerThreadslist);
        Controller controller = new Controller(Frame, stateoffood, possitionlist);
    }
}
