package com.hw.hw_9;

public class MyQueue <E> {
    final int MAX_SIZE = Integer.MAX_VALUE;
    final int INIT_SIZE = 10;
    private Object [] arrayQueue = new Object[INIT_SIZE];
    private int size;

    public void add(Object value){
        if (size == MAX_SIZE) throw new ArrayIndexOutOfBoundsException("The maximum queue size has been reached");
        else {
            if (size == arrayQueue.length){
                Object[] newQueue = new Object[arrayQueue.length + INIT_SIZE];
                System.arraycopy(arrayQueue, 0, newQueue, 0, size);
                arrayQueue = newQueue;
            }
            arrayQueue[size++] = value;
        }
    }

    public boolean remove(int index){
        return true;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            arrayQueue[i] = null;
        }
        size = 0;
        arrayQueue = new Object[INIT_SIZE];
    }

    public int size() {
        return size;
    }
    public E peek() {
        if (size > 0) return (E) arrayQueue[0];
        else return null;
    }
    public E poll() {
        if (size > 0) {
            Object object = arrayQueue[0];
            System.arraycopy(arrayQueue, 1, arrayQueue, 0, --size);
            arrayQueue[size] = null;
            return (E) object;
        }
        else return null;
    }

    /*Написати свій клас MyQueue як аналог класу Queue, який буде працювати по принципу FIFO (first-in-first-out).

    Можна робити з допомогою Node або використати масив.

    Методи
    add(Object value) додає елемент в кінець
    remove(int index) видаляє елемент по індексу
    clear() очищає колекцію
    size() повертає розмір колекції
    peek() повертає перший елемент з черги
    poll() повертає перший елемент з черги і видаляє його з колекції*/
}
