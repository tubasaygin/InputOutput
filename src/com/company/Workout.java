package com.company;

public class Workout {
    private int burpee_number;
    private int pushup_number;
    private int situp_number;
    private int squat_number;

    public Workout(int burpee_number, int pushup_number, int situp_number, int squat_number) {
        this.burpee_number = burpee_number;
        this.pushup_number = pushup_number;
        this.situp_number = situp_number;
        this.squat_number = squat_number;
    }

    public int getBurpee_number() {
        return burpee_number;
    }

    public void setBurpee_number(int burpee_number) {
        this.burpee_number = burpee_number;
    }

    public int getPushup_number() {
        return pushup_number;
    }

    public void setPushup_number(int pushup_number) {
        this.pushup_number = pushup_number;
    }

    public int getSitup_number() {
        return situp_number;
    }

    public void setSitup_number(int situp_number) {
        this.situp_number = situp_number;
    }

    public int getSquat_number() {
        return squat_number;
    }

    public void setSquat_number(int squat_number) {
        this.squat_number = squat_number;
    }

    public void makeMove(String movementType,int sayi){
        if (movementType.equals("Burpee")){

            doBurpee(sayi);

        }
        else if (movementType.equals("Pushup")){
            doPushup(sayi);


        }
        else if (movementType.equals("Situp")){
            doSitup(sayi);


        }
        else if (movementType.equals("Squat")){
            doSquat(sayi);


        }
        else {
            System.out.println("Invalid Move...");
        }

    }
    public void doBurpee(int sayi) {

        if (burpee_number == 0) {
            System.out.println("No more burpees to do.");
        }
        if (burpee_number - sayi < 0) {
            System.out.println("You beat your target number of burpee. Congratulations!");
            burpee_number = 0;
            System.out.println("Remaining burpee : " + burpee_number);

        }
        else {

            burpee_number -= sayi;

            System.out.println("Remaining burpee : " + burpee_number);

        }


    }
    public void doPushup(int sayi) {

        if (pushup_number == 0) {
            System.out.println("No more pushup to do.");
        }
        if (pushup_number - sayi < 0) {
            System.out.println("You beat your target number of pushup. Congratulations!");
            pushup_number = 0;
            System.out.println("Remaining pushup :" + pushup_number);

        }
        else {

            pushup_number -= sayi;

            System.out.println("Remaining pushup : " + pushup_number);

        }


    }
    public void doSitup(int sayi) {

        if (situp_number == 0) {
            System.out.println("No more situp to do.");
        }
        if (situp_number - sayi < 0) {
            System.out.println("You beat your target number of situp. Congratulations!");
            situp_number = 0;
            System.out.println("Remaining situp : " + situp_number);

        }
        else {

            situp_number -= sayi;

            System.out.println("Remaining situp :  " + situp_number);

        }


    }
    public void doSquat(int sayi) {

        if (squat_number == 0) {
            System.out.println("No more squat to do.");
        }
        if (squat_number - sayi < 0) {
            System.out.println("You beat your target number of squats. Congratulations!");
            squat_number = 0;
            System.out.println("Remaining squat : " + squat_number);

        }
        else {

            squat_number -= sayi;

            System.out.println("Remaining squat : : " + squat_number);

        }


    }
    public boolean isFinish() {

        return (burpee_number == 0 ) && (situp_number == 0 ) && (squat_number == 0 ) && (pushup_number == 0 );

    }
}
