package Reg_Pet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

class Programm {
    private DB DB;

    public Programm() {
    }

    public void start() throws IOException, SQLException {
        DB db = new DB();
        System.out.println("Добро пожаловать в 'Учет домашних животных'!");
        boolean res = false;
        do {
            System.out.println("\n Введите необходимую операцию:\n" +
                    "\n 1 >>>> показать всех животных\n 2 >>>> добавить животное\n 3 >>>> удалить животное" +
                    "\n 4 >>>> показать навыки животного\n 5 >>>> обучить навыку животное\n 6 >>>> выход\n");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    db.view();
                    break;
                case "2":
                    Animal.add();
                    db.write();
                    break;
                case "3":
                    db.del();
                    break;
                case "4":
                    db.showComand();
                    break;
                case "5":
                    db.learn();
                    break;
                case "6":
                    System.out.println("Всего хорошего! До новых встреч!");
                    res = true;
                    break;
                default:
                    System.out.println("Введен недопустимый символ! \n Повторите ввод:");
            }
        }
            while (res == false) ;
    }
}

