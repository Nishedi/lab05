package view;

import threads.WorkerThread;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppFrame extends JFrame{

    JPanel editpanel;
    JPanel simulationpanel;
    JPanel parameterspanel;
    public JButton removeworker;
    public JButton addworker;
    public JButton removeanimal;
    public JButton addanimal;

    public JList list;
    public JButton butn;
    public JButton increasespeedofeating;
    public JButton decreasespeedofeating;
    public JButton increasespeedofmoving;
    public JButton decreasespeedofmoving;
    public JButton increasespeedofgettingresources;
    public JButton decreasespeedofgettingresources;
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



        //list=new JList<>();
        butn = new JButton();

        simulationpanel = new DrawPanel(listoffood, possitionlist, workerfoodlist, workerThreadslist);
        simulationpanel.setSize(800,500);
        simulationpanel.setPreferredSize(new Dimension(800,500));


        parameterspanel =new JPanel();
        editpanel.setBackground(Color.ORANGE);
        simulationpanel.setBackground(Color.cyan);
        parameterspanel.setBackground(Color.green);
        parameterspanel.setPreferredSize(new Dimension(500,50));
       // parameterspanel.add(list);

        increasespeedofeating = new JButton();
        decreasespeedofeating = new JButton();
        increasespeedofeating.setText("+");
        decreasespeedofeating.setText("-");
        increasespeedofeating.setBounds(10,10,10,10);
        increasespeedofmoving.setText("+");
        decreasespeedofmoving.setText("-");
        increasespeedofgettingresources.setText("+");
        decreasespeedofgettingresources.setText("-");
        parameterspanel.add(increasespeedofeating);
        parameterspanel.add(decreasespeedofeating);
        parameterspanel.add(increasespeedofmoving);
        parameterspanel.add(decreasespeedofmoving);
        parameterspanel.add(increasespeedofgettingresources);




        this.add(editpanel, BorderLayout.NORTH);
        this.add(simulationpanel, BorderLayout.CENTER);
        this.add(parameterspanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ustawia domyślną akcję zamknięcia okna
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void removeworkerListener(ActionListener listenforremoveworkerbutton){removeworker.addActionListener(listenforremoveworkerbutton);}
    public void addworkerListener(ActionListener listenforaddworkerbutton){addworker.addActionListener(listenforaddworkerbutton);}
    public void removeanimallistener(ActionListener listenforremoveanimallbutton){removeanimal.addActionListener(listenforremoveanimallbutton);}
    public void addanimallistener(ActionListener listenforaddanimalbutton){addanimal.addActionListener(listenforaddanimalbutton);}
    public void setIncreasespeedofeating(ActionListener listenforincreasespeedofeating){increasespeedofeating.addActionListener(listenforincreasespeedofeating);}
    public void setDecreasespeedofeating(ActionListener listenfordecreasespeedofeating){decreasespeedofeating.addActionListener(listenfordecreasespeedofeating);}
}
