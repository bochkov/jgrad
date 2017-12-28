package sb.jgrad.thermocouple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XAKTest {

    private XAK t;

    @Before
    public void setUp() {
        t = new XAK();
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
        Assert.assertEquals(-6.458, t.value(-270), EPS);
        Assert.assertEquals(-3.554, t.value(-100), EPS);
        Assert.assertEquals(0.0, t.value(0), EPS);
        Assert.assertEquals(12.209, t.value(300), EPS);
        Assert.assertEquals(24.905, t.value(600), EPS);
        Assert.assertEquals(37.326, t.value(900), EPS);
        Assert.assertEquals(48.838, t.value(1200), EPS);
        Assert.assertEquals(54.886, t.value(1372), EPS);
    }

    @Test
    public void testTemp() {
        Assert.assertEquals(-200, t.temp(-5.891), 0.015 * 200);
        Assert.assertEquals(-100, t.temp(-3.554), 2.5);
        Assert.assertEquals(0, t.temp(0.0), 1.5);
        Assert.assertEquals(300, t.temp(12.209), 1.5);
        Assert.assertEquals(600, t.temp(24.905), 0.004 * 600);
        Assert.assertEquals(900, t.temp(37.326), 0.004 * 900);
        Assert.assertEquals(1200, t.temp(48.838), 0.004 * 1200);
        Assert.assertEquals(1372, t.temp(54.886), 0.004 * 1372);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerTemp() {
        t.temp(-7.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherTemp() {
        t.temp(55.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        t.value(-271);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        t.value(1373);
    }
}
