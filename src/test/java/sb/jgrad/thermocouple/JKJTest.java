package sb.jgrad.thermocouple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JKJTest {

    private JKJ t;

    @Before
    public void setUp() {
        t = new JKJ();
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
        Assert.assertEquals(-8.095, t.value(-210), EPS);
        Assert.assertEquals(0.0, t.value(0), EPS);
        Assert.assertEquals(16.327, t.value(300), EPS);
        Assert.assertEquals(33.102, t.value(600), EPS);
        Assert.assertEquals(51.877, t.value(900), EPS);
        Assert.assertEquals(69.553, t.value(1200), EPS);
    }

    @Test
    public void testTemp() {
        //Assert.assertEquals(-210, t.temp(-8.095), 1.5);
        Assert.assertEquals(0, t.temp(0.0), 1.5);
        Assert.assertEquals(300, t.temp(16.327), 1.5);
        Assert.assertEquals(600, t.temp(33.102), 600 * 0.004);
        Assert.assertEquals(900, t.temp(51.877), 900 * 0.004);
        Assert.assertEquals(1200, t.temp(69.553), 1200 * 0.004);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerTemp() {
        t.temp(-9.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherTemp() {
        t.temp(70.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        t.value(-211);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        t.value(1201);
    }
}
