package com.bridgelabz.orderedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class OrderedList<T> {
    String[] strArray;
    Integer[] intArray;
    Integer inputNumber;

    LinkedList<T> linkedList = new LinkedList<>();
    LinkedList<T> linkedListUpdated = new LinkedList<>();

    /**
     * read file method reads the data in the file
     * stores in array when split with spaces as a string
     * stringToInteger method is used to change the strings into integers
     *
     * @throws FileNotFoundException
     */
    public void readFile() throws FileNotFoundException {
        File file = new File("/home/hp/Desktop/PROJECTS/listOfNumbers");
        Scanner sc = new Scanner(file);
        strArray = sc.nextLine().split(" ");
        stringToInteger(strArray);

        for (Integer item : intArray) {
            linkedList.add((T) item);
        }
        System.out.println("Linked list is : " + linkedList);
    }

    /**
     * This method takes input from user
     */
    public void readInputFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to compare with file: ");
        inputNumber = sc.nextInt();
    }

    /**
     * compare method is used in two ways
     * if number is already in the list the number will be removed
     * else number will be added to the list and stored in the file
     */
    public void compareText() {
        if (linkedList.contains(inputNumber)) {
            linkedList.remove(inputNumber);
        } else if (!linkedList.contains(inputNumber)) {
            linkedList.add((T) inputNumber);
        }
    }

    /**
     * This method sorts the array in ascending order
     */
    public void reSortList() {
        Integer[] array = new Integer[linkedList.size()];
        int i = 0;
        for (T item : linkedList) {
            array[i] = (Integer) item;
            i++;
        }
        Arrays.sort(array);
        for (Integer item : array) {
            linkedListUpdated.add((T) item);
        }
        System.out.println("New Linked list Updated");
    }

    /**
     * This method converts string to integer array and sorts the integer array
     *
     * @param array
     */
    public void stringToInteger(String[] array) {
        intArray = new Integer[array.length];
        int i = 0;
        for (String s : array) {
            intArray[i] = Integer.parseInt(s);
            i++;
        }
        Arrays.sort(intArray);
    }

    /**
     * This is method saves the updated list in the file
     */
    public void saveToFile() {
        StringBuilder contents = new StringBuilder("");
        for (T item : linkedListUpdated) {
            contents.append(item).append(" ");
        }
        try {
            Files.writeString(Path.of("/home/hp/Desktop/PROJECTS/listOfNumbers"), contents.toString(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            // Handle exception
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        OrderedList<Integer> orderedList = new OrderedList<>();
        orderedList.readFile();
        orderedList.readInputFromUser();
        orderedList.compareText();
        orderedList.reSortList();
        orderedList.saveToFile();
    }
}
