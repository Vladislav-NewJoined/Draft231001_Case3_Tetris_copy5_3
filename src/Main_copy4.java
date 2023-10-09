import javax.swing.*;
import java.awt.*;



public class Main_copy4 {
    static JFrame jFrame = getFrame();

    static JPanel jPanel = new JPanel();

    static class Field extends JFrame {
        int width = 10;
        int height = 10;
        static Field field = new Field();
        static JPanel jPanel = new JPanel();


        {
            getContentPane().setLayout(new GridLayout(height, width));
            for (int currentX = 0; currentX < width; currentX++)
                for (int currentY = 0; currentY < height; currentY++)
                    add(new JButton() {{
                        setFocusable(false);
                    }});

            //стандартные настройки окна
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(420, 430);

            clear();
        }

        void paintDot(int x_, int y_, Color color_) {
            getContentPane().getComponents()[x_ + (y_ * width)].setBackground(color_);
        }

        void clear() {
            for (Component currentComponent : getContentPane().getComponents())
                currentComponent.setBackground(Color.WHITE);
        }

    }

//    static class JFrame extends JFrame {
//        int width = 10;
//        int height = 10;
//        static JFrame jFrame = new JFrame();
//        static JPanel jPanel = new JPanel();
//
//        {
//            getContentPane().setLayout(new GridLayout(height, width));
//            for (int currentX = 0; currentX < width; currentX++)
//                for (int currentY = 0; currentY < height; currentY++)
//                    add(new JButton() {{
//                        setFocusable(false);
//                    }});
//
//            //стандартные настройки окна
//            setVisible(true);
//            setDefaultCloseOperation(EXIT_ON_CLOSE);
//            setSize(420, 430);
//
//            clear();
//        }
//
//        void paintDot(int x_, int y_, Color color_) {
//            getContentPane().getComponents()[x_ + (y_ * width)].setBackground(color_);
//        }
//
//        void clear() {
//            for (Component currentComponent : getContentPane().getComponents())
//                currentComponent.setBackground(Color.WHITE);
//        }
//    }


    static int NumCurrentBrick = 0;
//    static Main_copy4.brick[] bricks = new Main_copy4.brick[1000];
    static Main_copy4.Field field = new Main_copy4.Field();

    public static void main(String[] args) throws Exception {
        jFrame.add(jPanel);
        jPanel.add(new JTextField("default value", 20));
        JTextField jTextField = new JTextField();
        jTextField.getText();
        jPanel.revalidate();

        field.add(jPanel);
        jPanel.add(new JTextField("default value", 20));
        JTextField jTextField2 = new JTextField();
        jTextField2.getText();
        jPanel.revalidate();


        field.add(jPanel);

    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(10, 10, 420, 430);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }

    static Field getFirld() {
        Field field = new Field() {};
        field.setVisible(true);
        field.setBounds(10, 10, 420, 430);
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return field;
    }



}
