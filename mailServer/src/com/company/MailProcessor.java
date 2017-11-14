package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MailProcessor {
    public void createAndSendMessage(
            User senderUser,
            String receiverEmail,
            String subject,
            String mesBodyFileName
    ) {

        Message message = createMessage( senderUser, receiverEmail, subject, mesBodyFileName);
        sendMessage(message);

    }

    private void sendMessage(Message message) {
        StringBuilder sb = new StringBuilder("");

        sb.append("From:  ").append(message.getSender()). append("\n");
        sb.append("To:  ").append(message.getReceiver()). append("\n");
        sb.append("Subject:  ").append(message.getSubject()). append("\n");
        sb.append("Message:  ").append("\n");
        List<String> mesBody = message.getMessage();
        for(String line : mesBody){
            sb.append(line).append("\n");
        }
        System.out.println(sb.toString());
        try(FileWriter fileWriter = new FileWriter("outMailMessage.txt")){
            fileWriter.write(sb.toString());
            fileWriter.close();
            System.out.println("You can find your message saved as outMailMessage.txt");
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private Message createMessage(
            User senderUser,
            String receiverEmail,
            String subject,
            String mesBodyFileName) {

        Message message = new Message();

        String senderEmail = senderUser.getEmail();
        message.setSender(senderEmail);

        message.setReceiver(receiverEmail);
        message.setSubject(subject);

        List<String> mesBody = getMesBody(mesBodyFileName);
        message.setMessage(mesBody);

        return message;

    }

    private List<String> getMesBody(String mesBodyFileName) {
        String line;
        List<String> mesBody = new ArrayList();
        try  {
            BufferedReader br = new BufferedReader(new FileReader(mesBodyFileName));
            while ( (line = br.readLine()) != null ){
                mesBody.add(line);
            }

        } catch ( IOException e) {
            e.printStackTrace();
        }

        return mesBody;
    }
}
