package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileIOStreams {

    static void writeBytesFile(){
        try(FileOutputStream fileOutputStream = new FileOutputStream("byte text 1")){
            fileOutputStream.write("This is a byte text!".getBytes());
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    static void readBytesFile(){
        try(FileInputStream fileInputStream = new FileInputStream("byte text 1")){
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer, 0, fileInputStream.available());
            for (int i = 0; i < buffer.length; i++) {
                System.out.print(((char) buffer[i]));
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    static void readBytes(){
        byte[] buffer = "Hello".getBytes();
        for (int i = 0; i < buffer.length; i++) {
            System.out.println(buffer[i]);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
        int i;
        while ((i=byteArrayInputStream.read())!=-1){
            System.out.println(i);
        }
    }

    static void writeBytes(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try(FileOutputStream fileOutputStream= new FileOutputStream("Hello")){
            byteArrayOutputStream.write("Hello".getBytes());
            byteArrayOutputStream.writeTo(fileOutputStream);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    static void bufferedInputStream(){
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("byte text 1"))){
            int b;
            while ((b = bufferedInputStream.read()) != -1){
                System.out.println(((char) b));
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    static void bufferedOutputStream(){
        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("byte text 1", true))){
            byte[] bytes = "bytes".getBytes();
            bos.write(bytes);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    static void printStream(){
        try(PrintStream printStream = new PrintStream("print stream")){
            printStream.println("This sentence has been written due to PrintStream class");
        }
        catch (IOException ex){
            ex.getCause();
        }
    }

    static void printWriter(){
        try(PrintWriter printWriter = new PrintWriter("print writer")){
            int c = 0x0000;
            while (c != 0x4D20){
                printWriter.append(((char) c));
                c++;
            }
        }
        catch (IOException ex){

        }
    }

    static void dataStreams(){
        try(DataOutputStream dos = new DataOutputStream(new PrintStream("data.bin"));
        DataInputStream dis = new DataInputStream(new FileInputStream("data.bin")))
        {
            dos.writeByte(120);
//            int x = 0;
//            byte[] bytes = dis.readAllBytes();
//            for (int i = 0; i < bytes.length; i++) {
//                x |= bytes[i];
//            }
            System.out.println(dis.readByte());
            dos.writeUTF("line");
            dos.writeUTF("line 2");
//            System.out.println(dis.readLine());
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());

        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    static void fileWriter(){
        try(FileWriter fileWriter = new FileWriter("writer reader.txt"))
        {
            fileWriter.write("so long");
            fileWriter.flush();

        }
        catch (IOException ex){

        }

    }

    static void fileReader(){
        try(FileReader fileReader = new FileReader("writer reader.txt")){
            int c;
            while((c = fileReader.read()) != -1){
                System.out.println((char)c);
            }

        }
        catch (IOException ex){

        }
    }

    static void bufferedFileSreams(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line;
            while (!(line = br.readLine()).equals("exit")){
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        }
        catch(IOException ex){ }
    }

    static void objectStreams(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Autos.dat"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Autos.dat"))){
            ArrayList<Auto> autos = new ArrayList<>();
            autos.add(new Auto("Ford", 1988, 2.5, false));
            autos.add(new Auto("Dodge", 2001, 1.9, false));
            autos.add(new Auto("Nissan", 2008, 1.2, true));
            for(Auto auto : autos){
                System.out.println(auto);
            }
            oos.writeObject(autos);
            ArrayList<Auto> autosReaded = ((ArrayList<Auto>) ois.readObject());
            for(Auto auto : autosReaded){
                System.out.println(auto);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    static void files(){
        File file = new File("file2.txt");
        try(FileWriter fw = new FileWriter(file)){
            fw.write("something");
            fw.flush();
        }
        catch (IOException ex){

        }
        System.out.println("can be executed: " + file.canExecute());
        System.out.println("can be red" + file.canRead());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.length());
    }

    static void zipOutputStream(){
        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("for zip.zip"))){
            FileInputStream fis = new FileInputStream("for zip.txt");
            zos.putNextEntry(new ZipEntry("for zip.txt"));
            int b;
            while ((b = fis.read()) != -1){
                zos.write(b);
            }
            zos.closeEntry();

        }
        catch (IOException ex){

        }
    }

    static void zipInputStream(){
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream("for zip.zip"))){
            System.out.println(zis.getNextEntry().toString());
        }
        catch (IOException ex){

        }
    }

    static void console(){
        Console console = System.console();
        String nick = console.readLine();
        char[] pass = console.readPassword();
        console.writer().println("Your nickname: " + nick);
        console.writer().println("Your password: " + pass);
    }
}
