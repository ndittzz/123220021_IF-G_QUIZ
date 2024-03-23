package pkg123220021_if.g_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class kuis_123220021 extends JFrame implements ActionListener {
    private JLabel labelMenu, labelNama, labelNIM, labelTipeKelas, labelMataKuliah, labelNilaiTugas, labelNilaiQuiz;
    private JTextField fieldNama, fieldNIM, fieldNilaiTugas, fieldNilaiQuiz;
    private JRadioButton radioKelasPraktikum, radioKelasTeori;
    private ButtonGroup grupKelas;
    private JComboBox<String> comboMataKuliah;
    private JButton buttonSubmit, buttonLogout;

    public kuis_123220021() {
        setTitle("Input Nilai");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Panel Utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(8, 1, 10, 10));          
        
        // Panel Nama
        JPanel panelNama = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelNama = new JLabel("Nama Mahasiswa :");
        fieldNama = new JTextField(20);
        panelNama.add(labelNama);
        panelNama.add(fieldNama);
        mainPanel.add(panelNama);

        // Panel NIM
        JPanel panelNIM = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelNIM = new JLabel("NIM Mahasiswa     :");
        fieldNIM = new JTextField(20);
        panelNIM.add(labelNIM);
        panelNIM.add(fieldNIM);
        mainPanel.add(panelNIM);

        // Panel Tipe Kelas
        JPanel panelTipeKelas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelTipeKelas = new JLabel("Tipe Kelas             :");
        radioKelasPraktikum = new JRadioButton("Praktikum");
        radioKelasTeori = new JRadioButton("Teori");
        grupKelas = new ButtonGroup();
        grupKelas.add(radioKelasPraktikum);
        grupKelas.add(radioKelasTeori);
        panelTipeKelas.add(labelTipeKelas);
        panelTipeKelas.add(radioKelasPraktikum);
        panelTipeKelas.add(radioKelasTeori);
        mainPanel.add(panelTipeKelas);

        // Panel Nilai Tugas
        JPanel panelNilaiTugas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelNilaiTugas = new JLabel("Nilai Tugas            :");
        fieldNilaiTugas = new JTextField(20);
        panelNilaiTugas.add(labelNilaiTugas);
        panelNilaiTugas.add(fieldNilaiTugas);
        mainPanel.add(panelNilaiTugas);

        // Panel Nilai Quiz
        JPanel panelNilaiQuiz = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelNilaiQuiz = new JLabel("Nilai Quiz               :");
        fieldNilaiQuiz = new JTextField(20);
        panelNilaiQuiz.add(labelNilaiQuiz);
        panelNilaiQuiz.add(fieldNilaiQuiz);
        mainPanel.add(panelNilaiQuiz);

        // Panel Mata Kuliah
        JPanel panelMataKuliah = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelMataKuliah = new JLabel("Mata Kuliah            :");
        String[] mataKuliah = {"PBO", "SCPK", "Algo Lanjut"};
        comboMataKuliah = new JComboBox<>(mataKuliah);
        panelMataKuliah.add(labelMataKuliah);
        panelMataKuliah.add(comboMataKuliah);
        mainPanel.add(panelMataKuliah);

        // Panel Tombol Submit
        JPanel panelSubmit = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonSubmit = new JButton("Submit");
        buttonSubmit.addActionListener(this);
        panelSubmit.add(buttonSubmit);
        mainPanel.add(panelSubmit);

        // Panel Tombol Logout
        JPanel panelLogout = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonLogout = new JButton("Log-out");
        buttonLogout.addActionListener(this);
        panelLogout.add(buttonLogout);
        mainPanel.add(panelLogout);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new kuis_123220021();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == buttonSubmit) {
        double nilaiTugas = Double.parseDouble(fieldNilaiTugas.getText());
        double nilaiQuiz = Double.parseDouble(fieldNilaiQuiz.getText());
        double totalNilai;
        String status;

        String tipeKelas = radioKelasPraktikum.isSelected() ? "Praktikum" : "Teori";
        String mataKuliah = (String) comboMataKuliah.getSelectedItem();

        if (radioKelasPraktikum.isSelected()) {
            totalNilai = (0.3 * nilaiTugas) + (0.7 * nilaiQuiz);
        } else {
            totalNilai = (0.7 * nilaiTugas) + (0.3 * nilaiQuiz);
        }

        if (totalNilai >= 85) {
            status = "Pass";
        } else {
            status = "Not Pass";
        }

        String outputMessage = 
                "Nama            : " + fieldNama.getText() + 
                "\nNIM               : " + fieldNIM.getText() +
                "\nTotal Nilai    : " + totalNilai + 
                "\nTipe Kelas   : " + tipeKelas + 
                "\nMata Kuliah : " + mataKuliah + 
                "\nStatus          : " + status ;
        JOptionPane.showMessageDialog(this, outputMessage);
    } else if (e.getSource() == buttonLogout) {
        JOptionPane.showMessageDialog(this, "Anda berhasil logout.");
        System.exit(0);
    }
}

}
