package cpsc2150.MyDeque;

import java.util.*;
import java.lang.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestListDeque {
    private IDeque<Character> MakeADeque(){
        IDeque<Character> temp =  new ListDeque();
        return temp;
    }

    @Test
    public void enqueue_emptyDeck(){
        Character input1 = 'a';
        Character expectedValue = 'a';
        IDeque<Character> method = MakeADeque();
        method.enqueue(input1);
        Character actualValue = method.get(1);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void enqueue_deckOfRandomSize(){
        Random rand = new Random();
        int bounds = rand.nextInt(100)+1;
        Character input = 'a';
        Character expected = 'a';
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        for (int i=1; i<=bounds; i++) {
            Character actual = method.get(i);
            assertEquals(expected,actual);
        }
        assertTrue(method.length()==bounds);
    }

    @Test
    public void enqueue_almostFullDeck(){
        Character input = 'a';
        Character expected = 'a';
        int bounds = 99;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        method.enqueue(input);
        for (int i=1; i<=bounds+1; i++) {
            Character actual = method.get(i);
            assertEquals(expected,actual);
        }
        assertTrue(method.length()==bounds+1);
    }

    @Test
    public void dequeue_sizeOne(){
        Character input1 = 'a';
        Character expectedValue = 'a';
        IDeque<Character> method = MakeADeque();
        method.enqueue(input1);
        Character actualValue = method.dequeue();
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void dequeue_FullDeck(){
        Character input = 'a';
        Character expected = 'a';
        int expectedLengthAfterDequeue = 0;
        int bounds = 100;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        for (int i=1; i<=bounds; i++) {
            Character actual = method.dequeue();
            assertEquals(expected,actual);
        }
        assertTrue(method.length()==expectedLengthAfterDequeue);
    }

    @Test
    public void dequeue_RandomSize(){
        Random rand = new Random();
        int bounds = rand.nextInt(100)+1;
        Character input = 'a';
        Character expected = 'a';
        int expectedLengthAfterDequeue = 0;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        for (int i=1; i<=bounds; i++) {
            Character actual = method.dequeue();
            assertEquals(expected,actual);
        }
        assertTrue(method.length()==expectedLengthAfterDequeue);
    }

    @Test
    public void inject_OneLessThanMaxSize(){
        Character input = '1';
        Character expected = '1';
        int bounds = 99;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue('a'); // dummy variable to make sure inject gets the right character input
        method.inject(input);
        Character actual = method.get(1);
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds+1);
    }

    @Test
    public void inject_emptyDeck(){
        Character input = '1';
        Character expected = '1';
        IDeque<Character> method = MakeADeque();
        method.inject(input);
        Character actual = method.get(1);
        assertEquals(expected,actual);
        assertTrue(method.length()==1);
    }

    @Test
    public void inject_sizeOneDeck(){
        Character input = '1';
        Character expected = '1';
        int bounds = 1;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue('a'); // dummy variable to make sure inject gets the right character input
        method.inject(input);
        Character actual = method.get(1);
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds+1);
    }

    @Test
    public void removeLast_sizeOneDeck(){
        Character input = '1';
        Character expected = '1';
        int bounds = 1;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.removeLast();
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds-1);
    }

    @Test
    public void removeLast_fullDeck(){
        Character input = '1';
        Character expected = '1';
        int bounds = 100;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.removeLast();
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds-1);
    }

    @Test
    public void removeLast_randomSizeDeck(){
        Random rand = new Random();
        int bounds = rand.nextInt(100)+1;
        Character input = '1';
        Character expected = '1';
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.removeLast();
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds-1);
    }

    @Test
    public void clear_sizeOneDeck(){
        int expectedLength = 0;
        Character input = 'a';
        IDeque<Character> method = MakeADeque();
        method.enqueue(input);
        method.clear();
        assertTrue(method.length()==expectedLength);
    }

    @Test
    public void clear_FullDeck(){
        Character input = '1';
        int expectedLength = 0;
        int bounds = 100;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        method.clear();
        assertTrue(method.length()==expectedLength);
    }

    @Test
    public void clear_RandomDeck(){
        Character input = '1';
        int expectedLength = 0;
        Random rand = new Random();
        int bounds = rand.nextInt(100)+1;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        method.clear();
        assertTrue(method.length()==expectedLength);
    }

    @Test
    public void peek_sizeOneDeck(){
        Character input = '1';
        Character expected = '1';
        int bounds = 1;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.peek();
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds);
    }
    @Test
    public void peek_sizeFullDeck(){
        Character input = '1';
        Character expected = '1';
        int bounds = 100;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.peek();
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds);
    }

    @Test
    public void peek_sizeRandomDeck(){
        Character input = '1';
        Character expected = '1';
        Random rand = new Random();
        int bounds = rand.nextInt(100)+1;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.peek();
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds);
    }

    @Test
    public void endOfDeque_sizeOneDeck(){
        Character input = '1';
        Character expected = '1';
        int bounds = 1;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.endOfDeque();
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds);
    }

    @Test
    public void endOfDeque_sizeFullDeck(){
        Character input = '1';
        Character expected = '1';
        int bounds = 100;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.endOfDeque();
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds);
    }

    @Test
    public void endOfDeque_sizeRandomDeck(){
        Character input = '1';
        Character expected = '1';
        Random rand = new Random();
        int bounds = rand.nextInt(100)+1;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.endOfDeque();
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds);
    }

    @Test
    public void insert_frontPositionInDeck(){
        Character input = '1';
        Character expected = '1';
        int position = 1;
        int bounds = 50;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue('a');
        method.insert(input,position);
        Character actual = method.get(position);
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds+1);
    }

    @Test
    public void insert_RandomPositionInDeck(){
        Character input = '1';
        Character expected = '1';
        int bounds = 50;
        Random rand = new Random();
        int position = rand.nextInt(50)+1;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue('a');
        method.insert(input,position);
        Character actual = method.get(position);
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds+1);
    }

    @Test
    public void insert_lastPositionInDeck(){
        Character input = '1';
        Character expected = '1';
        int position = 50;
        int bounds = 50;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue('a');
        method.insert(input,position);
        Character actual = method.get(position);
        assertEquals(expected,actual);
        assertTrue(method.length()==bounds+1);
    }

    @Test
    public void remove_frontPositionInDeck(){
        Character input = 'a';
        int bounds = 50;
        Character expected = 'a';
        int expectedLength = bounds - 1;
        int position = 1;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.remove(position);
        assertEquals(expected,actual);
        assertTrue(method.length()==expectedLength);
    }

    @Test
    public void remove_RandomPositionInDeck(){
        Character input = 'a';
        int bounds = 50;
        Character expected = 'a';
        int expectedLength = bounds - 1;
        Random rand = new Random();
        int position = rand.nextInt(50)+1;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.remove(position);
        assertEquals(expected,actual);
        assertTrue(method.length()==expectedLength);
    }

    @Test
    public void remove_LastPositionInDeck(){
        Character input = 'a';
        int bounds = 50;
        Character expected = 'a';
        int expectedLength = bounds - 1;
        int position = bounds;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.remove(position);
        assertEquals(expected,actual);
        assertTrue(method.length()==expectedLength);
    }

    @Test
    public void get_CharacterAtFirstPosition(){
        Character input = 'a';
        int bounds = 100;
        Character expected = 'a';
        int expectedLength = bounds;
        int position = 1;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.get(position);
        assertEquals(expected,actual);
        assertTrue(method.length()==expectedLength);
    }

    @Test
    public void get_CharacterAtRandomPosition(){
        Character input = 'a';
        int bounds = 100;
        Character expected = 'a';
        int expectedLength = bounds;
        Random rand = new Random();
        int position = rand.nextInt(100)+1;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.get(position);
        assertEquals(expected,actual);
        assertTrue(method.length()==expectedLength);
    }

    @Test
    public void get_CharacterAtLastPosition(){
        Character input = 'a';
        int bounds = 100;
        Character expected = 'a';
        int expectedLength = bounds;
        int position = bounds;
        IDeque<Character> method = MakeADeque();
        for (int i=0; i<bounds; i++)
            method.enqueue(input);
        Character actual = method.get(position);
        assertEquals(expected,actual);
        assertTrue(method.length()==expectedLength);
    }
}
