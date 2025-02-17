package com.programming;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree
{
    public static class Node
    {
        Node left, right;
        int data;

        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
            if(ROOT == null)
                ROOT = this;
        }
    }
    public static Node ROOT = null;
    public static int index = -1;
    public static Scanner scanner = new Scanner(System.in);
    public static int height;

    public static Node buildTree(int[] nodes)
    {
        index++;
        if(nodes[index] == -1)
            return null;
        Node newNode = new Node(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    public static Node buildBinaryTreeByTakingInput(Node newNode)
    {
        int data;
        System.out.print("Enter data(-1)if no child:");
        data = scanner.nextInt();
        if(data == -1)
            return null;
        newNode = new Node(data);
        System.out.print("We are at left of "+data+",");
        newNode.left = buildBinaryTreeByTakingInput(newNode.left);
        System.out.print("We are at right of "+data+",");
        newNode.right = buildBinaryTreeByTakingInput(newNode.right);
        return newNode;
    }

    //TC=O(n)
    public static void preOrderTraversal(Node temp)
    {
        if(temp!=null)
        {
            System.out.print(temp.data+" ");
            preOrderTraversal(temp.left);
            preOrderTraversal(temp.right);
        }
    }

    //TC=O(n)
    public static void inOrderTraversal(Node temp)
    {
        if(temp!=null)
        {
            inOrderTraversal(temp.left);
            System.out.print(temp.data+" ");
            inOrderTraversal(temp.right);
        }
    }

    public static void postOrderTraversal(Node temp)
    {
        if(temp!=null)
        {
            postOrderTraversal(temp.left);
            postOrderTraversal(temp.right);
            System.out.print(temp.data+" ");
        }
    }

    public static void levelOrderTraversal()
    {
        Queue<Node>queue = new LinkedList<>();
        if(ROOT!=null)
        {
            queue.add(ROOT);
            queue.add(null);
        }
        else
            return;

        while(!queue.isEmpty())
        {
            Node dequeuedElement = queue.poll();
            if(dequeuedElement == null)
            {
                System.out.println();
                height++;
                if(queue.isEmpty())
                {
                    break;//node:3, edge:2
                }
                queue.add(null);
                continue;
            }
            if(dequeuedElement.left!=null)
                queue.add(dequeuedElement.left);
            if(dequeuedElement.right!=null)
                queue.add(dequeuedElement.right);
            System.out.print(dequeuedElement.data+" ");
        }
    }

    public static int calculateHeightOfTheTree(Node temp)
    {
        if(temp == null)
            return 0;

        int leftSubTreeHeight = calculateHeightOfTheTree(temp.left);
        int rightSubTreeHeight = calculateHeightOfTheTree(temp.right);
        return Math.max(leftSubTreeHeight,rightSubTreeHeight) + 1;
    }

    public static int totalNumberOfNodes(Node temp)
    {
        if(temp == null)
            return 0;

        int lhs = totalNumberOfNodes(temp.left);
        int rhs = totalNumberOfNodes(temp.right);
        return lhs + rhs + 1;
    }

    public static int sumOfAllTheNodes(Node temp)
    {
        if(temp == null)
            return 0;

        return temp.data+sumOfAllTheNodes(temp.left)+sumOfAllTheNodes(temp.right);
    }


    public static void main(String[] args)
    {
//        int[] nodes = {1,2,4,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};
//        BinaryTree.buildTree(nodes);

        BinaryTree.buildBinaryTreeByTakingInput(ROOT);

        System.out.println("Root node is pointing at:"+ROOT.data);
        System.out.println("PreOrder traversal:");
        BinaryTree.preOrderTraversal(ROOT);
        System.out.println("\nInorder traversal:");
        BinaryTree.inOrderTraversal(ROOT);
        System.out.println("\nPostorder traversal:");
        BinaryTree.postOrderTraversal(ROOT);
//        System.out.println("\nLevel order traversal:");
//        height = 0;
//        BinaryTree.levelOrderTraversal();

//        BinaryTree.buildBinaryTreeByTakingInput(ROOT);
//        System.out.println("PreOrder Traversal:");
//        preOrderTraversal(ROOT);
//        System.out.println("\nInOrder Traversal:");
//        inOrderTraversal(ROOT);
//        System.out.println("\nPostOrder Traversal:");
//        postOrderTraversal(ROOT);

//        System.out.println("Height of the tree:"+height);

        height = BinaryTree.calculateHeightOfTheTree(ROOT);
        System.out.println("\nHeight:"+height);

        BinaryTree.levelOrderTraversal();
        System.out.println("\nTotal Number of nodes:"+BinaryTree.totalNumberOfNodes(ROOT));

        System.out.println("\nSum of all the nodes of the tree is:"+BinaryTree.sumOfAllTheNodes(ROOT));



    }
}