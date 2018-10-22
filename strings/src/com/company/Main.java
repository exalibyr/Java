package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        testAll();
        buildersBuffers();
        System.out.println("___________________!!!!_____________________!!!!___________");
        testAll();
    }

    static void testAll(){
        String line1 = "Hi";
        String line2 = "Vsauce";
        String line3 = "Michael";
        String line4 = "is here";
        System.out.println(line1 + line2 + line3 + line4);
        System.out.println(line1.concat(line2));
        System.out.println(String.join(" :=) ", line1, line2, line3, line4));
        System.out.println(line2.charAt(0));
        char[] chars = new char[4];
        line4.getChars(3, 7, chars, 0);
        System.out.println(chars);
        System.out.println("Is Vsuace Michael? I think it's " + line2.equals(line3));
        System.out.println("But does Michael equal michael? I think it's " +
                line3.equalsIgnoreCase(line3.toLowerCase()));
        System.out.println(line1.regionMatches(true, 0, line3, 3, 1));
        System.out.println(line1.regionMatches(0, line3, 3, 1));
        System.out.print("What is longer? Michael or \"is here\"? I guess you think they are equal." +
                " But imma disappoint ya! The Longest is \"");
        if((line3.compareTo(line4)) > 0){
            System.out.println(line3 + "\"");
        }
        else if((line3.compareTo(line4 + "\"")) < 0){
            System.out.println(line4);
        }
        else System.out.println("! Wow! You are right. How could it happen? I retire...");
        System.out.println(line4.indexOf('e'));
        System.out.println(line4.lastIndexOf('e'));
        System.out.println(line2.startsWith("Vs"));
        System.out.println(line4.endsWith("re"));
        String sentence = String.join(" ", line1, line2, line3, line4) + "!";
        System.out.println(sentence);
        System.out.println("No! " + sentence.replace("Vsauce", "♥♥♥♥♥♥"));
        for (int i = 0; i < sentence.length(); i++) {
            System.out.println(sentence.substring(i));
        }
        System.out.println("One last time! Get ready!");
        sentence = sentence.toUpperCase();
        System.out.println(sentence);
        for (String word : sentence.split(" ")){
            System.out.println(word);
        }
    }

    static void buildersBuffers(){
        StringBuilder sb = new StringBuilder();
        System.out.println("initial capacity = " + sb.capacity());
        System.out.println("initial length = " + sb.length());
        sb.append("Hi").append(' ').append("Vsauce ").append("Michael ").append("is ").append("here!");
        System.out.println("current capacity = " + sb.capacity());
        System.out.println("current length = " + sb.length());
        System.out.println(sb.toString());
        System.out.println(sb.append(35).toString());
        System.out.println(sb.append(sb).toString());
        System.out.println(sb.reverse());
        sb.reverse();
        sb.setLength(20);
        System.out.println(sb.toString());
        sb.insert(0, 'B');
        sb.setCharAt(1, 'y');
        sb.replace(2, 3, "e");
        System.out.println(sb.toString());
        sb.delete(10, sb.length());
        System.out.println(sb.toString());
    }
}
