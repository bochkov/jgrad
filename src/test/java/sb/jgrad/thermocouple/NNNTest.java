package sb.jgrad.thermocouple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NNNTest {

    private NNN t;

    @Before
    public void setUp() {
        t = new NNN();
    }

    @Test
    public void testName() {
        Assert.assertNotNull(t.name());
        Assert.assertFalse(t.name().isEmpty());
    }

    @Test
    public void testDescription() {
        Assert.assertNotNull(t.description());
        Assert.assertFalse(t.description().isEmpty());
    }

    @Test
    public void testValue() {
        double EPS = 0.001;
        Assert.assertEquals(-4.345, t.value(-270), EPS);
        Assert.assertEquals(-3.990, t.value(-200), EPS);
        Assert.assertEquals(0.0, t.value(0), EPS);
        Assert.assertEquals(9.341, t.value(300), EPS);
        Assert.assertEquals(20.613, t.value(600), EPS);
        Assert.assertEquals(32.371, t.value(900), EPS);
        Assert.assertEquals(43.846, t.value(1200), EPS);
        Assert.assertEquals(47.513, t.value(1300), EPS);
    }

    @Test
    public void testTemp() {
        Assert.assertEquals(-200, t.temp(-3.990), 0.015 * 200);
        Assert.assertEquals(0, t.temp(0.0), 1.5);
        Assert.assertEquals(300, t.temp(9.341), 1.5);
        Assert.assertEquals(600, t.temp(20.613), 600 * 0.004);
        Assert.assertEquals(900, t.temp(32.371), 900 * 0.004);
        Assert.assertEquals(1200, t.temp(43.846), 1200 * 0.004);
        Assert.assertEquals(1300, t.temp(47.513), 1300 * 0.004);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerTemp() {
        t.temp(-5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherTemp() {
        t.temp(50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        t.value(-271);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        t.value(1301);
    }
}
