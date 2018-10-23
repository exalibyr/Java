package com.company;

import java.util.*;

public class CollectionsTest {

    static void arrayLists(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList.toString());
        arrayList.add(1, 0);
        System.out.println(arrayList.toString());
        arrayList.remove(2);
        System.out.println(arrayList.toString());
        ListIterator<Integer> listIterator = arrayList.listIterator(arrayList.size());
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }

    static void queue(){
        //that is queue
        System.out.println("!that is queue!");
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer("first in");
        arrayDeque.offer("second in");
        arrayDeque.offer("third in");
        System.out.println(arrayDeque.toString());
        System.out.println(arrayDeque.poll());
        System.out.println(arrayDeque.toString());
    }

    static void stack(){
        //that is stack
        System.out.println("!that is stack!");
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.push("first in");
        arrayDeque.push("second in");
        arrayDeque.push("third in");
        System.out.println(arrayDeque.toString());
        System.out.println(arrayDeque.pop());
        System.out.println(arrayDeque.toString());
    }

    static void deque(){
        //that is deque
        System.out.println("!that is deque!");
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst("first in");
        arrayDeque.offerLast("second in");
        arrayDeque.add("third in");
        arrayDeque.offer("fourth in");
        arrayDeque.addFirst("zero in");
        System.out.println(arrayDeque.toString());
        System.out.println(arrayDeque.remove());
        System.out.println(arrayDeque.toString());
        System.out.println(arrayDeque.removeFirst());
        System.out.println(arrayDeque.toString());
        System.out.println(arrayDeque.removeLast());
        System.out.println(arrayDeque.toString());
    }

    static void linkedList(){
        //that is queue, stack and list together
        LinkedList<String> states = new LinkedList<>();
        states.add("USA");
        states.push("Germany");
        states.offerFirst("France");
        states.addLast("Italy");
        System.out.println(states.toString());
        states.pop();
        states.removeLast();
        states.pollFirst();
        System.out.println(states.toString());
    }

    static void hashSet(){
        HashSet<Person> people = new HashSet<>();
        people.add(new Person("Bob"));
        System.out.println(people.toString());

        Person jack = new Person("Jack");
        people.add(jack);
        System.out.println(people.toString());

        people.add(jack);
        System.out.println(people.toString());

        people.add(new Person("Jack"));
        System.out.println(people.toString());

        people.add(new Person("Sandra"));
        System.out.println(people.toString());

        people.add(new Person("Jack"));
        System.out.println(people.toString());

        people.add(new Person("Jim"));
        System.out.println(people.toString());
    }

    static void treeSet(){
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(4);
        treeSet.add(2);
        treeSet.add(3);
        System.out.println(treeSet.toString());
        System.out.println(treeSet.descendingSet());
        System.out.println(treeSet.last());

        //person implements comparable
        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("Jane"));
        people.add(new Person("Alex"));
        people.add(new Person("Alice"));
        people.add(new Person("Oliver"));
        System.out.println(people.toString());

        //PersonComparator implements Comparator
        TreeSet<Person> people1 = new TreeSet<>(new PersonComparator());
        people1.add(new Person("Alex"));
        people1.add(new Person("Alice"));
        people1.add(new Person("Jane"));
        people1.add(new Person("Oliver"));
        System.out.println(people1.toString());

        //a few criteria for comparison
        Comparator<Auto> comparator = new AutoYearComparator().thenComparing(new AutoMarkComparator());
        TreeSet<Auto> autos = new TreeSet<>(comparator);
        autos.add(new Auto("Audi", 2008));
        autos.add(new Auto("Ford", 2001));
        autos.add(new Auto("Reno", 2005));
        autos.add(new Auto("Audi", 2005));
        System.out.println(autos.toString());
    }

    static void hashMap(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.putIfAbsent(0, "USA");
        hashMap.putIfAbsent(1, "Canada");
        hashMap.putIfAbsent(2, "Germany");
        hashMap.putIfAbsent(3, "Italy");
        System.out.println(hashMap.toString());
//        System.out.println(hashMap.entrySet());
        System.out.println(hashMap.keySet());
        for(Map.Entry<Integer, String> entry : hashMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    static void treeMap(){
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.putIfAbsent(0, "USA");
        treeMap.putIfAbsent(1, "Canada");
        treeMap.putIfAbsent(2, "Germany");
        treeMap.putIfAbsent(3, "Italy");
        System.out.println(treeMap.descendingMap());
        System.out.println(treeMap.descendingKeySet());
        System.out.println(treeMap.keySet());
        System.out.println(treeMap.navigableKeySet());
    }
}
