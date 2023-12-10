public class LinkedDequeue {
    private QueueNode head;
    private QueueNode tail;
    private int count;

    public static void main(String[] args) {
        LinkedDequeue dequeue = new LinkedDequeue();

        // Adding elements to head and tail
        dequeue.headAdd("Head 1");
        dequeue.tailAdd("Tail 1");
        dequeue.headAdd("Head 2");
        dequeue.tailAdd("Tail 2");

        // Displaying the dequeue after additions
        System.out.println("Dequeue after adding elements:");
        System.out.println(dequeue);

        // Checking size and if empty
        System.out.println("Peek Head: " + dequeue.headPeek());
        System.out.println("Peek Tail: " + dequeue.tailPeek());

        // Removing elements from head and tail
        System.out.println("Removed from Head: " + dequeue.headRemove());
        System.out.println("Removed from Tail: " + dequeue.tailRemove());

        // Displaying the dequeue after removals
        System.out.println("Dequeue after removing elements:");
        System.out.println(dequeue);

        // Checking size and if empty
        System.out.println("Size of Dequeue: " + dequeue.size());
        System.out.println("Is Dequeue Empty? " + dequeue.isEmpty());
    }

    class QueueNode {
        private Object item;
        private QueueNode next;

        QueueNode(Object item) {
            this.item = item;
            this.next = null;
        }
    }

    public LinkedDequeue() {
        head = tail = null;
        count = 0;
    }

    public void headAdd(Object o) {
        QueueNode newNode = new QueueNode(o);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    public Object headPeek() {
        return isEmpty() ? null : head.item;
    }

    public Object headRemove() {
        if (isEmpty()) {
            return null;
        }
        Object item = head.item;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        count--;
        return item;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int size() {
        return count;
    }

    public void tailAdd(Object o) {
        QueueNode newNode = new QueueNode(o);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    public Object tailPeek() {
        return isEmpty() ? null : tail.item;
    }

    public Object tailRemove() {
        if (isEmpty()) {
            return null;
        }
        if (head == tail) { // only one node
            return headRemove();
        }
        QueueNode current = head;
        while (current.next != tail) {
            current = current.next;
        }
        Object item = tail.item;
        tail = current;
        tail.next = null;
        count--;
        return item;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        QueueNode current = head;
        while (current != null) {
            sb.append(current.item).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
}
