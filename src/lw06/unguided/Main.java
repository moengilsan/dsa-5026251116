package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(
                Main.class.getResourceAsStream("treenumbers.txt"));

        BinarySearchTree tree = new BinarySearchTree();
        Scanner numbers = new Scanner(read.nextLine());

        while (numbers.hasNextInt()) {
            tree.insert(numbers.nextInt());
        }
        numbers.close();

        int target = read.nextInt();

        System.out.print("Preorder : ");
        tree.preOrder();

        System.out.print("Inorder : ");
        tree.inOrder();

        System.out.print("Postorder : ");
        tree.postOrder();

        System.out.println("Search " + target + " : " + tree.search(target));
        System.out.println("Minimum : " + tree.findMin());
        System.out.println("Maximum : " + tree.findMax());

        read.close();
    }
}
