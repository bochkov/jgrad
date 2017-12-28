package sb.jgrad.thermocouple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VRA3Test {

    private VRA3 t;

    @Before
    public void setUp() {
        t = new VRA3();
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
        Assert.assertEquals(4.470, t.value(300), EPS);
        Assert.assertEquals(9.506, t.value(600), EPS);
        Assert.assertEquals(14.411, t.value(900), EPS);
        Assert.assertEquals(18.981, t.value(1200), EPS);
        Assert.assertEquals(23.106, t.value(1500), EPS);
        Assert.assertEquals(26.773, t.value(1800), EPS);
    }

    @Test
    public void testTemp() {
        //Assert.assertEquals(0, t.temp(0.0), EPS);
        //Assert.assertEquals(300, t.temp(4.470), EPS);
        //Assert.assertEquals(600, t.temp(9.506), EPS);
        //Assert.assertEquals(900, t.temp(14.411), EPS);
        Assert.assertEquals(1200, t.temp(18.981), 1200 * 0.005);
        Assert.assertEquals(1500, t.temp(23.106), 1500 * 0.005);
        Assert.assertEquals(1800, t.temp(26.773), 1800 * 0.005);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerTemp() {
        t.temp(-0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherTemp() {
        t.temp(27.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        t.value(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        t.value(1801);
    }
}
