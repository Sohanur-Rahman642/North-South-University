package Codes;

import static org.junit.Assert.*;

import java.io.EOFException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import java.util.EmptyStackException;
import org.junit.rules.ExpectedException;

import org.junit.Test;



public class GenericStackTest {
	
	@BeforeClass
    public static void setUpClass() {
		
		GenericStack<Object>  gs = new GenericStack<>(Object.class,5);
		
	}
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
	
	GenericStack<Object>  gs = new GenericStack<>(Object.class,5);

	@Test
	/*
	 * @Test will get a compilation error due to missing of getSize method in the GenericStack Class
	 * That's what we wanted before using Refactoring 
	 * After adding getSize() it will pass the test
	 */
	public void sizeOfStackShouldBeZero() {
		
		
		assertThat("New Stack Should be Empty", gs.sizeAfterPush(),is (0));
		
	}
	
/*	@Test
	
	 * Test the codes of push 
	 * Implement the same code in the GenericStack class
	 
	public void testANormalPush() {
		Object actual = push(10);
		assertEquals(10,actual);
		
		
	}
	
	public Object push(Object x) {
			int top=0;
			Object[] elements=null;
			int size=5;
		    GenericStack<Object> gs = new GenericStack<>(Object.class,5);
		    if(top<size) {
			elements[top] = x;
			top++;	
		}
		    return x;
	}
	*/
	
	
	
	@Test
	/*
	 * Test the size after a new push
	 * expected value = 1
	 * 
	 */
	public void sizeOfStackAfterAPush() {
		
		
		gs.push(11);
		assertThat("New Stack Should be One", gs.sizeAfterPush(),is (1));
		
	}
	
	@Test
	/*
	 * Test the size after three new push
	 * expected value = 3
	 * 
	 */
	
	public void sizeOfStackAfterThreePush() {
		
		
		gs.push("Lionel");
		gs.push("Messi");
		gs.push(10);
		assertThat("New Stack Should be One", gs.sizeAfterPush(),is (3));
		
	}
	

	@Test
	/*
	 * Implement peek()
	 * Generate a compilation error 
	 * Add peek() into the GenericStack Class to fix
	 */
	
	public void pushOneAndPeek() {
		
		gs.push(1100);
		assertThat("1 was pushed on the stack and 1 should be returned when calling peek.", gs.peek(), is(1100));
	}
	
	
    @Test
    /*
	 * Test of isEmpty method of class GenericStack.
	 * Generate a compilation error 
	 * Add isEmpty() into the GenericStack Class to fix
	 */
    public void testStackIsEmptyTrue() 
    {
        
        assertTrue( gs.isEmpty());
    }
	
    @Test
    /*
	 * Test of isEmpty is false or not after a push class GenericStack.
	 */
    public void testStackIsEmptyFalse() 
    {
      
    	 
         gs.push( 1 );
         assertFalse( gs.isEmpty() );
    }
    
    @Test
    /*
	 * Test some successful push
	 */
    public void testPush() {
    	gs.push( -17 );
    	gs.push(12);
    	gs.push(-16);
        assertEquals(-16, gs.peek());
    }
    
    @Test
    /*
	 * Test for pop()
	 * Again it will generate a compilation error
	 * will have to refacotr it adding pop() in the Generic Stack
	 * class after the test fail
	 */
  
    public void testPop() 
    {
    	gs.push("Xavi");
    	gs.push("Busi");
    	gs.push("Iniesta");
    	
        Object actual = gs.pop();
        
        assertEquals("Iniesta", actual);
        
    }
    
    
    @Test
    /*
	 * Test for isFull()
	 * Again it will generate a compilation error
	 * will have to Refactor it adding isFull() in the Generic Stack
	 * class after the test fail
	 */
  
    public void isFull() 
    {
    	gs.push("Lamborghini");
    	gs.push("Aston Martin");
    	gs.push("Roles Royace");
    	gs.push(-11);
    	gs.push(120);
        assertTrue( gs.isFull());
       
        
    }
    

    @Test
    /*
	 * Test check IndexOutOfBoundsException for pop() method
	 */
    public void testPopException() 
    {
       
        exception.expect( IndexOutOfBoundsException.class );
        Object peek = gs.pop();
    }
    
    /*....Input space partition testing....*/
    @Test
    /*
	 * Test push for Positive Integers
	 * values from the partition 67,991,1677
	 */
    public void testPushForPositiveIntegers() {
    	gs.push(67);
    	gs.push(991);
    	gs.push(1677);
        assertEquals(1677, gs.peek());
    }
    
    @Test
    /*
	 * Test push for Negative Integers
	 * values from the partition -10,-577,-1754
	 */
    public void testPushForNegativeIntegers() {
    	gs.push(-10);
    	gs.push(-577);
    	gs.push(-1754);
        assertEquals(-1754, gs.peek());
    }
    
    @Test
    /*
	 * Test push for Positive Floats
	 * values from the partition 1.2,3.4,14.20
	 */
    public void testPushForPositiveFloates() {
    	gs.push(1.2);
    	gs.push(3.4);
    	gs.push(14.20);
        assertEquals(14.20, gs.peek());
    }
    
    @Test
    /*
	 * Test push for Negative Floats
	 * values from the partition -12.4,-43.2,-17.5
	 */
    public void testPushForNegativeFloates() {
    	gs.push(-12.4);
    	gs.push(-43.2);
    	gs.push(-17.5);
        assertEquals(-17.5, gs.peek());
    }
    
    @Test
    /*
	 * Test push for Positive Doubles
	 * values from the partition 19.25,3.4,244.23
	 */
    public void testPushForPositiveDoubles() {
    	gs.push(19.25);
    	gs.push(3.4);
    	gs.push(244.23);
        assertEquals(244.23, gs.peek());
    }
    
    @Test
    /*
	 * Test push for Negative Doubles
	 * values from the partition -42.4,-73.12,-122.57
	 */
    public void testPushForNegativeDoubles() {
    	gs.push(-42.4);
    	gs.push(-73.12);
    	gs.push(-122.57);
        assertEquals(-122.57, gs.peek());
    } 


    
    @Test
    /*
	 * Test push for Character values
	 * values from the partition a,x,z
	 */
    public void testPushForCharacterValues() {
    	gs.push('a');
    	gs.push('x');
    	gs.push('z');
        assertEquals('z', gs.peek());
    }
    
    
    @Test
    /*
	 * Test push for String values
	 * values from the partition Lamborghini,Ferrari,Aston Martin
	 */
    public void testPushForStringValues() {
    	gs.push("Lamborghini");
    	gs.push("Ferrari");
    	gs.push("Aston Martin");
        assertEquals("Aston Martin", gs.peek());
    }
    
    
    @Test
    /*
	 * Test Pop for Multiple values
	 * values from the partition Lamborghini,-122.54, 45,v,3.12
	 */
    public void testPopForStringValues() {
    	
    	gs.push("Lamborghini");
    	gs.push(-122.54);
    	gs.push(45);
    	gs.push('v');
    	gs.push(3.12);
    	
    	gs.pop();
    	gs.pop();
    	Object actual = gs.pop();
        
        assertEquals(45, actual);
        
    }
    
    
    
}
