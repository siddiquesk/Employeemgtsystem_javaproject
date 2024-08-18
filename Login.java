
package employ.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    
     JTextField lbltext,lbltpass;
    
    Login()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lbluser=new JLabel("Username");
        lbluser.setBounds(40,20,100,25);
        lbluser.setFont(new Font("serif",Font.PLAIN,20));
        add(lbluser);
        
        lbltext=new JTextField();
        lbltext.setBounds(150,20,200,25);
        add(lbltext);
        
        
          JLabel lblpass=new JLabel("Password");
        lblpass.setBounds(40,70,100,25);
        lblpass.setFont(new Font("serif",Font.PLAIN,20));
        add(lblpass);
        
         lbltpass=new JTextField();
        lbltpass.setBounds(150,70,200,25);
        add(lbltpass);
        
        JButton login=new JButton("Login");
    login.setBounds(160,150,150,35);
    login.setBackground(Color.BLACK);
    login.setForeground(Color.WHITE);
    login.addActionListener(this);
    add(login);
    
         ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
     Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     image.setBounds(350,0,200,200);
     add(image);
        
        setSize(600,300);
        setLocation(400,200);
        setVisible(true);
    }
    
      public void actionPerformed(ActionEvent e1)
    {
        try{
            String username=lbltext.getText();
            String password=lbltpass.getText();
            Conn c=new Conn();
            String query="select * from login where username='"+username+"' and password='"+password+"'";
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next())
            {
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
                    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 
    public static void main(String args[])
    {
        new Login();
    }
}
