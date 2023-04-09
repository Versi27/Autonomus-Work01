package Port;

import PaqI04.Hub;
import PaqI04.Container;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JTextField text1;
    private JTextField text2;
    private JTextArea description1;
    private JTextField text3;
    private JTextField text4;
    private JButton pileButton;
    private JButton unpileButton;
    private JButton showDButton;
    private JButton numCButton;
    private JTextField text5;
    private JTextArea description2;
    private JTextField text6;
    private JCheckBox check1;
    private JTextArea description3;
    private JRadioButton Rbutton02;
    private JRadioButton Rbutton01;
    private JComboBox Cbox2;
    private JPanel mainPanel;
    private JComboBox cbox1;
    private JRadioButton Rbutton03;
    private JPanel logo;

    public MainFrame(){
        setTitle("Port");
        setSize(1200, 1500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        logo.setSize(150,128);
        
        Hub x = new Hub();

        showDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String desc1 = description1.getText();

                description2.setText(desc1);
            }
        });

        numCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                x.contC((String) cbox1.getSelectedItem());

                text6.setText(String.valueOf(x.contC((String) cbox1.getSelectedItem())));
            }
        });


    //PILE:
        pileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container c = new Container();

                c.setId(Integer.parseInt(text1.getText()));
                c.setDescription(description2.getText());
                c.setCountry((String)cbox1.getSelectedItem());
                if (Rbutton01.isSelected()) c.setPriority(1);
                if (Rbutton02.isSelected()) c.setPriority(2);
                if (Rbutton03.isSelected()) c.setPriority(3);
                c.setWeight(Integer.parseInt(text2.getText()));
                if(check1.isSelected()) c.isInspected();
                c.setEmisor(text3.getText());
                c.setReceptor(text4.getText());

                System.out.println("A container is being stacked...");
                x.apilar(c);
                description3.setText(x.toString());
            }
        });


    //UNPILE:
        unpileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                x.desapilar(Integer.parseInt(text6.getText()));
                System.out.println("A container from the selected column has been removed");
                description3.setText(x.toString());
            }
        });
    }


    //MAIN:
    public static void main(String[] args) {

        MainFrame myFrame = new MainFrame();
    }
}
