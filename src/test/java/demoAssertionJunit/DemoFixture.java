package demoAssertionJunit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.Closeable;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import demoAssertionJunit.service.CalculatriceService;

public class DemoFixture
{
	static double a, b;
	
	static class ExpensiveManagedResource implements Closeable
	{
	    public void close() throws IOException {}
	}
	
	static class ManagedResource implements Closeable
	{
	    public void close() throws IOException {}
	}
	
	@BeforeAll
	public static void setUpClass()
	{
	    System.out.println("@BeforeClass setUpClass");
	    myExpensiveManagedResource = new ExpensiveManagedResource();
	    a = 15;
	    b = 3;
	}
	
	@AfterAll
	public static void tearDownClass() throws IOException
	{
	    System.out.println("@AfterClass tearDownClass");
	    myExpensiveManagedResource.close();
	    myExpensiveManagedResource = null;
	}
	
	private ManagedResource myManagedResource;
	private static ExpensiveManagedResource myExpensiveManagedResource;
	
	private void println(String string)
	{
	    System.out.println(string);
	}
	
	@BeforeEach
	public void setUp()
	{
	    this.println("@Before setUp");
	    this.myManagedResource = new ManagedResource();
	}

	@AfterEach
	public void tearDown() throws IOException
	{
	    this.println("@After tearDown");
	    this.myManagedResource.close();
	    this.myManagedResource = null;
	}

	@Test
	public void additionnerTest()
	{
	    this.println("additionnerTest");
		assertTrue(CalculatriceService.additionner(a, b) == 18, "Devrait être true");
	}
	
	@Test
	public void soustraireTest()
	{
	    this.println("soustraireTest");
		assertTrue(CalculatriceService.soustraire(a, b) == 12, "Devrait être true");
	}
	
	@Test
	public void multiplierTest()
	{
	    this.println("multiplierTest");
		assertTrue(CalculatriceService.multiplier(a, b) == 45, "Devrait être true");
	}
	
	@Test
	public void diviserTest()
	{
	    this.println("diviserTest");
		assertTrue(CalculatriceService.diviser(a, b) == 5, "Devrait être true");
	}
}