import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        ArrayList<Song> songs = new ArrayList<Song>();
//        MyParser parser = new MyParser();
//        parser.parse("Music.xml", songs);
//        System.out.println(songs);

        MyParser jaxbParser = new MyParser();
        Music music = jaxbParser.parseList("Music.xml");

        List<Song> songs = music.getCustomerList();
        if (songs != null) {
            for (Song song : songs) {
                System.out.println(song);
            }
        } else {
            System.out.println("no music in list");
        }
    }
}
