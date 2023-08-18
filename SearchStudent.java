import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class SearchStudent extends JFrame implements ActionListener {
    public static void main(String[] args) {
        SearchStudent searchStudent = new SearchStudent();
    }

    JFrame jf;
    Font f,f1;
    JButton b1,b2,b3,b4;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    ImageIcon img1;
    JTextField roll_no;//roll no
    String name,f_name,mobile,gender;
    Integer grade;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    java.sql.Date date;

    public SearchStudent(){
        jf = new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);//button
        f1 = new Font("Times New Roman",Font.BOLD,25);//label
        img1 = new ImageIcon("stdmanagement1.png");
        jf.setLayout(null);

        l1 = new JLabel();
        l1.setIcon(img1);
        l1.setBounds(330,50,700,200);
        jf.add(l1);

        l2 = new JLabel("Search Student.");
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

        b1 = new JButton("Search",new ImageIcon("search1.png"));
        b1.setFont(f);
        b1.setBounds(175,770,150,50);
        jf.getRootPane().setDefaultButton(b1);
        b1.addActionListener(this);
        jf.add(b1);

        b2 = new JButton("Clear",new ImageIcon("clear.png"));
        b2.setFont(f);
        b2.setBounds(350,770,150,50);
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

        l5 = new JLabel();
        l5.setFont(f1);
        l5.setForeground(Color.BLACK);
        l5.setBounds(500,450,350,30);
        jf.add(l5);

        l6 = new JLabel("Father's Name :");
        l6.setFont(f1);
        l6.setForeground(Color.BLACK);
        l6.setBounds(200,500,350,30);
        jf.add(l6);

        l7 = new JLabel();
        l7.setFont(f1);
        l7.setForeground(Color.BLACK);
        l7.setBounds(500,500,350,30);
        jf.add(l7);

        l8 = new JLabel("Mobile Number :");
        l8.setFont(f1);
        l8.setForeground(Color.BLACK);
        l8.setBounds(200,550,350,30);
        jf.add(l8);

        l9 = new JLabel();
        l9.setFont(f1);
        l9.setForeground(Color.BLACK);
        l9.setBounds(500,550,350,30);
        jf.add(l9);

        l10 = new JLabel("Grade :");
        l10.setFont(f1);
        l10.setForeground(Color.BLACK);
        l10.setBounds(200,600,350,30);
        jf.add(l10);

        l11 = new JLabel();
        l11.setFont(f1);
        l11.setForeground(Color.BLACK);
        l11.setBounds(500,600,350,30);
        jf.add(l11);

        l12 = new JLabel("Gender");
        l12.setFont(f1);
        l12.setForeground(Color.BLACK);
        l12.setBounds(200,650,350,30);
        jf.add(l12);

        l13 = new JLabel();
        l13.setFont(f1);
        l13.setForeground(Color.BLACK);
        l13.setBounds(500,650,350,30);
        jf.add(l13);

        l14 = new JLabel("Date of Birth :");
        l14.setFont(f1);
        l14.setForeground(Color.BLACK);
        l14.setBounds(200,700,350,30);
        jf.add(l14);

        l15  = new JLabel();
        l15.setFont(f1);
        l15.setForeground(Color.BLACK);
        l15.setBounds(500,700,350,30);
        jf.add(l15);


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
        if(e.getSource() == b1){
            if (roll_no.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter roll no");
            }
            else{
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
                    ps = con.prepareStatement("SELECT * FROM stdtable WHERE roll_no=?");
                    ps.setInt(1,Integer.parseInt(roll_no.getText()));
                    rs = ps.executeQuery();
                    if(rs.next()){
                        name = rs.getString("name");
                        f_name = rs.getString("fathername");
                        mobile = rs.getString("mobile");
                        gender = rs.getString("gender");
                        date = rs.getDate("dob");
                        grade = rs.getInt("grade");

                        l5.setText(name);
                        l7.setText(f_name);
                        l9.setText(mobile);
                        l11.setText(String.valueOf(grade));
                        l13.setText(gender);
                        l15.setText(String.valueOf(date));

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
        else if(e.getSource() == b2){
            roll_no.setText("");
            l5.setText("");
            l7.setText("");
            l9.setText("");
            l11.setText("");
            l13.setText("");
            l15.setText("");
        }
        else if(e.getSource() == b3){
            System.exit(0);
            jf.setVisible(false);
        }
        else if (e.getSource() == b4){
            new stdMenu();
            jf.setVisible(false);
        }

    }
}
