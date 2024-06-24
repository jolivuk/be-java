package org.demo.summary05_20240621.code.client;

import java.util.Scanner;

import org.demo.summary05_20240621.code.core.mvp.View;
import org.demo.summary05_20240621.code.seed.Data;
import org.demo.summary05_20240621.code.Environment;
import org.demo.summary05_20240621.code.core.mvp.Presenter;
import org.demo.summary05_20240621.code.ui.ConsoleView;

public class App {
    public static void ButtonClick() {
        Data.seed(Environment.path);

        System.out.print("\033[H\033[J"); // https://ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, Environment.path);
        presenter.LoadFromFile();

        try (Scanner in = new Scanner(System.in)) {
            boolean flag = true;
            while (flag) {
                System.out.println(" 1 - prev  2 - next 3 - print all 0 - exit");
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.prev();
                        break;
                    case "2":
                        presenter.next();
                        break;
                    case "3":
                        System.out.println("Print all list");
                        presenter.displayAll();
                        break;
                    case "0":
                        flag = false;
                        break;


                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }
    }
}
