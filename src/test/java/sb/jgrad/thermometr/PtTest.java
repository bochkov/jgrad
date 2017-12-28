package sb.jgrad.thermometr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PtTest {

    private Pt t;

    @Before
    public void setUp() {
        t = new Pt(100);
    }

    @Test
    public void testName() {
        Assert.assertEquals(t.name(), "Pt100");
    }

    @Test
    public void testDescription() {
        Assert.assertNotNull(t.description());
    }

    @Test
    public void testValue() {
        double EPS = 0.05;
        Assert.assertEquals(18.52, t.value(-200), EPS);
        Assert.assertEquals(60.26, t.value(-100), EPS);
        Assert.assertEquals(100.0, t.value(0), EPS);
        Assert.assertEquals(175.86, t.value(200), EPS);
        Assert.assertEquals(247.09, t.value(400), EPS);
        Assert.assertEquals(313.71, t.value(600), EPS);
        Assert.assertEquals(390.48, t.value(850), EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerValue() {
        //noinspection ResultOfMethodCallIgnored
        t.value(-201);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHigherValue() {
        //noinspection ResultOfMethodCallIgnored
        t.value(851);
    }

    @Test
    public void lowerHigherTest() {
        Assert.assertTrue(t.lower() < t.higher());
    }
}
