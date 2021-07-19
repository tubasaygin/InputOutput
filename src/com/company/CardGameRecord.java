package com.company;

import java.io.*;

public class CardGameRecord {

    public static void saveGame(Card[][] cards){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("gameRecord.bin"))){

            System.out.println("Game is recording...");
            outputStream.writeObject(cards);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error opening file.");
        }
    }

    public static Card[][] takeRecord(){
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("gameRecord.bin"))){

            Card[][] cards = (Card[][]) inputStream.readObject();
            return cards;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error opening file.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
