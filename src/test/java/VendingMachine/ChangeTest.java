package VendingMachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ChangeTest
{	private Change testChange;

	@Before
	public void setUp() throws Exception
	{
		testChange = new Change();
	}
	
	@Test
	public void testChange() {
		assertNotNull(testChange);
	}

	@Test
	public void testMakeChange1()
	{
		assertEquals("Your change is: 4 quarter(s), 0 dime(s), and 0 nicklel(s).", testChange.makeChange(new BigDecimal("1")));
	}
	
	@Test
	public void testMakeChangeDollar()
	{
		assertEquals("Your change is: 4 quarter(s), 0 dime(s), and 0 nicklel(s).", testChange.makeChange(new BigDecimal("1.00")));
	}
	
	@Test
	public void testMakeChange40Cents()
	{
		assertEquals("Your change is: 1 quarter(s), 1 dime(s), and 1 nicklel(s).", testChange.makeChange(new BigDecimal("0.40")));
	}
	
	@Test
	public void testMakeChangeNone()
	{
		assertEquals("Your change is: 0 quarter(s), 0 dime(s), and 0 nicklel(s).", testChange.makeChange(new BigDecimal("0.00")));
	}
	
	
	
}
