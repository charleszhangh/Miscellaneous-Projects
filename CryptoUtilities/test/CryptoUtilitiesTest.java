import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Put your name here
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("0", n.toString());
        assertEquals("0", m.toString());
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber m = new NaturalNumber2(21);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("3", n.toString());
        assertEquals("0", m.toString());
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("0", n.toString());
        assertTrue(result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("1", n.toString());
        assertTrue(!result);
    }

    @Test
    public void testIsEven_4() {
        NaturalNumber n = new NaturalNumber2(4);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("4", n.toString());
        assertTrue(result);
    }

    @Test
    public void testIsEven_33() {
        NaturalNumber n = new NaturalNumber2(33);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("33", n.toString());
        assertTrue(!result);
    }

    @Test
    public void testIsEven_100() {
        NaturalNumber n = new NaturalNumber2(100);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("100", n.toString());
        assertTrue(result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("0", p.toString());
        assertEquals("2", m.toString());
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("18", p.toString());
        assertEquals("19", m.toString());
    }

    @Test
    public void testPowerMod_10_7_5() {
        NaturalNumber n = new NaturalNumber2(10);
        NaturalNumber p = new NaturalNumber2(7);
        NaturalNumber m = new NaturalNumber2(5);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("0", n.toString());
        assertEquals("7", p.toString());
        assertEquals("5", m.toString());
    }

    @Test
    public void testPowerMod_2_3_15() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber p = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(15);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("8", n.toString());
        assertEquals("3", p.toString());
        assertEquals("15", m.toString());
    }

    @Test
    public void isWitnessToCompositeness_21_23() {
        NaturalNumber w = new NaturalNumber2(21);
        NaturalNumber n = new NaturalNumber2(23);
        boolean trueFalse = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertTrue(!trueFalse);
    }

    @Test
    public void isWitnessToCompositeness_3_18() {
        NaturalNumber w = new NaturalNumber2(3);
        NaturalNumber n = new NaturalNumber2(18);
        boolean trueFalse = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertTrue(trueFalse);
    }

    @Test
    public void isWitnessToCompositeness_7_53() {
        NaturalNumber w = new NaturalNumber2(7);
        NaturalNumber n = new NaturalNumber2(53);
        boolean trueFalse = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertTrue(!trueFalse);
    }

    @Test
    public void isPrime1_17() {
        NaturalNumber n = new NaturalNumber2(17);
        boolean trueFalse = CryptoUtilities.isPrime1(n);
        assertTrue(trueFalse);
    }

    @Test
    public void isPrime1_2() {
        NaturalNumber n = new NaturalNumber2(2);
        boolean trueFalse = CryptoUtilities.isPrime1(n);
        assertTrue(trueFalse);
    }

    @Test
    public void isPrime1_9973() {
        NaturalNumber n = new NaturalNumber2(9973);
        boolean trueFalse = CryptoUtilities.isPrime1(n);
        assertTrue(trueFalse);
    }

    @Test
    public void isPrime1_4() {
        NaturalNumber n = new NaturalNumber2(16);
        boolean trueFalse = CryptoUtilities.isPrime1(n);
        assertTrue(!trueFalse);
    }

    @Test
    public void isPrime1_82() {
        NaturalNumber n = new NaturalNumber2(82);
        boolean trueFalse = CryptoUtilities.isPrime1(n);
        assertTrue(!trueFalse);
    }

    @Test
    public void isPrime2_2() {
        NaturalNumber n = new NaturalNumber2(2);
        boolean trueFalse = CryptoUtilities.isPrime1(n);
        assertTrue(trueFalse);
    }

    @Test
    public void isPrime2_28() {
        NaturalNumber n = new NaturalNumber2(28);
        boolean trueFalse = CryptoUtilities.isPrime1(n);
        assertTrue(!trueFalse);
    }

    @Test
    public void isPrime2_7621() {
        NaturalNumber n = new NaturalNumber2(7621);
        boolean trueFalse = CryptoUtilities.isPrime1(n);
        assertTrue(trueFalse);
    }

    @Test
    public void generateNextLikelyPrime4() {
        NaturalNumber n = new NaturalNumber2(4);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("5", n.toString());
    }

    @Test
    public void generateNextLikelyPrime24() {
        NaturalNumber n = new NaturalNumber2(24);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("29", n.toString());
    }

}