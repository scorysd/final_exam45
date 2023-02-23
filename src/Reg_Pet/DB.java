package Reg_Pet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DB {
    private static PreparedStatement prstmt;
    private static ResultSet res;
    public void write() throws IOException {
        try {
            String url = "jdbc:mysql://localhost:3306/human_friends";
            String username = "root";
            String password = "rootroot";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                System.out.println("Подключение к БД успешно!");
                String sql = "insert into animals (animal_name, animal_age, animal_type, animal_clan)" +
                        "values (?, ?, ?, ?)";
                prstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                prstmt.setString(1, Animal.getName());
                prstmt.setInt(2, Animal.getAge());
                prstmt.setInt(3, Animal.getType());
                prstmt.setInt(4, Animal.getClan());
                prstmt.executeUpdate();
                ResultSet rs = prstmt.getGeneratedKeys();
                if (rs.next()) {
                    int pk = rs.getInt(1);
                    System.out.println("Животное успешно добавлено:");
                    System.out.printf("имя: %s, взраст: %d, тип: %d, род: %d,%n", Animal.getName(), Animal.getAge(), Animal.getType(), Animal.getClan());
                    System.out.println("Порядковый номер животного: " + pk);
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    public void view() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/human_friends";
            String username = "root";
            String password = "rootroot";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                System.out.println("Подключение к БД успешно!");
                prstmt = conn.prepareStatement("SELECT animal_id, animal_name, animal_age, type, clan FROM human_friends.animals as t1\n" +
                        "join human_friends.type as t2 on t1.animal_type = t2.type_id\n" +
                        "join human_friends.clan as t3 on t1.animal_clan = t3.clan_id;");
                res = prstmt.executeQuery();
                while (res.next()) {
                    int id = res.getInt(1);
                    String name = res.getString(2);
                    int age = res.getInt(3);
                    String type = res.getString(4);
                    String clan = res.getString(5);
                    System.out.printf("id: %d, Имя: %s, Возраст: %d, Тип: %s, Род: %s  %n", id, name, age, type, clan);
                }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    public void del() throws IOException {
        try {
            String url = "jdbc:mysql://localhost:3306/human_friends";
            String username = "root";
            String password = "rootroot";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                System.out.println("Подключение к БД успешно!");
                String sql = "delete from animals where animal_id = ?";
                prstmt = conn.prepareStatement(sql);
                System.out.println("Введите порядковый номер животного: ");
                Scanner sc = new Scanner(System.in);
                int num = sc.nextInt();
                prstmt.setInt(1, num);
                prstmt.executeUpdate();
                sql = "alter table human_friends.animals drop animal_id";
                prstmt = conn.prepareStatement(sql);
                prstmt.executeUpdate();
                sql = "alter table human_friends.animals add animal_id int not null auto_increment first ,add primary key (animal_id)";
                prstmt = conn.prepareStatement(sql);
                prstmt.executeUpdate();
                System.out.println("Животное успешно удалено!");
//                System.out.printf("имя: %s, взраст: %d, тип: %d, род: %d,%n", Animal.getName(), Animal.getAge(), Animal.getType(),Animal.getClan());

            }

        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    public void showComand() throws IOException {
        try {
            String url = "jdbc:mysql://localhost:3306/human_friends";
            String username = "root";
            String password = "rootroot";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                System.out.println("Подключение к БД успешно!");
                String sql = ("SELECT animal_id, animal_name, animal_age, type, clan FROM human_friends.animals as t1\n" +
                        "join human_friends.type as t2 on t1.animal_type = t2.type_id\n" +
                        "join human_friends.clan as t3 on t1.animal_clan = t3.clan_id\n" +
                        "where t1.animal_id = ?;");
                prstmt = conn.prepareStatement(sql);
                System.out.println("Введите порядковый номер животного: ");
                Scanner sc = new Scanner(System.in);
                int num = sc.nextInt();
                prstmt.setInt(1, num);
                res = prstmt.executeQuery();
                while (res.next()) {
                    int id = res.getInt(1);
                    String name = res.getString(2);
                    int age = res.getInt(3);
                    String type = res.getString(4);
                    String clan = res.getString(5);
                    System.out.printf("id: %d, Имя: %s, Возраст: %d, Тип: %s, Род: %s  %n", id, name, age, type, clan);
                }
                String sql1 = "SELECT animal_id, animal_name, animal_age, type, clan, comand_name FROM human_friends.animals as t1\n" +
                        "join human_friends.type as t2 on t1.animal_type = t2.type_id\n" +
                        "join human_friends.clan as t3 on t1.animal_clan = t3.clan_id\n" +
                        "join human_friends.skils as t4 on t1.animal_id = t4.animal\n" +
                        "join human_friends.comand as t5 on t5.comand_id = t4.comand\n" +
                        "where t1.animal_id = ?;";
                prstmt = conn.prepareStatement(sql1);
                prstmt.setInt(1, num);
                res = prstmt.executeQuery();

                while (res.next()) {
                    String skil = res.getString(6);
                    System.out.printf("Умеет: %s  %n", skil);
                }
            } catch (Exception ex) {
                System.out.println("Connection failed...");
                System.out.println(ex);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
    public void learn() throws IOException {
        try {
            String url = "jdbc:mysql://localhost:3306/human_friends";
            String username = "root";
            String password = "rootroot";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                System.out.println("Подключение к БД успешно!\n Навыки:");
                prstmt = conn.prepareStatement("select * from comand");
                res = prstmt.executeQuery();
                while (res.next()) {
                    int id = res.getInt(1);
                    String name = res.getString(2);
                    System.out.printf(" %d >>>>: %s, %n", id, name);
                }
                String sql = "insert into skils (animal, comand)" +
                        "values (?, ?)";
                prstmt = conn.prepareStatement(sql);
                System.out.println("Введите порядковый номер животного, которое желаете обучить: ");
                Scanner sc = new Scanner(System.in);
                int num = sc.nextInt();
                System.out.println("Какому навыку желаете обучить: ");
                Scanner sc1 = new Scanner(System.in);
                int num1 = sc1.nextInt();
                prstmt.setInt(1, num);
                prstmt.setInt(2, num1);
                prstmt.executeUpdate();
                System.out.println("Животное успешно обучено!");
                }
            } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
}


