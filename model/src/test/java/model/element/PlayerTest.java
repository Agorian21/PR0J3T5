package model.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import contract.model.Permeability;
import contract.model.SpriteType;
public class PlayerTest {
	private Player player;
	  @Before
	    public void setUp() throws Exception {
	        this.player = new Player(16,16);
	    }
	  
	@Test
	public void expectedMinX() {
		try {
			new Player(0,1*16);
			fail("The minimum x is supposed to be > 0");
		} catch (final Exception e) {
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void expectedMaxX() {
		try {
			new Player(24*16,1*16);
			fail("The maximum x is supposed to be < 24*16");
		} catch (final Exception e) {
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void expectedMinY() {
		try {
			new Player(1*16,0);
			fail("The minimum y is supposed to be > 0");
		} catch (final Exception e) {
			final String expected = "Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}	
	
	@Test
	public void expectedMaxY() {
		try {
			new Player(1*16,24*16);
			fail("The maximum y is supposed to be < 24*16");
		} catch (final Exception e) {
			final String expected = "Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}	
	
	@Test
	public void expectedType() {
		final SpriteType expected = SpriteType.PLAYER;	
		assertEquals(expected, player.getType());
	}

	@Test
	public void expectedPermeability() {
		final Permeability expected = Permeability.BLOCKING;	
		assertEquals(expected, player.getPermeability());
	}
}
