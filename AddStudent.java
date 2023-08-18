
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Properties;

public class AddStudent extends JFrame implements ActionListener {
    public static void main(String[] args) {
        AddStudent addStudent = new AddStudent();
    }
    JFrame jf;
    Font f,f1;
    JButton b1,b2,b3;
    JTextField name,f_name,mobile,grade;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    ImageIcon img1;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    JRadioButton male,female;
    ButtonGroup bg;
    SqlDateModel model;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;

    java.sql.Date date;

    String name_check,f_name_check,number;
    String gender;
    int roll_no,getRoll_no,grade_check;

    public AddStudent(){
        jf = new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);//button
        f1 = new Font("Times New Roman",Font.BOLD,25);//label
        img1 = new ImageIcon("stdmanagement1.png");
        jf.setLayout(null);

        l1 = new JLabel();
        l1.setIcon(img1);
        l1.setBounds(330,50,700,200);
        jf.add(l1);

        l2 = new JLabel("Add Student.");
        l2.setFont(new Font("Times New Roman",Font.BOLD,40));
        l2.setForeground(Color.BLACK);
        l2.setBounds(400,300,500,50);
        jf.add(l2);

        b1 = new JButton("Back",new ImageIcon("back.png"));
        b1.setFont(f);
        b1.setBounds(450,750,150,50);
        b1.addActionListener(this);
        jf.add(b1);

        b2 = new JButton("Exit",new ImageIcon("cancel.png"));
        b2.setFont(f);
        b2.setBounds(700,750,150,50);
        b2.addActionListener(this);
        jf.add(b2);

        b3 = new JButton("Add",new ImageIcon("add1.png"));
        b3.setFont(f);
        b3.setBounds(200,750,150,50);
        b3.addActionListener(this);
        jf.add(b3);

        l3 = new JLabel("Enter Name :");
        l3.setFont(f1);
        l3.setForeground(Color.BLACK);
        l3.setBounds(200,400,350,30);
        jf.add(l3);

        l4 = new JLabel("Enter Father's Name :");
        l4.setFont(f1);
        l4.setForeground(Color.BLACK);
        l4.setBounds(200,450,350,30);
        jf.add(l4);

        l5 = new JLabel("Enter Mobile Number :");
        l5.setFont(f1);
        l5.setForeground(Color.BLACK);
        l5.setBounds(200,500,350,30);
        jf.add(l5);

        l6 = new JLabel("Enter Grade :");
        l6.setFont(f1);
        l6.setForeground(Color.BLACK);
        l6.setBounds(200,550,350,30);
        jf.add(l6);

        l7 = new JLabel("Choose Gender :");
        l7.setFont(f1);
        l7.setForeground(Color.BLACK);
        l7.setBounds(200,600,350,30);
        jf.add(l7);

        l8 = new JLabel("Date of Birth :");
        l8.setFont(f1);
        l8.setForeground(Color.BLACK);
        l8.setBounds(200,650,350,30);
        jf.add(l8);

        model = new SqlDateModel ();
        model.setDate(1990,00,01);
        model.setSelected(true);
        datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel);
        datePicker.setBounds(500,650,250,30);
        jf.add(datePicker);

        name = new JTextField();
        name.setFont(f1);
        name.setForeground(Color.BLACK);
        name.setBounds(500,400,250,30);
        jf.add(name);

        f_name = new JTextField();
        f_name.setFont(f1);
        f_name.setForeground(Color.BLACK);
        f_name.setBounds(500,450,250,30);
        jf.add(f_name);

        mobile = new JTextField();
        mobile.setFont(f1);
        mobile.setForeground(Color.BLACK);
        mobile.setBounds(500,500,250,30);
        mobile.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE) || mobile.getText().length()>=13){
                    e.consume();
                }
            }
        });
        jf.add(mobile);

        grade = new JTextField();
        grade.setFont(f1);
        grade.setForeground(Color.BLACK);
        grade.setBounds(500,550,250,30);
        grade.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE) || grade.getText().length()>=2 ){
                    e.consume();
                }
            }
        });

        jf.add(grade);

        male = new JRadioButton("Male");
        male.setFont(f);
        male.setBounds(500,600,100,30);
        jf.add(male);

        female = new JRadioButton("Female");
        female.setFont(f);
        female.setBounds(650,600,100,30);
        jf.add(female);




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
        if (e.getSource()==b1){
            jf.dispose();
            new stdMenu();
        }
        else if (e.getSource() == b2){
            System.exit(0);
            jf.setVisible(false);
        }
        else if (e.getSource() == b3) {
            if (name.getText().equals("") || f_name.getText().equals("") || mobile.getText().equals("") || grade.getText().equals("") || (!male.isSelected() && !female.isSelected())){
                JOptionPane.showMessageDialog(this,"Please Enter All Details.");

            }
            else{
                date = (java.sql.Date) datePicker.getModel().getValue();
                name_check = name.getText();
                f_name_check = f_name.getText();
                number = mobile.getText();
                grade_check = Integer.parseInt(grade.getText());
                if (male.isSelected()) {
                    gender = "Male";
                } else if (female.isSelected()) {
                    gender = "Female";
                }


                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
                    System.out.println("Connected to Database");
                    ps = con.prepareStatement("SELECT roll_no FROM stdtable ORDER BY roll_no DESC LIMIT 1");
                    rs = ps.executeQuery();
                    if (rs.next()){
                        roll_no = rs.getInt(1);
                        getRoll_no = roll_no + 1;
                    }
                    else{
                        getRoll_no = 1000;
                    }
                    System.out.println("Date: "+date);
                    System.out.println("Name: "+name_check);
                    System.out.println("Father Name: "+f_name_check);
                    System.out.println("Mobile Number: "+number);
                    System.out.println("Grade: "+grade_check);
                    System.out.println("Gender: "+gender);
                    System.out.println("Roll no: "+getRoll_no);

                    ps = con.prepareStatement("insert into stdtable values(?,?,?,?,?,?,?)");
                    ps.setInt(1,getRoll_no);
                    ps.setDate(4,date);
                    ps.setString(2,name_check);
                    ps.setString(5,f_name_check);
                    ps.setString(6,number);
                    ps.setInt(3,grade_check);
                    ps.setString(7,gender);

                    int row_affect = ps.executeUpdate();
                    if(row_affect>0){
                        JOptionPane.showMessageDialog(this,"Student Added Successfully.");
                        JOptionPane.showMessageDialog(this,"Your Roll Number is: "+getRoll_no);
                        name.setText("");
                        f_name.setText("");
                        mobile.setText("");
                        grade.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Student Not Added.");
                    }


                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        }

    }
}
