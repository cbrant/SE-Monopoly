package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AuctionViewTest {
	public static MainWindow main;
	public static GamePanel game;
	public static AuctionView av;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		main = new MainWindow();
		main.createAndShowGUI();
		game = (GamePanel)main.cards.getComponent(2);
		av = new AuctionView(game);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAuctionWindowVisible() {
		// test AuctionView()
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testFirstPlayerBid() {
		// something in bidMade -- maybe just call the helper function in there
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testRaisingBid() {
		// something in bidMade -- again maybe just a helper function
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testPassingOnBid() {
		// something in playerPasses -- maybe just helper
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testIllegalBid() {
		// in bidMade
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testEndOfAuction() {
		// in playerPasses
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testPlayerRecievesProperty() {
		// in playerPasses -- or helper that ends auction
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testMoneyIsDeducted() {
		// same as above
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void testNoBid() {
		// in playerPasses 
		fail("Not yet implemented"); // TODO
	}
	
}
