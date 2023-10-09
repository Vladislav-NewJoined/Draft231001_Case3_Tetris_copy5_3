// источник: https://www.youtube.com/watch?v=uuhqubcspPc
// источник: https://drive.google.com/file/d/1ZzrnYv5qsacdeT4Rj2jQK726d9XDsPdI/view?pli=1
// Кейс 3: Мой рабочий кейс - Draft231001_Case3_Tetris_copy5_2
// Счет берём отсюда: Draft231001_Case3_Tetris_4copy
//// источник: https://github.com/mdinep/java-simple-tetris/blob/master/Tetris.java
// Draft_Task1_3_10_4_6copy  - Отсюда взять табличку, если понадобится


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main_copy3 {

    static class brick {
        int[][][] typicalForms = new int[][][]{{{1, 0}, {1, 1}, {1, 2}, {0, 2}}, {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
                {{1, 0}, {0, 1}, {1, 1}, {2, 1}}, {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, {{0, 0}, {0, 1}, {1, 0}, {1, 1}}};

        int[][] form = typicalForms[give_a_random_number_from(0, typicalForms.length)];
        Color color = Color.BLUE;
        int posX = 0;
        int posY = 0;
    }

    static class Field extends JFrame {
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

        void paintDot(int x_, int y_, Color color_) {
            getContentPane().getComponents()[x_ + (y_ * width)].setBackground(color_);
        }

        void clear() {
            for (Component currentComponent : getContentPane().getComponents())
                currentComponent.setBackground(Color.WHITE);
        }

        void paintAllBrick(brick[] bricks_) {
            clear();
            for (brick currentBrick : bricks_) // проходимся по каждому кирпичику
                if (currentBrick != null)
                    for (int[] currentCell : currentBrick.form) // проходимся по каждой ячейке кирпичика
                        if (currentCell != null)
                            paintDot(currentCell[0] + currentBrick.posX, currentCell[1] + currentBrick.posY,
                                    currentBrick.color);
            repaint();
        }
    }


    static int NumCurrentBrick = 0;
    static brick[] bricks = new brick[1000];
    static Field field = new Field();

    public static void main(String[] args) {
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
                   Следующая фигура: Down.
                   Раскладка должна быть переключена на латинский шрифт (ENG).""");

        bricks[NumCurrentBrick] = new brick();

        field.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(KeyEvent e) {

                step(e.getKeyText(e.getKeyCode()));
            }
        });

        field.paintAllBrick(bricks);
    }

    static void step(String dir_) {
        // задаем клавиши движения
        int dirX = 0;
        int dirY = 0;

        if (dir_ == "Down")
            dirY++;
        if (dir_ == "Up")
            dirY--;
        if (dir_ == "Right")
            dirX++;
        if (dir_ == "Left")
            dirX--;

        if (dir_ == "Insert")
            rotateLeft();
        if (dir_ == "Delete")
            rotateRight();


        //вычисляем коллизию
        boolean collision = collision(dirX, dirY);
        // если направление вниз - поставить, иначе просто подвинуть
        if (collision && dirY > 0) {
            NumCurrentBrick++;
            bricks[NumCurrentBrick] = new brick();
            ClearFullLines();

        } else if (!collision) {
            bricks[NumCurrentBrick].posX += dirX;
            bricks[NumCurrentBrick].posY += dirY;
        }

        field.paintAllBrick(bricks);
    }

    static void rotateRight() {

        int maxX = 0;
        int maxY = 0;

        for (int[] currentCell : bricks[NumCurrentBrick].form) {
            if (currentCell[0] > maxX)
                maxX = currentCell[0];
            if (currentCell[1] > maxY)
                maxY = currentCell[1];
        }


        int[][] newForm = new int[bricks[NumCurrentBrick].form.length][2];

        for (int currentCellNum = 0; currentCellNum < newForm.length; currentCellNum++) {
            newForm[currentCellNum][0] = maxY - bricks[NumCurrentBrick].form[currentCellNum][1];
            newForm[currentCellNum][1] = bricks[NumCurrentBrick].form[currentCellNum][0];
        }
        int[][] temp = bricks[NumCurrentBrick].form;

        bricks[NumCurrentBrick].form = newForm;
        if (collision(0, 0))
            bricks[NumCurrentBrick].form = temp;
    }

    static void rotateLeft() {

        int maxX = 0;
        int maxY = 0;

        for (int[] currentCell : bricks[NumCurrentBrick].form) {
            if (currentCell[0] > maxX)
                maxX = currentCell[0];
            if (currentCell[1] > maxY)
                maxY = currentCell[1];
        }


        int[][] newForm = new int[bricks[NumCurrentBrick].form.length][2];

        for (int currentCellNum = 0; currentCellNum < newForm.length; currentCellNum++) {
            newForm[currentCellNum][0] = bricks[NumCurrentBrick].form[currentCellNum][1];
            newForm[currentCellNum][1] = maxX - bricks[NumCurrentBrick].form[currentCellNum][0];
        }
        int[][] temp = bricks[NumCurrentBrick].form;

        bricks[NumCurrentBrick].form = newForm;
        if (collision(0, 0))
            bricks[NumCurrentBrick].form = temp;
    }

    static boolean collision(int dirX_, int dirY_) {
        boolean out = false;
        for (brick currentBrick : bricks) // проходимся по каждому кирпичику
            if (currentBrick != null) {
                for (int[] currentCell : currentBrick.form)
                    if (currentBrick == bricks[NumCurrentBrick]) {

                        int nextX = currentCell[0] + currentBrick.posX + dirX_;
                        int nextY = currentCell[1] + currentBrick.posY + dirY_;

                        // колизия краёв
                        if (nextY < 0)
                            out = true;
                        if (nextY >= field.height)
                            out = true;
                        if (nextX >= field.width)
                            out = true;
                        if (nextX < 0)
                            out = true;

                        //коллизия с каждым квадратиком на поле
                        for (int NumTargetBrick = 0; NumTargetBrick < bricks.length; NumTargetBrick++)
                            if (bricks[NumTargetBrick] != null && NumTargetBrick != NumCurrentBrick)
                                for (int[] targetCell : bricks[NumTargetBrick].form)
                                    if (targetCell != null) {
                                        int nextTargetY = targetCell[1] + bricks[NumTargetBrick].posY;
                                        int nextTargetX = targetCell[0] + bricks[NumTargetBrick].posX;
                                        if (nextTargetY == nextY && nextTargetX == nextX)
                                            out = true;
                                    }

                    }
            }

        return out;
    }

    static int give_a_random_number_from(int min_, int max_) {
        return min_ + (int) (Math.random() * max_);
    }

    static void ClearFullLines() {

        //ищем заполненные строки
        int[] countOfCellsInLine = new int[field.height];
        for (brick currentBrick : bricks)
            if (currentBrick != null)
                for (int[] currentCell : currentBrick.form)
                    if (currentCell != null)
                        countOfCellsInLine[currentCell[1] + currentBrick.posY]++;

        //если среди всех строк есть заполненные
        for (int currentLineNum = 0; currentLineNum < countOfCellsInLine.length; currentLineNum++) {
            if (countOfCellsInLine[currentLineNum] == field.width) {

                // ищем все ячейки, лежащие на заполненных строках
                for (int currentBrickNum = 0; currentBrickNum < bricks.length; currentBrickNum++)
                    if (bricks[currentBrickNum] != null && currentBrickNum != NumCurrentBrick)
                        for (int currentCellNum = 0; currentCellNum < bricks[currentBrickNum].form.length;
                             currentCellNum++) {
                            // удалить заполненные строки
                            if (bricks[currentBrickNum].form[currentCellNum] != null)
                                if (bricks[currentBrickNum].form[currentCellNum][1] + bricks[currentBrickNum].posY
                                        == currentLineNum)
                                    bricks[currentBrickNum].form[currentCellNum] = null;
                            // те ячейки, что выше - опустить
                            if (bricks[currentBrickNum].form[currentCellNum] != null)
                                if (bricks[currentBrickNum].form[currentCellNum][1] + bricks[currentBrickNum].posY
                                        < currentLineNum)
                                    bricks[currentBrickNum].form[currentCellNum][1]++;
                            }
            }
        }
    }

//    static void paintComponent(Graphics g) {
//        // Показываем счёт
//        g.setColor(Color.WHITE);
//        g.drawString("Счет"/* + score*/, 19*12, 25);
//    }
}
