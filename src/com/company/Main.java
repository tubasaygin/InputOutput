package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Copy mp3 --- file read:
    public static ArrayList<Integer> bytes = new ArrayList<>();

    public static void readFile(){
        try {
            FileInputStream readFile = new FileInputStream("imagine-dragons-believer.mp3");

            int value;
            while((value = readFile.read()) != -1){
                bytes.add(value);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found error.. ");
        } catch (IOException e) {
            System.out.println("file could not be read..");
        }

    }

    //Copy mp3 --- file write:
    public static void copyFile(String fileName){
        try {
            FileOutputStream writeFile = new FileOutputStream(fileName);
            for(int value : bytes){
                writeFile.write(value);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found error");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }

    }

    public static void main(String[] args) {
        //Writing data to the file with using FileOutputStream:
        System.out.println("-------------------------------------");

        FileOutputStream fos = null;
        File file = new File("file.txt");
        try {
            fos = new FileOutputStream(file , true);

            byte[] array = {102,34,56,45};
            fos.write(array);
            fos.write(65);

            String s = "Hello World";
            byte[] array2 = s.getBytes();
            fos.write(array2);

        } catch (FileNotFoundException e) {
            System.out.println("File not found error");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("Error closing file ");
            }
        }


        System.out.println("-------------------------------------");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("file.txt");

            //Reading the file character by character
            /*
            System.out.println("Value : " +(char)fis.read());
            System.out.println("Value : " +(char)fis.read());
            System.out.println("Value : " +(char)fis.read());
             */
            //If we want to read a specific value directly

            fis.skip(5);
            System.out.println("Value : " +(char)fis.read());

            int deger;
            String s = "";

            while((deger = fis.read()) != -1){
                s += (char)deger;
            }

            System.out.println("Value : "+ s);


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("file could not be read..");
        } finally {
            try {
                if(fis != null){
                    fis.close();
                }

            } catch (IOException e) {
                System.out.println("Error closing file ");
            }
        }


        System.out.println("-------------------------------------");
        //Mp3 copy:
        readFile();
        copyFile("imagine-dragons-copy.mp3");


        System.out.println("-------------------------------------");
        //Writing data using FileWriter:
        FileWriter writer = null;
        try {
            writer = new FileWriter("file2.txt", true); //True : If we want the file content to be overwritten without deleting it
            writer.write("Hello World\n");
        } catch (IOException e) {
            System.out.println("Error opening file");
        }finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Error closing file");
                }
            }
        }


        System.out.println("-------------------------------------");
        //Try with resource:
        String language;
        try(FileWriter writer2 = new FileWriter("file2.txt")){
            //writer2.write("Hello Programmer");

            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("Enter the programming language you want to print to the file. ");
                language = scanner.nextLine();

                if(language.equals("-1")){
                    System.out.println("Exiting the program");
                    break;
                }
                writer2.write(language+ "\n");

            }


        } catch (IOException e) {
            System.out.println("Error creating file");
        }


    }
}
