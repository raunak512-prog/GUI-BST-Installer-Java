package Trees;

import java.util.Scanner;

public class AllBSTFunc {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    //For pre-Order Traveral.
    public static void preOrder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");

        preOrder(root.left);

        preOrder(root.right);
    }


    //Function for insert a node.
    public static TreeNode insertNode(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);


        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else {
            if (val > root.val) {
                root.right = insertNode(root.right, val);
            }
        }

        if (val == root.val) {
            System.out.println("The value is already present! try another one.");
        }
        return root;
    }

    //For delete a Node.

    static TreeNode findMin(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static TreeNode deleteNode(TreeNode root, int val) {

        if (root == null) return null;

        if (val < root.val) {
            root.left = deleteNode(root.left, val);
        }

        else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        }
        
        else {
            if (root.left == null && root.right == null) return null;

            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //For post-Order Traversal.
    public static void postOrder(TreeNode root) {

        if (root == null){
            return;
        }

        postOrder(root.left);

        postOrder(root.right);

        System.out.print(root.val + " ");

    }

    boolean search(TreeNode root, int target) {
        if (root == null) {
            System.out.println("Oops! The value is not found in the list. ");
            return false;
        }

        if (root.val == target) {
            System.out.println("Yeaa! The value is found the list.");
            return true;
        }

        if (target < root.val) {
            return search(root.left, target);
        }

        else {
            return search(root.right, target);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AllBSTFunc pq = new AllBSTFunc();

        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(23);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        while (true) {

            System.out.println("\n Enter the choice:\n 1 -- Search the number in the list. \n 2 -- Pre-Order Traversal. \n 3 -- Post-Order Traversal \n 4 -- In-Order Traversal. \n 5 -- Insert a Node in the list. \n 6 -- Delete a Node from the list. \n 7 -- Exit the program.");

            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the number you want to find in the list. ");
                    int find = sc.nextInt();
                    pq.search(root, find);
                    break;

                case 2:
                    System.out.println("The Pre-Order Traversal of the list is: ");
                    preOrder(root);
                    break;

                case 3:
                    System.out.println("The Post-Order Traversal of the list is: ");
                    postOrder(root);
                    break;

                case 4:
                    System.out.println("The In-Order Traversal is: ");
                    inOrder(root);
                    break;

                case 5:
                    System.out.println("Enter the value to insert in the list: ");
                    int insert = sc.nextInt();

                    insertNode(root, insert);
                    break;

                case 6:
                    System.out.println("Enter the number you want to delete from the list: ");
                    int delete = sc.nextInt();
                    deleteNode(root, delete);
                    break;

                case 7:
                    System.out.println("Exiting the program....");
                    return;

                default:
                    System.out.println("Invalid choice! Please select between 1 - 7.");

            }
        }
    }
}