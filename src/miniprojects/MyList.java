package miniprojects;

import java.util.*;


public class MyList<T> implements Iterable<T>  {
    private Object [] arr;
    private int capacity;
    private int size;

    public MyList() {
        capacity = 10;
        arr = new Object[capacity];
        size = 0;
    }
    public MyList(int capacity) {
        if(capacity <= 0 || capacity >= Integer.MAX_VALUE)
            throw new IndexOutOfBoundsException();
        this.capacity = capacity;
        arr = new Object[capacity];
         size = 0;
    }

    public void add(T o) {
        if(size < Integer.MAX_VALUE) {
            if (size >= capacity) {
                resize();
            }
            arr[size++] = o;
        }
    }
    public void resize() { // doubles the size of the array
        Object [] tempArr = new Object[arr.length * 2];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        capacity *= 2;
        arr = tempArr;
    }

    public Object get(int index) { //get object at index
        return  arr[index];
    }

    public int geti(T o) { // get index location
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == o) {
                return i;
            }
        }
        return -1;

    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() { //single use class
            final MyList<T>  temp = MyList.this;
            int indexPosition = 0;
            @Override
            public boolean hasNext() {
                if(temp.size >= indexPosition + 1)
                    return true;
                return false;
            }

            @Override
            public T next() {
                @SuppressWarnings("unchecked")
                T val = (T) temp.get(indexPosition);
                indexPosition++;
                return val;
            }
        };
    }

    /*
    Iterator private inner class
    private class Itr implements Iterator<T> {
        MyList<T>  temp = MyList.this;
        int indexPosition = 0;

        @Override
        public boolean hasNext() {
            if(temp.size >= indexPosition + 1)
                return true;
            return false;
        }

        @Override
        public T next() {
            T val = (T) temp.get(indexPosition);
            indexPosition++;
            return val;
        }
    }*/
}

class You {
    public static void main(String[] args) {
        MyList<Integer> you = new MyList<>(10);
        you.add(1);
        //System.out.println(you.get(0));
        MyList<Character> cool = new MyList<>();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            cool.add(alphabet);
        }
        System.out.println(cool.geti('z'));
       for(Character c : cool) {
            System.out.println(c);
        }
    }
}

