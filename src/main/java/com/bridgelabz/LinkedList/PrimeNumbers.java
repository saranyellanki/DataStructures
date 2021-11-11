package com.bridgelabz.LinkedList;

import java.util.ArrayList;

public class PrimeNumbers {
    static int[][] prime2D = new int[11][25];

    public static Object[] primeNumber(int initial, int last) {
        ArrayList<Integer> primeNumber = new ArrayList<>();
        boolean isPrime = false;
        for (int i = initial; i < last; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                } else {
                    isPrime = true;
                }
            }
            if (isPrime || i == 2) {
                primeNumber.add(i);
            }
        }
        return primeNumber.toArray();
    }

    public static void prime2D(){
        for(int i=1;i<=10;i++){
            int last = i*100;
            int initial = last-100;
            Object[] prime = primeNumber(initial+1,last);
            System.out.print("Prime numbers in range "+initial+ " to "+last+" : ");
            for(int k=0;k<prime.length;k++){
                prime2D[i][k] = (int) prime[k];
                System.out.print(prime2D[i][k]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        prime2D();
    }
}
