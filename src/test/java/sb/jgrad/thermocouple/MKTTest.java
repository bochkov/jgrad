package sb.jgrad.thermocouple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MKTTest {

    private MKT t;

    @Before
    public void setUp() {
        t = new MKT();
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
        Assert.assertEquals(-6.258, t.value(-270), EPS);
        Assert.assertEquals(-1.819, t.value(-50), EPS);
        Assert.assertEquals(0.0, t.value(0), EPS);
        Assert.assertEquals(2.036, t.value(50), EPS);
        Assert.assertEquals(9.288, t.value(200), EPS);
        Assert.assertEquals(20.872, t.value(400), EPS);
    }

    @Test
    public void testTemp() {
        Assert.assertEquals(-200, t.temp(-5.603), 0.015 * 200);
        Assert.assertEquals(-50, t.temp(-1.819), 2.5);
        Assert.assertEquals(0, t.temp(0.0), 1.5);
        Assert.assertEquals(50, t.temp(2.036), 0.5);
        Assert.assertEquals(200, t.temp(9.288), 200 * 0.004);
        Assert.assertEquals(400, t.temp(20.872), 400 * 0.004);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerTemp() {
        t.temp(-7.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherTemp() {
        t.temp(21.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        t.value(-300);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        t.value(401);
    }
}
