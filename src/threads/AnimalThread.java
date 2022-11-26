package threads;

import java.util.ArrayList;

public class AnimalThread extends Thread{
    ArrayList<Integer> whichlist;
    int number;
    int isrunning;
    public AnimalThread(ArrayList<Integer> whichlist, int number){
        this.whichlist=whichlist;
        this.number=number;
        isrunning=1;
    }

    public void run(){
        System.out.println("StartAnimalThread "+number);
        while(isrunning==1){
            whichlist.set(number,whichlist.get(number)-1);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(whichlist.size()>number) {
                if (whichlist.get(number) <= 0) {
                    cancel();
                }
            }else{
                cancel();
            }
        }
    }
    public void cancel(){
        isrunning=0;
    }
}
