package cpsc2150.MyDeque;

import java.util.*;

public class ListDeque<T> extends AbsDeque<T> {

    /**
     * @invariant: 0 <= myQ.size() <= MAX_LENGTH
     *
     * @correspondence: self = myQ
     *
     */

    // this time store the deque in a list
    // myQ.get(0) is the front of the deque
    private List<T> myQ;

    /**
     *Constructor for a deque that uses a list as its storage mechanism.
     *The ListDeque object created is initially set to being empty.
     *
     * @pre:
     * @post: A ListDeque Object is created && ListDeque is empty
     */
    public ListDeque() {
        myQ =  new ArrayList<T>();
    }

    // Adds x to the end of the deque
    public void enqueue(T x){
        myQ.add(x);
    }

    //removes and returns the Character at the front of the deque
    public T dequeue() {
        T t = myQ.get(0);
        myQ.remove(0);
        return t;
    }

    // Adds x to the front of the deque
    public void inject(T x) {
        myQ.add(0, x);
    }

    //removes and returns the Character at the end of the deque
    public T removeLast(){
        T t = myQ.get(myQ.size() - 1);
        myQ.remove(myQ.size() - 1);
        return t;
    }

    //returns the number of Characters in the deque
    public int length() {
        return myQ.size();
    }

    //clears the entire deque
    public void clear() {
        myQ.clear();
    }
}

