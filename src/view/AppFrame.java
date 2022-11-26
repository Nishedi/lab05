package view;

import threads.WorkerThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppFrame extends JFrame{

    JPanel editpanel;
    JPanel simulationpanel;
    JPanel logpanel;
    public JButton removeworker;
    public JButton addworker;
    public JButton removeanimal;
    public JButton addanimal;

    public JList list;
    public JButton butn;
    ArrayList<Integer> listoffood;
    ArrayList<Integer> possitionlist;
    ArrayList<Integer> workerfoodlist;
    public ArrayList<WorkerThread> workerThreadslist;

    public AppFrame(ArrayList<Integer> listoffood, ArrayList<Integer> possitionlist, ArrayList<Integer> workerfoodlist, ArrayList<WorkerThread> workerThreadslist){
        this.listoffood = listoffood;
        this.possitionlist = possitionlist;
        this.workerfoodlist = workerfoodlist;
        this.workerThreadslist=workerThreadslist;
        editpanel = new JPanel();
        removeworker=new JButton();
        removeworker.setText("removeworker");
        addworker=new JButton();
        addworker.setText("addworker");
        removeanimal = new JButton();
        removeanimal.setText("removeanimal");
        addanimal = new JButton();
        addanimal.setText("addanimal");
        editpanel.add(removeworker);
        editpanel.add(addworker);
        editpanel.add(removeanimal);
        editpanel.add(addanimal);



        list=new JList<>();
        butn = new JButton();

        simulationpanel = new DrawPanel(listoffood, possitionlist, workerfoodlist, workerThreadslist);
        simulationpanel.setSize(800,500);
        simulationpanel.setPreferredSize(new Dimension(800,500));


        logpanel=new JPanel();
        editpanel.setBackground(Color.ORANGE);
        simulationpanel.setBackground(Color.cyan);
        logpanel.setBackground(Color.green);
        logpanel.setPreferredSize(new Dimension(500,200));
        logpanel.add(list);

        this.add(editpanel, BorderLayout.NORTH);
        this.add(simulationpanel, BorderLayout.CENTER);
        this.add(logpanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ustawia domyślną akcję zamknięcia okna
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void removeworkerListener(ActionListener listenforremoveworkerbutton){removeworker.addActionListener(listenforremoveworkerbutton);}
    public void addworkerListener(ActionListener listenforaddworkerbutton){addworker.addActionListener(listenforaddworkerbutton);}
    public void removeanimallistener(ActionListener listenforremoveanimallbutton){removeanimal.addActionListener(listenforremoveanimallbutton);}
    public void addanimallistener(ActionListener listenforaddanimalbutton){addanimal.addActionListener(listenforaddanimalbutton);}
}
