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
        return (this.first == null && this.last == null);
    }
    public void insertFirst(double data) {
        Dlink newDlink = new Dlink(data);
        if(!this.isEmpty()) {
            this.first.prev = newDlink;
            newDlink.next = this.first;
        }else{
            this.last = newDlink;
        }
        this.first = newDlink;
        this.length += 1;

    }
    public void insertLast(double value) {
        Dlink newDlink = new Dlink(value);
        if (this.isEmpty()) {
            this.first = newDlink;
        } else {
            last.next = newDlink;
            newDlink.prev = last;
        }
        last = newDlink;
        length++;
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        // If there's only one element in the list, set both head and tail to null.
        if (first == last) {
            first = null;
            last = null;
        } else {
            // Update the tail to the previous node and set its next pointer to null.
            last = last.prev;
            last.next = null;
        }
    }


    public void insertLast(int value) {
        Dlink newNode = new Dlink(value);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
    }

    public void displayForward() {
        Dlink current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void insertAt(int value, int index) {
        if (index < 0) {
            System.out.println("Invalid index.");
            return;
        }

        Dlink newNode = new Dlink(value);

        if (index == 0) {
            // Insert at the beginning
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

        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;

        if (newNode.next == null) {
            // If inserting at the end, update the tail
            last = newNode;
        }
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        if (length == 1) {
            // Only one element in the list
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        length--;
    }

    public void deleteAt(int index) {
        if(index < 0 || index >= length) {
            System.out.println("Index out of bounds");
            return;
        }
        if(index == 0) {
            deleteFirst();
        } else if (index == length - 1) {
            deleteLast();

        }else {
            Dlink current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            length--;
        }
    }






}