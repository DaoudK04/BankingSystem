import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankSystemGUI {
    private Bank bank;

    public BankSystemGUI(){
        bank = new Bank("Goon Bank");

        //Window
        JFrame frame = new JFrame("Goon Bank");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Window Layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));

        //Buttons
        JButton createBtn = new JButton("Create Account");
        JButton depositBtn = new JButton("Deposit Money");
        JButton withdrawBtn = new JButton("Withdraw Money");
        JButton transferBtn = new JButton("Transfer Money");
        JButton detailsBtn = new JButton("View Account Details");
        JButton exitBtn = new JButton("Exit");

        //Actions
        createBtn.addActionListener(e -> createAccount());
        depositBtn.addActionListener(e -> depositMoney());
        withdrawBtn.addActionListener(e -> withdrawMoney());
        transferBtn.addActionListener(e -> transferMoney());
        detailsBtn.addActionListener(e -> viewDetails());
        exitBtn.addActionListener(e -> System.exit(0));

        //Adding buttons to the panel
        panel.add(createBtn);
        panel.add(depositBtn);
        panel.add(withdrawBtn);
        panel.add(transferBtn);
        panel.add(detailsBtn);
        panel.add(exitBtn);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void createAccount(){
        
    }
}
