package sb.jgrad.thermocouple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XKnETest {

    private XKnE t;

    @Before
    public void setUp() {
        t = new XKnE();
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
        Assert.assertEquals(-9.835, t.value(-270), EPS);
        Assert.assertEquals(0.0, t.value(0), EPS);
        Assert.assertEquals(21.036, t.value(300), EPS);
        Assert.assertEquals(45.093, t.value(600), EPS);
        Assert.assertEquals(76.373, t.value(1000), EPS);
    }

    @Test
    public void testTemp() {
        Assert.assertEquals(-200, t.temp(-8.825), 0.015 * 200);
        Assert.assertEquals(0, t.temp(0.0), 1.5);
        Assert.assertEquals(300, t.temp(21.036), 1.5);
        Assert.assertEquals(600, t.temp(45.093), 0.004 * 600);
        Assert.assertEquals(1000, t.temp(76.373), 0.004 * 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerTemp() {
        t.temp(-10.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherTemp() {
        t.temp(80.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        t.value(-300);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        t.value(1001);
    }
}
