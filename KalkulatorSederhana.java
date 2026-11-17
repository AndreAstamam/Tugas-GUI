import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KalkulatorSederhana implements ActionListener, KeyListener {

    JFrame frame = new JFrame("Kalkulator Sederhana");

    JTextField txtAngka1 = new JTextField(10);
    JTextField txtAngka2 = new JTextField(10);
    JTextField txtHasil = new JTextField(10);
    String[] operator = {"+", "-", "x", "/"};
    JComboBox<String> cmbOperator = new JComboBox<>(operator);
    JButton btnHitung = new JButton("Hitung");
    JButton btnReset = new JButton("Reset");

    public KalkulatorSederhana() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320, 280);
        frame.setLocationRelativeTo(null);

        // Intermediate Component (setiap panel = 1 baris)
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new JLabel("Angka 1:"));
        p1.add(txtAngka1);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(new JLabel("Operator:"));
        p2.add(cmbOperator);

        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(new JLabel("Angka 2:"));
        p3.add(txtAngka2);

        JPanel p4 = new JPanel(new FlowLayout());
        p4.add(new JLabel("Hasil:"));
        p4.add(txtHasil);

        JPanel p5 = new JPanel(new FlowLayout());
        p5.add(btnHitung);
        p5.add(btnReset);

        txtHasil.setEditable(false);

        
        btnHitung.addActionListener(this);   
        btnReset.addActionListener(this);    
        txtAngka2.addKeyListener(this);      

        frame.setLayout(new GridLayout(5, 1));
        frame.add(p1);
        frame.add(p2);
        frame.add(p3);
        frame.add(p4);
        frame.add(p5);

        frame.setVisible(true);
    }

    void hitung() {
        try {
            double a = Double.parseDouble(txtAngka1.getText());
            double b = Double.parseDouble(txtAngka2.getText());
            String op = (String) cmbOperator.getSelectedItem();
            double hasil = 0;

            if (op.equals("+")) {
                hasil = a + b;
            } else if (op.equals("-")) {
                hasil = a - b;
            } else if (op.equals("x")) {
                hasil = a * b;
            } else {
                if (b == 0) {
                    JOptionPane.showMessageDialog(frame, "Tidak bisa dibagi nol!");
                    return;
                }
                hasil = a / b;
            }

            if (hasil % 1 == 0) {
                txtHasil.setText(String.valueOf((long) hasil));
            } else {
                txtHasil.setText(String.valueOf(hasil));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Masukkan angka valid!");
        }
    }

    void reset() {
        txtAngka1.setText("");
        txtAngka2.setText("");
        txtHasil.setText("");
        cmbOperator.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnHitung) {
            hitung();
        } else if (e.getSource() == btnReset) {
            reset();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            hitung();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        new KalkulatorSederhana();
    }
}
