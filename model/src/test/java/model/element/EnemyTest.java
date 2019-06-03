package model.element;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import contract.model.Permeability;
import contract.model.SpriteType;
public class EnemyTest {
	private Enemy enemy;
	  @Before
	    public void setUp() throws Exception {
	        this.enemy = new Enemy(16,16);
	    }
	  
	@Test
	public void expectedMinX() {
		try {
			new Enemy(0,1*16);
			fail("The minimum x is supposed to be > 0");
		} catch (final Exception e) {
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void expectedMaxX() {
		try {
			new Enemy(24*16,1*16);
			fail("The maximum x is supposed to be < 24*16");
		} catch (final Exception e) {
			final String expected = "X out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void expectedMinY() {
		try {
			new Enemy(1*16,0);
			fail("The minimum y is supposed to be > 0");
		} catch (final Exception e) {
			final String expected = "Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}	
	
	@Test
	public void expectedMaxY() {
		try {
			new Enemy(1*16,24*16);
			fail("The maximum y is supposed to be < 24*16");
		} catch (final Exception e) {
			final String expected = "Y out of range";
			assertEquals(expected, e.getMessage());
		}
	}	
	
	@Test
	public void expectedType() {
		final SpriteType expected = SpriteType.ENEMY;	
		assertEquals(expected, enemy.getType());
	}

	@Test
	public void expectedPermeability() {
		final Permeability expected = Permeability.BLOCKING;	
		assertEquals(expected, enemy.getPermeability());
	}
}
