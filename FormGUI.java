/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Suwaphot
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FormGUI implements ActionListener{
    private JFrame fr;
    private JLabel lb1,lb2,lb3,lb4,lb5,lb6;
    private JLabel lb7,lb8;
    private JTextField tf1,tf2,tf3,tf4;
    private JTextArea ta5;
    private JButton submit;
    private JPanel panel1,panel2,panel3;
    private JPanel sm1,sm2,sm3,sm4,sm5,sm6,sm7,sm8,sm9,sp1;
    private JLabel blank1,blank2;
    private JComboBox cb1,cb2,cb3,cb4,cb5,cb6;
    private JTextField autodate1,autodate2,autodate3;
    private JPanel fill1,fill2,fill3;
    
    
    public FormGUI(){
        
       fr = new JFrame("Forms");
       
       lb1 = new JLabel("ID     ");
       lb2 = new JLabel("Name       ");
       lb3 = new JLabel("Amount Due     ");
       lb4 = new JLabel("Advance Payment        ");
       lb5 = new JLabel("Details        ");
       lb6 = new JLabel("Due Date       ");
       lb7 = new JLabel("Last Paid      ");
       lb8 = new JLabel("Joined Date        ");

       blank1 = new JLabel("");blank2 = new JLabel("");
       
       tf1 = new JTextField(30);
       tf1.setEditable(false);
       tf2 = new JTextField(30);
       tf3 = new JTextField(30);
       tf4 = new JTextField(30);
       tf4.setEditable(false);
       ta5 = new JTextArea(5,30);
       
       panel1 = new JPanel();
       panel2 = new JPanel();
       panel3 = new JPanel();
       
       cb2 = new JComboBox();
       cb5 = new JComboBox();
       
       
       sm1 = new JPanel();
       sm2 = new JPanel();
       sm3 = new JPanel();
       sm4 = new JPanel();
       sm5 = new JPanel();
       sm6 = new JPanel();
       sm7 = new JPanel();
       sm8 = new JPanel();
       sm9 = new JPanel();
       sp1 = new JPanel();

       
       fill1 = new JPanel();
       fill2 = new JPanel();
       fill3 = new JPanel();
       
       autodate1 = new JTextField(8);
       autodate2 = new JTextField(8);
       autodate3 = new JTextField(8);

       
       submit = new JButton("Submit");
       
       submit.addActionListener(this);
       
       //Combo Box
       ArrayList<String> day_tmp = new ArrayList<>();
       for(int day = 1; day<=31; day++) {
       day_tmp.add(day+"");
       }
       cb1 = new JComboBox(day_tmp.toArray());
       cb4 = new JComboBox(day_tmp.toArray()); 
       ArrayList<String> years_tmp = new ArrayList<>();
       for(int years = 2020; years<=2050; years++) {
       years_tmp.add(years+"");
       }
       cb3 = new JComboBox(years_tmp.toArray());
       cb6 = new JComboBox(years_tmp.toArray());
       
                 
       cb2.addItem("January");cb2.addItem("February");cb2.addItem("March");cb2.addItem("April");cb2.addItem("May");cb2.addItem("June");
       cb2.addItem("July");cb2.addItem("August");cb2.addItem("September");cb2.addItem("October");cb2.addItem("November");cb2.addItem("December");
       cb5.addItem("January");cb5.addItem("February");cb5.addItem("March");cb5.addItem("April");cb5.addItem("May");cb5.addItem("June");
       cb5.addItem("July");cb5.addItem("August");cb5.addItem("September");cb5.addItem("October");cb5.addItem("November");cb5.addItem("December");
       
       
       fill1.setLayout(new GridLayout(1,3));
       fill1.add(cb1);fill1.add(cb2);fill1.add(cb3);
       
       fill2.setLayout(new GridLayout(1,3));
       fill2.add(autodate1);fill2.add(autodate2);fill2.add(autodate3);
       autodate1.setEditable(false);autodate2.setEditable(false);autodate3.setEditable(false);
       
       fill3.setLayout(new GridLayout(1,3));
       fill3.add(cb4);fill3.add(cb5);fill3.add(cb6);
       
       sm1.setLayout(new BorderLayout());
       sm1.add(lb1);sm1.add(tf1,BorderLayout.EAST);
       sm1.setBorder(new EmptyBorder(10,10,10,10));
       sm2.setLayout(new BorderLayout());
       sm2.add(lb2);sm2.add(tf2,BorderLayout.EAST);
       sm2.setBorder(new EmptyBorder(10,10,10,10));
       sm3.setLayout(new BorderLayout());
       sm3.add(lb3);sm3.add(tf3,BorderLayout.EAST);
       sm3.setBorder(new EmptyBorder(10,10,10,10));
       sm4.setLayout(new BorderLayout());
       sm4.add(lb4);sm4.add(tf4,BorderLayout.EAST);
       sm4.setBorder(new EmptyBorder(10,10,10,10));
       sm5.setLayout(new BorderLayout());
       sm5.add(lb5);sm5.add(ta5,BorderLayout.EAST);
       sm5.setBorder(new EmptyBorder(10,10,10,10));
       sm6.setLayout(new BorderLayout());
       sm6.add(lb6);sm6.add(fill1,BorderLayout.EAST);
       sm6.setBorder(new EmptyBorder(10,10,10,10));
       sm7.setLayout(new BorderLayout());
       sm7.add(lb7);sm7.add(fill2,BorderLayout.EAST);
       sm7.setBorder(new EmptyBorder(10,10,10,10));
       sm8.setLayout(new BorderLayout());
       sm8.add(lb8);sm8.add(fill3,BorderLayout.EAST);
       sm8.setBorder(new EmptyBorder(10,10,10,10));
       sp1.add(blank1);
       sm9.setLayout(new GridLayout(1,3));
       sm9.add(blank1);
       sm9.add(submit);
       sm9.add(blank2);
       
       
       panel1.setLayout(new GridLayout(4,1));
       panel2.setLayout(new GridLayout(1,1));
       panel3.setLayout(new GridLayout(6,1));
       
       
       panel1.add(sm1);
       panel1.add(sm2);
       panel1.add(sm3);
       panel1.add(sm4);
       panel2.add(sm5);
       panel3.add(sm6);
       panel3.add(sm7);
       panel3.add(sm8);
       panel3.add(sp1);
       panel3.add(sm9);
       
       
       fr.setLayout(new GridLayout(3,1));
       fr.add(panel1);
       fr.add(panel2);
       fr.add(panel3);
       
       fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);fr.pack();
       fr.setVisible(true);fr.setLocation(650,100);  
    }

    public static void main(String[] args){
        new FormGUI(); 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(submit)){
            Thread success = new Thread(new FinishedSubmit());
            success.start();
            
            //Info Code - To be continued
        }
    }
    

    
}

