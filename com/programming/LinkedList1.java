package com.programming;

public class LinkedList1
{
    public Node head = null;
    public Node tail = null;
    public int size = 0;

    public static class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    //T.C. = O(1)
    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        size++;

        if(head == null && tail == null)
        {
            head = tail = newNode;
        }
        else
        {
             newNode.next = head;
             head = newNode;
        }
    }

    //T.C. = O(1)
    public void addLast(int data)
    {
        Node newNode = new Node(data);
        size++;
        if(head == null && tail == null)
        {
            head = tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }

    //T.C. = O(n)
    public void printLinkedList()
    {
        if(head == null && tail == null)
            System.out.println("Linked list is empty");
        else
        {
            Node temp = head;

            while (temp != null)
            {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public void addAtMiddle(int data,int index)
    {
        if(index == 0)
            addFirst(data);
        else
        {
            if(index>size)
                System.out.println("Cannot add at this location as the linked list is not that big enough");
            else
            {
                int i = 1;
                Node temp = head;
                while (i != index)
                {
                    temp = temp.next;
                    i++;
                }

                size++;
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                if (temp == tail)
                    tail = newNode;
            }
        }
    }

    public void removeFirst()
    {
        if(size == 0)
            System.out.println("Cannot remove as the linked list is empty");
        else
        {
            size--;
            head = head.next;
            if(head == null)
                tail = null;
        }
    }

    public void removeLast()
    {
        if(size == 0)
            System.out.println("Cannot remove as the linked list is empty");
        else
        {
            if(size == 1)
                tail = head = null;
            else
            {
                Node temp = head;
                while (temp.next != tail)
                    temp = temp.next;
                tail = temp;
                tail.next = null;
            }
            size--;
        }
    }

    public int searchItr(int key)
    {
        Node temp = head;
        int index = 0;
        while(temp!=null)
        {
            if(temp.data == key)
                break;
            index++;
            temp = temp.next;
        }

        if(temp == null)
            return -1;

        return index;
    }

    public int searchRec(Node temp,int key,int index)
    {
        if(temp == null)
            return -1;

        if(temp.data == key)
            return index;

        return searchRec(temp.next,key,index+1);
    }

    //T.C.:O(n)
    public void reverseItr()
    {
        if(size == 1 || size == 0)
            return;
        Node prev = null;
        Node current = tail = head;
        Node next;

        while(current!=null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void removeNthNodeFromEnd(int nodeToBeDeletedFromEnd)
    {
        if(nodeToBeDeletedFromEnd > size)
        {
            System.out.println("Cannot remove as the linked list is not that big");
        }
        else
        {
            int nodeToDeleteFromFront = size - nodeToBeDeletedFromEnd;
            if(nodeToDeleteFromFront == 0)
                removeFirst();
            else if(nodeToDeleteFromFront == (size - 1))
                removeLast();
            else
            {
                Node temp = head;
                Node prev = head;
                int i = 0;
                while(i!=nodeToDeleteFromFront)
                {
                    prev = temp;
                    temp = temp.next;
                    i++;
                }
                prev.next = temp.next;
            }
        }
    }

    public boolean isPalindromeLinkedList()
    {
        if(head == null)
            return true;
        Node slow, fast;
        slow = fast = head;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current,next;
        current = slow;

        while(current!=null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node temp1 = head;
        Node temp2 = prev;

        while(temp2!=null)
        {
            if(temp1.data != temp2.data)
                return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;

    }

    public boolean isCycle()
    {
        Node slow,fast;
        slow = fast = head;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }

        return false;
    }

    public void removeCycle()
    {
        Node slow, fast,prev;
        slow = fast = prev = head;
        boolean isCycle = false;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                isCycle = true;
                break;
            }
        }

        if(isCycle)
        {
            fast = head;

            while (slow != fast)
            {
                prev = slow;
                slow = slow.next;
                fast = fast.next;
            }

            prev.next = null;
        }
    }

    public static void main(String[] args)
    {
        LinkedList1 ll = new LinkedList1();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        //1->2->3->4
        ll.addAtMiddle(80,4);
        //1->2->3->4->80
        ll.addAtMiddle(90,4);
        //1->2->3->4->90->80

//        ll.printLinkedList();
//        System.out.println("Size of the linked list:"+ll.size);

        ll.removeFirst();
        //2->3->4->90->80
//        ll.printLinkedList();
//        System.out.println("Size of the linked list:"+ll.size);

        ll.removeLast();
        //2->3->4->90
        ll.printLinkedList();
        System.out.println("Size of the linked list:"+ll.size);
        ll.reverseItr();
        ll.printLinkedList();

//        int index = ll.searchItr(90);
//        System.out.println("90 is present at index:"+index);//3
//
//        index =ll.searchItr(3);
//        System.out.println("3 is present at index:"+index);//1
//
//        index = ll.searchItr(100);
//        System.out.println("100 is present at index:"+index);//-1

//        int index = ll.searchRec(ll.head,90,0);
//        System.out.println("90 is present at index:"+index);//3
//
//        index = ll.searchRec(ll.head,3,0);
//        System.out.println("3 is present at index:"+index);//1
//
//        index = ll.searchRec(ll.head,100,0);
//        System.out.println("100 is present at index:"+index);//-1




    }
}