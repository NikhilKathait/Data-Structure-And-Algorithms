public class customHashMap {
    // Node for chaining
    private static class Node {
        int key, value;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Node[] buckets;
    private int bucketCount;
    private int size;

    // Initial bucket count = 4
    public void CustomHashMap() {
        bucketCount = 4;
        buckets = new Node[bucketCount];
        size = 0;
    }

    // Hash function
    private int hash(int key) {
        return Math.abs(key) % bucketCount;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        // Update if key exists
        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        // Key not found, insert new node at head
        Node node = new Node(key, value);
        node.next = head;
        buckets[index] = node;
        size++;

        // Check load factor for re-hashing
        if ((double) size / bucketCount > 2.0) {
            rehash();
        }
    }

    // GET operation
    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    // REMOVE operation
    public int remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return -1;
    }

    // SIZE operation
    public int size() {
        return size;
    }

    // REHASH operation
    private void rehash() {
        Node[] oldBuckets = buckets;
        bucketCount *= 2;
        buckets = new Node[bucketCount];

        // reinsert existing nodes
        for (Node head : oldBuckets) {
            Node curr = head;
            while (curr != null) {
                int index = hash(curr.key);
                Node next = curr.next;

                curr.next = buckets[index];
                buckets[index] = curr;

                curr = next;
            }
        }
    }
}
