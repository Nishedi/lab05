package view;

import threads.WorkerThread;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
    ArrayList<Integer> listoffood;
    ArrayList<Integer> possitionlist;
    ArrayList<Integer> workerfoodlist;
    ArrayList<WorkerThread> workerThreadslist;
    public DrawPanel(ArrayList listoffood, ArrayList<Integer> possitionlist, ArrayList<Integer> workerfoodlist, ArrayList<WorkerThread> workerThreadslist){
        this.listoffood=listoffood;
        this.possitionlist = possitionlist;
        this.workerfoodlist=workerfoodlist;
        this.workerThreadslist=workerThreadslist;
    }
    public void paint (Graphics G) {
        super.paint(G);
        Graphics2D G2D = (Graphics2D) G;
        G2D.drawLine(100, 50,200+ (listoffood.size()-1)*50, 50);
        G2D.drawLine(100,50,100,200);
        G2D.drawLine(100,200,200+ (listoffood.size()-1)*50,200);
        G2D.drawLine(200+ (listoffood.size()-1)*50,50,200+ (listoffood.size()-1)*50,200);

        for(int i = 0; i<= listoffood.size()-1;i++) {
            G2D.drawString(String.valueOf(listoffood.get(i)),150+i*50,125);
            paintwithcolorlines(G2D, i);
        }

        for(int i = 0; i<= possitionlist.size()-1;i++) {
            if(possitionlist.get(i)!=0) {
                int workerid = possitionlist.get(i);
                int state = workerThreadslist.get(workerid-1).state;
                if(state == 1)
                    G2D.setColor(Color.green);
                if(state == 2)
                    G2D.setColor(Color.blue);
                if(state == 3)
                    G2D.setColor(Color.yellow);
                if(state == 4)
                    G2D.setColor(Color.red);
                G2D.fillOval(143 + i * 50, 160,20,20);
                G2D.setColor(Color.BLACK);
                G2D.drawOval(143 + i * 50, 160,20,20);
                G2D.drawString(String.valueOf(possitionlist.get(i)), 150 + i * 50, 175);
            }
        }

        for(int i = 0; i<= listoffood.size()-1;i++) {
            paintwithcolorlines(G2D, i);
            G2D.drawString(String.valueOf(listoffood.get(i)),150+i*50,125);
        }

    }
    public void paintwithlines(Graphics2D G2D, int i){
        G2D.fillRect(146+i*50,110,20,20);
    }

    public void paintwithcolorlines(Graphics2D G2D, int i){
        int k = listoffood.get(i);
        if(k>=85) {
            G2D.setColor(Color.green.darker().darker());
            paintwithlines(G2D, i);
            G2D.setColor(Color.BLACK);
            return;
        }
        if(k>=70) {
            G2D.setColor(Color.green.darker());
            paintwithlines(G2D, i);
            G2D.setColor(Color.BLACK);
            return;
        }
        if(k>=55) {
            G2D.setColor(Color.green);
            paintwithlines(G2D, i);
            G2D.setColor(Color.BLACK);
            return;
        }
        if(k>=40) {
            G2D.setColor(Color.YELLOW);
            paintwithlines(G2D, i);
            G2D.setColor(Color.BLACK);
            return;
        }
        if(k>=25) {
            G2D.setColor(Color.orange);
            paintwithlines(G2D, i);
            G2D.setColor(Color.BLACK);
            return;
        }
        if(k>=10) {
            G2D.setColor(Color.RED);
            paintwithlines(G2D, i);
            G2D.setColor(Color.BLACK);
            return;
        }
        paintwithlines(G2D, i);
    }
}
