package sb.jgrad.thermometr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ThermometrTest {

    private TSM t;

    @Before
    public void setUp() {
        t = new TSM(100);
    }

    @Test
    public void testTemp() {
        double EPS = 0.05;
        Assert.assertEquals(-50, t.temp(78.46), EPS);
        Assert.assertEquals(0, t.temp(100.0), EPS);
        Assert.assertEquals(50, t.temp(121.40), EPS);
        Assert.assertEquals(100, t.temp(142.80), EPS);
        Assert.assertEquals(150, t.temp(164.20), EPS);
        Assert.assertEquals(200, t.temp(185.60), EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        t.temp(-51);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        t.temp(201);
    }
}
