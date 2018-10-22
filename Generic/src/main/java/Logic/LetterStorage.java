package Logic;

public class LetterStorage extends Storage<Letter, Person> {

    @Override
    public void sort() {
        System.out.println("List of letters has been sorted");
    }

}
