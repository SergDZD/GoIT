package com.hw.hw_9;

public class MyHashMap <K,V> {
    private int size;
    private Node firstNode;
    private Node lastNode;

    private class Node {
        private Node prevNode;
        private Node nextNode;
        private Object key;
        private Object value;

        Node(Node prevNode, Node nextNode, Object key, Object value) {
            this.prevNode = prevNode;
            this.nextNode = nextNode;
            this.key = key;
            this.value = value;
        }

        void setPrev(Node prevNode) {
            this.prevNode = prevNode;
        }

        void setNext(Node nextNode) {
            this.nextNode = nextNode;
        }

        Node next(){
            return nextNode;
        }

        Node prev(){
            return prevNode;
        }

        K getKey(){
            return (K) key;
        }

        V getValue(){
            return (V) value;
        }

        void clearNode(){
            key = null;
            value = null;
            prevNode = null;
            nextNode = null;
        }
    }

    public boolean put(Object key, Object value){
        if(size == Integer.MAX_VALUE) throw new RuntimeException("HashMap is full");
        if (size == 0){
            firstNode = lastNode = new Node(null, null, key, value);
            size++;
            return true;
        }
        if(findNodeByKey(key) != null) return false;
        Node node = new Node(lastNode, null, key, value);
        lastNode.setNext(node);
        node.setPrev(lastNode);
        lastNode = node;
        size++;
        return true;
    }

    private Node findNodeByKey(Object key){
        if(size == 0) return null;
        Node node = firstNode;
        for (int i = 0; i < size; i++) {
            if(node.getKey().equals(key)) return node;
            node = node.next();
        }
        return null;
    }

    public boolean remove(Object key){
        if (size == 0) return false;
        Node node = findNodeByKey(key);
        if(node != null){
            remove(node);
            return true;
        }
        return false;
    }

    private void remove(Node node){
        node.prev().setNext(node.next());
        node.next().setPrev(node.prev());
        node.clearNode();
        node = null;
        size--;
    }

    public void clear(){
        Node node, nextNode;
        nextNode = firstNode;
        for (int i = 0; i < size; i++) {
            node = nextNode;
            nextNode = node.next();
            node.clearNode();
            node = null;
        }
        firstNode = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public V get(Object key){
        if(size == 0) return null;
        Node node = findNodeByKey(key);
        return node == null ? null : (V)node.getValue();
    }
    /*    Написати свій клас MyHashMap як аналог класу HashMap.

    Потрібно робити з допомогою однозв'язної Node.

    Не може зберігати дві ноди з однаковими ключами.

    Методи

    put(Object key, Object value) додає пару ключ + значення
    remove(Object key) видаляє пару по ключу
    clear() очищає колекцію
    size() повертає розмір колекції
    get(Object key) повертає значення (Object value) по ключу*/

    public static void main(String[] args) {
        MyHashMap<Integer, String> testMyHashMap = new MyHashMap<>();
        System.out.println("Add key is 0, value is \"text0\" is " + testMyHashMap.put(0, "text0"));
        System.out.println("size is " + testMyHashMap.size());
        System.out.println("Add key is 1, value is \"text1\" is " + testMyHashMap.put(1, "text1"));
        System.out.println("size is " + testMyHashMap.size());
        System.out.println("Add key is 2, value is \"text2\" is " + testMyHashMap.put(2, "text2"));
        System.out.println("size is " + testMyHashMap.size());
        System.out.println("Add key is 3, value is \"text3\" is " + testMyHashMap.put(3, "text3"));
        System.out.println("size is " + testMyHashMap.size());
        System.out.println("Add key is 4, value is \"text4\" is " + testMyHashMap.put(4, "text4"));
        System.out.println("size is " + testMyHashMap.size());
        System.out.println("Add key is 5, value is \"text5\" is " + testMyHashMap.put(5, "text5"));
        System.out.println("size is " + testMyHashMap.size());
        System.out.println("Add key is 6, value is \"text6\" is " + testMyHashMap.put(6, "text6"));
        System.out.println("size is " + testMyHashMap.size());
        System.out.println("Add key is 7, value is \"text6\" is " + testMyHashMap.put(7, "text6"));
        System.out.println("size is " + testMyHashMap.size());
        System.out.println("Add key is 4, value is \"text8\" is " + testMyHashMap.put(4, "text8"));
        System.out.println("size is " + testMyHashMap.size());
        System.out.println("Remove index 4 is " + testMyHashMap.remove(4) + ", size is " + testMyHashMap.size());
        System.out.println("Add key is 4, value is \"text4\" is " + testMyHashMap.put(4, "text4") + " size is " + testMyHashMap.size());
        System.out.println("Remove index 44 is " + testMyHashMap.remove(44) + ", size is " + testMyHashMap.size());
        System.out.println("Key is 3, value is " + testMyHashMap.get(3));
        System.out.println("Key is 33, value is " + testMyHashMap.get(33));
        System.out.println("Clear testMyHashMap");
        testMyHashMap.clear();
        System.out.println("Size is " + testMyHashMap.size());
    }
}
