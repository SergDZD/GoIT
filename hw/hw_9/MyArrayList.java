package hw.hw_9;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.ArrayList;

public class MyArrayList<E> {
    private Object [] arrayList = new Object[10];
    final int MAX_SIZE = Integer.MAX_VALUE;
    private int size;


    public int size(){
        return size;
    }

    public boolean add(Object value){
        if(size == MAX_SIZE) throw new ArrayIndexOutOfBoundsException();
        arrayList[size++] = value;
        return true;
    }

    public void clear(){
        for(int i = 0; i < size; i++){
            arrayList[i] = null;
        }
        size = 0;
    }

    public Object get(int index){
        if(index < size && index >= 0){
            return arrayList[index];
        }
        throw new ArrayIndexOutOfBoundsException();
    }


    //add(Object value) додає елемент в кінець
    //remove(int index) видаляє елемент з вказаним індексом
    //clear() очищає колекцію
    //size() повертає розмір колекції
    //get(int index) повертає елемент по індексу

}
