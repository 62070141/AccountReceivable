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
import javax.swing.*;
import static java.lang.Thread.interrupted;

public class FinishedSubmit implements Runnable{
    private JFrame fr;
    private JLabel lb1;
    
    public FinishedSubmit(){
        fr = new JFrame("Success");
        lb1 = new JLabel("ขณะนี้คุณได้กรอกข้อมูลเสร็จเรียบร้อยแล้ว");
        fr.setLayout(new BorderLayout());
        fr.add(lb1, BorderLayout.CENTER);
        fr.setSize(275,100);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         
    }
    @Override
    public void run() {
        while (true){
            try {
                
                while (!interrupted()) {
                    
                    
                    fr.setLocation(850,400);
                    Thread.sleep(100);
                    
                }
             }
            catch(InterruptedException e) {}
        }
    }
}
