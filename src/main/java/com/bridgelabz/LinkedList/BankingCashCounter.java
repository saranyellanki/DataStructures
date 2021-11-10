package com.bridgelabz.LinkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BankingCashCounter {
    Queue<String> queue = new LinkedList<>();
    private int amount = 80000;

    public void updateCash(){
        addPeople();
        while (!queue.isEmpty()){
            System.out.println("Hello "+queue.peek()+" please select a number");
            System.out.println("Enter\n1.To Withdraw\n2.To Deposit");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            if(option==1){
                boolean isSufficientBalance = false;
                while (!isSufficientBalance) {
                    System.out.println("Enter amount to withdraw");
                    int withdraw = sc.nextInt();
                    if (amount - withdraw >= 0) {
                        amount -= withdraw;
                        isSufficientBalance = true;
                    } else {
                        System.out.println("Insufficient balance, please enter amount less than or equal to "+amount);
                    }
                }
                queue.remove();
            }else if(option==2){
                System.out.println("Enter amount to deposit");
                int deposit = sc.nextInt();
                amount += deposit;
                queue.remove();
            }
        }
        System.out.println("Balance left : " +amount);
    }
    public void addPeople(){
        queue.add("Saran");
        queue.add("Dinesh");
        queue.add("Santhan");
        queue.add("Surya");
    }
    public static void main(String[] args) {
        BankingCashCounter bk = new BankingCashCounter();
        bk.updateCash();
    }
}
