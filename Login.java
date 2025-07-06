package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton submit, Reset, close;
    JTextField tfUserName;
    JPasswordField pfPassword;

    public Login() {
        

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lbUserName = new JLabel("Username:");
        lbUserName.setBounds(20, 20, 100, 20);
        add(lbUserName);

        tfUserName = new JTextField();
        tfUserName.setBounds(130, 20, 180, 20);
        add(tfUserName);

        JLabel lbPassword = new JLabel("Password:");
        lbPassword.setBounds(20, 60, 100, 20);
        add(lbPassword);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(130, 60, 180, 20);
        add(pfPassword);

        Reset = new JButton("Reset");
        Reset.setBounds(40, 120, 100, 30);
        Reset.addActionListener(this);
        add(Reset);

        getRootPane().setDefaultButton(submit);
        submit = new JButton("Submit");
        submit.setBounds(210, 120, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        
        close = new JButton("Close");
        close.setBounds(125, 160, 100, 30);
        close.addActionListener(this);
        add(close);

        setSize(400, 250);
        setLocation(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
    String username = tfUserName.getText().trim();
    String password = new String(pfPassword.getPassword()).trim();

    System.out.println("Username: " + username);
    System.out.println("Password: " + password);
    System.out.println("Query: select * from login where username = '" + username + "' and password = '" + password + "'");

    try {
        conn c = new conn();
        String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
        ResultSet rs = c.s.executeQuery(query);

        if (rs.next()) {
            new Home();
            setVisible(false);
            // Open next window here
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
 else if (ae.getSource() == close) {
            setVisible(false);

        } else if (ae.getSource() == Reset) {
            tfUserName.setText("");
            pfPassword.setText("");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
     
}
