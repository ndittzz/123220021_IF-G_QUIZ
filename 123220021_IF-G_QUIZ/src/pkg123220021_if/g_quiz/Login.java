package pkg123220021_if.g_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private JLabel labelNIM, labelPassword;
    private JTextField fieldNIM;
    private JPasswordField fieldPassword;
    private JButton buttonLogin;

    public Login() {
        setTitle("Halaman Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2, 5, 5));

        labelNIM = new JLabel("NIM");
        mainPanel.add(labelNIM);

        fieldNIM = new JTextField();
        mainPanel.add(fieldNIM);

        labelPassword = new JLabel("Password");
        mainPanel.add(labelPassword);

        fieldPassword = new JPasswordField();
        mainPanel.add(fieldPassword);

        buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(this);
        mainPanel.add(buttonLogin);

        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogin) {
            String nim = fieldNIM.getText();
            String password = new String(fieldPassword.getPassword());

            if (nim.equals("123220021") && password.equals("123123")) {
                dispose(); 
                new kuis_123220021(); 
            } else {
                JOptionPane.showMessageDialog(this, "Login gagal, nim atau password salah.");
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
