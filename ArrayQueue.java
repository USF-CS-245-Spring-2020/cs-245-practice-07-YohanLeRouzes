public class ArrayQueue<T> implements Queue<T>{
    public int a, b, size;
    public T[] arr;

    public ArrayQueue(){ //Defines an array queue with initial values
        a = 0;
        b = 0;
        size = 0;
        arr = (T[]) new Object[10];
    }
    
    public void doubleArray(){ //Double the array when its size is too small
        T[] temp= (T[]) new Object[arr.length*2]; //multiply array length by two
        for(int i = 0;i<size;i++){ //Copy every element of the array queue in a temp array
            temp[i] = arr[(a+i)%arr.length];
        }
        a = 0;
        b = size;
        arr = temp;
    }
    
    public boolean empty(){ //Checks if the array queue is empty
        if(size==0){ //return true if the size of the array queue is 0
            return true;
        }
        return false; //return false if it is different
    }
    
    public void enqueue(T item){ //Add an element to the end of the array queue
        if(size==arr.length){
            doubleArray(); //If the current size is restrictive to the enqueue function, we double the size
        }
        arr[(b%arr.length)] = item; //The value of the new element is item
        b++; //Incrementing b to make sure the queue's respected
        size++; //Incrementing the size of the array queue
    }
    
    public T dequeue() throws Exception //Deletes an element at the beginning of the array
    {
        if(empty())
            throw new IndexOutOfBoundsException(); //Throw exception if the array is empty
        T dataRemove = arr[a]; //Remove the first element of the array queue
        a++; //Increment a so that the next element becomes the first one
        size--; //Decrement the size of the array
        return dataRemove; //Return the value of the removed element
    }
}