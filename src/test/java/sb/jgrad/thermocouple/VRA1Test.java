package sb.jgrad.thermocouple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VRA1Test {

    private VRA1 t;

    @Before
    public void setUp() {
        t = new VRA1();
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
        Assert.assertEquals(7.908, t.value(500), EPS);
        Assert.assertEquals(16.128, t.value(1000), EPS);
        Assert.assertEquals(23.311, t.value(1500), EPS);
        Assert.assertEquals(29.186, t.value(2000), EPS);
        Assert.assertEquals(33.640, t.value(2500), EPS);
    }

    @Test
    public void testTemp() {
        //Assert.assertEquals(0, t.temp(0.0), EPS);
        //Assert.assertEquals(500, t.temp(7.908), EPS);
        Assert.assertEquals(1000, t.temp(16.128), 1000 * 0.005);
        Assert.assertEquals(1500, t.temp(23.311), 1500 * 0.005);
        Assert.assertEquals(2000, t.temp(29.186), 2000 * 0.005);
        Assert.assertEquals(2500, t.temp(33.640), 2500 * 0.005);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerTemp() {
        t.temp(-0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherTemp() {
        t.temp(35.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        t.value(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        t.value(2501);
    }
}
