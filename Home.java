
package employ.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
    
    JButton view,update,add,remove;
    Home()
    {
        setLayout(null);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
     Image i2=i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     image.setBounds(0,0,1120,630);
     add(image);
     
     JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
     heading.setBounds(600,20,500,35);
     heading.setFont(new Font("Raleway",Font.BOLD,25));
     image.add(heading);
     
     add=new JButton("Add Employee");
     add.setBounds(600,80,150,35);
      add.addActionListener(this);
     image.add(add);
        
     view=new JButton(" View Employee");
     view.setBounds(770,80,150,35);
     view.addActionListener(this);
     image.add(view);
     
    remove=new JButton(" Remove Employee");
   remove.setBounds(600,180,150,35);
    remove.addActionListener(this);
     image.add(remove);
     
   update=new JButton("Update Employee");
    update.setBounds(770,180,150,35);
     update.addActionListener(this);
     image.add(update);
     
        setSize(1120,630);
        setLocation(200,30);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e1)
    {
        if(e1.getSource()==add)
        {
            setVisible(false);
            new Addemployee();
        }
        
         else if(e1.getSource()==view)
        {
            setVisible(false);
            new Viewemployee();
        }
        else if(e1.getSource()==update)
        {
            setVisible(false);
            new Viewemployee();
        }
       
        else
        {
            
        }
    }
    public static void main(String args[])
    {
        new Home();
    }
}
