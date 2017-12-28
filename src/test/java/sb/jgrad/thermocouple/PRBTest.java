package sb.jgrad.thermocouple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PRBTest {

    private PRB t;

    @Before
    public void setUp() {
        t = new PRB();
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
        Assert.assertEquals(0.0, t.value(0), EPS);
        Assert.assertEquals(0.431, t.value(300), EPS);
        Assert.assertEquals(1.792, t.value(600), EPS);
        Assert.assertEquals(3.957, t.value(900), EPS);
        Assert.assertEquals(6.786, t.value(1200), EPS);
        Assert.assertEquals(10.099, t.value(1500), EPS);
        Assert.assertEquals(13.820, t.value(1820), EPS);
    }

    @Test
    public void testTemp() {
        //Assert.assertEquals(300, t.temp(0.431), EPS);
        Assert.assertEquals(600, t.temp(1.792), 0.0025 * 600);
        Assert.assertEquals(900, t.temp(3.957), 0.0025 * 900);
        Assert.assertEquals(1200, t.temp(6.786), 0.0025 * 1200);
        Assert.assertEquals(1500, t.temp(10.099), 0.0025 * 1500);
        Assert.assertEquals(1820, t.temp(13.820), 0.0025 * 1820);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerTemp() {
        t.temp(-0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherTemp() {
        t.temp(13.900);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        t.value(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        t.value(1821);
    }
}
