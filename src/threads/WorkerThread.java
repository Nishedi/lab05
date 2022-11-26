package threads;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class WorkerThread extends Thread {
    ArrayList<Integer> whichlist;
    ArrayList<Integer> possitionslist;
    int storage;
    int number;
    int isrunning;
    int possition;
    int direction; // -1 left, 1 - right
    Integer flagofacces;

    public int state; // 1 - moving - green, 2 - feeding - blue, 3 - trying to get food source - yellow, 4 - while getting food from source - red
    Random rand = new Random();
    public WorkerThread(ArrayList<Integer> whichlist, ArrayList<Integer> possitionslist, int number, Integer flage){
        this.flagofacces = flage;
        this.storage = 100;
        this.whichlist=whichlist;
        this.number=number;
        this.possitionslist=possitionslist;
        isrunning=1;
        int startpoint = rand.nextInt(0,2);
        if(startpoint==0)
            possition=-1;
        if(startpoint==1)
            possition=possitionslist.size();
    }

    public void run(){
        while(isrunning==1){
                if (possition >= 0 && possition <= possitionslist.size() - 1) {
                    Integer statusoffood = whichlist.get(possition);
                    if (statusoffood < 50 && statusoffood > 0) {
                        state = 2;
                        int need = 100 - statusoffood;
                        whichlist.set(possition, statusoffood + Math.min(need, storage));
                        storage = storage - Math.min(need, storage);
                        try {
                            sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        state = 1;
                        if (storage == 0) {
                            getFoodFromStorage();
                        }
                    }
                }
                move();
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        }
        System.out.println("Closed");
    }

    void getFoodFromStorage(){
        state = 3;
        synchronized (flagofacces) {
            state = 4;
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            storage = 100;
            state = 1;
        }
    }

    public void move(){
        if(possition<=0){
            direction=1;
        }
        if(possition>=possitionslist.size()){
            direction=-1;
        }
        if(possition>=possitionslist.size()-1){
            direction=-1;
        }

        int newpossition;

        newpossition=possition+direction;
        synchronized (possitionslist) {
            if (possitionslist.get(newpossition) == 0) {
                if (possition >= 0 && possition <= possitionslist.size() - 1)
                    possitionslist.set(possition, 0);
                possition = newpossition;
                possitionslist.set(newpossition, number + 1);
            } else {
                direction = -direction;
            }
        }
    }

    public void cancel(){
        isrunning=0;
    }
}

