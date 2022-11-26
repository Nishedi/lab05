package controller;

import threads.AnimalThread;
import threads.WorkerThread;
import view.AppFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Controller {
    AppFrame appframe;
    Timer timer;
    ArrayList<Integer> possitionlist;
    ArrayList<Integer> listoffood;
    ArrayList<AnimalThread> animalThreadslist = new ArrayList<>();
    ArrayList<WorkerThread> workerThreadslist;
    int flag;
    public Controller(AppFrame appframe, ArrayList<Integer> listoffood, ArrayList<Integer> possitionlist) {
        this.possitionlist=possitionlist;
        this.listoffood=listoffood;
        this.appframe = appframe;
        this.workerThreadslist=appframe.workerThreadslist;

        this.appframe.removeanimallistener(new removeanimallistener());
        this.appframe.addanimallistener(new addanimallistener());
        this.appframe.addworkerListener(new addworkerlistener());
        this.appframe.removeworkerListener(new removeworkerListener());
        timer = new Timer(10, new TimerListener());
        timer.start();

        for(int i =0 ; i<=listoffood.size()-1; i++) {
            AnimalThread animalThread = new AnimalThread(listoffood,i);
            animalThreadslist.add(animalThread);
            animalThread.start();
        }

        for(int i = 0; i <= 3; i++){
            WorkerThread workerThread = new WorkerThread(listoffood, possitionlist, i, flag);
            workerThread.state=1;
            workerThreadslist.add(workerThread);
            workerThread.start();

        }

    }

    class TimerListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            appframe.repaint();
        }
    }

    class removeworkerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                //listoffood.add(100);

            }
    }

    class addworkerlistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            WorkerThread workerThread = new WorkerThread(listoffood, possitionlist,workerThreadslist.size(),flag);
            workerThreadslist.add(workerThread);
            workerThread.start();

        }
    }

    class removeanimallistener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (animalThreadslist.size() > 0) {
                animalThreadslist.get(animalThreadslist.size()-1).cancel();
                animalThreadslist.remove(animalThreadslist.size()-1);
            }
            if(listoffood.size()>0){
                listoffood.remove(listoffood.size()-1);
            }
            if(listoffood.size()>0) {
                listoffood.remove(listoffood.size() - 1);
            }
        }
    }

    class addanimallistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            listoffood.add(100);
            AnimalThread animalThread = new AnimalThread(listoffood,animalThreadslist.size());
            animalThreadslist.add(animalThread);
            possitionlist.add(0);
            animalThread.start();
        }
    }
}
