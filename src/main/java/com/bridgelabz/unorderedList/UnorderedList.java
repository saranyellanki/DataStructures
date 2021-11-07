package com.bridgelabz.unorderedList;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Scanner;

public class UnorderedList<T> {

    T inputText;
    LinkedList<T> linkedList = new LinkedList<T>();

    public void readFromFile() throws IOException {
        FileReader fr = new FileReader("/home/hp/Desktop/PROJECTS/test");
        int i;
        StringBuilder s = new StringBuilder();
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1) {
            s.append((char) i);
        }
        System.out.println(s);
        T[] splitWords = (T[]) s.toString().split(" ");
        for (T item : splitWords) {
            linkedList.add((T) item);
        }
        System.out.println(linkedList);
    }

    public void readInputFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text to compare with file: ");
        inputText = (T) sc.nextLine();
    }

    public void compareText() {
        if (linkedList.contains(inputText)) {
            linkedList.remove(inputText);
        } else if (!linkedList.contains(inputText)) {
            linkedList.add((T) inputText);
        }
    }

    public void saveToFile() {
        StringBuilder contents = new StringBuilder("");
        for (T item : linkedList) {
            contents.append(item).append(" ");
        }
        try {
            Files.writeString(Path.of("/home/hp/Desktop/PROJECTS/test"), contents.toString(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            // Handle exception
        }
    }

    public static void main(String[] args) throws IOException {
        UnorderedList<String> obj = new UnorderedList<>();
        obj.readFromFile();
        obj.readInputFromUser();
        obj.compareText();
        obj.saveToFile();
    }
}
