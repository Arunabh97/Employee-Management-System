package empmanagementsystem;

import java.awt.Choice;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    JLabel image,lempid,lname,lphone,lemail,lblname,lblphone,lblemail;
    JButton delete,back;
    Choice cempid;
    RemoveEmployee() {
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 0, 600, 400);
        add(image);
        
        lempid = new JLabel("Employee Id");
        lempid.setBounds(50, 50, 100, 30);
        add(lempid);
        
        cempid = new Choice();
        cempid.setBounds(180, 50, 150, 30);
        add(cempid);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                cempid.add(rs.getString("empid"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        lname = new JLabel("Name");
        lname.setBounds(50, 100, 100, 30);
        add(lname);
        
        lblname = new JLabel();
        lblname.setBounds(180, 100, 100, 30);
        add(lblname);
        
        lphone = new JLabel("Phone");
        lphone.setBounds(50, 150, 100, 30);
        add(lphone);
        
        lblphone = new JLabel();
        lblphone.setBounds(180, 150, 100, 30);
        add(lblphone);
        
        lemail = new JLabel("Email");
        lemail.setBounds(50, 200, 100, 30);
        add(lemail);
        
        lblemail = new JLabel();
        lblemail.setBounds(180, 200, 150, 30);
        add(lblemail);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empid = '"+cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));          
            }       
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cempid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from employee where empId = '"+cempid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        delete = new JButton("Delete");
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.setBounds(80, 300, 100, 30);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(220, 300, 100, 30);
        back.addActionListener(this);
        add(back);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == delete) {
        try {
            Conn c = new Conn();
            String query = "delete from employee where empid = '" + cempid.getSelectedItem() + "'";
            int rowsDeleted = c.s.executeUpdate(query);
            
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Employee information deleted successfully");
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete employee information");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        setVisible(false);
        new Home();
    }
}

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
