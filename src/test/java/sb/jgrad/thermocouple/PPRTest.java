package sb.jgrad.thermocouple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PPRTest {

    private PPR t;

    @Before
    public void setUp() {
        t = new PPR();
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
        Assert.assertEquals(-0.226, t.value(-50), EPS);
        Assert.assertEquals(0.0, t.value(0), EPS);
        Assert.assertEquals(2.401, t.value(300), EPS);
        Assert.assertEquals(5.583, t.value(600), EPS);
        Assert.assertEquals(9.205, t.value(900), EPS);
        Assert.assertEquals(13.228, t.value(1200), EPS);
        Assert.assertEquals(17.451, t.value(1500), EPS);
        Assert.assertEquals(20.222, t.value(1700), EPS);
        Assert.assertEquals(21.101, t.value(1768), EPS);
    }

    @Test
    public void testTemp() {
        //Assert.assertEquals(-50, t.temp(-0.226), EPS);
        //Assert.assertEquals(-30, t.temp(-0.145), EPS);
        //Assert.assertEquals(-10, t.temp(-0.051), EPS);
        Assert.assertEquals(0, t.temp(0.0), 1.0);
        Assert.assertEquals(300, t.temp(2.401), 1.0);
        Assert.assertEquals(600, t.temp(5.583), 1.0);
        Assert.assertEquals(900, t.temp(9.205), 1.0);
        Assert.assertEquals(1200, t.temp(13.228), 1.0 + 0.003 * (1200 - 1100));
        Assert.assertEquals(1500, t.temp(17.451), 1.0 + 0.003 * (1500 - 1100));
        Assert.assertEquals(1700, t.temp(20.222), 1.0 + 0.003 * (1700 - 1100));
        Assert.assertEquals(1768, t.temp(21.101), 1.0 + 0.003 * (1768 - 1100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerTemp() {
        t.temp(-0.3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherTemp() {
        t.temp(21.200);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        t.value(-51);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        t.value(1780);
    }
}
