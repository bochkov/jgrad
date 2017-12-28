package sb.jgrad.thermometr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TSMTest {

    private TSM t;

    @Before
    public void setUp() {
        t = new TSM(100);
    }

    @Test
    public void testName() {
        Assert.assertEquals(t.name(), "100М");
    }

    @Test
    public void testDescription() {
        Assert.assertNotNull(t.description());
    }

    @Test
    public void testValue() {
        double EPS = 0.05;
        Assert.assertEquals(78.46, t.value(-50), EPS);
        Assert.assertEquals(100.0, t.value(0), EPS);
        Assert.assertEquals(121.40, t.value(50), EPS);
        Assert.assertEquals(142.80, t.value(100), EPS);
        Assert.assertEquals(164.20, t.value(150), EPS);
        Assert.assertEquals(185.60, t.value(200), EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        //noinspection ResultOfMethodCallIgnored
        t.value(-51);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        //noinspection ResultOfMethodCallIgnored
        t.value(201);
    }

    @Test
    public void lowerHigherTest() {
        Assert.assertTrue(t.lower() < t.higher());
    }
}
