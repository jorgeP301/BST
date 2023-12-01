package cs2720.bst;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BinarySearchTreeDriver {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a list type (i - int, d - double, s - string)");
        String list = sc.nextLine();
        switch (list) {
        case "i" : { //each case will be its own thing based on list choice

            BinarySearchTree<Integer> original = new BinarySearchTree<Integer>();
            try {
                sc = new Scanner(new File(args[0]));
                while (sc.hasNextInt()) {
                    int num = sc.nextInt();
                    original.insert(num);
                }
            }
            catch(FileNotFoundException fnf) {
                System.out.println("file not found");
                System.exit(0);
            }
            sc = new Scanner(System.in);
            System.out.println("Commands:");
            System.out.println("(i) - Insert Value");
            System.out.println("(d) - Delete Value");
            System.out.println("(p) - Print Tree");
            System.out.println("(r) - Retrieve item");
            System.out.println("(l) - Count leaf nodes");
            System.out.println("(s) - Find single parents");
            System.out.println("(c) - Find cousins");
            System.out.println("(q) - Quit Program");

            String comm = "";
            boolean running = true;
            while (running) {
                System.out.println("Enter a command");
                comm = sc.nextLine();
                int tempNum;
                switch (comm) {
                case "i":
                    System.out.print("in order: ");
                    original.inOrder();
                    sc.nextLine();
                    System.out.print("Enter a number to insert: ");
                    tempNum = sc.nextInt();
                    sc.nextLine();
                    original.insert(tempNum);
                    System.out.print("in order: ");
                    original.inOrder();
                    sc.nextLine();
                    break;

                case "d":
                    System.out.print("in order: ");
                    original.inOrder();
                    sc.nextLine();
                    System.out.print("Enter a number to delete: ");
                    tempNum = sc.nextInt();
                    sc.nextLine();
                    original.delete(tempNum);
                    System.out.print("in order: ");
                    original.inOrder();
                    sc.nextLine();
                    break;
                case "p":
                    System.out.print("in Order: : ");
                    original.inOrder();
                    sc.nextLine();
                    break;
                case "r":
                    System.out.print("inOrder: ");
                    original.inOrder();
                    sc.nextLine();
                    System.out.print("Enter a number to search: " );
                    tempNum = sc.nextInt();
                    sc.nextLine();
                    if (original.retrieve(tempNum)) {
                        System.out.print("the item is present in the tree");
                        sc.nextLine();
                    }
                    else {
                        System.out.print("the item is not present in the tree");
                        sc.nextLine();
                    }
                    break;
                case "l" :
                    System.out.print("The number of leaf nodes are: ");
                    System.out.print(original.getNumLeafNodes(original.root));
                    sc.nextLine();
                    break;
                case "s" :
                    System.out.print("Single Parents: ");
                    original.getSingleParent(original.root);
                    sc.nextLine();
                    break;
                case "c" :
                    System.out.print("in Order: ");
                    original.inOrder();
                    sc.nextLine();
                    System.out.print("Enter a number: ");
                    tempNum = sc.nextInt();
                    sc.nextLine();
                    System.out.print(tempNum + " cousins: ");
                    original.getCousins(original.root,tempNum);
                    sc.nextLine();
                    break;
                case "q":
                    System.out.print("Exiting the program...");
                    System.exit(0);
                    break;
                case "ch" : //helper for testing helper methods
                    System.out.print("enter a node to find its children: ");
                    tempNum = sc.nextInt();
                    sc.nextLine();
                    original.getChildren(original.root);
                    sc.nextLine();
                    break;
                default :
                    System.out.print("invalid command");
                }
            }
            break;
        }

        case "d" : {
            BinarySearchTree<Double> original = new BinarySearchTree<Double>();
            try {
                sc = new Scanner(new File(args[0]));
                while (sc.hasNextDouble()) {
                    double num = sc.nextDouble();
                    original.insert(num);
                }
            }
            catch(FileNotFoundException fnf) {
                System.out.println("file not found");
                System.exit(0);
            }
            sc = new Scanner(System.in);
            System.out.println("Commands:");
            System.out.println("(i) - Insert Value");
            System.out.println("(d) - Delete Value");
            System.out.println("(p) - Print Tree");
            System.out.println("(r) - Retrieve item");
            System.out.println("(l) - Count leaf nodes");
            System.out.println("(s) - Find single parents");
            System.out.println("(c) - Find cousins");
            System.out.println("(q) - Quit Program");
            String comm = "";
            boolean running = true;
            while (running) {
                System.out.println("Enter a command");
                comm = sc.nextLine();
                double tempNum;
                switch (comm) {
                case "i":
                    System.out.print("in order: ");
                    original.inOrder();
                    sc.nextLine();
                    System.out.print("Enter a number to insert: ");
                    tempNum = sc.nextDouble();
                    sc.nextLine();
                    original.insert(tempNum);
                    System.out.print("in order: ");
                    original.inOrder();
                    sc.nextLine();
                    break;

                case "d":
                    System.out.print("in order: ");
                    original.inOrder();
                    sc.nextLine();
                    System.out.print("Enter a number to delete: ");
                    tempNum = sc.nextDouble();
                    sc.nextLine();
                    original.delete(tempNum);
                    System.out.print("in order: ");
                    original.inOrder();
                    sc.nextLine();
                    break;
                case "p":
                    System.out.print("in Order: : ");
                    original.inOrder();
                    sc.nextLine();
                    break;
                case "r":
                    System.out.print("inOrder: ");
                    original.inOrder();
                    sc.nextLine();
                    System.out.print("Enter a number to search: " );
                    tempNum = sc.nextDouble();
                    sc.nextLine();
                    if (original.retrieve(tempNum)) {
                        System.out.print("the item is present in the tree");
                        sc.nextLine();
                    }
                    else {
                        System.out.print("the item is not present in the tree");
                        sc.nextLine();
                    }
                    break;
                case "l" :
                    System.out.print("The number of leaf nodes are: ");
                    System.out.print(original.getNumLeafNodes(original.root));
                    sc.nextLine();
                    break;
                case "s" :
                    System.out.print("Single Parents: ");
                    original.getSingleParent(original.root);
                    sc.nextLine();
                    break;
                case "c" :
                    System.out.print("in Order: ");
                    original.inOrder();
                    sc.nextLine();
                    System.out.print("Enter a number: ");
                    tempNum = sc.nextDouble();
                    sc.nextLine();
                    System.out.print(tempNum + " cousins: ");
                    original.getCousins(original.root,tempNum);
                    sc.nextLine();
                    break;
                case "q":
                    System.out.print("Exiting the program...");
                    System.exit(0);
                    break;
                default :
                    System.out.print("invalid command");
                }
            }
            break;
        }
        case "s" : {
            BinarySearchTree<String> original = new BinarySearchTree<String>();
            try {
                sc = new Scanner(new File(args[0]));
                while (sc.hasNext()) {
                    String s = sc.next();
                    original.insert(s);
                }
            }
            catch(FileNotFoundException fnf) {
                System.out.println("file not found");
                System.exit(0);
            }
            sc = new Scanner(System.in);
            System.out.println("Commands:");
            System.out.println("(i) - Insert Value");
            System.out.println("(d) - Delete Value");
            System.out.println("(p) - Print Tree");
            System.out.println("(r) - Retrieve item");
            System.out.println("(l) - Count leaf nodes");
            System.out.println("(s) - Find single parents");
            System.out.println("(c) - Find cousins");
            System.out.println("(q) - Quit Program");
            String comm = "";
            boolean running = true;
            while (running) {
                System.out.println("Enter a command");
                comm = sc.nextLine();
                String tempStr;
                switch (comm) {
                case "i":
                    System.out.print("in order: ");
                    original.inOrder();
                    sc.nextLine();
                    System.out.print("Enter a string to insert: ");
                    tempStr = sc.next();
                    sc.nextLine();
                    original.insert(tempStr);
                    System.out.print("in order: ");
                    original.inOrder();
                    sc.nextLine();
                    break;
                case "d":
                    System.out.print("in order: ");
                    original.inOrder();
                    sc.nextLine();
                    System.out.print("Enter a string to delete: ");
                    tempStr = sc.nextLine();
                    sc.nextLine();
                    original.delete(tempStr);
                    System.out.print("in order: ");
                    original.inOrder();
                    sc.nextLine();
                    break;
                case "p":
                    System.out.print("in Order: : ");
                    original.inOrder();
                    sc.nextLine();
                    break;
                case "r":
                    System.out.print("inOrder: ");
                    original.inOrder();
                    sc.nextLine();
                    System.out.print("Enter a String to search: " );
                    tempStr = sc.nextLine();
                    sc.nextLine();
                    if (original.retrieve(tempStr)) {
                        System.out.print("the item is present in the tree");
                        sc.nextLine();
                    }
                    else {
                        System.out.print("the item is not present in the tree");
                        sc.nextLine();
                    }
                    break;
                case "l" :
                    System.out.print("The number of leaf nodes are: ");
                    System.out.print(original.getNumLeafNodes(original.root));
                    sc.nextLine();
                    break;
                case "s" :
                    System.out.print("Single Parents: ");
                    original.getSingleParent(original.root);
                    sc.nextLine();
                    break;
                case "c" :
                    System.out.print("in Order: ");
                    original.inOrder();
                    sc.nextLine();
                    System.out.print("Enter a String: ");
                    tempStr = sc.nextLine();
                    sc.nextLine();
                    System.out.print(tempStr + " cousins: ");
                    original.getCousins(original.root,tempStr);
                    sc.nextLine();
                    break;
                case "q":
                    System.out.print("Exiting the program...");
                    System.exit(0);
                    break;
                case "com":
                    original.compTest("Igloo", "Movie");
                    break;
                default :
                    System.out.print("invalid command");
                }
            }
            break;
        }
        default: {
            System.out.println("not a correct list type");
        }
        }//switch

    }
}//BSTDriver
