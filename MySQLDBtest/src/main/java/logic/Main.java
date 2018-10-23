package logic;


public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver has been successfully registered");
        }
        catch (ClassNotFoundException e){
            System.out.println("Errrror");
        }
        Config config = ConfigReader.getFromFile();
        QueryBuilder.tryConnection(config);
        QueryBuilder.createTable(config);
        QueryBuilder.insertData(config);
        QueryBuilder.updateTable(config);
        QueryBuilder.deleteRow(config);
        QueryBuilder.printData(config);
        QueryBuilder.tetsPreparedStatement(config);
        QueryBuilder.printData(config);
    }
}
