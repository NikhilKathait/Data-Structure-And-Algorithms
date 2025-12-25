public class genericCustomHashMap {
    class CustomHashMap<K, V> {

        // Node for chaining
        private static class Node<K, V> {
            K key;
            V value;
            Node<K, V> next;

            Node(K k, V v) {
                key = k;
                value = v;
            }
        }

        private Node<K, V>[] buckets;
        private int bucketCount;
        private int size;

        // Initial bucket count = 4
        @SuppressWarnings("unchecked")
        public CustomHashMap() {
            bucketCount = 4;
            buckets = (Node<K, V>[]) new Node[bucketCount];
            size = 0;
        }

        // Hash function
        private int hash(K key) {
            return Math.abs(key.hashCode()) % bucketCount;
        }

        // PUT
        public void put(K key, V value) {
            int index = hash(key);
            Node<K, V> curr = buckets[index];

            // Update existing key
            while (curr != null) {
                if (curr.key.equals(key)) {
                    curr.value = value;
                    return;
                }
                curr = curr.next;
            }

            // Insert new node
            Node<K, V> node = new Node<>(key, value);
            node.next = buckets[index];
            buckets[index] = node;
            size++;

            // Rehash if load factor > 2
            if ((double) size / bucketCount > 2.0) {
                rehash();
            }
        }

        // GET
        public V get(K key) {
            int index = hash(key);
            Node<K, V> curr = buckets[index];

            while (curr != null) {
                if (curr.key.equals(key)) {
                    return curr.value;
                }
                curr = curr.next;
            }
            return null; // generic map returns null if not found
        }

        // REMOVE
        public V remove(K key) {
            int index = hash(key);
            Node<K, V> curr = buckets[index];
            Node<K, V> prev = null;

            while (curr != null) {
                if (curr.key.equals(key)) {
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
            return null;
        }

        // SIZE
        public int size() {
            return size;
        }

        // REHASH
        @SuppressWarnings("unchecked")
        private void rehash() {
            Node<K, V>[] oldBuckets = buckets;
            bucketCount *= 2;
            buckets = (Node<K, V>[]) new Node[bucketCount];

            for (Node<K, V> head : oldBuckets) {
                Node<K, V> curr = head;
                while (curr != null) {
                    Node<K, V> next = curr.next;

                    int index = hash(curr.key);
                    curr.next = buckets[index];
                    buckets[index] = curr;

                    curr = next;
                }
            }
        }
    }
}
