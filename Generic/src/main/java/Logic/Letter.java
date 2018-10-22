package Logic;

public class Letter {
    private int id;
    private String address;

    public Letter(int id, String address) {
        this.id = id;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
