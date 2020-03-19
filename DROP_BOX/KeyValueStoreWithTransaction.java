package DROP_BOX;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
Implement (code) a Key value store with transactions.
Set
Get
Delete are methods in Key value store

for transactions
Begin
Commit
Rollback
 */
public class KeyValueStoreWithTransaction {

    public static void main(String[] args) {
        KVStore<Integer, String> kv = new KVStore<>(100);

        kv.startTransaction();
        kv.set(1,"A");
        kv.set(2,"B");
        System.out.println(kv.get(1));
        System.out.println(kv.get(2));
        kv.rollback(1);
        kv.endTransaction();
        System.out.println(kv.get(1));
        System.out.println(kv.get(2));

    }
}

// It took me longer than 30 mins.
// And I'm not even sure if this would meet the expectation. As this can go in so many tangents.
// But, here is my attempt. Feedback welcome!

// The idea is to use a hashmap to store the actual key-value pairs and a linked list to maintain the commit log. The commit log entries
// will have a transaction id, type of mutation performed (set or delete) and previous value for set operation so we can restore the state in
// case of a rollback. Any mutations to both the commit logs and key-value pairs need to be synchronous if multiple threads access the store.
 class KVStore<K, V> {

    private final int size;
    private Map<K, V> store;
    private LinkedList<Node> logs;
    private ReadWriteLock lock;
    private static long counter;

    public KVStore(int size) {
        this.size = size;
        this.store = new HashMap<>();
        this.logs = new LinkedList<>();
        this.lock = new ReentrantReadWriteLock();
    }

    static class Node<K, V> {
        long id;
        String type;
        K key;
        V previousValue;

        public Node(long id, String type, K key, V previousValue) {
            this.id = id;
            this.type = type;
            this.key = key;
            this.previousValue = previousValue;
        }
    }

   public V get(K key) {
        lock.readLock().lock();

        V value = store.get(key);

        lock.readLock().unlock();
        return value;
    }

  public  void set(K key, V value) {
        lock.writeLock().lock();

        try {
            if (size == store.size()) throw new Exception("Store full! No more inserts allowed");
            Node node = new Node(counter++, "set", key, store.put(key, value));
            logs.addLast(node);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    void delete(K key) {
        lock.writeLock().lock();

        Node node = new Node(counter++, "set", key, store.remove(key));
        logs.addLast(node);

        lock.writeLock().unlock();
    }

    void rollback(long idToRollback) {
        lock.writeLock().lock();

        ListIterator<Node> iterator = logs.listIterator();
        while (iterator.hasPrevious()) {
            Node<K, V> node = iterator.previous();
            if (node.id != idToRollback) {
                store.put(node.key, node.previousValue);
                iterator.remove();
            }
        }

        while (iterator.hasPrevious()) {
            Node<K, V> node = iterator.previous();
            if (node.id == idToRollback) {
                store.put(node.key, node.previousValue);
                iterator.remove();
            } else break;
        }

        lock.writeLock().unlock();
    }

    public void startTransaction() {
        lock.writeLock().lock();
    }

    public void endTransaction() {
        lock.writeLock().unlock();
    }
}