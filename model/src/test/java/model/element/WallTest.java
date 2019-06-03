package model.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import contract.model.Permeability;
import contract.model.SpriteType;
public class WallTest {
	private Wall wall;
	  @Before
	    public void setUp() throws Exception {
	        this.wall = new Wall(0,0);
	    }
	  
	@Test
	public void expectedMinX() {
		try {
			new Wall(-1*16,0);
			fail("The minimum x is supposed to be >= 0");
		} catch (final Exception e) {
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void expectedMaxX() {
		try {
			new Wall(25*16,1*16);
			fail("The maximum x is supposed to be <= 24*16");
		} catch (final Exception e) {
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void expectedMinY() {
		try {
			new Wall(0,-1*16);
			fail("The minimum y is supposed to be >= 0");
		} catch (final Exception e) {
			final String expected = "Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}	
	
	@Test
	public void expectedMaxY() {
		try {
			new Wall(0,25*16);
			fail("The maximum y is supposed to be <= 24*16");
		} catch (final Exception e) {
			final String expected = "Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}	
	
	@Test
	public void expectedType() {
		final SpriteType expected = SpriteType.WALL;	
		assertEquals(expected, wall.getType());
	}

	@Test
	public void expectedPermeability() {
		final Permeability expected = Permeability.BLOCKING;	
		assertEquals(expected, wall.getPermeability());
	}
}
