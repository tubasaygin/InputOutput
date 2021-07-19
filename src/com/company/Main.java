package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //Copy mp3 --- file read:
    public static ArrayList<Integer> bytes = new ArrayList<>();
    public static Card[][] cards = new Card[4][4];

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
    public static String calculateNotes(String name, int exam1, int exam2, int exam3){
        double average = (exam1 * 0.3) + (exam2 * 0.3) + (exam3 * 0.4);
        if(average>=87 && average<=100){
            return name + " 's grade : "+ average + " and letter grade equivalent : AA";
        }
        else if(average>=81 && average<87){
            return name + " 's grade : "+ average + " and letter grade equivalent : BA";
        }
        else if(average>=74 && average<=80){
            return name + " 's grade : "+ average + " and letter grade equivalent : BB";
        }
        else if(average>=67 && average<=75){
            return name + " 's grade : "+ average + " and letter grade equivalent : CB";
        }
        else if(average>=60 && average<=66){
            return name + " 's grade : "+ average + " and letter grade equivalent : CC";
        }
        else if(average>=53 && average<=59){
            return name + " 's grade : "+ average + " and letter grade equivalent : DC";
        }
        else if(average>=46 && average<=52){
            return name + " 's grade : "+ average + " and letter grade equivalent : DD";
        }
        else if(average>=39 && average<=45){
            return name + " 's grade : "+ average + " and letter grade equivalent : FD";
        }
        else {
            return name + " 's grade : "+ average + " and letter grade equivalent : FF";
        }

    }

    public static void guess(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("First Prediction : (Enter the i and j values with a space) : " );
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();

        cards[i1][j1].setPrediction(true);
        gameBoard();

        System.out.println("Second Prediciton : (Enter the i and j values with a space : ");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();

        if (cards[i1][j1].getValue() == cards[i2][j2].getValue()) {
            System.out.println("Correct guess, congrats.");
            cards[i2][j2].setPrediction(true);

        }
        else {
            System.out.println("Wrong guess...");
            cards[i1][j1].setPrediction(false);

        }


    }
    public static boolean isFinishedGame() {

        for (int i =  0 ; i < 4; i++){
            for (int j = 0 ; j < 4 ; j++) {
                if (cards[i][j].isPrediction() == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void gameBoard(){

        for (int i = 0 ;  i < 4 ; i++) {
            System.out.println("____________________");
            for (int j = 0 ; j < 4 ; j++) {

                if (cards[i][j].isPrediction()) {
                    System.out.print(" |" + cards[i][j].getValue() + "| ");

                }
                else {
                    System.out.print(" | | ");

                }
            }
            System.out.println("");
        }
        System.out.println("____________________");

    }

    public static void takeRecords(){
        Scanner scanner = new Scanner(System.in);
        File file = new File("gameRecord.bin");
        if(file.exists()){
            System.out.println("You have a saved game. Would you like to continue with the recording? (yes or no)");
            String answer = scanner.nextLine();

            if(answer.equals("yes")){
                cards = CardGameRecord.takeRecord();
                return;
            }
        }
        cards[0][0] = new Card('E');
        cards[0][1] = new Card('A');
        cards[0][2] = new Card('D');
        cards[0][3] = new Card('F');
        cards[1][0] = new Card('G');
        cards[1][1] = new Card('J');
        cards[1][2] = new Card('K');
        cards[1][3] = new Card('B');
        cards[2][0] = new Card('B');
        cards[2][1] = new Card('F');
        cards[2][2] = new Card('J');
        cards[2][3] = new Card('A');
        cards[3][0] = new Card('D');
        cards[3][1] = new Card('K');
        cards[3][2] = new Card('G');
        cards[3][3] = new Card('E');


    }
    public static void main(String[] args) {
        //Writing data to the file with using FileOutputStream:

        System.out.println("-------------------------------------------------------------------");

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


        System.out.println("-------------------------------------------------------------------");
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


        System.out.println("-------------------------------------------------------------------");
        //Mp3 copy:
        readFile();
        copyFile("imagine-dragons-copy.mp3");



        System.out.println("-------------------------------------------------------------------");
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


        System.out.println("-------------------------------------------------------------------");
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
        System.out.println("-------------------------------------------------------------------");
        //Create a workout log file
        System.out.println("Welcome to Workout Program ... ");
        String workouts = "Valid Moves : \n" +
                    "Burpee \n"+
                    "Pushup \n"+
                    "Situp \n"+
                    "Squat \n";
        System.out.println(workouts);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create a workout : ");
        System.out.println("Burpee number : ");
        int burpee = scanner.nextInt();
        System.out.println("Pushup Number : ");
        int pushup = scanner.nextInt();
        System.out.println("Situp Number : ");
        int situp = scanner.nextInt();
        System.out.println("Squat Number : ");
        int squat = scanner.nextInt();

        scanner.nextLine();
        Workout workout = new Workout(burpee,pushup,situp,squat);
        System.out.println("Your workout is starting... ");

        int i = 1;
        try(FileWriter writer2 = new FileWriter("log.txt")){
            writer2.write("Workout Program... \n");
            writer2.write("Burpee Number : "+workout.getBurpee_number() + "\n");
            writer2.write("Pushup Number : "+workout.getPushup_number() + "\n");
            writer2.write("Situp Number : "+workout.getSitup_number()+ "\n");
            writer2.write("Squat Number : "+workout.getSquat_number() + "\n");

            while(!(workout.isFinish())){
                System.out.print("Movement Type(Burpee,Pushup,Situp,Squat) : ");
                String type = scanner.nextLine();
                System.out.print("How many of these moves will you do? ");
                int number = scanner.nextInt();
                scanner.nextLine();
                workout.makeMove(type, number);

                writer2.write(i + ".İşlem ---------->  Hareket : " + type + " Sayı : " + number + "\n");
                i++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("The workout has been successfully completed." );


        System.out.println("-------------------------------------------------------------------");
        //FileReader, BufferedReader, BufferedWriter :
        //We created FileReader with scanner to be able to read line by line.
        try(Scanner scanner2 = new Scanner(new FileReader("paragraph.txt"))){

            while(scanner2.hasNextLine()){  //Are there any lines left to read?
                System.out.println("Line : "+scanner2.nextLine());
            }



        } catch (FileNotFoundException e) {
            System.out.println("File not found.. ");
        } catch (IOException e) {
            System.out.println("Error opening file.. ");
        }
        //BufferedReader is more advantageous than FileReader.
        try(Scanner scanner2 = new Scanner(new BufferedReader(new FileReader("paragraph.txt")))){

            while(scanner2.hasNextLine()){  //Are there any lines left to read?
                System.out.println("Line : "+scanner2.nextLine());
            }



        } catch (FileNotFoundException e) {
            System.out.println("File not found.. ");
        } catch (IOException e) {
            System.out.println("Error opening file.. ");
        }

        //BufferedWriter is more advantageous than FileWriter.
        try(BufferedWriter writer3 = new BufferedWriter(new FileWriter("paragraph.txt",true))){
            writer3.write("\nBut throw high dear sister, or we shall never hit the ceiling.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------------------------------------------------");
        //Calculate grades by reading from a file
        try(Scanner scannerNotes = new Scanner(new FileReader("notes.txt"))){
            while(scannerNotes.hasNextLine()){

                String studentInfo = scannerNotes.nextLine();
                String[] arrayNotes = studentInfo.split(",");
                String result = calculateNotes(arrayNotes[0], Integer.valueOf(arrayNotes[1]), Integer.valueOf(arrayNotes[2]) ,Integer.valueOf(arrayNotes[3]));
                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        }


        System.out.println("-------------------------------------------------------------------");
        //How to serialize||Serialization :
        //Write to object:
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("student.bin"))){

            StudentSerializable studentSerializable = new StudentSerializable("Jack", 20, "Computer Engineeer");
            StudentSerializable studentSerializable2 = new StudentSerializable("Oliver", 602, "Mechanical Engineeer");

            outputStream.writeObject(studentSerializable);
            outputStream.writeObject(studentSerializable2);
        } catch (FileNotFoundException e) {
            System.out.println("File not found..");
        } catch (IOException e) {
            System.out.println("Error opening file");
        }

        //Read object:
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.bin"))){
            StudentSerializable student1 = (StudentSerializable) objectInputStream.readObject();
            StudentSerializable student2 = (StudentSerializable) objectInputStream.readObject();

            System.out.println(student1);
            System.out.println(student2);

        } catch (FileNotFoundException e) {
            System.out.println("File not found..");
        } catch (IOException e) {
            System.out.println("Error opening file");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        System.out.println("-------------------------------------------------------------------");
        //Serializing arrays and collections
        StudentSerializable students1 = new StudentSerializable("Jackson", 403, "Econometry");
        StudentSerializable students2 = new StudentSerializable("Mary", 234, "Finance");
        StudentSerializable students3 = new StudentSerializable("Harry", 122, "Electrical Engineer");

        StudentSerializable[] arrayStudents = {students1,students2,students3};
        ArrayList<StudentSerializable> arrayListStudents = new ArrayList<>(Arrays.asList(arrayStudents));


        try(ObjectOutputStream outputStream2 = new ObjectOutputStream(new FileOutputStream("students.bin"))){
            outputStream2.writeObject(arrayStudents);
            outputStream2.writeObject(arrayListStudents);


        } catch (FileNotFoundException e) {
            System.out.println("File not found..");
        } catch (IOException e) {
            System.out.println("Error opening file");
        }

        try(ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream("students.bin"))){
            StudentSerializable[] studentsSerializable = (StudentSerializable[]) objectInputStream2.readObject();
            ArrayList<StudentSerializable> studentsSerializableList = (ArrayList<StudentSerializable>) objectInputStream2.readObject();

            System.out.println("Students Array : ");
            for(StudentSerializable s:studentsSerializable){
                System.out.println(s);
            }
            System.out.println("Students Array List : ");
            for(StudentSerializable s : studentsSerializableList){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found..");
        } catch (IOException e) {
            System.out.println("Error opening file");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("-------------------------------------------------------------------");
        //Saving the memory game with Serialization:
        takeRecords();

        Scanner scanner4 = new Scanner(System.in);
        while (isFinishedGame() == false){
            gameBoard();
            System.out.print("Press q to exit (yes ya da no)");
            String cikis = scanner4.nextLine();

            if (cikis.equals("yes")) {
                System.out.print("Do you want to save the game ? (yes ya da no)");

                String record = scanner4.nextLine();

                if (record.equals("yes")){

                    CardGameRecord.saveGame(cards);

                }
                else {
                    System.out.println("Game not saved..");
                }
                System.out.println("Exiting the program..");
                break;

            }

            guess();
        }

    }
}
