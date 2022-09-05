package com.hw.hw_9;

public class MyStack<E> {
    final int MAX_SIZE = Integer.MAX_VALUE;
    final int INIT_SIZE = 10;
    private Object [] arrayStack = new Object[INIT_SIZE];
    private int size;

    public void push(Object value){
        if (size == MAX_SIZE) throw new RuntimeException("Stack is full");
        else {
            if (size == arrayStack.length){
                Object[] newQueue = new Object[arrayStack.length + INIT_SIZE];
                System.arraycopy(arrayStack, 0, newQueue, 0, size);
                arrayStack = newQueue;
            }
            arrayStack[size++] = value;
        }
    }

    public void remove(int index){
        if(index >= 0 && index < size) {
            System.arraycopy(arrayStack, index + 1, arrayStack, index, --size - index);
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            arrayStack[i] = null;
        }
        size = 0;
        arrayStack = new Object[INIT_SIZE];
    }

    public int size() {
        return size;
    }
    public E peek() {
        if (size > 0) return (E) arrayStack[size - 1];
        else throw new RuntimeException("Stack is empty");
    }
    public E pop() {
        if (size > 0) {
            Object object = arrayStack[size--];
            arrayStack[size] = null;
            return (E) object;
        }
        else throw new RuntimeException("Stack is empty");
    }
   /* Написати свій клас MyStack як аналог класу Stack, який працює по принципу LIFO (last-in-first-out).

    Можна робити з допомогою Node або використати масив.

    Методи

    push(Object value) додає елемент в кінець
    remove(int index) видаляє елемент по індексу
    clear() очищає колекцію
    size() повертає розмір колекції
    peek() повертає перший елемент стеку
    pop() повертає перший елемент стеку та видаляє його з колекції*/
}
