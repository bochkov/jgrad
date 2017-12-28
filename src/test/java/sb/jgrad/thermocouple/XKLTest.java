package sb.jgrad.thermocouple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XKLTest {

    private XKL t;

    @Before
    public void setUp() {
        t = new XKL();
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
        Assert.assertEquals(-9.488, t.value(-200), EPS);
        Assert.assertEquals(0.0, t.value(0), EPS);
        Assert.assertEquals(14.560, t.value(200), EPS);
        Assert.assertEquals(31.492, t.value(400), EPS);
        Assert.assertEquals(49.108, t.value(600), EPS);
        Assert.assertEquals(66.466, t.value(800), EPS);
    }

    @Test
    public void testTemp() {
        Assert.assertEquals(-200, t.temp(-9.488), 1.5 + 0.01 * 200);
        Assert.assertEquals(-190, t.temp(-9.203), 1.5 + 0.01 * 190);
        Assert.assertEquals(0, t.temp(0.0), 2.5);
        Assert.assertEquals(200, t.temp(14.560), 2.5);
        Assert.assertEquals(400, t.temp(31.492), 0.7 + 0.005 * 400);
        Assert.assertEquals(600, t.temp(49.108), 0.7 + 0.005 * 600);
        Assert.assertEquals(800, t.temp(66.466), 0.7 + 0.005 * 800);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerTemp() {
        t.temp(-10.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherTemp() {
        t.temp(67.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        t.value(-201);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        t.value(801);
    }
}
