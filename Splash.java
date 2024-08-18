
package employ.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Splash extends JFrame implements ActionListener{
    Splash()
    {
     
        
     setLayout(null);
     getContentPane().setBackground(Color.WHITE);
     
     
     JLabel heading =new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
     heading.setBounds(300,30,800,35);
     add(heading);
     heading.setForeground(Color.red);
     heading.setFont(new Font("serif",Font.PLAIN,35));
     
     ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
     Image i2=i1.getImage().getScaledInstance(1100, 750, Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     image.setBounds(50,80,1050,460);
     add(image);
     
     JButton clickhere=new JButton("CLICK HERE TO CONTINUE");
    clickhere.setBounds(400,380,250,60);
    clickhere.setBackground(Color.BLACK);
    clickhere.setForeground(Color.WHITE);
     clickhere.addActionListener(this);
    image.add(clickhere);
     
        setSize(1170,600);
        setLocation(100,0);
        setVisible(true);
        
        while(true)
        {
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e1)
            {
                
            }
             heading.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e1)
            {
                
            }
            
        }
    }
            
            
      public void actionPerformed(ActionEvent e1)
    {
        setVisible(false);
        new Login();
    }
    public static void main(String args[])
    {
        new Splash();
    }
}
