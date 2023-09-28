package empmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EmpManagementSystem extends JFrame implements ActionListener{
    
    JLabel heading,image;
    JButton clickhere;
    EmpManagementSystem(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 1100, 600);
        add(image);
        
        heading = new JLabel("EMPLOYEE MANAGEMNET SYSTEM");
        heading.setBounds(40, 30, 1100, 60);
        heading.setFont(new Font("serif",Font.BOLD,57));
        heading.setForeground(Color.yellow);
        image.add(heading);
        
        clickhere = new JButton("Click Here To Continue");
        clickhere.setBackground(Color.yellow);
        clickhere.setForeground(Color.blue);
        clickhere.setFont(new Font("serif",Font.PLAIN,40));
        clickhere.setBounds(320, 350, 450, 60);
        clickhere.addActionListener(this);
        add(clickhere);
         
        setSize(1100, 600);
        setLocation(200, 70);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
            }
            
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
        }
            
    }
    
}
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        new EmpManagementSystem();
    }
    
}
