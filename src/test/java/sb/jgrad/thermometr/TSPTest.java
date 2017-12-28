package sb.jgrad.thermometr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TSPTest {

    private TSP t;

    @Before
    public void setUp() {
        t = new TSP(100);
    }

    @Test
    public void testName() {
        Assert.assertEquals(t.name(), "100П");
    }

    @Test
    public void testDescription() {
        Assert.assertNotNull(t.description());
    }

    @Test
    public void testValue() {
        double EPS = 0.05;
        Assert.assertEquals(17.24, t.value(-200), EPS);
        Assert.assertEquals(59.64, t.value(-100), EPS);
        Assert.assertEquals(100.0, t.value(0), EPS);
        Assert.assertEquals(177.04, t.value(200), EPS);
        Assert.assertEquals(249.41, t.value(400), EPS);
        Assert.assertEquals(317.11, t.value(600), EPS);
        Assert.assertEquals(395.16, t.value(850), EPS);
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
