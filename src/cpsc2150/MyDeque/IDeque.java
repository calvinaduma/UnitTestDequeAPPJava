package cpsc2150.MyDeque;

/**
 *A deque containing characters.
 *A deque is a data structure a double-ended queue that allows you to insert and remove from both ends.
 *This deque is bounded by MAX_LENGTH
 *
 *Initialization insures:
 *	Deque is empty && is less than MAX_LENGTH
 *
 *Constraints:
 *	length of deque <= MAX_LENGTH &&
 *  length of deque >= 0
 *
 *Specification:
 *	Adds elements to the front and to the end of the deque. Removes and returns elements
 *	from the front and the end of the deque. Clears deque. Returns current length of deque.
 *
 * Defines:
 *   MAX_LENGTH = 100
 *
 *Invariants:
 *	0 < length < MAX_LENGTH 
 *
 */

public interface IDeque<T> {
    /**
     * the maximum length that our deque may be
     * I tested max length of 3 to make sure all operations when the deque is full still work.
     */
    public static final int MAX_LENGTH = 100;

    /**
     *  Adds x to the end of the deque
     *
     * @param: x the incoming character to be added at end of deque
     * @pre: length <= MAX_LENGTH
     * @post: deque = #deque, except X added to end of deque
     */
    public void enqueue(T x);

    /**
     * removes and returns the Character at the front of the deque
     *
     *@pre: length > 0
     *@post: deque = #deque, except first character in deque is removed
     *       && [all other characters are shifted down one]
     *       && [Character at front of dequeue is returned]
     * @return Character at front of dequeue
     */
    public T dequeue();

    /**
     * Adds x to the front of the deque
     *
     *@pre: length <= MAX_LENGTH
     *@post: deque = #deque, except X added to front of deque
     */
    public void inject(T x);

    /**
     * removes and returns the Character at the end of the deque
     *
     *@pre: length > 0
     *@post: deque = #deque, except last character removed && last Character in deque returned
     * @return: Character at the end of the deque
     */
    public  T removeLast();

    /**
     * returns the number of Characters in the deque (The size of the deque)
     *
     *@pre:
     *@post: returns the length of the deque
     * @return: length of deque
     */
    public int length();

    /**
     * clears the entire deque
     *
     *@pre: length > 0
     *@post: [length of deque] = 0
     */
    public void clear();

    //Secondary methods
    /**
     * returns character at front of deque
     *
     *@pre: 0 < length
     *@post: returns character in front of deque &&
     * 	     self = #self
     *@return: character at front of deque
     */
    public default T peek() {
        T t = dequeue();
        System.out.println(t);
        inject(t);
        return t;
    }

    /**
     * returns character at end of deque
     *
     *@pre: 0 <= length
     *@post: returns character at end of deque &&
     *	    self = #self
     *@return: character at end of deque
     */
    public default T endOfDeque() {
        T temp = removeLast();
        enqueue(temp);
        return temp;
    }

    /**
     * inserts character ‘c’ at positions pos in deque
     *
     *@param: c is incoming character to be inserted in deque &&
     *	      pos is integer of desired position for c to be inserted into deque
     *
     *@pre: 0 < length < MAX_LENGTH && 1 <= pos <= length()
     *@post: self = #self, except ‘c’ inserted at pos in deque
     */
    public default void insert(T c, int pos) {
        Integer length = length();
        //in case of using this function to add to the end
        T[] temp = (T[]) new Object[length];


        //since we implemented it with the first index at 0, correction needs to be made
        int correction = pos - 1;

        for (int i = 0; i < correction; i++) {
            temp[i] = dequeue();
        }

        inject(c);


        //repopulate deque
        for (int i = correction - 1; i >= 0; i--) {
            inject(temp[i]);
        }

    }

    /**
     *removes character at position pos in deque and returns that character
     *
     *@param: pos is integer of desired position of an element in deque to be removed
     *@pre: 0 < length < MAX_LENGTH && 1 <= pos <= length
     *@post: returns character at position pos of deque
     *           self = #self, except character at pos is removed
     *@return: character at position pos in deque
     */
    public default T remove(int pos) {
        Integer length = length();
        T[] temp = (T[]) new Object[length]; //in case of using this function to add to the end

        //since we implemented it with the first index at 0, correction needs to be made
        int correction = pos - 1;

        for (int i = 0; i < pos; i++) {
            temp[i] = dequeue();
        }

        //saved removed character to be returned
        T t = temp[correction];

        //delete character that is being removed
        temp[correction] = null;

        //repopulate deque
        for (int i = correction - 1; i >= 0; i--) {
            inject(temp[i]);
        }

        return t;
    }

    /**
     *gets character at position pos in deque and returns that character
     *@pre: 0 < length < MAX_LENGTH [there is at least one character] && 1 <= pos <= length
     *@post: self = #self &&
     *	    returns character at position pos of deque
     *@return: character at position pos in deque
     */
    public default T get(int pos) {
        Integer length = length();
        T[] temp = (T[]) new Object[length];

        if (length.equals(0)) {
            System.out.println("Deque is Empty! Please add a character first!");
            return null;
        }

        for (int i = 0; i < length; i++) {
            temp[i] = dequeue();
        }

        //since we implemented it with the first index at 0, correction needs to be made
        int correction = pos - 1;

        //save desired Character at pos
        T t = temp[correction];

        //repopulate deque
        for (int i = 0; i < length; i++) {
            enqueue(temp[i]);
        }

        return t;
    }
}

