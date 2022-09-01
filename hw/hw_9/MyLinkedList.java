package com.hw.hw_9;

public class MyLinkedList<E> {
    private int size;
    private Node firstNode;
    private Node currentNode;

    class Node {
        private Node prevNode;
        private Node nextNode;
        private Object currentObject;

        public Node(Node prevNode, Node nextNode, Object currentObject) {
            this.prevNode = prevNode;
            this.nextNode = nextNode;
            this.currentObject = currentObject;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node next(){
            return nextNode;
        }

        public Node prev(){
            return prevNode;
        }

        public E getObject(){
            return (E)currentObject;
        }

        public void deleteObject(){
            currentObject = null;
        }
    }

    public void add(Object object){
        Node newNode;
        if(size == 0){
            newNode = new Node(null, null, object);
            firstNode = newNode;
        } else {
            newNode = new Node(currentNode, null, object);
            currentNode.setNextNode(newNode);
        }
        currentNode = newNode;
        size++;
    }

    public void remove(int index){
        if(index >= 0 && index < size){
            int i = 0;
            Node searchNode = firstNode;
            while(i != index){
                searchNode = searchNode.next();
                i++;
            }
            searchNode.prev().setNextNode(searchNode.next());
            searchNode.next().setPrevNode(searchNode.prev());
            searchNode.deleteObject();
            searchNode = null;
            size--;
        }
    }

    public void clear(){
        Node tempNextNode;
        Node tempCurrentNode = firstNode.next();
        firstNode = null;
        firstNode.deleteObject();
        firstNode.setNextNode(null);
        for (int i = 1; i < size; i++) {
            tempNextNode = tempCurrentNode.next();
            currentNode.setNextNode(null);
            currentNode.setPrevNode(null);
            currentNode.deleteObject();
        }
        size = 0;
    }

    public int size(){
        return size;
    }

    public E get(int index){
        if(index >= 0 && index < size){
            int i = 0;
            Node searchNode = firstNode;
            while(i != index){
                searchNode = searchNode.next();
                i++;
            }
            return (E) searchNode.getObject();
        }
        else throw new ArrayIndexOutOfBoundsException();
    }
    /*Не можна використовувати масив. Кожний елемент має бути окремим об'єктом-посередником (Node - нода), що зберігає посилання на попередній та наступний елемент колекції (двозв'язний список).
    Методи
    add(Object value) додає елемент в кінець
    remove(int index) видаляє елемент з вказаним індексом
    clear() очищає колекцію
    size() повертає розмір колекції
    get(int index) повертає елемент по індексу*/

    public static void main(String[] args) {
        MyLinkedList<String> testMyLinkedList = new MyLinkedList<>();
        testMyLinkedList.add("text0");
        testMyLinkedList.add("text1");
        testMyLinkedList.add("text2");
        testMyLinkedList.add("text3");
        testMyLinkedList.add("text4");
        testMyLinkedList.add("text5");
        testMyLinkedList.add("text6");
        testMyLinkedList.add("text7");
        testMyLinkedList.add("text8");
        testMyLinkedList.add("text9");
        testMyLinkedList.add("text10");
        testMyLinkedList.add("text11");
        System.out.println(testMyLinkedList.get(5));
        testMyLinkedList.remove(5);
        testMyLinkedList.clear();
    }
}
