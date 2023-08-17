import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DisplayStudent extends JFrame implements ActionListener {

    public static void main(String[] args) throws ClassNotFoundException {
        DisplayStudent displayStudent = new DisplayStudent();
    }
    JFrame jf;
    Font f,f1;
    JButton b1,b2;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel model;
    JTable tab;
    JScrollPane scrlpane;
    ImageIcon img1;
    JLabel l1,l2;

    public DisplayStudent() throws ClassNotFoundException {
        f = new Font("Times New Roman",Font.BOLD,25);//button
        f1 = new Font("Times New Roman",Font.BOLD,35);//label

        jf = new JFrame();
        jf.setLayout(null);

        img1 = new ImageIcon("stdmanagement1.png");

        l2 = new JLabel("All Student Details");
        l2.setFont(new Font("Times New Roman",Font.BOLD,40));
        l2.setForeground(Color.BLACK);
        l2.setBounds(330,300,500,50);
        jf.add(l2);

        l1 = new JLabel();
        l1.setIcon(img1);
        l1.setBounds(330,50,700,200);
        jf.add(l1);

        b1 = new JButton("Back",new ImageIcon("back.png"));
        b1.setFont(f);
        b1.setBounds(300,750,150,50);
        b1.addActionListener(this);
        jf.add(b1);

        b2 = new JButton("Exit",new ImageIcon("cancel.png"));
        b2.setFont(f);
        b2.setBounds(550,750,150,50);
        b2.addActionListener(this);
        jf.add(b2);

        model = new DefaultTableModel();
        tab = new JTable(model);
        scrlpane = new JScrollPane(tab);
        scrlpane.setBounds(50,400,900,300);
        scrlpane.setBackground(new Color(0xcbcbcb));
        jf.add(scrlpane);
        tab.setOpaque(false);
        tab.setFont(new Font("Times New Roman",Font.BOLD,15));

        model.addColumn("Roll no");
        model.addColumn("Name");
        model.addColumn("Father's Name");
        model.addColumn("Grade");
        model.addColumn("Mobile");
        model.addColumn("DOB");
        model.addColumn("Gender");
        jf.setTitle("Student Management System");
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(1000,900);
        jf.setLocation(220,20);
        jf.getContentPane().setBackground(new Color(0xcbcbcb));


        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
            System.out.println("Connected to Database");
            ps = con.prepareStatement("select * from stdtable",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
            rs.last();
            model.setRowCount(0);
            do {
                model.addRow(new Object[]
                        {rs.getString("roll_no"),
                                rs.getString("name"),
                                rs.getString("fathername"),
                                rs.getString("grade"),
                                rs.getString("mobile"),
                                rs.getString("dob"),
                                rs.getString("gender")
                        });
            }while(rs.previous());



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            new stdMenu();
            jf.setVisible(false);
        }
        else if(e.getSource() == b2){
            System.exit(0);
        }

    }
}
