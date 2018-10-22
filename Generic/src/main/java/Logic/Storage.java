package Logic;

import java.util.ArrayList;
import java.util.List;

public abstract class Storage<T, K extends Owner> {
    private List<T> tItems = new ArrayList<T>();
    private K owner;

    public void add(List<T> tItems, K owner){
        this.tItems = tItems;
        this.owner = owner;
    }

    public abstract void sort();

//    public void sort(){
//        if(items.get(0) instanceof Letter){
//            System.out.println("List of letters has been sorted");
//        }
//        else if(items.get(0) instanceof Package){
//            System.out.println("List of package has been sorted");
//        }
//        else {
//            throw new IllegalArgumentException();
//        }
//    }


    @Override
    public String toString() {
        return "Storage{" +
                "tItems=" + tItems +
                ", owner=" + owner +
                '}';
    }
}
