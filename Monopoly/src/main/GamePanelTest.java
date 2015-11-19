package main;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GamePanelTest {

	public static MainWindow main;
	public static GamePanel game;
	
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
	}

	@After
	public void tearDown() throws Exception {
		main = null; game = null;
	}

	@Test
	/* testGamePanel()
	 * test that the game panel constructor runs properly, ie. the game
	 *  window is visible after the constructor runs
	 */
	public void testGamePanel() {
		main.flipCards();
		main.flipCards();
		assertTrue(game.isVisible());
	}

	@Test
	public void testOptionToBuy() {
		// player 0's turn
		// NOTE: for this test, select "YES" for buying the property
		int currBank = main.players[game.currPlayer].getBank();
		assertEquals(game.currPlayer, game.optionToBuy((Property)main.spaces.get(1)));
		assertEquals(game.currPlayer, ((Property)main.spaces.get(1)).getOwner());
		assertEquals(currBank - ((Property)main.spaces.get(1)).getPrice(), main.players[game.currPlayer].getBank());

		// NOTE: for this second assert, select "NO" for buying the property
		assertEquals(-1, game.optionToBuy((Property)main.spaces.get(3)));
		assertFalse(game.currPlayer == ((Property)main.spaces.get(3)).getOwner());
		
	}

	@Test
	/* testPayRent()
	 * make player 1 own space 1 and have player 0 pay rent on it
	 */
	public void testPayRent() {
		// current player is 0
		((Property)main.spaces.get(1)).setOwner(1);
		main.players[1].addProperty((Property)main.spaces.get(1));
		// check that player 0 pays $2 rent
		assertEquals(((Property)main.spaces.get(1)).getRent(), game.payRent((Property)main.spaces.get(1), 4));
		// check that player 0's bank has been reduced
		assertEquals(1500-((Property)main.spaces.get(1)).getRent(),main.players[0].getBank());
	}

	@Test
	public void testNextTurn() {
		// puts player 1 out of the game
		main.players[1].deductFromBank(1500, main.playersOut);
		// starting player is player 0 -- go to next turn
		game.nextTurn();
		assertEquals(2, game.currPlayer);
	}

	@Test
	public void testUpdateCurrentPlayer() {
		game.currPlayer = 2;
		Color n = new Color(238, 238, 238);
		Color y = new Color(153, 255, 153);
		Color out = new Color(200, 200, 200);
		game.updateCurrentPlayer();
		assertTrue( y.equals(game.panel_2.getBackground()));
		assertTrue( n.equals(game.panel.getBackground()));
		assertTrue( n.equals(game.panel_1.getBackground()));
		assertTrue( n.equals(game.panel_3.getBackground()));
		main.players[1].deductFromBank(1500, main.playersOut);
		game.updateCurrentPlayer();
		assertTrue( out.equals(game.panel_1.getBackground()));
		assertFalse( y.equals(game.panel_1.getBackground()));
	}

}
