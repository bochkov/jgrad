package sb.jgrad.thermometr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TSNTest {

    private TSN t;

    @Before
    public void setUp() {
        t = new TSN(100);
    }

    @Test
    public void testName() {
        Assert.assertEquals(t.name(), "100Н");
    }

    @Test
    public void testDescription() {
        Assert.assertNotNull(t.description());
    }

    @Test
    public void testValue() {
        double EPS = 0.05;
        Assert.assertEquals(69.45, t.value(-60), EPS);
        Assert.assertEquals(100.0, t.value(0), EPS);
        Assert.assertEquals(135.41, t.value(60), EPS);
        Assert.assertEquals(175.95, t.value(120), EPS);
        Assert.assertEquals(223.21, t.value(180), EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        //noinspection ResultOfMethodCallIgnored
        t.value(-61);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        //noinspection ResultOfMethodCallIgnored
        t.value(181);
    }

    @Test
    public void lowerHigherTest() {
        Assert.assertTrue(t.lower() < t.higher());
    }
}
