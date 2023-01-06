package sampleQueue;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

//import com.sun.source.tree.AssertTree;
//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
//import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;
//import sun.jvm.hotspot.utilities.Assert;

@DisplayName("[my special queue test]")
class QueueTest {

	/**
	 * Tests for Queue.
	 */

	private static final String SOME_ITEM = "some-content";
	private Queue<String> q;

	@Test
	@DisplayName("is instantiated with new Queue()")
	void isInstantiatedWithNew() {
		new Queue<>();
	}

	@BeforeEach
	void init() {
        this.q = new Queue<String>();
	}

	@Test
	@DisplayName("Verify Queue isEmpty when queue is initialized")
	void isEmptyShouldGiveTrueOnQueueInit() {
		assertTrue(q.isEmpty());
	}

/////////////////////////////////////////////////////////////////////



    //////////////////////////// CONSTRUCTORS AND ENQUEUE
    @Test
    @DisplayName("Test Constructor With 0 constructor")
    void ConstructorWithZeroConstructor(){
        this.q = new Queue<String>(0);
        Exception exception = assertThrows(RuntimeException.class, () -> q.enqueue("placeholder"));
        String expected = "Maximum Size of queue reached, cannot add more.";
        String actual = exception.getMessage();
        assertTrue(actual.contains(expected));

    }
    @Test
    @DisplayName("Test Constructor With Int")
    void ConstructorWithInt(){
        this.q = new Queue<String>(1);
        this.q.enqueue("place holder 2");
        Exception exception = assertThrows(RuntimeException.class, () -> q.enqueue("placeholder"));
        String expected = "Maximum Size of queue reached, cannot add more.";
        String actual = exception.getMessage();
        assertTrue(actual.contains(expected));

    }
////////////////////////////



    //////////////////////////// DEQUEUE
@Test
@DisplayName("dequeue is null when empty")
void testDequeue(){
        assertTrue(this.q.isEmpty());
    Exception exception = assertThrows(NoSuchElementException.class, () -> this.q.dequeue());
    String expected = "Queue underflow";
    String actual = exception.getMessage();
    assertTrue(actual.contains(expected));

}

    @Test
    @DisplayName("dequeue when one item in Q")
    void testWhenOneInQDequeue(){
        this.q.enqueue("place holder");
        assertEquals("place holder", this.q.dequeue());
    }

    @Test
    @DisplayName("dequeue when two items in Q")
    void testWhenTwoInQDequeue(){
        this.q.enqueue("place holder");
        this.q.enqueue("place holder 2");
        assertEquals("place holder", this.q.dequeue());
        assertEquals("place holder 2", this.q.dequeue());
    }
////////////////////////////



    //////////////////////////// PEEK
    @Test
    @DisplayName("peek returns no such element when empty")
    void peekReturnsNoSuchElementWhenEmpty(){
        assertThrows(NoSuchElementException.class, () -> this.q.peek());
    }

    @Test
    @DisplayName("peek returns 7")
    void peekReturns7(){
        this.q.enqueue("7");
        assertEquals("7", this.q.peek());
    }
    @Test
    @DisplayName("peek returns 9 multiple elements in Q")
    void peekReturns9(){
        this.q.enqueue("9");
        this.q.enqueue("7");
        assertEquals("9", this.q.peek());
    }
////////////////////////////



    //////////////////////////// LENGTH
    @Test
    @DisplayName("returns 4 when asked length")
    void returns4WhenAskedLength(){
        this.q.enqueue("1");
        this.q.enqueue("2");
        this.q.enqueue("3");
        this.q.enqueue("4");
        assertEquals(4, this.q.length());
    }

    @Test
    @DisplayName("returns 1 when asked length")
    void returns1WhenAskedLength(){
        this.q.enqueue("1");
        assertEquals(1, this.q.length());
    }

    @Test
    @DisplayName("returns 0 when asked length")
    void returns0WhenAskedLength(){
        assertEquals(0, this.q.length());
    }
    ////////////////////////////



    //////////////////////////// SIZE
    @Test
    @DisplayName("returns 4 when asked size")
    void returns4WhenAskedSize(){
        this.q.enqueue("1");
        this.q.enqueue("2");
        this.q.enqueue("3");
        this.q.enqueue("4");
        assertEquals(4, this.q.size());
    }

    @Test
    @DisplayName("returns 1 when asked size")
    void returns1WhenAskedSize(){
        this.q.enqueue("1");
        assertEquals(1, this.q.size());
    }

    @Test
    @DisplayName("returns 0 when asked size")
    void returns0WhenAskedSize(){
        assertEquals(0, this.q.size());
    }
    //////////////////////////////////////

    //////////////////////////// REMOVE ALL
    @Test
    @DisplayName("removeAll when not empty")
    void removeAllWhenNotEmpty(){
        this.q.enqueue("a special test string");
        assertFalse(this.q.isEmpty());
        this.q.removeAll();
        assertTrue(this.q.isEmpty());
    }

    @Test
    @DisplayName("removeAll when is empty")
    void removeAllWhenIsEmpty(){
        assertTrue(this.q.isEmpty());
        this.q.removeAll();
        assertTrue(this.q.isEmpty());
    }
//////////////////////////////////////

//////////////////////////// IS EMPTY
    @Test
    @DisplayName("Test isEmpty With 1 Element In Q")
    void isEmptyShouldGiveFalseWith1ElementOnQ() {
        this.q.enqueue("a special test string");
        assertFalse(this.q.isEmpty());
    }
    @Test
    @DisplayName("Test isEmpty when empty")
    void isEmptyShouldGiveNullWhenEmpty() {
        assertTrue(this.q.isEmpty());
    }

    //////////////////////////////////////



	//Example of Wrong Test!
	@Test
	@DisplayName("Verify Queue isEmpty returns false when queue is not empty")
	void isEmptyShouldGiveFalseWhenQueueIsNotEmpty() {
		this.q.enqueue(SOME_ITEM);
		assertFalse(q.isEmpty());
	}


}
