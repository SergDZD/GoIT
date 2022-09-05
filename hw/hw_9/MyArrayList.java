package com.hw.hw_9;

public class MyArrayList<E> {
    final int MAX_SIZE = Integer.MAX_VALUE;
    final int INIT_SIZE = 10;
    private Object [] arrayList = new Object[INIT_SIZE];
    private int size;


    public void add(Object value){
        if(size == MAX_SIZE) throw new ArrayIndexOutOfBoundsException();
        if(size == arrayList.length){
            Object[] newArrayList = new Object[size + INIT_SIZE];
            System.arraycopy(arrayList, 0, newArrayList, 0, size);
            arrayList = newArrayList;
        }
        arrayList[size++] = value;
    }

    public void remove(int index){
        if(index >= size && index < 0) throw new ArrayIndexOutOfBoundsException();
        for(int i = index + 1; i < size; i++){
            arrayList[i - 1] = arrayList[i];
        }
        arrayList[--size] = null;
    }

    public void clear(){
        for(int i = 0; i < size; i++){
            arrayList[i] = null;
        }
        arrayList = new Object[INIT_SIZE];
        size = 0;
    }

    public int size(){
        return size;
    }

    public E get(int index){
        if(index < size && index >= 0){
            return (E) arrayList[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }
 

    public static void main(String[] args) {
        MyArrayList<String> test = new MyArrayList<>();
        test.add("test0");
        test.add("test1");
        test.add("test2");
        test.add("test3");
        test.add("test4");
        test.add("test5");
        test.add("test6");
        test.add("test7");
        test.add("test8");
        test.add("test9");
        test.add("test10");
        test.add("test11");
        System.out.println(test.get(5));
        System.out.println(test.size());
        test.remove(5);
        test.clear();
    }
}