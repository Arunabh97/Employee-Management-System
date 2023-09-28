package empmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{

    JLabel heading , labelempid, lblempid, lname, lfname, ldob ,empId, lsalary, laddress, lphone, lemail, lhighedu, ldesignation, laadharno;
    JTextField tffname, tfsalary, tfaddress, tfphone, tfemail, tfdesignation, tfeducation;
    JButton update,back;
    String empid;
    UpdateEmployee(String empid) {
        
        this.empid=empid;
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        lname = new JLabel("Name");
        lname.setBounds(50, 150, 150, 30);
        lname.setFont(new Font("serif",Font.PLAIN,20));
        add(lname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        lfname = new JLabel("Father's Name");
        lfname.setBounds(400, 150, 150, 30);
        lfname.setFont(new Font("serif",Font.PLAIN,20));
        add(lfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        ldob = new JLabel("Date of Birth");
        ldob.setBounds(50, 200, 150, 30);
        ldob.setFont(new Font("serif",Font.PLAIN,20));
        add(ldob);
        
        JLabel doc = new JLabel();
        doc.setBounds(200, 200, 150, 30);
        add(doc);
        
        lsalary = new JLabel("Salary");
        lsalary.setBounds(400, 200, 150, 30);
        lsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(lsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        laddress = new JLabel("Address");
        laddress.setBounds(50, 250, 150, 30);
        laddress.setFont(new Font("serif",Font.PLAIN,20));
        add(laddress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        lphone = new JLabel("Phone");
        lphone.setBounds(400, 250, 150, 30);
        lphone.setFont(new Font("serif",Font.PLAIN,20));
        add(lphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        lemail = new JLabel("Email");
        lemail.setBounds(50, 300, 150, 30);
        lemail.setFont(new Font("serif",Font.PLAIN,20));
        add(lemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        lhighedu = new JLabel("Highest Education");
        lhighedu.setBounds(400, 300, 150, 30);
        lhighedu.setFont(new Font("serif",Font.PLAIN,20));
        add(lhighedu);
        
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);
        
        ldesignation = new JLabel("Designation");
        ldesignation.setBounds(50, 350, 150, 30);
        ldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(ldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);
        
        laadharno = new JLabel("Aadhar Number");
        laadharno.setBounds(400, 350, 150, 30);
        laadharno.setFont(new Font("serif",Font.PLAIN,20));
        add(laadharno);
        
        JLabel lblaadharno = new JLabel();
        lblaadharno.setBounds(600, 350, 150, 30);
        add(lblaadharno);
        
        labelempid = new JLabel("Employee Id");
        labelempid.setBounds(50, 400, 150, 30);
        labelempid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempid);
        
        empId = new JLabel();
        empId.setBounds(200, 400, 150, 30);
        empId.setFont(new Font("serif",Font.PLAIN,20));
        add(empId);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empId ='"+empid+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                doc.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation"));
                lblaadharno.setText(rs.getString("aadhar"));
                empId.setText(rs.getString("empId"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        update = new JButton("Update Details");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(250, 550, 150, 40);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        add(back);
        
        setSize(900 , 700);
        setLocation(300, 50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==update){
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText(); 
            try{
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details update sucessfully ");
                setVisible(false);
                new Home();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
            else{
                    setVisible(false);
                    new Home();
                    }
    }
    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
