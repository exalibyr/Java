package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStreamAPI {

    static void simpleTest(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.add(3, 7);
        list.add(3);
        System.out.println(list);
        list.stream().dropWhile(i -> i < 5).forEach(i -> System.out.print(i + "\t"));
        System.out.println("dropWhile");
        list.stream().takeWhile(i -> i < 5).forEach(i -> System.out.print(i + "\t"));
        System.out.println("takeWhile");
    }

    static void simpleTest2(){
        int[] figures = new int[10];
        for (int i = 0; i < 10; i++) {
            figures[i] = i;
        }
        IntStream intStream = Arrays.stream(figures);
        intStream.filter(i -> i % 2 == 1).forEach(i -> System.out.print(i + "\t"));
        System.out.println("odd figures");
    }

    static void simpleTest3(){
        List<String> states = new ArrayList<>();
        Collections.addAll(states, "USA", "Italy", "Germany", "France", "Spain");
        boolean b = Stream.of(states).anyMatch(s -> s.contains("USA"));
        System.out.println("Sequence " + states + " has USA is " + b);
        Stream<String> stringStream = states.stream();
        b = stringStream.anyMatch(s -> s.contains("r"));
        System.out.println("Sequence " + states + " has r is " + b);
    }

    static void test1(){
        Stream<Phone> stream = Stream.of(new Phone("Honor 10", 27000),
                new Phone("P20 Pro", 55000),
                new Phone("P20 Lite", 21000));
        stream.filter(p -> p.getPrice() > 25000).forEach(p -> System.out.println(p.getName() + "\t" + p.getPrice()));
        stream = Stream.of(new Phone("Honor 10", 27000),
                new Phone("P20 Pro", 55000),
                new Phone("P20 Lite", 21000));
        stream.map(p -> p.getName()).forEach(System.out::println);
    }

    static void test2(){
        Stream<Phone> stream = Stream.of(new Phone("Honor 10", 27000),
                new Phone("P20 Pro", 55000),
                new Phone("P20 Lite", 21000));

        stream.flatMap(p -> Stream.of(String.format("Модель: %s\tцена со скидкой: %d", p.getName(), (int)(p.getPrice()* 0.8)),
                String.format("Модель: %s\tцена без скидки: %d", p.getName(), p.getPrice())))
                .forEach(p -> System.out.println(p));
    }

    static void testSorting(){
        Stream<Auto> autoStream = Stream.of(new Auto("ford", 1992, false),
                new Auto("lamborgini", 2012, true),
                new Auto("BMW", 2015, true));
        autoStream.sorted((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()))
                .forEach(a -> System.out.println(a.getName()));

    }

    static void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3);
        Stream<Integer> stream1 = Stream.of(3, 2, 1);
        Stream.concat(stream, stream1).forEach(i -> System.out.print(i));
        System.out.println();
        Stream.of(1, 2, 3, 3, 5, 4, 7, 2, 1).distinct().forEach(i -> System.out.print(i));
    }

    static void test4(){
        int[] figures = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.stream(figures).skip(3).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        Arrays.stream(figures).limit(figures.length - 3).forEach(i -> System.out.print(i + "\t"));
    }

    static void test5(){
        List<String> phones = new ArrayList<>();
        phones.addAll(Arrays.asList(new String[]
                {"iPhone 6 S", "Lumia 950", "Huawei Nexus 6P",
                        "Samsung Galaxy S 6", "LG G 4", "Xiaomi MI 5",
                        "ASUS Zenfone 2", "Sony Xperia Z5", "Meizu Pro 5",
                        "Lenovo S 850"}));

        int pageSize = 3; // количество элементов на страницу
        Scanner scanner = new Scanner(System.in);
        while(true){

            System.out.println("Введите номер страницы: ");
            int page = scanner.nextInt();

            if(page<1) break; // если число меньше 1, выходим из цикла

            phones.stream().skip((page-1) * pageSize)
                    .limit(pageSize)
                    .forEach(s->System.out.println(s));
        }
    }

    static void test6(){
        Stream<Phone> stream = Stream.of(new Phone("Honor 10", 27000),
                new Phone("P20 Pro", 55000),
                new Phone("P20 Lite", 21000));
        System.out.println(stream.min(new PhoneComparator()).get().getPrice());
        stream = Stream.of(new Phone("Honor 10", 27000),
                new Phone("P20 Pro", 55000),
                new Phone("P20 Lite", 21000));
        System.out.println(stream.max(new PhoneComparator()).get().getPrice());
    }

    static void testReduce(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> multiplied = stream.reduce((x, y) -> x * y);
        System.out.println(multiplied.get());
        Stream<String> stringStream = Stream.of("Философ", "кушал", "пельмени.", "Позже", "он", "поперхнулся", "и", "помер.");
        String sentence = stringStream.reduce("Баллада о философе. \n", (x, y) -> x + " " + y);
        System.out.println(sentence);
        Stream<Phone> stream2 = Stream.of(new Phone("Honor 10", 27000),
                new Phone("P20 Pro", 55000),
                new Phone("P20 Lite", 21000));
        int sum = stream2.reduce(0, (p1, p2) ->{
            if(p2.getPrice() < 50000)
                return p1 + p2.getPrice();
            else
                return p1 + 0;
        }, (p1, p2) -> p1 + p2);
        System.out.println(sum);
    }

    static void testOptional(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> emptyStream = Stream.of();
        Optional<Integer> optional = stream.max(Integer::compareTo);
        Consumer<Integer> ifPresent = v -> System.out.println(v);
        optional.ifPresentOrElse(ifPresent, () -> System.out.println("Nothing"));
        optional = emptyStream.max(Integer::compareTo);
        optional.ifPresentOrElse(ifPresent, () -> System.out.println("Nothing"));
        System.out.println(Stream.of().findAny().orElse("Nothing"));
        ArrayList<Integer> arrayList = new ArrayList<>();
        Optional<Integer> optional1 = arrayList.stream().max(Integer::compareTo);
        Random random = new Random();
        System.out.println(optional1.orElseGet(() -> random.nextInt()));
    }

    static void testCollectors(){
        HashSet<Integer> set = new HashSet<>();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            set.add(rnd.nextInt(100));
        }
        System.out.println(set);
        System.out.println(set.stream().filter(x -> x < 50).collect(Collectors.toList()));
        Stream<Phone> stream = Stream.of(new Phone("Honor 10", 27000),
                new Phone("P20 Pro", 55000),
                new Phone("P20 Lite", 21000));
        Map<String, Integer> phones = stream.collect(Collectors.toMap(p -> p.getName(), t -> t.getPrice()));
        phones.forEach((k, v) -> System.out.println(k + "\t" + v));
        Stream<String> autos = Stream.of("Ford", "Kia", "Reno");
        TreeSet<String> strings = autos.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(strings);
    }

    static void testGrouping(){
        Stream<Auto> autoStream = Stream.of(new Auto("Ford", 1996, false),
                new Auto("Kia", 2001, true),
                new Auto("Ford", 2003, false),
                new Auto("Ford", 2001, false),
                new Auto("Reno", 1996, true));
        Map<Integer, List<Auto>> listMap = autoStream.collect(Collectors.groupingBy(Auto::getYear));
        for(Map.Entry<Integer, List<Auto>> entry : listMap.entrySet()){
            System.out.println(entry.getKey());
            for(Auto auto : entry.getValue()){
                System.out.println(auto);
            }
            System.out.println();
        }
    }

    static void testPartioning(){
        Stream<Auto> autoStream = Stream.of(new Auto("Ford", 1996, false),
                new Auto("Kia", 2001, true),
                new Auto("Ford", 2003, false),
                new Auto("Ford", 2001, false),
                new Auto("Reno", 1996, true));
        Map<Boolean, List<Auto>> listMap = autoStream.collect(Collectors.partitioningBy(p -> p.getYear() < 2000));
        for(Map.Entry<Boolean, List<Auto>> entry : listMap.entrySet()){
            System.out.println("Before 21x century: " + entry.getKey());
            for(Auto auto : entry.getValue()){
                System.out.println(auto);
            }
            System.out.println();
        }
    }

    static void testCounting(){
        Stream<Auto> autoStream = Stream.of(new Auto("Ford", 1996, false),
                new Auto("Kia", 2001, true),
                new Auto("Ford", 2003, false),
                new Auto("Ford", 2001, false),
                new Auto("Reno", 1996, true));
        Map<String, Long> listMap = autoStream.collect(Collectors.groupingBy(Auto::getName, Collectors.counting()));
        for(Map.Entry<String, Long> entry : listMap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static void testSumming(){
        Stream<Auto> autoStream = Stream.of(new Auto("Ford", 1996, false),
                new Auto("Kia", 2001, true),
                new Auto("Ford", 2003, false),
                new Auto("Ford", 2001, false),
                new Auto("Reno", 1996, true));
        Map<String, Long> listMap = autoStream.collect(Collectors.groupingBy(Auto::getName, Collectors.summingLong(Auto::getYear)));
        for(Map.Entry<String, Long> entry : listMap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static void testMinBy(){
        Stream<Auto> autoStream = Stream.of(new Auto("Ford", 1996, false),
                new Auto("Kia", 2001, true),
                new Auto("Ford", 2003, false),
                new Auto("Ford", 2001, false),
                new Auto("Reno", 1996, true));
        Map<String, Optional<Auto>> listMap = autoStream.collect(Collectors.groupingBy(Auto::getName,
                Collectors.minBy(Comparator.comparing(Auto::getYear))));
        for(Map.Entry<String, Optional<Auto>> entry : listMap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().get().getYear());
        }

    }

    static void testSummarizing(){
        Stream<Auto> autoStream = Stream.of(new Auto("Ford", 1996, false),
                new Auto("Kia", 2001, true),
                new Auto("Ford", 2003, false),
                new Auto("Ford", 2001, false),
                new Auto("Reno", 1996, true));
        Map<String, IntSummaryStatistics> listMap = autoStream.collect(Collectors.groupingBy(Auto::getName,
                Collectors.summarizingInt(Auto::getYear)));
        for(Map.Entry<String, IntSummaryStatistics> entry : listMap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue().getAverage());
        }
    }

    static void testMapping(){
        Stream<Auto> autoStream = Stream.of(new Auto("Ford", 1996, false),
                new Auto("Kia", 2001, true),
                new Auto("Ford", 2003, false),
                new Auto("Ford", 2001, false),
                new Auto("Reno", 1996, true));
        Map<Integer, List<String>> listMap = autoStream.collect(Collectors.groupingBy(Auto::getYear,
                Collectors.mapping(Auto::getName, Collectors.toList())
        ));
        for(Map.Entry<Integer, List<String>> entry : listMap.entrySet()){
            System.out.println(entry.getKey());
            for(String name : entry.getValue()){
                System.out.println(name);
            }
            System.out.println();
        }
    }

    static void testParallel(){
        Stream<String> wordsStream = Stream.of("мама", "мыла", "раму", "hello world");
        String sentence = wordsStream.parallel()
                .filter(s->s.length()<10) // фильтрация над параллельным потоком
                .sequential()
                .reduce("Результат:", (x,y)->x + " " + y); // операция над последовательным потоком
        System.out.println(sentence);
        Stream<String> words = Stream.of("мама", "мыла", "раму", "hello world");
        Optional<String> sentence2 = words.parallel()
                .reduce((x,y)->x + " " + y); // операция над последовательным потоком
        System.out.println("Результат: " + sentence2.get());
        int[] numbers = {1, 2, 3, 4, 5, 6};
        IntStream intStream = Arrays.stream(numbers);
        intStream.unordered().forEach(s -> System.out.print(s + "\t"));
        System.out.println();
        int[] numbers2 = {1, 2, 3, 4, 5, 6};
        IntStream intStream2 = Arrays.stream(numbers2);
        intStream2.forEachOrdered(s -> System.out.print(s + "\t"));
        System.out.println();
    }



}
