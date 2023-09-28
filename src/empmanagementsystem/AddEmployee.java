package empmanagementsystem;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JLabel heading , labelempid, lblempid, lname, lfname, ldob , lsalary, laddress, lphone, lemail, lhighedu, ldesignation, laadharno;
    JTextField tfname, tffname, tfsalary, tfaddress, tfphone, tfemail, tfdesignation, tfaadharno;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JButton add, back;
    AddEmployee() {
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        lname = new JLabel("Name");
        lname.setBounds(50, 150, 150, 30);
        lname.setFont(new Font("serif",Font.PLAIN,20));
        add(lname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
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
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);
        
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
        
        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.white);
        cbeducation.setBounds(600, 300, 150, 30);
        add(cbeducation);
        
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
        
        tfaadharno = new JTextField();
        tfaadharno.setBounds(600, 350, 150, 30);
        add(tfaadharno);
        
        labelempid = new JLabel("Employee Id");
        labelempid.setBounds(50, 400, 150, 30);
        labelempid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempid);
        
        lblempid = new JLabel(""+number);
        lblempid.setBounds(200, 400, 150, 30);
        lblempid.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempid);
        
        add = new JButton("Add Details");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add(add);
        
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
        if(ae.getSource()==add){
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String higheducation = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadharno = tfaadharno.getText();
            String empid = lblempid.getText();
        
        try{
            Conn conn = new Conn();
            String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+higheducation+"','"+designation+"','"+aadharno+"','"+empid+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Deatils added sucessfully");
            setVisible(false);
            new Home();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
        else{
            setVisible(false);
            new Home();
        }
 }
    public static void main(String[] args) {
        new AddEmployee();
    }
}
