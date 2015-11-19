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
		av = new AuctionView(game, (Property)main.spaces.get(1));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAuctionWindowVisible() {
		// test AuctionView()
		assertTrue(av.isVisible());
	}

	@Test
	public void testFirstPlayerBid() {
		// something in bidMade -- maybe just call the helper function in there
		// current player = 0
		assertEquals((game.currPlayer + 1) %4, av.currBidder);
	}
	
	@Test
	public void testRaisingBid() {
		// something in bidMade -- again maybe just a helper function
		int currBid = av.currBid;
		av.updateBid(currBid + 100);
		assertTrue(currBid < av.currBid);
		assertEquals(currBid+100, av.currBid);		
	}
	
	@Test
	public void testPassingOnBid() {
		// something in playerPasses -- maybe just helper
		int currBid = av.currBid;
		int currBidder = av.currBidder;
		av.updateBidder();
		// make sure bid is still the same
		assertEquals(currBid, av.currBid);
		// make sure have moved on to the next bidder
		assertEquals((currBidder+1)%4, av.currBidder);
	}
	
	@Test
	public void testIllegalBid() {
		// in bidMade
		assertFalse(av.checkBidInput(av.currBid-100));
		// all players will have a max bank of 1500
		assertFalse(av.checkBidInput(Integer.MAX_VALUE));
		// check legal value
		assertTrue(av.checkBidInput(av.currBid + 100));
	}
	
	@Test
	public void testEndOfAuction() {
		// check if auction has ended before anything happens
		assertFalse(av.isEndAuction());
		
		// in playerPasses
		av.highestBidder = 0;
		// next three bidders pass
		av.updateBidder();
		av.updateBidder();
		av.updateBidder();
	
		// check if end of auction with winning bidder
		assertTrue(av.isEndAuction());
	}
	
	@Test
	public void testPlayerRecievesProperty() {
		// set highest bidder to player 0 and have them win
		av.highestBidder = 0;
		av.bidWon();
		
		// check that that player now owns that property
		assertTrue(main.players[av.highestBidder].ownsProperty(av.propForAuction));
	}
	
	@Test
	public void testMoneyIsDeducted() {
		// set highest bidder to player 0 and have them win
		av.highestBidder = 0;
		int currBank = main.players[av.highestBidder].getBank();
		av.bidWon();
		
		// check that the player got that much money deducted
		assertEquals(currBank-av.currBid, main.players[av.highestBidder].getBank());
	}
	
	@Test
	public void testNoBid() {
		av.updateBidder();
		av.updateBidder();
		av.updateBidder();
		av.updateBidder();
		assertTrue(av.noBids());
	}
	
}
