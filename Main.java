
import java.sql.SQLOutput;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        LinkedList linkedList ;// after creating the nodes and linkedlist within the main menu we will get the refernce of the head and then initalize thhis linked list


        System.out.println("==============================================");
        System.out.println("=============== Operation Menu ===============");
        System.out.println("==============================================");


        while (true) {


            System.out.println("==============================================");
            System.out.println(" 1- deleting nodes");
            System.out.println(" 2- swapping nodes");
            System.out.println(" 3- sorting intersected node in a single linked list");
            System.out.println(" 4- sorting node in a double linked list");
            System.out.println(" 5- End the operations... ");
            System.out.println("==============================================");
            System.out.print("choose your options: ");
            int choice = input.nextInt();

            // to guarantee that we will implement operations on a copy
            // or else if we opreated onthe original then we won't be able to operate anything else in a loop since we migth end up getting no node
            // after the operations


            switch (choice) {

                case 1:
                    linkedList=new LinkedList();
                    MainMenu(linkedList);
                    LinkedList copy = copyOfOriginal(linkedList);
                    printLinkedList(linkedList, "Input");// this will print the original linked list
                    System.out.print("how many values do u want to skip in the linked list ");
                    int m = input.nextInt();
                    System.out.print("how many values do u want to remove from the linked list ");
                    int n = input.nextInt();
                    copy.deleteNodes(n, m);
                    printLinkedList(copy, "Output");
                    System.out.println();
                    break;


                case 2:
                    linkedList=new LinkedList();
                    MainMenu(linkedList);
                    copy = copyOfOriginal(linkedList);
                    printLinkedList(linkedList, "Input");// this will print the original linked list
                    System.out.print("Enter the kth value that you want to swap in the node ");
                    int k = input.nextInt();
                    copy.swapNodes(k);// we will implement the swapping on a duplicate of the original array
                    printLinkedList(copy, "Output");
                    System.out.println();
                    break;


                case 3:// we will create a another copy of a linked list
                    linkedList=new LinkedList();
                    MainMenu(linkedList);
                    copy = copyOfOriginal(linkedList);
                    LinkedList linkedList2 = new LinkedList();
                    System.out.println("===\n Now please enter the value for the second lInkedList\n===");
                    MainMenu(linkedList2);
                    LinkedList copy2 = copyOfOriginal(linkedList2);
                    linkedList.bubbleSort();
                    linkedList2.bubbleSort();
                    copy.bubbleSort();
                    copy2.bubbleSort();
                    printLinkedList(linkedList, "Input");// this will print the original linked list
                    printLinkedList(linkedList2, "input 2");
                    LinkedList result=new LinkedList();// this will be the object with the new intersect
                    result.sortedIntersect(copy, copy2);// this will change the head of the new linkedlist to the resul of the sorted intersect
                    printLinkedList(result, "Output");
                    break;


                case 4:
                    LinkedList linkedList1 = new LinkedList();
                    MainMenu2(linkedList1);
                    copy = copyOfOriginalDoubleNode(linkedList1);
                    printLinkedListDoubleNode(linkedList1,"Input");
                    copy.sortDoubleLinkedList();
                    printLinkedListDoubleNode(copy, "Output");
                    break;

                case 5:
                    System.exit(0);



                default:
                    System.out.println("==============================================\nthe choice that you have chosen isn't found.... please a vaild choice :) ");

            }


        }


    }


    public static LinkedList copyOfOriginal(LinkedList original) {

        LinkedList copy = new LinkedList();

        Node pointer = original.getHead();
        while (pointer != null) {

            copy.createNodes(new Node(pointer.getNumber()));

            pointer = pointer.getNextNode();
        }

        return copy;
    }


    public static LinkedList copyOfOriginalDoubleNode(LinkedList original){

        LinkedList copy =new LinkedList();
        DoubleNode pointer = original.getDoubleNodeHead();


        while(pointer!=null){
            copy.createDoubleNodes(new DoubleNode(pointer.getvalue()));
            pointer=pointer.getNextDoubleNode();
        }
        return copy;

    }


    public static void printLinkedList(LinkedList linkedList,String outcome){
        System.out.println("==============================================");
        Node pointer;

        pointer = linkedList.getHead();


        System.out.print(outcome + ": ");
        while (pointer != null) {

            System.out.print(pointer.getNumber() + " -->");
            pointer = pointer.getNextNode();
        }
        System.out.print("null\n");


    }

    public static void printLinkedListDoubleNode(LinkedList linkedList, String outcome) {


        System.out.println("==============================================");
        DoubleNode pointer;

        pointer = linkedList.getDoubleNodeHead();

        System.out.print(outcome + ": ");

        while (pointer != null) {

            System.out.print(pointer.getvalue() + " -->");
            pointer = pointer.getNextDoubleNode();
        }
        System.out.print("null\n");


    }


    public static void MainMenu(LinkedList linkedList) {

        int value;
        do {
            System.out.println("========= welcome to the linked list operation program ========");
            System.out.println("===============================================================");
            System.out.print("Enter values to create a linked list (nodes)( enter -ve value to stop creating nodes) ");
            value = input.nextInt();

            if (value >= 0)
                linkedList.createNodes(new Node(value));// i have created an object of node and gave the reference to method insert

        } while (value >= 0);


    }


    public static void MainMenu2(LinkedList list) {// this main menu will be responsible with the creating of a double linkedList with values
        int value;

        do {
            System.out.println("========= welcome to the linked list operation program ========");
            System.out.println("===============================================================");
            System.out.print("Enter values to create a Double linked list (nodes)( enter -ve value to stop creating nodes) ");
            value = input.nextInt();

            if (value >= 0) {
                list.createDoubleNodes(new DoubleNode(value));//we will create a doubleNode linkedlist
            }

        } while (value >= 0);

    }
}

