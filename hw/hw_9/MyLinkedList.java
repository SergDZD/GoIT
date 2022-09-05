package com.hw.hw_9;

public class MyLinkedList<E> {
    private int size;
    private Node firstNode;
    private Node lastNode;

    class Node {
        private Node prevNode;
        private Node nextNode;
        private Object value;

        Node(Node prevNode, Node nextNode, Object currentObject) {
            this.prevNode = prevNode;
            this.nextNode = nextNode;
            this.value = currentObject;
        }

        void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }

        void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        Node next(){
            return nextNode;
        }

        Node prev(){
            return prevNode;
        }

        E getObject(){
            return (E) value;
        }

        void clearNode(){
            value = null;
            prevNode = null;
            nextNode = null;
        }
    }

    public void add(Object value){
        if(size == Integer.MAX_VALUE) throw new RuntimeException("LinkedList is full");
        if(size == 0){
            firstNode = lastNode = new Node(null, null, value);
        } else {
            Node node = new Node(lastNode, null, value);
            lastNode.setNextNode(node);
            node.setPrevNode(lastNode);
            lastNode = node;
        }
        size++;
    }

    public void remove(int index){
        if(index >= 0 && index < size){
            int i = 0;
            Node node = firstNode;
            while(i != index){
                node = node.next();
                i++;
            }
            node.prev().setNextNode(node.next());
            node.next().setPrevNode(node.prev());
            node.clearNode();
            node = null;
            size--;
        } else throw new ArrayIndexOutOfBoundsException();
    }

    public void clear(){
        Node nextNode = firstNode;
        Node node;
        firstNode = null;
        for (int i = 0; i < size; i++) {
            node = nextNode;
            nextNode = node.next();
            node.clearNode();
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
        System.out.println(testMyLinkedList.get(6));
        System.out.println("size is " + testMyLinkedList.size());
        testMyLinkedList.remove(5);
        System.out.println("size is " + testMyLinkedList.size());
        //testMyLinkedList.remove(12); //ArrayIndexOutOfBoundsException
        testMyLinkedList.clear();
        System.out.println("size is " + testMyLinkedList.size());
    }
}
