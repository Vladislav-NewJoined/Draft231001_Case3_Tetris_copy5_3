import javax.swing.*;


public class Main_copy7_withJPanel {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);
        jPanel.add(new JLabel("Score: "));
        int score = 0;
        jPanel.add(new JTextField(Integer.toString(score), 5));
        JTextField jTextField = new JTextField();
        jTextField.getText();
        jPanel.revalidate();
    }

    static JFrame getFrame () {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(10, 10, 420, 430);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;

    }
}
