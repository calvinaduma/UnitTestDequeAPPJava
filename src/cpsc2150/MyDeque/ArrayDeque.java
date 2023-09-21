package cpsc2150.MyDeque;

public class ArrayDeque<T> extends AbsDeque<T> {
    /**
     * @invariant: 0 <= myLength <= MAX_LENGTH
     *
     * @correspondence: self = myQ[MAX_LENGTH]
     *
     */

    // where the data is stored. myQ[0] is the front of the deque
    private T myQ[];

    // tracks how many items in the deque
    // also used to find the end of the deque
    private int myLength;

    /**
     * This constructor constructs a deque using an array as its storage mechanism.
     * The ArrayDeque array is initially set to empty/null.
     * myLength, which represents the number of characters being stored, is initially set to 0.
     *
     * @pre:
     * @post: ArrayDeque is empty && myLength = 0
     */
    public ArrayDeque(){
        myQ = (T[]) new Object[MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) myQ[i] = null;
        myLength = 0;
    }

    // Adds x to the end of the deque
    public void enqueue(T x){
        myQ[myLength] = x;
        myLength++;
    }

    //removes and returns the Character at the front of the deque
    public T dequeue(){
        T t = myQ[0];

        for (int i = 0; i < myLength; i++) {
            if (i == myLength - 1) myQ[i] = null;
            else myQ[i] = myQ[i+1];
        }

        myLength--;
        return t;
    }

    // Adds x to the front of the deque
    public void inject(T x){

        for (int i = myLength; i > 0; i--) {
            myQ[i] = myQ[i-1];
        }
        myQ[0] = x;
        myLength++;
    }

    //removes and returns the Character at the end of the deque
    public T removeLast(){
        T t = myQ[myLength-1];
        myQ[myLength - 1] = null;
        myLength--;
        return t;
    }

    //returns the number of Characters in the deque
    public int length(){
        return myLength;
    }

    //clears the entire deque
    public void clear(){
        Integer length = length();
        if (length.equals(0)) {
            System.out.println("Deque is Empty! Please add a character first!");
            return;
        }


        for (int i = 0; i < myLength; i++ ) {
            myQ[i] = null;
        }
        myLength = 0;
    }
}
