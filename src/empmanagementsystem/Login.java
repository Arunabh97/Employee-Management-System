package empmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener{

    JLabel lblusername , lblpassword;
    JTextField tfusername,tfpassword;
    JButton login;
    JLabel image;
    Login(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        lblusername = new JLabel("Username");
        lblusername.setBounds(90, 170, 120, 20);
        lblusername.setFont(new Font("seif",Font.PLAIN,25));
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(290, 170, 190, 30);
        add(tfusername);
        
        lblpassword = new JLabel("Password");
        lblpassword.setBounds(90, 230, 120, 20);
        lblpassword.setFont(new Font("seif",Font.PLAIN,25));
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(290, 230, 190, 30);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setFont(new Font("serif",Font.PLAIN,25));
        login.setBounds(250, 320, 120, 40);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(500, 80, 300, 300);
        add(image);
        
        setSize(800, 550);
        setLocation(400, 70);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    public void actionPerformed(ActionEvent e) {
    try {
        String username = tfusername.getText();
        String password = tfpassword.getText();
        Conn c = new Conn();
        String query = "select * from login where username='"+username+"' and password='"+password+"'";
        
        ResultSet rs= c.s.executeQuery(query);
        if(rs.next()){
            setVisible(false);
            new Home();
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
            setVisible(true);
        }   
    }
    catch(Exception ae){
        ae.printStackTrace();
    }
}

    public static void main(String[] args) {
        new Login();
    }
    
}
