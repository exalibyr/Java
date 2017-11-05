package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileInfo {
    private File file;
    public int getAmountOfLines(String fileName) throws FileNotFoundException{
        file = new File(fileName);
        Scanner read = new Scanner(file);
        try{
            if(read.ioException() != null ){
                throw new IOException();
            }
            int k = 0;
            try{
                while((read.nextLine().length()) != 0){
                    k++;
                }
                throw new NoSuchElementException();
            }
            catch (NoSuchElementException ex){
                return k;
            }
        }
        catch(IOException ex){
            System.out.println("Error of scanning!");
            throw new RuntimeException(ex);
        }
        finally {
            read.close();
        }
    }
    public void showTextWithLenOfLines(String fileName) throws FileNotFoundException{
        file = new File(fileName);
        Scanner read = new Scanner(file);
        try {
            if(read.ioException() != null ){
                throw new IOException();
            }
            String line;
            while (read.hasNextLine()) {
                line = read.nextLine();
                System.out.println(line + "\t" + line.length() + " symbols");
            }
        }
        catch(IOException ex){
            System.out.println("Error of scanning!");
        }
        finally {
            read.close();
        }
    }
    public long getLenOfFile(String fileName) throws FileNotFoundException{
        file = new File(fileName);
        Scanner read = new Scanner(file);
        try {
            if(read.ioException() != null ){
                throw new IOException();
            }
            int len = 0;
            while (read.hasNextLine()) {
                len += read.nextLine().length();
            }
            return len;
        }
        catch(IOException ex){
            System.out.println("Error of scanning!");
            throw new RuntimeException(ex);
        }
        finally {
            read.close();
        }
    }
}
