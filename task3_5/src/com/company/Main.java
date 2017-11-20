//Task3_5
//Создать структуру кафе (класс JavaCafe)
//Структура классов (родитель => наследники):
//Персонал => Управляющий, Менеджер, Официант, Бармен, Уборщик
//Меню => Завтрак, Обед, Ужин, ЛюбоеВремя (здесь имеется ввиду что эти классы содержат списки блюд)
//Блюдо => Закуски, Салаты, Горячее, Гарниры, Десерт
//У всех персонажей кафе есть определенное расписание.
//То есть когда с консоли вводится информация об имени посетителя,
//то происходит расчет или генерация состава текущей смены в кафе (кто сегодня менеджер, какие официанты, кто бармен и т.д.).
//Информация о составе персонала, дате и времени посещения выводится на экран.
//Затем выводится соответствующее меню со списком блюд.
//С консоли вводятся названия блюд до тех пор пока не будет введена фраза "это все".
//Затем посетителю выводится на экран стоимость выбранных им блюд и время их ожидания.

package com.company;

import java.io.FileReader;
import java.time.DayOfWeek;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Salad> salads = new ArrayList<>();
        List<Dessert> desserts = new ArrayList<>();
        List<Garnish> garnishes = new ArrayList<>();
        List<Snack> snacks = new ArrayList<>();
        List<Starter> starters = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        try{
            Scanner read = new Scanner(new FileReader("salads.txt"));
            String[] line;
            while(read.hasNextLine()){
                line = read.nextLine().split("/");
                salads.add(new Salad(line[0].trim(),
                        Double.parseDouble(line[1].trim())));
            }
            read = new Scanner(new FileReader("desserts.txt"));
            while(read.hasNextLine()){
                line = read.nextLine().split("/");
                desserts.add(new Dessert(line[0].trim(),
                        Double.parseDouble(line[1].trim())));
            }
            read = new Scanner(new FileReader("garnishes.txt"));
            while(read.hasNextLine()){
                line = read.nextLine().split("/");
                garnishes.add(new Garnish(line[0].trim(),
                        Double.parseDouble(line[1].trim())));
            }
            read = new Scanner(new FileReader("snacks.txt"));
            while(read.hasNextLine()){
                line = read.nextLine().split("/");
                snacks.add(new Snack(line[0].trim(),
                        Double.parseDouble(line[1].trim())));
            }
            read = new Scanner(new FileReader("starter.txt"));
            while(read.hasNextLine()){
                line = read.nextLine().split("/");
                starters.add(new Starter(line[0].trim(),
                        Double.parseDouble(line[1].trim())));
            }
            read = new Scanner(new FileReader("desserts.txt"));
            while(read.hasNextLine()){
                line = read.nextLine().split("/");
                desserts.add(new Dessert(line[0].trim(),
                        Double.parseDouble(line[1].trim())));
            }
            read = new Scanner(new FileReader("customers.txt"));
            while(read.hasNextLine()){
                Customer customer = new Customer(read.nextLine());
                customers.add(customer);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
            MenuForAnyTime menuForAnyTime = new MenuForAnyTime();
            menuForAnyTime.setSalads(salads);
            menuForAnyTime.setDesserts(desserts);
            menuForAnyTime.setGarnishes(garnishes);
            menuForAnyTime.setSnacks(snacks);
            menuForAnyTime.setStarters(starters);

            BreakfastMenu breakfastMenu = new BreakfastMenu();
            breakfastMenu.setStarters(Arrays.asList(new Starter("Morning omelet", 1.00)));
            breakfastMenu.setSnacks(Arrays.asList(new Snack("Morning sandwich", 1.00)));

            LunchMenu lunchMenu = new LunchMenu();
            lunchMenu.setSalads(Arrays.asList(new Salad("Lunch salad", 1.00)));

            DinnerMenu dinnerMenu = new DinnerMenu();
            dinnerMenu.setDesserts(Arrays.asList(new Dessert("Evening cookies", 1.00)));
            dinnerMenu.setGarnishes(Arrays.asList(new Garnish("Evening cereals", 1.00)));



    }
}
