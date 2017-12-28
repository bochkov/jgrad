package sb.jgrad.thermocouple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MKMTest {

    private MKM t;

    @Before
    public void setUp() {
        t = new MKM();
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
        Assert.assertEquals(-6.154, t.value(-200), EPS);
        Assert.assertEquals(-3.715, t.value(-100), EPS);
        Assert.assertEquals(0.0, t.value(0), EPS);
        Assert.assertEquals(4.722, t.value(100), EPS);
    }

    @Test
    public void testTemp() {
        Assert.assertEquals(-200, t.temp(-6.154), 1.3 + 0.001 * 200);
        Assert.assertEquals(-150, t.temp(-5.111), 1.3 + 0.001 * 150);
        Assert.assertEquals(-100, t.temp(-3.715), 1.3 + 0.001 * 100);
        Assert.assertEquals(0, t.temp(0.0), 1.0);
        Assert.assertEquals(100, t.temp(4.722), 1.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerTemp() {
        t.temp(-7.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherTemp() {
        t.temp(5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        t.value(-201);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        t.value(101);
    }
}
