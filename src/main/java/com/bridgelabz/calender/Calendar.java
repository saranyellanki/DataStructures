package com.bridgelabz.calender;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Calendar {
    String[][] calendar = new String[6][7];
    private String month;

    public void calendarSetup(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Month : ");
        month = sc.nextLine().toLowerCase(Locale.ROOT);
        System.out.println("Enter year : ");
        int year = sc.nextInt();
        System.out.println("% Java Calendar %");
        System.out.println(month+" "+year);
        System.out.println("===========================");
        String weekName = "S\t"+"M\t"+"T\t"+"W\t"+"Th\t"+"F\t"+"S\t";
        System.out.println(weekName);
        System.out.println("===========================");
    }

    public void days(){
        Random r = new Random();
        int dayCount = 1;
        int numberOfDays = 0;
        if (month.equals("january") || month.equals("march") || month.equals("may") ||
                month.equals("july") || month.equals("august") || month.equals("october") || month.equals("december")) {
            numberOfDays = 32;
        } else if (month.equals("february")) {
            numberOfDays = 29;
        } else numberOfDays = 31;
        int random = r.nextInt(7);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (dayCount < numberOfDays) {
                    String date = Integer.toString(dayCount);
                    if(random-->0) {
                        calendar[i][j] = " ";
                    }
                    else {
                        calendar[i][j] = date;
                        dayCount++;
                    }
                    System.out.print(calendar[i][j] + "\t");
                    if (j == 6) System.out.println();
                }
            }
        }
    }
    public static void main(String[] args) {
        Calendar cal = new Calendar();
        cal.calendarSetup();
        cal.days();
    }
}
