package Logic;

public class PackageStorage extends Storage<Package, Organization> {

    @Override
    public void sort() {
        System.out.println("List of package has been sorted");
    }
}
