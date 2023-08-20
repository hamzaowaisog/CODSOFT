import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class EditStudent extends JFrame implements ActionListener {
    public static void main(String[] args) {
        EditStudent editStudent = new EditStudent();
    }
    JFrame jf;
    Font f,f1;
    JButton b1,b2,b3,b4;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    ImageIcon img1;
    JTextField roll_no;//roll no
    String s_name,s_f_name,s_mobile,s_gender;
    Integer s_grade,s_roll_no;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    java.sql.Date date;
    JTextField name,f_name,mobile,grade;
    JRadioButton male,female;
    ButtonGroup bg;
    SqlDateModel model;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;


    public EditStudent(){
        jf = new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);//button
        f1 = new Font("Times New Roman",Font.BOLD,25);//label
        img1 = new ImageIcon("stdmanagement1.png");
        jf.setLayout(null);

        l1 = new JLabel();
        l1.setIcon(img1);
        l1.setBounds(330,50,700,200);
        jf.add(l1);

        l2 = new JLabel("Edit Student.");
        l2.setFont(new Font("Times New Roman",Font.BOLD,40));
        l2.setForeground(Color.BLACK);
        l2.setBounds(400,300,500,50);
        jf.add(l2);
        l3 = new JLabel("Enter Roll No :");
        l3.setFont(f1);
        l3.setForeground(Color.BLACK);
        l3.setBounds(200,400,350,30);
        jf.add(l3);

        roll_no = new JTextField(4);
        roll_no.setFont(f1);
        roll_no.setBounds(500,400,250,30);
        roll_no.setToolTipText("Enter Roll No");
        roll_no.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE) || roll_no.getText().length() >=4){
                    e.consume();
                }
            }
        });
        jf.add(roll_no);

        b1 = new JButton("Edit",new ImageIcon("edit1.png"));
        b1.setFont(f);
        b1.setBounds(175,770,150,50);
        b1.addActionListener(this);
        jf.add(b1);

        b2 = new JButton("Search",new ImageIcon("search1.png"));
        b2.setFont(f);
        b2.setBounds(350,770,150,50);
        jf.getRootPane().setDefaultButton(b2);
        b2.addActionListener(this);
        jf.add(b2);

        b3 = new JButton("Exit",new ImageIcon("cancel.png"));
        b3.setFont(f);
        b3.setBounds(700,770,150,50);
        b3.addActionListener(this);
        jf.add(b3);

        b4 = new JButton("Back", new ImageIcon("back.png"));
        b4.setFont(f);
        b4.setBounds(525, 770, 150, 50);
        b4.addActionListener(this);
        jf.add(b4);

        l4 = new JLabel("Name :");
        l4.setFont(f1);
        l4.setForeground(Color.BLACK);
        l4.setBounds(200,450,350,30);
        jf.add(l4);

        name = new JTextField();
        name.setFont(f1);
        name.setForeground(Color.BLACK);
        name.setVisible(false);
        name.setBounds(500,450,250,30);
        jf.add(name);

        l6 = new JLabel("Father's Name :");
        l6.setFont(f1);
        l6.setForeground(Color.BLACK);
        l6.setBounds(200,500,350,30);
        jf.add(l6);

        f_name = new JTextField();
        f_name.setFont(f1);
        f_name.setForeground(Color.BLACK);
        f_name.setVisible(false);
        f_name.setBounds(500,500,250,30);
        jf.add(f_name);

        l8 = new JLabel("Mobile Number :");
        l8.setFont(f1);
        l8.setForeground(Color.BLACK);
        l8.setBounds(200,550,350,30);
        jf.add(l8);

        mobile = new JTextField();
        mobile.setFont(f1);
        mobile.setForeground(Color.BLACK);
        mobile.setVisible(false);
        mobile.setBounds(500,550,250,30);
        mobile.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE) || mobile.getText().length() >=12){
                    e.consume();
                }
            }
        });
        jf.add(mobile);

        l10 = new JLabel("Grade :");
        l10.setFont(f1);
        l10.setForeground(Color.BLACK);
        l10.setBounds(200,600,350,30);
        jf.add(l10);

        grade = new JTextField();
        grade.setFont(f1);
        grade.setForeground(Color.BLACK);
        grade.setVisible(false);
        grade.setBounds(500,600,250,30);
        grade.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE) || grade.getText().length() >=2){
                    e.consume();
                }
            }
        });
        jf.add(grade);

        l12 = new JLabel("Gender");
        l12.setFont(f1);
        l12.setForeground(Color.BLACK);
        l12.setBounds(200,650,350,30);
        jf.add(l12);

        male = new JRadioButton("Male");
        male.setFont(f);
        male.setBounds(500,650,100,30);
        male.setVisible(false);
        jf.add(male);

        female = new JRadioButton("Female");
        female.setFont(f);
        female.setBounds(650,650,100,30);
        female.setVisible(false);
        jf.add(female);

        l14 = new JLabel("Date of Birth :");
        l14.setFont(f1);
        l14.setForeground(Color.BLACK);
        l14.setBounds(200,700,350,30);
        jf.add(l14);

        model = new SqlDateModel();
        model.setSelected(true);
        datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel);
        datePicker.setBounds(500,700,250,30);
        datePicker.setVisible(false);
        jf.add(datePicker);

        jf.setTitle("Student Management System");
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(1000,900);
        jf.setLocation(220,20);
        jf.getContentPane().setBackground(new Color(0xcbcbcb));



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            if (name.getText().equals("") || f_name.getText().equals("") || mobile.getText().equals("") || grade.getText().equals("") || (!male.isSelected() && !female.isSelected())){
                JOptionPane.showMessageDialog(this,"Please Enter All Details.");

            }
            else{
                s_roll_no = Integer.parseInt(roll_no.getText());
                date = (java.sql.Date) datePicker.getModel().getValue();
                s_name = name.getText();
                s_f_name = f_name.getText();
                s_mobile = mobile.getText();
                s_grade = Integer.parseInt(grade.getText());
                if(male.isSelected()){
                    s_gender = "Male";
                }
                else {
                    s_gender = "Female";
                }
            }
            System.out.println(s_name);
            System.out.println(s_f_name);
            System.out.println(s_mobile);
            System.out.println(s_grade);
            System.out.println(s_gender);
            System.out.println(date);

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
                System.out.println("Connected to Database");
                ps = con.prepareStatement("Update stdtable SET name=?, fathername=?, grade=?, mobile=?, gender=?, dob=? where roll_no=?");
                ps.setString(1,s_name);
                ps.setString(2,s_f_name);
                ps.setInt(3,s_grade);
                ps.setString(4, s_mobile);
                ps.setString(5,s_gender);
                ps.setDate(6,date);
                ps.setInt(7,s_roll_no);

                Integer row_affected = ps.executeUpdate();
                if(row_affected>0){
                    JOptionPane.showMessageDialog(this,"Student Updated Successfully");
                    new DisplayStudent();
                    jf.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Student Not Updated");
                }

            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
        else if(e.getSource() == b2){
            if(roll_no.getText().equals(null)){
                JOptionPane.showMessageDialog(this,"Please Enter Roll No");
            }
            else {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
                    System.out.println("Connected to DataBase");
                    ps = con.prepareStatement("select * from stdtable where roll_no = ?");
                    ps.setInt(1,Integer.parseInt(roll_no.getText()));
                    rs = ps.executeQuery();
                    if(rs.next()){
                        name.setVisible(true);
                        f_name.setVisible(true);
                        mobile.setVisible(true);
                        grade.setVisible(true);
                        male.setVisible(true);
                        female.setVisible(true);
                        datePicker.setVisible(true);

                        name.setText(rs.getString("name"));
                        f_name.setText(rs.getString("fathername"));
                        mobile.setText(rs.getString("mobile"));
                        grade.setText(String.valueOf(rs.getInt("grade")));

                        date = rs.getDate("dob");
                        model.setDate(date.getYear()+1900,date.getMonth(),date.getDate());
                        roll_no.setEnabled(false);
                        if(rs.getString("gender").equalsIgnoreCase("male")){
                            male.setSelected(true);
                        }
                        else{
                            female.setSelected(true);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"No Such Student Found");
                    }
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
        else if(e.getSource() == b4){
            new stdMenu();
            jf.setVisible(false);
        }
        else if (e.getSource() == b3){
            System.exit(0);
        }


    }
}
