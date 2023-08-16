import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StdManagement extends JFrame implements ActionListener {
    /**public static void main(String[] args) {
        StdManagement stdManagement = new StdManagement();
    }**/
    JFrame jf;
    Font f,f1;
    JButton b,b1;
    JLabel l1,l2,l3,l4,l5,l6;
    ImageIcon img1;

    public StdManagement(){
        jf = new JFrame();
        f = new Font("Times New Roman",Font.BOLD,20);//button
        f1 = new Font("Times New Roman",Font.BOLD,25);//label
        img1 = new ImageIcon("stdlogo1.png");
        jf.setLayout(null);

        l1 = new JLabel();
        l1.setText("Welcome To Student Management System");
        l1.setIcon(img1);
        l1.setFont(new Font("Times New Roman",Font.BOLD,40));
        l1.setForeground(Color.BLACK);
        l1.setHorizontalTextPosition(JLabel.CENTER);
        l1.setVerticalTextPosition(JLabel.BOTTOM);
        l1.setBounds(120,20,800,300);
        l1.setIconTextGap(30);
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setVerticalAlignment(JLabel.TOP);
        jf.add(l1);

        l2 = new JLabel("Student Management System");
        l2.setFont(new Font("Times New Roman",Font.BOLD,30));
        l2.setForeground(Color.BLACK);
        l2.setBounds(330,400,500,30);
        l2.setVerticalTextPosition(JLabel.BOTTOM);
        l2.setHorizontalTextPosition(JLabel.CENTER);
        jf.add(l2);

        l3 = new JLabel("Press OK To Use Student Management System or Press Exit to Quit.");
        l3.setFont(f1);
        l3.setForeground(Color.BLACK);
        l3.setBounds(150,500,750,40);
        jf.add(l3);

        b= new JButton("OK",new ImageIcon("ok.png"));
        b.setFont(f);
        b.setBounds(250,700,150,50);
        b.addActionListener(this);
        jf.add(b);

        b1 = new JButton("Exit",new ImageIcon("cancel.png"));
        b1.setFont(f);
        b1.setBounds(620,700,150,50);
        b1.addActionListener(this);
        jf.add(b1);

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
        if(e.getSource() == b){
            new AdmLogin();
            jf.setVisible(false);
        }
        else if(e.getSource() == b1){
            System.exit(0);
            jf.setVisible(false);
        }
    }
}
