package employ.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Updateemployee extends JFrame implements ActionListener{
    
    JButton add, back;
    JTextField lbltname, lblftname, teducation, lbltsalary, lbltphone, lbltaddress, lbltemail, lbltdesignation;    
    JLabel labelname, ldob, lbltadhar, lblemp;
    String empid;

    Updateemployee(String empid) {
        this.empid = empid;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(300, 30, 500, 30);
        heading.setFont(new Font("Raleway", Font.BOLD, 30));
        add(heading);
        
        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(200, 150, 170, 30);
        add(labelname);
        
        JLabel lblfname = new JLabel("Father's Name:");
        lblfname.setBounds(400, 150, 150, 30);
        lblfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblfname);
        
        lblftname = new JTextField();
        lblftname.setBounds(600, 150, 170, 30);
        add(lblftname);
        
        JLabel lbldob = new JLabel("Date Of Birth:");
        lbldob.setBounds(50, 200, 150, 30);
        lbldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbldob);
    
        ldob = new JLabel();
        ldob.setBounds(200, 200, 170, 30);
        add(ldob);
        
        JLabel lblsalary = new JLabel("Salary:");
        lblsalary.setBounds(400, 200, 150, 30);
        lblsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblsalary);
        
        lbltsalary = new JTextField();
        lbltsalary.setBounds(600, 200, 170, 30);
        add(lbltsalary);
        
        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(50, 250, 150, 30);
        lbladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbladdress);
        
        lbltaddress = new JTextField();
        lbltaddress.setBounds(200, 250, 170, 30);
        add(lbltaddress);
        
        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(400, 250, 150, 30);
        lblphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblphone);
        
        lbltphone = new JTextField();
        lbltphone.setBounds(600, 250, 170, 30);
        add(lbltphone);
        
        JLabel lblemail = new JLabel("Email:");
        lblemail.setBounds(50, 300, 150, 30);
        lblemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblemail);
        
        lbltemail = new JTextField();
        lbltemail.setBounds(200, 300, 170, 30);
        add(lbltemail);
        
        JLabel lbleducation = new JLabel("Highest Education:");
        lbleducation.setBounds(400, 300, 150, 30);
        lbleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbleducation);
        
        teducation = new JTextField();
        teducation.setBounds(600, 300, 170, 30);
        add(teducation);
        
        JLabel lbldesignation = new JLabel("Designation:");
        lbldesignation.setBounds(50, 350, 150, 30);
        lbldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbldesignation);
        
        lbltdesignation = new JTextField();
        lbltdesignation.setBounds(200, 350, 170, 30);
        add(lbltdesignation);
        
        JLabel lbladhar = new JLabel("Aadhar:");
        lbladhar.setBounds(400, 350, 150, 30);
        lbladhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbladhar);
        
        lbltadhar = new JLabel();
        lbltadhar.setBounds(600, 350, 170, 30);
        add(lbltadhar);
        
        JLabel lblempid = new JLabel("Employee Id:");
        lblempid.setBounds(50, 400, 150, 30);
        lblempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempid);
        
        lblemp = new JLabel();
        lblemp.setBounds(220, 400, 150, 30);
        lblemp.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblemp);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee where empid ='" + empid + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                ldob.setText(rs.getString("dob"));
                lbltadhar.setText(rs.getString("adhar"));
                lblftname.setText(rs.getString("fname"));
                lbltsalary.setText(rs.getString("salary"));
                lbltaddress.setText(rs.getString("address"));
                lbltphone.setText(rs.getString("phone"));
                lbltemail.setText(rs.getString("email"));
                teducation.setText(rs.getString("education"));
                lbltdesignation.setText(rs.getString("designation"));
                lblemp.setText(rs.getString("empid"));
            }
            c.s.close(); // Close the connection
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(300, 500, 150, 35);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
       
        back = new JButton("Back");
        back.setBounds(500, 500, 150, 35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this); // Fix: Add action listener to back button
        add(back);
        
        setSize(900, 650);
        setLocation(100, 20);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = labelname.getText();
            String fname = lblftname.getText();
            String salary = lbltsalary.getText();
            String address = lbltaddress.getText();
            String phone = lbltphone.getText();
            String email = lbltemail.getText();
            String education = teducation.getText();
            String designation = lbltdesignation.getText();
            
            try {
                Conn conn = new Conn();
                String query = "update employee set fname='" + fname + "', salary='" + salary + "', address='" + address + "', phone='" + phone + "', email='" + email + "', education='" + education + "', designation='" + designation + "' where empid='" + empid + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String args[]) {
        new Updateemployee("");
    }
}