package cpsc2150.MyDeque;

import java.util.*;
import java.util.regex.Pattern;

public class DequeApp {
    public static void main(String[] args) {
        IDeque<Character> q;
        boolean active;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 'a' for array, or enter any other character for list");
        String choice = sc.nextLine();

        if (choice.equals("a"))
            q = new ArrayDeque<Character>();
        else
            q = new ListDeque<Character>();

        System.out.println("Select an option: ");
        System.out.println("1. Add to the end of deque");
        System.out.println("2. Add to the front of deque");
        System.out.println("3. Remove from the front of deque");
        System.out.println("4. Remove from the end of deque");
        System.out.println("5. Peek from the front of the deque");
        System.out.println("6. Peek from the end of the deque");
        System.out.println("7. Insert to a position in the deque");
        System.out.println("8. Remove from a position in the deque");
        System.out.println("9. Get a position in the deque");
        System.out.println("10. Get the length of the deque");
        System.out.println("11. Clear the deque");
        System.out.println("12. Quit");

        choice = sc.nextLine();

        active = !choice.equals("12");

        while (active) {
            Character input;
            switch (choice) {
                case "1":
                    System.out.println("What character to enqueue at the end of the deque?");
                    input = sc.next().charAt(0);
                    Integer length = q.length();

                    if (length.equals(IDeque.MAX_LENGTH)) {
                        System.out.println("Deque is full! Did not add to the deque. Please remove a character first!");
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }
                    q.enqueue(input);
                    System.out.println("Deque is: ");
                    System.out.println(q);
                    sc.nextLine();
                    break;

                case "2":
                    System.out.println("What character to inject at the front of the deque?");
                    input = sc.next().charAt(0);
                    Integer length2 = q.length();
                    if (length2.equals(IDeque.MAX_LENGTH)) {
                        System.out.println("Deque is Full!");
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }
                    q.inject(input);
                    System.out.println("Deque is: ");
                    System.out.println(q);
                    sc.nextLine();
                    break;

                case "3":
                    //System.out.println("Character at front of deque is: " + q.dequeue());


                    Integer length3 = q.length();
                    if (length3.equals(0)) {
                        System.out.println("Deque is Empty! Please add a character first!");
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }
                    else {
                        System.out.println("Character at front of deque is: " + q.dequeue());
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }


                case "4":

                    Integer length4 = q.length();
                    if (length4.equals(0)) {
                        System.out.println("Deque is Empty! Please add a character first!");
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }
                    else {
                        System.out.println("Character at end of deque is: " + q.removeLast());
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }



                case "5":
                    Integer length5 = q.length();
                    if (length5.equals(0)) {
                        System.out.println("Deque is Empty! Please add a character first!");
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }
                    else {
                        System.out.println("Peek: " + q.peek());
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }

                case "6":
                    Integer length6 = q.length();
                    if (length6.equals(0)) {
                        System.out.println("Deque is Empty! Please add a character first!");
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }
                    else {
                        System.out.println("EndOfDeque: " + q.endOfDeque());
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }

                case "7":
                    int pos;


                    Integer length7= q.length();
                    if (length7.equals(0)) {
                        System.out.println("Deque is Empty! Please add a character via options 1 or 2 first!");
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }
                    if (length7.equals(IDeque.MAX_LENGTH)) {
                        System.out.println("Deque is Full! Cannot insert a character!");
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }

                    System.out.println("What character to insert into the deque?");
                    input = sc.next().charAt(0);

                    System.out.println("What position to insert in?");
                    pos = sc.nextInt();

                    while (pos > q.length()) {
                        System.out.println("Not a valid position in the deque!");
                        System.out.println("Character/Position must already exist!");
                        System.out.println("What position to insert in?");
                        pos = sc.nextInt();
                    }
                    q.insert(input, pos);
                    System.out.println("Deque is: ");
                    System.out.println(q);
                    sc.nextLine();
                    break;

                case "8":
                    int p;
                    Integer length8 = q.length();
                    if (length8.equals(0)) {
                        System.out.println("Deque is empty! Add to the deque first!");
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }

                    System.out.println("What position to remove from the deque?");
                    p = sc.nextInt();

                    while (p > q.length()) {
                        System.out.println("Not a valid position in the deque!");
                        System.out.println("What position to remove from deque?");
                        p = sc.nextInt();
                    }
                    System.out.println(q.remove(p) + " was at position " + p + " in the Deque");
                    System.out.println("Deque is: ");
                    System.out.println(q);
                    sc.nextLine();
                    break;

                case "9":
                    int position;

                    Integer l = q.length();
                    if (l.equals(0)) {
                        System.out.println("Deque is empty! Add to the deque first!");
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }

                    System.out.println("What position to get?");
                    position = sc.nextInt();

                    while (position > q.length()) {
                        System.out.println("Not a valid position in the deque!");
                        System.out.println("What position to get?");
                        position = sc.nextInt();
                    }
                    System.out.println(q.get(position) + " was at position " + position + " in the Deque");
                    System.out.println("Deque is: ");
                    System.out.println(q);
                    sc.nextLine();
                    break;

                case "10":
                    if (q.length() < 1) {
                        System.out.println("Deque is empty!");
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }
                    System.out.println("Length of deque is: " + q.length());
                    System.out.println("Deque is: ");
                    System.out.println(q);
                    break;

                case "11":
                    if (q.length() < 1) {
                        System.out.println("Deque is empty!");
                        System.out.println("Deque is: ");
                        System.out.println(q);
                        break;
                    }
                    q.clear();
                    System.out.println("Deque is now empty!");
                    System.out.println("Deque is: ");
                    System.out.println(q);
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;

            }

            System.out.println("Select an option: ");
            System.out.println("1. Add to the end of deque");
            System.out.println("2. Add to the front of deque");
            System.out.println("3. Remove from the front of deque");
            System.out.println("4. Remove from the end of deque");
            System.out.println("5. Peek from the front of the deque");
            System.out.println("6. Peek from the end of the deque");
            System.out.println("7. Insert to a position in the deque");
            System.out.println("8. Remove from a position in the deque");
            System.out.println("9. Get a position in the deque");
            System.out.println("10. Get the length of the deque");
            System.out.println("11. Clear the deque");
            System.out.println("12. Quit");

            choice = sc.nextLine();

            active = !choice.equals("12");

        }
    }
}
