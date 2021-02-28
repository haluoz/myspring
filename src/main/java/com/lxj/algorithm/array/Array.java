package com.lxj.algorithm.array;

/**
 * @author Administrator
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(E[] arr) {
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    public Array() {
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void resize(double newCapacity){
        E[] newData = (E[]) new Object[(int)newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void addFirst(E e){
        add(0, e);
    }

    public void addLast(E e){
        add(size, e);
    }

    public void add(int index, E e){
        if (size == data.length){
            resize(1.5*data.length);
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("add failed, Array is full");
        }
        for (int i = size -1; i >= index ; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("addList failed");
        }
        return data[index];
    }

    public void swap(int i, int j){
        if (i<0 || i>=size || j<0 || j>=size){
            throw new IllegalArgumentException("index is invalid");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    public void set(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("addList failed");
        }
        data[index] = e;
    }

    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }

    public E remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("addList failed");
        }
        E ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        if (size == data.length/2 && data.length/2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        array.addLast(1);
        array.addLast(2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size is: %d, capacity is %d \n", size, data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1){
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
