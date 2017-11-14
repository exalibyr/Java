    /*Task 2.1
    Изменить проект mailServer таким образом,
    чтобы текст письма выводился в файл outMailMessage.txt*/

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        User[] users = getUsers();


        String login = null;
        String password = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Enter login: ");
            login = br.readLine();

            System.out.print("Enter password: ");
            password = br.readLine();


            CredentialsChecker checker = new CredentialsChecker();
            User user = checker.checkUser(users, login, password);

            if (user != null) {
                String receiverEmail = null;
                String subject = null;
                String mesBodyFileName = null;

                System.out.print("Enter message receiver: ");
                receiverEmail = br.readLine();

                System.out.print("Enter message subject: ");
                subject = br.readLine();

                System.out.print("Enter message file: ");
                mesBodyFileName = br.readLine();

                MailProcessor processor = new MailProcessor();
                processor.createAndSendMessage(
                        user,
                        receiverEmail,
                        subject,
                        mesBodyFileName
                );
            } else {
                System.out.println("Invalid login or password. Exit...");
                return;
            }
        } catch(IOException e){
                e.printStackTrace();

        }

    }

    private static User[] getUsers() {
        User[] users = new User[3];

        users[0] = new User();
        users[0].setLogin("first user");
        users[0].setPassword("first password");
        users[0].setEmail("first@mail.com");

        users[1] = new User();
        users[1].setLogin("second user");
        users[1].setPassword("second password");
        users[1].setEmail("second@mail.com");


        users[2] = new User();
        users[2].setLogin("third user");
        users[2].setPassword("third password");
        users[2].setEmail("third@mail.com");
        return users;
    }
}
