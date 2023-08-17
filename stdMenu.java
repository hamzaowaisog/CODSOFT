import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class stdMenu implements ActionListener {
    JFrame jf;
    Font f,f1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    JLabel l1,l2;
    ImageIcon img1;

    public static void main(String[] args) {
        stdMenu stdMenu = new stdMenu();
    }


    public stdMenu() {
        f = new Font("Times New Roman",Font.BOLD,25);//button
        f1 = new Font("Times New Roman",Font.BOLD,35);//label

        jf = new JFrame();
        jf.setLayout(null);

        img1 = new ImageIcon("stdmanagement1.png");

        l1 = new JLabel();
        l1.setIcon(img1);
        l1.setBounds(330,50,700,200);
        jf.add(l1);

        l2 = new JLabel("Select Any Option From The Below");
        l2.setFont(new Font("Times New Roman",Font.BOLD,40));
        l2.setForeground(Color.BLACK);
        l2.setBounds(210,300,900,50);
        jf.add(l2);

        b1 = new JButton("Add Student",new ImageIcon("add1.png"));
        b1.setFont(f);
        b1.setBounds(150,400,250,50);
        b1.addActionListener(this);
        jf.add(b1);

        b2 = new JButton("Display Student",new ImageIcon("display1.png"));
        b2.setFont(f);
        b2.setBounds(550,400,250,50);
        b2.addActionListener(this);
        jf.add(b2);

        b3 = new JButton("Search Student",new ImageIcon("search1.png"));
        b3.setFont(f);
        b3.setBounds(150,500,250,50);
        b3.addActionListener(this);
        jf.add(b3);

        b4 = new JButton("Edit Student",new ImageIcon("edit1.png"));
        b4.setFont(f);
        b4.setBounds(550,500,250,50);
        b4.addActionListener(this);
        jf.add(b4);

        b5 = new JButton("Delete Student",new ImageIcon("delete.png"));
        b5.setFont(f);
        b5.setBounds(350,600,250,50);
        b5.addActionListener(this);
        jf.add(b5);

        b6 = new JButton("Exit",new ImageIcon("cancel.png"));
        b6.setFont(f);
        b6.setBounds(525,765,175,50);
        b6.addActionListener(this);
        jf.add(b6);

        b7 = new JButton("Back",new ImageIcon("back.png"));
        b7.setFont(f);
        b7.setBounds(275,765,175,50);
        b7.addActionListener(this);
        jf.add(b7);



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
            new AddStudent();
            jf.setVisible(false);

        }
        else if (e.getSource() == b2){
            new DisplayStudent();
            jf.setVisible(false);
        }
        else if(e.getSource() == b3){
            new SearchStudent();
            jf.setVisible(false);

        }
        else if (e.getSource() == b4){
            new EditStudent();
            jf.setVisible(false);

        }
        else if (e.getSource() == b5){
            new DeleteStudent();
            jf.setVisible(false);

        }
        else if (e.getSource() == b7){
            new StdManagement();
            jf.setVisible(false);
        }
        else if (e.getSource() == b6){
            System.exit(0);
            jf.setVisible(false);
        }

    }
}
