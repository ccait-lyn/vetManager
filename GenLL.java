// Gen_LL.java: General linked list data structure used for storing patient records and veternarian records.

public class GenLL<T> {
    private class ListNode 
    {
        T data;
        ListNode next;

        public ListNode(T aData, ListNode aNext) {
            this.data = aData;
            this.next = aNext;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public GenLL() 
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // add(): ADDS A NEW NODE (PATIENT) TO THE PATIENT RECORDS (LINKED LIST). Always adds to the end of the linked list.
    public void add(T data) 
    {
        if (data == null) throw new IllegalArgumentException("Cannot add null.");
        
        ListNode newNode = new ListNode(data, null);

        // If the list is empty, the new node becomes the head and the tail of the linked list.
        if (head == null)
        {
            head = newNode;
            tail = newNode;
        } 

        // Otherwise, add the new node to the end of the linked list.
        else 
        {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // size(): RETURNS THE NUMBER OF NODES (PATIENTS) IN THE LINKED LIST (PATIENT RECORDS).
    public int size()
    {
        return size;
    }

    // get(): RETURNS THE VALUE (PATIENT) AT ANY GIVEN POSITION (0 = FIRST RECORD).
    /*
        Note: We may not need this method because the linked list is primarily used for storing patient and vet records. 
                Something like this may be more useful in the Appointments functionality, where patients can check what number they are in line.
                Check back on this later.
    */
    public T get(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        ListNode node = head;
        for (int i = 0; i < index; i++)
        {
            node = node.next;
        }
        return node.data;
    }

    // remove(): REMOVES A NODE (PATIENT) FROM THE LINKED LIST (PATIENT RECORDS). Handles if removing from the beginning and middle/end of the LL.
    public boolean remove(T data)
    {
        ListNode current;

        if (head == null || data == null) return false;

        // Case 1: If the head of the LL is the record we want to remove:
        if (head.data.equals(data))
        {
            head = head.next;
            if (head == null) tail = null; // If there are no more nodes in the LL, tail must also become null.
            size--;
            return true;
        }

        // Case 2: If the record we want to remove is elsewhere in the LL:
        current = head;
        while (current.next != null)
        {
            if (current.next.data.equals(data))
            {
                // If the node we want to remove is the last one, make the second-to-last node the new tail.
                if (current.next == tail) tail = current; 

                current.next = current.next.next;
                size--;
                return true;
            }

            current = current.next;
        }
        
        return false;
    }
}