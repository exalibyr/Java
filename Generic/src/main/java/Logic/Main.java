package Logic;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("eeeeeeeeeeee");
        List<Letter> letters = new ArrayList<>();
        letters.add(new Letter(0, "aga"));
        letters.add(new Letter(1, "hmmm"));
        letters.add(new Letter(2 ,"mmmmhm"));
        Person person = new Person("Jim");
        List<Package> packages = new ArrayList<>();
        Organization organization = new Organization("org");
        packages.add(new Package(3,100 ,  "EEEEEEEEEEe"));
        LetterStorage letterStorage = new LetterStorage();
        PackageStorage packageStorage = new PackageStorage();
        letterStorage.add(letters, person);
        packageStorage.add(packages, organization);
        System.out.println(letterStorage);
        System.out.println(packageStorage);
        packageStorage.sort();
        letterStorage.sort();
    }

}
