package demoAssertionJunit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.hamcrest.core.CombinableMatcher;
import org.junit.jupiter.api.Test;

import demoAssertionJunit.service.CalculatriceService;

public class DemoTest
{
	@Test
	public void additionnerTest()
	{
		double a = 6, b = 10;

		assertTrue(CalculatriceService.additionner(a, b) == 16, "Devrait être true");
	}
	
	@Test
	public void soustraireTest()
	{
		double a = 6, b = 2;
		
		assertTrue(CalculatriceService.soustraire(a, b) == 4, "Devrait être true");
	}
	
	@Test
	public void multiplierTest()
	{
		double a = 5, b = 6;
		
		assertTrue(CalculatriceService.multiplier(a, b) == 30, "Devrait être true");
	}
	
	@Test
	public void diviserTest()
	{
		double a = 15, b = 5;
		
		assertTrue(CalculatriceService.diviser(a, b) == 3, "Devrait être true");
	}
	
	@Test
	public void testAssertArrayEquals()
	{
	    int[] array = {1, 2, 3};
	    assertArrayEquals(array, array, "Devraient être égaux");
	}
	
	@Test
	public void testAssertEquals()
	{
		assertEquals("text", "text", "Devraient être égaux");
	}
	
	@Test
	public void testAssertFalse()
	{
	    assertFalse(false, "Devrait être false");
	}
	
	@Test
	public void testAssertNotNull()
	{
	    assertNotNull(new Object(), "Ne devrait pas être null");
	}
	
	@Test
	public void testAssertNotSame()
	{
	    assertNotSame(new Object(), new Object(), "Ne devraient pas être identiques");
	}
	
	@Test
	public void testAssertNull()
	{
	    assertNull(null, "Devrait être null");
	}
	
	@Test
	public void testAssertSame()
	{
	    Object object = new Object();
	    assertSame(object, object, "Devrait être identique");
	}
	
	// JUnit Matchers assertThat
	@Test
	public void testAssertThatBothContainsString()
	{
		
	    assertThat("string", both(containsString("s")).and(containsString("g")));
	}
	
	@Test
	public void testAssertThatHasItems()
	{
	    assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
	}
	
	@Test
	public void testAssertThatEveryItemContainsString()
	{
	    assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), everyItem(containsString("n")));
	}
	
	// Core Hamcrest Matchers with assertThat
	@Test
	public void testAssertThatHamcrestCoreMatchers()
	{
	    assertThat("good", allOf(equalTo("good"), startsWith("good")));
	    assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
	    assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
	    assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
	    assertThat(new Object(), not(sameInstance(new Object())));
	}
}
