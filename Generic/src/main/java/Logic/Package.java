package Logic;

public class Package {
    private int id;
    private int weight;
    private String address;

    public Package(int id, int weight, String address) {
        this.id = id;
        this.weight = weight;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", weight=" + weight +
                ", address='" + address + '\'' +
                '}';
    }
}
