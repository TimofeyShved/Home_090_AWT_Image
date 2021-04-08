package com.AWT;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    // создаем в классе пееменные
    private Frame mainFrame; // фрайм и 2 метки (лэйблы) и панель
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public Main() { // ----------------------------------------- конструктор для нашего класса
        prepareGUI(); // и вызываемый метод prepareGUI
    }

    public static void main(String[] args) {
        Main myMainClass = new Main(); // создание наешого основного класса
        myMainClass.showImageDemo(); // и вызываемый метод showImageDemo
    }

    // ----------------------------------------------------- описывает основное визуальное отображение
    private void prepareGUI() {
        mainFrame = new Frame("Java AWT BufferedImage");  // инициализация фрэйма
        mainFrame.setSize(400, 400); // размеры
        mainFrame.setLayout(new GridLayout(3, 1));// расположение объектов на форме

        mainFrame.addWindowListener(new WindowAdapter() {// обработка событий
            public void windowClosing(WindowEvent windowEvent) { // принажатии на кнопку "Закрыть"
                System.exit(0);
            }
        });

        // метки
        headerLabel = new Label(); // инициализация
        headerLabel.setAlignment(Label.CENTER);// в центре
        statusLabel = new Label();// инициализация
        statusLabel.setAlignment(Label.CENTER);// в центре
        statusLabel.setSize(350, 100);// размеры

        controlPanel = new Panel();// новая панель
        controlPanel.setLayout(new FlowLayout()); // расположение объектов на форме (лайаут)

        // добавление объектов на форму
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true); // видимость формы true
    }

    //----------------------------------------------------- Что будет в BufferedImage
    private void showImageDemo(){
        headerLabel.setText("Контрол в действии: Image");

        // добавление объектов на форму
        controlPanel.add(new ImageComponent("java.png"));
        mainFrame.setVisible(true); // видимость формы true
    }

    class ImageComponent extends Component { // наш класс картинки который наследует параметры компонента

        BufferedImage img; // создание переменной картики

        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null); // прорисовка картинки
        }

        public ImageComponent(String path) { // конструктор
            try {
                img = ImageIO.read(new File(path)); //закидываем путь
            } catch (IOException e) {
                e.printStackTrace(); // если ощибка, сообщение
            }
        }

        public Dimension getPreferredSize() { // обработка размеров
            if (img == null) {
                return new Dimension(100,100);
            } else {
                return new Dimension(img.getWidth(), img.getHeight());
            }
        }
    }
}