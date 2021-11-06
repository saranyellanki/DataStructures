package com.bridgelabz.LinkedList;

public class LinkedList<T> {
    public Node<T> head;
    public Node<T> tail;

    public void add(T data) {
        Node<T> addNode = new Node<T>(data);
        if (head == null) {
            head = addNode;
        } else {
            Node<T> temp = head;
            head = addNode;
            addNode.next = temp;
        }
    }

    public void append(T data) {
        Node<T> appendNode = new Node<T>(data);
        if (head == null) {
            head = appendNode;
            tail = appendNode;
        } else {
            tail.next = appendNode;
            tail = tail.next;
        }
    }

    public void insert(T data) {
        Node<T> node = new Node<T>(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public void insertBetween(T x, T y, T z) {
        Node<T> newNode = new Node<T>(z);
        Node<T> temp = head;
        while (temp.next != null) {
            if ((temp.data == x && temp.next.data == y) || (temp.data == y && temp.next.data == x)) {
                Node<T> afterZ = temp.next;
                temp.next = newNode;
                temp.next.next = afterZ;
                break;
            }
            temp = temp.next;
        }
    }

    public void pop() {
        Node<T> temp = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            head = temp.next;
        }
    }

    public void popLast() {
        Node<T> temp = head;
        if (head == null) {
            System.out.println("Linked list is empty");
        } else {
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    public boolean search(T data){
        Node<T> temp = head;
        boolean isPresent = false;
        if(head==null){
            System.out.println("Linked List is empty");
            return false;
        }else {
            while (temp!=null){
                if(temp.data==data){
                    isPresent = true;
                    break;
                }else {
                    temp = temp.next;
                }
            }
        }
        return isPresent;
    }

    public void insertAfter(T insertAfter, T insertData) {
        Node<T> temp = head;
        Node<T> insertNode = new Node<T>(insertData);
        if (head == null) {
            System.out.println("Linked List is empty");
        } else {
            while (temp != null) {
                if (temp.data == insertAfter) {
                    Node<T> node = temp.next;
                    temp.next = insertNode;
                    insertNode.next = node;
                    temp = node;
                } else {
                    temp = temp.next;
                }
            }
        }
    }

    public void deleteNode(T key) {
        if (head == null) {
            System.out.println("Linked List is empty");
        } else {
            Node<T> temp = head;
            if (head.data == key) {
                head = head.next;
            }
            while (temp != null && temp.next != null) {
                if (temp.next.data == key) {
                    temp.next = temp.next.next;
                }
                temp = temp.next;
            }
        }
    }

    public void show() {
        Node<T> temp = head;
        if (head == null) {
            System.out.println("Linked list is empty");
        } else {
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
