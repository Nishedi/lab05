package controller;

public class Storage {
    private int flag;
    public Storage(){
        flag=0;
    }
    public void getAcces(){
        synchronized (this) {
            flag = 1;
        }
    }


}
