import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdmLogin extends JFrame implements ActionListener {
    public static void main(String[] args) {
        AdmLogin admLogin = new AdmLogin();
    }
    JFrame jf;
    Font f,f1;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6;
    ImageIcon img1;
    JTextField txt; //name
    JTextField id1; //id
    JPasswordField pwd; //password
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String name,pass,checkname,checkpass;
    int id,checkid;
    boolean isActive;




    public AdmLogin(){
        jf = new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);//button
        f1 = new Font("Times New Roman",Font.BOLD,25);//label
        img1 = new ImageIcon("stdmanagement1.png");
        jf.setLayout(null);

        l1 = new JLabel();
        l1.setIcon(img1);
        l1.setBounds(330,50,700,200);
        jf.add(l1);

        l2 = new JLabel("Admin Login.");
        l2.setFont(new Font("Times New Roman",Font.BOLD,40));
        l2.setForeground(Color.BLACK);
        l2.setBounds(400,300,500,50);
        jf.add(l2);

        l3 = new JLabel("Enter Name :");
        l3.setFont(f1);
        l3.setForeground(Color.BLACK);
        l3.setBounds(200,500,350,30);
        jf.add(l3);

        l4 = new JLabel("Enter Password :");
        l4.setFont(f1);
        l4.setForeground(Color.BLACK);
        l4.setBounds(200,600,350,30);
        jf.add(l4);

        l5 = new JLabel("Enter ID:");
        l5.setFont(f1);
        l5.setForeground(Color.BLACK);
        l5.setBounds(200,400,350,30);
        jf.add(l5);

        id1 = new JTextField();
        id1.setFont(f1);
        id1.setForeground(Color.BLACK);
        id1.setBounds(500,400,250,30);
        id1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
                    e.consume();
                }
            }
        });
        jf.add(id1);

        txt = new JTextField();
        txt.setFont(f1);
        txt.setForeground(Color.BLACK);
        txt.setBounds(500,500,250,30);
        jf.add(txt);

        pwd  = new JPasswordField(20);
        pwd.setFont(f1);
        pwd.setForeground(Color.BLACK);
        pwd.setBounds(500,600,250,30);
        jf.add(pwd);

        b1 = new JButton("Enter",new ImageIcon("ok.png"));
        b1.setFont(f);
        b1.setBounds(150,750,175,50);
        b1.addActionListener(this);
        jf.add(b1);

        b2 = new JButton("Clear",new ImageIcon("clear.png"));
        b2.setFont(f);
        b2.setBounds(435,750,175,50);
        b2.addActionListener(this);
        jf.add(b2);

        b3 = new JButton("Exit",new ImageIcon("cancel.png"));
        b3.setFont(f);
        b3.setBounds(700,750,175,50);
        b3.addActionListener(this);
        jf.add(b3);

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
            try {
                if(txt.getText().equals("") || id1.getText().equals("") || pwd.getText().equals("")){
                    JOptionPane.showMessageDialog(this,"Please Enter the Empty Field");
                }
                else{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
                    System.out.println("Connected to Database");
                    id = Integer.parseInt(id1.getText());
                    name = txt.getText();
                    pass = pwd.getText();
                    ps = con.prepareStatement("select * from admintbl where id=? and name=? and password=?");
                    ps.setInt(1,id);
                    ps.setString(2,name);
                    ps.setString(3,pass);
                    rs = ps.executeQuery();
                    while (rs.next()){
                        checkid = rs.getInt("id");
                        checkname = rs.getString("name");
                        checkpass = rs.getString("password");
                        isActive = rs.getBoolean("active");
                    }
                    if (id == checkid && name.equals(checkname) && pass.equals(checkpass)) {
                        if (isActive) {
                            JOptionPane.showMessageDialog(this, "Login Successful");
                            new stdMenu();
                            jf.setVisible(false);
                        }
                        else{

                            JOptionPane.showMessageDialog(this,"Your Account is Deactivated");
                            new StdManagement();
                            jf.setVisible(false);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Invalid ID, Name or Password");
                        txt.setText("");
                        pwd.setText("");
                        id1.setText("");
                    }
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }


        }
        else if (e.getSource() == b2 ){
            txt.setText("");
            pwd.setText("");
            id1.setText("");
        }
        else if (e.getSource() == b3){
            new StdManagement();
            jf.setVisible(false);
        }

    }
}
