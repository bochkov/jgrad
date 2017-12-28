package sb.jgrad.thermocouple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PPSTest {

    private PPS t;

    @Before
    public void setUp() {
        t = new PPS();
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
        Assert.assertEquals(-0.236, t.value(-50), EPS);
        Assert.assertEquals(0.0, t.value(0), EPS);
        Assert.assertEquals(2.323, t.value(300), EPS);
        Assert.assertEquals(5.239, t.value(600), EPS);
        Assert.assertEquals(8.449, t.value(900), EPS);
        Assert.assertEquals(11.951, t.value(1200), EPS);
        Assert.assertEquals(15.582, t.value(1500), EPS);
        Assert.assertEquals(17.947, t.value(1700), EPS);
        Assert.assertEquals(18.693, t.value(1768), EPS);
    }

    @Test
    public void testTemp() {
        //Assert.assertEquals(-50, t.temp(-0.235), EPS);
        //Assert.assertEquals(-40, t.temp(-0.194), EPS);
        //Assert.assertEquals(-10, t.temp(-0.053), EPS);
        Assert.assertEquals(0, t.temp(0.0), 1.0);
        Assert.assertEquals(300, t.temp(2.323), 1.0);
        Assert.assertEquals(600, t.temp(5.239), 1.0);
        Assert.assertEquals(900, t.temp(8.449), 1.0);
        Assert.assertEquals(1200, t.temp(11.951), 1.0 + 0.003 * (1200 - 1100));
        Assert.assertEquals(1500, t.temp(15.582), 1.0 + 0.003 * (1500 - 1100));
        Assert.assertEquals(1700, t.temp(17.947), 1.0 + 0.003 * (1700 - 1100));
        Assert.assertEquals(1768, t.temp(18.693), 1.0 + 0.003 * (1768 - 1100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerTemp() {
        t.temp(-0.236);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherTemp() {
        t.temp(19.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        t.value(-51);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        t.value(1800);
    }
}
