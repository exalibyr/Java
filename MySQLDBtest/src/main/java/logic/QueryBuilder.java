package logic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueryBuilder {

    static void tryConnection(Config cfg){
        try(Connection connection = DriverManager.getConnection(cfg.getUrl(), cfg.getLogin(), cfg.getPassword())) {
            System.out.println("Connection established");
        }
        catch (SQLException e){
            System.out.println("error");
        }

    }

    static void createTable(Config cfg){
        try(Connection connection = DriverManager.getConnection(cfg.getUrl(), cfg.getLogin(), cfg.getPassword())) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE products (Id INT PRIMARY KEY AUTO_INCREMENT," +
                    " ProductName VARCHAR(20), Price INT)");
            System.out.println("Table has been created");
        }
        catch (SQLException e){
            System.out.println("Table creating error");
        }
    }

    static void insertData(Config cfg){
        try(Connection connection = DriverManager.getConnection(cfg.getUrl(), cfg.getLogin(), cfg.getPassword())){
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("INSERT Products(ProductName, Price) VALUES ('iPhone X', 76000)," +
                    "('Galaxy S9', 45000), ('Nokia 9', 36000)");
            System.out.println(rows + " rows has been added");
        }
        catch (SQLException e){
            System.out.println("Insert failed");
        }
    }

    static void updateTable(Config cfg){
        try(Connection connection = DriverManager.getConnection(cfg.getUrl(), cfg.getLogin(), cfg.getPassword())){
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("UPDATE Products SET Price = Price - 5000");
            System.out.println(rows + " rows has been updated");
        }
        catch (SQLException e){
            System.out.println("Update failed");
        }
    }

    static void deleteRow(Config cfg){
        try(Connection connection = DriverManager.getConnection(cfg.getUrl(), cfg.getLogin(), cfg.getPassword())){
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("DELETE FROM Products WHERE Id = 3");
            System.out.println(rows + " rows has been deleted");
        }
        catch (SQLException e){
            System.out.println("Delete failed");
        }
    }

    static void printData(Config cfg){
        try(Connection connection = DriverManager.getConnection(cfg.getUrl(), cfg.getLogin(), cfg.getPassword())){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
            List<Product> products = new ArrayList<>();
            while (resultSet.next()){
                products.add(new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3)));
            }
            for(Product product : products){
                System.out.println(product);
            }
        }
        catch (SQLException e){
            System.out.println("Delete failed");
        }
    }

    static void tetsPreparedStatement(Config cfg){
        try(Connection connection = DriverManager.getConnection(cfg.getUrl(), cfg.getLogin(), cfg.getPassword())){
            PreparedStatement preparedStatement = connection.
                    prepareStatement("INSERT INTO Products (ProductName, Price) Values (?, ?)");
            Scanner in = new Scanner(System.in);
            System.out.print("Product name: ");
            preparedStatement.setString(1, in.next());
            System.out.print("Product price: ");
            preparedStatement.setInt(2, in.nextInt());
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows has been added");
        }
        catch (SQLException e){

        }
    }

}
