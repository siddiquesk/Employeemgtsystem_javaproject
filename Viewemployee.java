
package employ.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;      
public class Viewemployee extends JFrame implements ActionListener{
    JTable table;
    Choice employee;
    JButton p,update,print,back;
    
    Viewemployee()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel search =new JLabel("Search Employee Id");
        search.setBounds(20,20,150,25);
        add(search);
        
        employee=new Choice();
        employee.setBounds(180,20,150,20);
        add(employee);
        
        table =new JTable();
        
         try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            while(rs.next())
            {
                employee.add(rs.getString("empid"));
            }
            
        }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {
                employee.add(rs.getString("empid"));
            }
            
        }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
        
        JScrollPane jsp =new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
          p= new JButton("search");
        p.setBounds(20,60,80,20);
        p.addActionListener(this);
        add(p);
        
         print= new JButton("Print");
         print.setBounds(130,60,80,20);
        print.addActionListener(this);
        add(print);
        
          update= new JButton("Update");
         update.setBounds(230,60,80,20);
         update.addActionListener(this);
        add( update);
        
        back= new JButton("Back");
         back.setBounds(330,60,80,20);
         back.addActionListener(this);
        add( back);
        
        
        
        setSize(900,650);
        setLocation(100,30);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent e1)
    {
        
        if(e1.getSource()==p)
        {
            String query="select * from employee where empid='"+employee.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }
            catch(Exception p1)
            {
                p1.printStackTrace();
            }
        }
        else if(e1.getSource()==print)
        {
            try{
                table.print();
            }
            catch(Exception p2)
            {
                p2.printStackTrace();
            }
        }
         else if(e1.getSource()==update)
        {
            setVisible(true);
            new Updateemployee(employee.getSelectedItem());
        }
        else
         {
             setVisible(false);
             new Home();
         }
        
    }
    public static void main(String args[])
    {
        new Viewemployee();
    }
}
