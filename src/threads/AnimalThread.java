package threads;

import controller.Parameters;

import java.util.ArrayList;
import java.util.Random;

public class AnimalThread extends Thread{
    Parameters parameters;
    ArrayList<Integer> whichlist;
    ArrayList<Integer> stamina;
    int number;
    int isrunning;
    Random rand;
    int counter;
    public AnimalThread(ArrayList<Integer> whichlist, int number, ArrayList<Integer> stamina, Parameters parameters){
        this.whichlist=whichlist;
        this.number=number;
        this.stamina=stamina;
        rand=new Random();
        isrunning=1;
        this.parameters=parameters;
    }

    public void run(){

        System.out.println("StartAnimalThread "+number);
        counter=1;
        while(isrunning==1){
            if(whichlist.get(number)>0)
                whichlist.set(number,whichlist.get(number)-1);
            if(whichlist.get(number)<1){
                counter++;
                if(counter%5==0)
                    stamina.set(number,stamina.get(number)-1);
            }
            try {
                System.out.println(parameters);
                sleep(parameters.speedofeating*100+10*rand.nextInt(0,6));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(whichlist.size()>number) {
                if (stamina.get(number) <= 0) {
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
