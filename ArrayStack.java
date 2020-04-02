public class ArrayStack<T> implements Stack<T>{

    T [] array = (T[]) new Object[10];
    int top = 0;

    public void push(T item){ //Add an item at the top of the array stack
        if(top == array.length) //If the top is equal to the length of the array stack, we double its size
            doubleArray();
        array[top] = item; //The top element of the array takes the value of item
        top++; //Increment the value of top
    }
    
    private void doubleArray(){ //Double the size of the array
        T[] temp = (T[]) new Object[array.length*2]; //Create a temp array of double size
        for(int i = 0; i < array.length; i++) //Every element in the array is copied to the temp array
            temp[i] = array[i];
        array = temp; //array takes the values of the temp array back
    }
    
    public T pop() throws Exception{ //Removes the last element that was added to the array stack
        if(top <= 0) //If the value of top is less or equal to zero, throw exception because stack is empty
            throw new IndexOutOfBoundsException();
        T itemRemove = array[top-1]; //Remove the last element of the array stack
        top--; //top decrements
        return itemRemove; //Return the value of the removed element
    }
    
    public T peek() throws Exception{
        if(empty()) //If the stack is empty, throw exception
            throw new IndexOutOfBoundsException();
        return array[top];//Return the element on the top of the array stack
    }
    
    public boolean empty(){ //Returns true if the array stack is empty ( top is equal to 0 )
        return top == 0;
    }
}