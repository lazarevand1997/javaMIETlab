package controller;

import view.Chart;
import view.Menu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class main {

    public static final String PATH_TO_PROPERTIES = "src/resources/config.properties";

    public static void main(String[] args) {
        // получение параметров
        getProp();
        // прелоедер
        Scanner reader = new Scanner(System.in);
        String questToUser = "chart or text?";
        System.out.println(questToUser);
        String  printMode = reader.nextLine();
        if(printMode.contentEquals(PrintModes.CHART_MODE)){
            Chart barchart = new Chart();
            barchart.showChart();
        } else if (printMode.contentEquals(PrintModes.TEXT_MODE)){
            Menu menu = new Menu();
            menu.startUp();
        } else {
            System.out.println("err");
        }
        reader.close();
    }

    public static void getProp() {
        FileInputStream fileInputStream;
        //инициализируем специальный объект Properties
        //типа Hashtable для удобной работы с данными
        Properties prop = new Properties();

        try {
            //обращаемся к файлу и получаем данные
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);

            String loginToSite = prop.getProperty("login");
            String passwordToSite = prop.getProperty("password");

            //печатаем полученные данные в консоль
            System.out.println(
                    "loginToSite: " + loginToSite
                            + "\npasswordToSite: " + passwordToSite
            );

        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружено");
            e.printStackTrace();
        }
    }

    public void showMenu(){
    }
}
