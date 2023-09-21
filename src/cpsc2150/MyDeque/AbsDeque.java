package cpsc2150.MyDeque;

public abstract class AbsDeque<T> implements IDeque<T> {
    @Override
    /**
     * An override of the toString function to easily print out the Deque
     *
     * @pre none
     * @post self = #self, except the contents of the Deque are copied into a String
     * @return Deque as a string
     */
    public String toString() {
        String s = "<";
        int length = length();
        T temp[] = (T[]) new Object[length];


        for (int i = 0; i < length; i++) {
            temp[i] = dequeue();
        }


        //repopulate deque

        for (int i = 0; i < length; i++) {
            if (i == 0) s = s + temp[i];
            else s = s + ", " + temp[i];
            enqueue(temp[i]);
        }


        s = s + ">";
        return s;
    }
}
