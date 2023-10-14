public class DoublyLinkedList implements LinkedList {
    Dlink first;
    Dlink last;
    int length;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        // This method checks whether the doubly-linked list is empty or not.
        // It returns true if both 'first' and 'last' are null, which means the list has no elements.
        return (this.first == null && this.last == null);
    }

    public void insertFirst(double data) {
        // This method inserts a new node with the given data at the beginning of the doubly-linked list.
        // It creates a new Dlink node 'newDlink' with the specified data.
        Dlink newDlink = new Dlink(data);

        if (!this.isEmpty()) {
            // If the list is not empty, it means there are existing nodes.
            // Connect the 'prev' reference of the current first node to 'newDlink'.
            this.first.prev = newDlink;
            // Connect the 'next' reference of 'newDlink' to the current first node.
            newDlink.next = this.first;
        } else {
            // If the list is empty, set 'last' to 'newDlink' since it will be both the first and last node.
            this.last = newDlink;
        }

        // Update 'first' to point to 'newDlink' as it is now the new first node.
        this.first = newDlink;
        // Increment the length of the list by 1 to reflect the addition of a new node.
        this.length += 1;
    }

    public void insertLast(double value) {
        // This method inserts a new node with the given value at the end of the doubly-linked list.
        // Create a new 'Dlink' node 'newDlink' with the specified value.
        Dlink newDlink = new Dlink(value);

        if (this.isEmpty()) {
            // If the list is empty, 'newDlink' becomes both the first and last node.
            this.first = newDlink;
        } else {
            // If the list is not empty, connect the 'next' reference of the current last node to 'newDlink'.
            last.next = newDlink;
            // Connect the 'prev' reference of 'newDlink' to the current last node.
            newDlink.prev = last;
        }

        // Update the 'last' reference to point to 'newDlink' as it is now the new last node.
        last = newDlink;
        // Increment the 'length' of the list by 1 to reflect the addition of a new node.
        length++;
    }


    public void deleteLast() {
        // This method removes the last node from the doubly-linked list.

        if (isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        // If there's only one element in the list, set both 'first' and 'last' to null.
        if (first == last) {
            first = null;
            last = null;
        } else {
            // Update the 'last' to the previous node and set its 'next' pointer to null.
            last = last.prev;
            last.next = null;
        }
    }



    public void insertLast(int value) {
        // This method inserts a new node with the given value at the end of the doubly-linked list.

        Dlink newNode = new Dlink(value);

        if (isEmpty()) {
            // If the list is empty, set 'first' and 'last' to the new node.
            first = newNode;
            last = newNode;
        } else {
            // Connect the 'prev' reference of the current 'last' node to the 'newNode'.
            newNode.prev = last;
            // Connect the 'next' reference of the 'last' node to the 'newNode'.
            last.next = newNode;
            // Update 'last' to point to 'newNode' as it is now the new last node.
            last = newNode;
        }
    }


    public void displayForward() {
        // This method traverses the doubly-linked list from the 'first' node to the 'last' node and prints the values.

        Dlink current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void insertAt(int value, int index) {
        // This method inserts a new node with the given value at the specified index in the doubly-linked list.

        if (index < 0) {
            System.out.println("Invalid index.");
            return;
        }

        Dlink newNode = new Dlink(value);

        if (index == 0) {
            // Insert at the beginning by updating 'next' and 'prev' references.
            newNode.next = first;
            if (first != null) {
                first.prev = newNode;
            }
            first = newNode;

            if (last == null) {
                last = newNode;
            }
            return;
        }

        Dlink current = first;
        int currentIndex = 0;

        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            System.out.println("Index out of bounds. Element not inserted.");
            return;
        }

        // Connect the 'next' and 'prev' references to insert 'newNode' at the specified index.
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;

        if (newNode.next == null) {
            // If inserting at the end, update the 'last' to 'newNode'.
            last = newNode;
        }
    }


    public void deleteFirst() {
        // This method removes the first node from the doubly-linked list.

        if (isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        if (length == 1) {
            // If there's only one element in the list, set both 'first' and 'last' to null.
            first = null;
            last = null;
        } else {
            // Update the 'first' to point to the next node and set its 'prev' pointer to null.
            first = first.next;
            first.prev = null;
        }
        // Decrement the 'length' to reflect the removal of the first node.
        length--;
    }


    public void deleteAt(int index) {
        // This method deletes a node at the specified index in the doubly-linked list.

        if (index < 0 || index >= length) {
            System.out.println("Index out of bounds");
            return;
        }
        if (index == 0) {
            // If the index is 0, call 'deleteFirst' to remove the first node.
            deleteFirst();
        } else if (index == length - 1) {
            // If the index is the last node, call 'deleteLast' to remove the last node.
            deleteLast();
        } else {
            Dlink current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            // Connect the 'prev' and 'next' references to remove 'current' node.
            current.prev.next = current.next;
            current.next.prev = current.prev;
            // Decrement the 'length' to reflect the removal of the node at the specified index.
            length--;
        }
    }

}






