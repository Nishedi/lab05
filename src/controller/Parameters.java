package controller;

import javax.swing.*;

public class Parameters {
    public int speedofeating=5;
    public int speedofmoving=5;
    public int speedofgettingresources=5;


    public void increasespeedofeating(){
        if(speedofeating<=10)
            speedofeating++;

    }
    public void decreasespeedofeating(){
        if(speedofeating>=1)
            speedofeating--;
    }
    public void increasespeedofmoving(){
        if(speedofmoving<=10)
            speedofmoving++;
    }
    public void decreasespeedofmoving(){
        if(speedofmoving>=1)
            speedofmoving--;
    }
    public void increasespeedofgettingresources(){
        if(speedofgettingresources<=10)
            speedofgettingresources++;
    }
    public void decreasespeedofgettingresources(){
        if(speedofgettingresources>=1)
            speedofgettingresources--;
    }
}
