package model.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import contract.model.Permeability;
import contract.model.SpriteType;
public class BoulderTest {
	private Boulder boulder;
	  @Before
	    public void setUp() throws Exception {
	        this.boulder = new Boulder(1,1);
	    }
	  
	@Test
	public void expectedMinX() {
		try {
			new Boulder(0,1);
			fail("The minimum x is supposed to be > 0");
		} catch (final Exception e) {
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void expectedMaxX() {
		try {
			new Boulder(24,1);
			fail("The maximum x is supposed to be < 24");
		} catch (final Exception e) {
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void expectedMinY() {
		try {
			new Boulder(1,0);
			fail("The minimum y is supposed to be > 0");
		} catch (final Exception e) {
			final String expected = "Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}	
	
	@Test
	public void expectedMaxY() {
		try {
			new Boulder(1,24);
			fail("The maximum y is supposed to be < 24");
		} catch (final Exception e) {
			final String expected = "Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}	
	
	@Test
	public void expectedType() {
		final SpriteType expected = SpriteType.BOULDER;	
		assertEquals(expected, boulder.getType());
	}

	@Test
	public void expectedPermeability() {
		final Permeability expected = Permeability.BLOCKING;	
		assertEquals(expected, boulder.getPermeability());
	}
}
