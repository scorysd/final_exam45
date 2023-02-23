package Reg_Pet;

import java.util.Scanner;

class Animal {
    static String name;
    static int age;
    static int type;
    static int clan;

    Animal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        Animal.name = scanner.nextLine();
        System.out.println("Введите возраст: ");
        Animal.age = scanner.nextInt();
        System.out.println("Выбирите тип: \n 1>>>> вьючные \n 2>>>> домашние ");
        boolean res = false;
        do {
            Animal.type = scanner.nextInt();
            switch (type) {
                case 1:
                    this.type = 1;
                    res = true;
                    break;
                case 2:
                    this.type = 2;
                    res = true;
                    break;
                default:
                    System.out.println("Введен недопустимый символ! \n Повторите ввод:");
                    res = false;
            }
        } while (res == false);
        res = false;
        if (type == 1) {
            System.out.println("Выбирите род:  \n 4>>>> лошади \n 5>>>> ослы \n 6>>>> верблюды");
            do {
                Animal.clan = scanner.nextInt();
                switch (clan) {
                    case 4:
                        this.clan = 4;
                        res = true;
                        break;
                    case 5:
                        this.clan = 5;
                        res = true;
                        break;
                    case 6:
                        this.clan = 6;
                        res = true;
                        break;
                    default:
                        System.out.println("Введен недопустимый символ! \n Повторите ввод:");
                        res = false;
                }
            } while (res == false);
        }
        if (type == 2) {
            System.out.println("Выбирите род: \n 1>>>> собаки \n 2>>>> кошки \n 3>>>> хомяки \n");
            do {
                Animal.clan = scanner.nextInt();
                switch (clan) {
                    case 1:
                        this.clan = 1;
                        res = true;
                        break;
                    case 2:
                        this.clan = 2;
                        res = true;
                        break;
                    case 3:
                        this.clan = 3;
                        res = true;
                        break;
                    default:
                        System.out.println("Введен недопустимый символ! \n Повторите ввод:");
                        res = false;
                }
            } while (res == false);
        }
    }

    public static void add() {
        Animal animal = new Animal();
    }

    public static String getName() {
        return name;
    }
    public static int getAge(){
        return age;
    }
    public static int getType(){
        return type;
    }
    public static int getClan(){
        return clan;
    }
}