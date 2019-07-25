package testing_work;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Tests {

	@Test
	public void PutAndGet() {
		HashMap hash = new HashMap();
		hash.put(5, 125);
		try {
			Assert.assertEquals(hash.get(5), 125);
		} catch (KeyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = KeyNotFoundException.class)
	public void whenExceptionThrown_thenExpectationSatisfied() throws KeyNotFoundException {
		HashMap hash = new HashMap();
		Assert.assertEquals(hash.get(6), 125);
	}
	
	@Test
	public void MinAndMaxKeys() {
		HashMap hash = new HashMap();
		hash.put(Integer.MIN_VALUE, 125);
		hash.put(Integer.MAX_VALUE, 125);
		
		try {
			Assert.assertEquals(hash.get(Integer.MIN_VALUE), 125);
		} catch (KeyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Assert.assertEquals(hash.get(Integer.MAX_VALUE), 125);
		} catch (KeyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
