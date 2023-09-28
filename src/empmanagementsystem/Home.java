package empmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener{
    
    JLabel image,heading ;
    JButton add,view,update,delete;
    Home() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        heading = new JLabel("Employee Management System");
        heading.setForeground(Color.blue);
        heading.setBounds(550, 20, 480, 40);
        heading.setFont(new Font("Raleway",Font.BOLD,30));
        image.add(heading);
        
        add = new JButton("Add Employee");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setFont(new Font("Raleway",Font.BOLD,13));
        add.setBounds(600, 100, 150, 50);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Employee");
        view.setBackground(Color.black);
        view.setForeground(Color.white);
        view.setFont(new Font("Raleway",Font.BOLD,13));
        view.setBounds(790, 100, 150, 50);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Employee");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setFont(new Font("Raleway",Font.BOLD,13));
        update.setBounds(600, 180, 150, 50);
        update.addActionListener(this);
        image.add(update);
        
        delete = new JButton("Delete Employee");
        delete.setBounds(790, 180, 150, 50);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.setFont(new Font("Raleway",Font.BOLD,13));
        delete.addActionListener(this);
        image.add(delete);
        
        setSize(1120, 630);
        setLocation(200, 70);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            setVisible(false);
            new AddEmployee();
        } 
        else if(ae.getSource()==view){
            setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee("");
        }
        else{
            setVisible(false);
            new RemoveEmployee();
        }
    }
    public static void main(String[] args) {
        new Home();
    }
}
