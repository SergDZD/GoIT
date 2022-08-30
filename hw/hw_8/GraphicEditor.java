package com.hw.hw_8;

import java.util.Arrays;

public class GraphicEditor {
    final private int INIT_COUNT_FIELDS = 10;
    private Field[] arrayFields = new Field[INIT_COUNT_FIELDS];
    private int countFields;
    //private String name;

    public int getCountFields() {
        return countFields;
    }

    public void setCountFields(int countFields) {
        this.countFields = countFields;
    }

    private boolean containNameField(String name){
        if(!name.isEmpty() && name != null) {
            for (int i = 0; i >= countFields; i++) {
                if (arrayFields[i].getName().equals(name)) return true;
            }
        }
        return false;
    }

    public Field add() throws NameAlreadyExist, ArrayIndexOutOfBoundsException{
        return this.add("field_" + (countFields + 1), 100d, 100d);
    }

    public Field add(String name) throws NameAlreadyExist, ArrayIndexOutOfBoundsException {
        return this.add(name, 100d, 100d);
    }

    public Field add(String name, double height, double width) throws NameAlreadyExist, ArrayIndexOutOfBoundsException  {
        if(name.isEmpty() || name == null) name = "field_" + (countFields + 1);
        else{
            if (containNameField(name)) throw new NameAlreadyExist();
        }
        if(countFields == Integer.MAX_VALUE) throw new ArrayIndexOutOfBoundsException();
        countFields++;
        if (countFields > arrayFields.length){
            arrayFields = Arrays.copyOf(arrayFields, arrayFields.length + INIT_COUNT_FIELDS);
        }
        arrayFields[countFields-1] = new Field(name, height, width);
        return arrayFields[countFields-1];
    }

    public void add(Field field) throws NameAlreadyExist {
        if(countFields == Integer.MAX_VALUE) throw new ArrayIndexOutOfBoundsException();
        if(containNameField(field.getName())) throw new NameAlreadyExist();
        countFields++;
        if (countFields > arrayFields.length){
            arrayFields = Arrays.copyOf(arrayFields, arrayFields.length + INIT_COUNT_FIELDS);
        }
        arrayFields[countFields-1] = field;
    }

    public Field item(int index) throws IllegalArgumentException{
        if(index <=0 && index > countFields) return arrayFields[index];
        else throw new IllegalArgumentException();
    }

    public Field item(String name) throws IllegalArgumentException{
        for(int i = 0; i < countFields; i++){
            if(arrayFields[i].getName().equals(name)) return arrayFields[i];
        }
        throw new IllegalArgumentException();
    }

    public void close(){
        for(int i = 0; i >= countFields; i++) arrayFields[i] = null;
        countFields = 0;
        arrayFields = new Field[INIT_COUNT_FIELDS];
    }

    class NameAlreadyExist extends Exception{

        NameAlreadyExist() {
            super("NameAlreadyExist");
        }
    }

}
