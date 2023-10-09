import javax.swing.*;
import java.awt.*;

public class Main_copy8 extends JFrame {

        int width = 10;
        int height = 10;

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


        void clear() {
            for (Component currentComponent : getContentPane().getComponents())
                currentComponent.setBackground(Color.WHITE);
        }

        static Main_copy8 field = new Main_copy8();

        public static void main(String[] args) throws Exception {
            System.out.println("""
                    Задание:\s
                    Кейс 3. Пошаговый тетрис.\s
                       Пусть у Вас будет поле 10х10 (двумерный массив chart). В случайном месте генерируется 
                       фигура: можно начать с простых форм: …. :: … . : на Ваше усмотрение. Каждый ход считывайте 
                       от игрока: просто опустить фигуру, или ещё сдвинуть ее влево-вправо. Считайте количество очков: 
                       полностью выстроенных линий (таковые сгорают). Когда фигуре некуда упасть, игра закончена. 
                       В файл записывайте рекордное количество очков. Реализуйте по крайней мере два-три класса.

                    Решение:\s
                       Клавиши управления: Сдвиг: Up, Down, Right, Left. Вращение: Insert, Delete.
                       Следующая фигура: Down. """);

//            int score = 0;
//            jPanel.add(new JLabel(/*"     Score: " +  */Integer.toString(score)));
//            JLabel jLabel1 = new JLabel("     Score: " +  Integer.toString(score));
//            field.add(jLabel1);
//            jPanel.add(new JTextField(Integer.toString(score), 5));
//            JTextField jTextField = new JTextField();
//            jTextField.getText();
//            jPanel.revalidate();





        }


//    static JFrame jFrame = getFrame();
//    static JPanel jPanel = new JPanel();
//
//
//    public static void main(String[] args) throws Exception {
//        jFrame.add(jPanel);
//        jPanel.add(new JLabel("Score: "));
//        int score = 0;
//        jPanel.add(new JTextField(Integer.toString(score), 5));
//        JTextField jTextField = new JTextField();
//        jTextField.getText();
//        jPanel.revalidate();
//    }
//
//    static JFrame getFrame() {
//        JFrame jFrame = new JFrame() {};
//        jFrame.setVisible(true);
//        jFrame.setBounds(10, 10, 420, 430);
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        return jFrame;
//
//    }
}
