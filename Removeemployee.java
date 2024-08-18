
package employ.management.system;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Removeemployee extends JFrame implements ActionListener{
    Choice emp;
    JButton  delete,back;
    Removeemployee()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblempid=new JLabel("Employee Id");
        lblempid.setBounds(50,50,100,30);
        add(lblempid);
        
        emp =new Choice();
        emp.setBounds(200,55,150,30);
        add(emp);
        
        try{
            Conn c=new Conn();
            String query="select * from employee";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                emp.add(rs.getString("empid"));
            }
        }
        catch(Exception e1)
        {
            
        }
            
         JLabel labelname=new JLabel("Name");
         labelname.setBounds(50,100,100,30);
        add( labelname);
        
        JLabel lblname=new JLabel();
         lblname.setBounds(200,100,100,30);
        add(lblname);
        
           JLabel labelphone=new JLabel("Phone");
          labelphone.setBounds(50,150,100,30);
        add(labelphone);
        
        JLabel lblphone=new JLabel();
        lblphone.setBounds(200,150,100,30);
        add(lblphone);
        
          JLabel labelemail=new JLabel("Email");
         labelemail.setBounds(50,200,200,30);
        add(labelemail);
        
        JLabel lblemail=new JLabel();
       lblemail.setBounds(200,200,100,30);
        add( lblemail);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where empid ='"+emp.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
               lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                 lblemail.setText(rs.getString("email"));
            }
        }
        catch(Exception e1)
        {
            
        }
        
        emp.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent i1)
            {
                try{
            Conn c=new Conn();
            String query="select * from employee where empid ='"+emp.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
               lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                 lblemail.setText(rs.getString("email"));
            }
        }
        catch(Exception e1)
        {
            
        } 
            }
        });
        
        
             ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
     Image i2=i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     image.setBounds(400,50,500,200);
     add(image);
        
        delete =new JButton("Delete");
        delete.setBounds(100,300,120,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
         back =new JButton("Back");
        back.setBounds(300,300,120,30);
        back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
      setSize(1000,500);
      setLocation(100,200);
      setVisible(true);
    }
    public void actionPerformed(ActionEvent e1)
    {
        if(e1.getSource()==delete)
        {
            try{
                Conn c=new Conn();
                String query="delete from employee where empid = '"+emp.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "employee information delete succesfully");
                setVisible(false);
                new Home();
            }
            catch(Exception p1)
            {
                p1.printStackTrace();
            }
                
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[])
    {
        new Removeemployee();
    }
}
