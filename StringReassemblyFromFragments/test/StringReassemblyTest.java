import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;

public class StringReassemblyTest {

    @Test
    public void combination_a_a() {
        String n = "a";
        String m = "a";
        String con = StringReassembly.combination(n, m, 1);
        assertEquals("a", con);
    }

    @Test
    public void combination_Hello_Charles() {
        String n = "Hello, my name";
        String m = "name is Charles.";
        String con = StringReassembly.combination(n, m, 4);
        assertEquals("Hello, my name is Charles.", con);
    }

    @Test
    public void combination_Superh_rhero() {
        String n = "Superh";
        String m = "rhero";
        String con = StringReassembly.combination(n, m, 2);
        assertEquals("Superhero", con);
    }

    @Test
    public void addToSetAvoidingSubstrings1() {
        Set<String> strSet = new Set1L<>();
        String[] objects = { "cat", "dog", "pig" };
        for (int i = 0; i < objects.length; i++) {
            strSet.add(objects[i]);
        }

        String str = "dogg";
        Set<String> strSet2 = new Set1L<>();
        String[] objects2 = { "cat", "pig", "dogg" };
        for (int i = 0; i < objects2.length; i++) {
            strSet2.add(objects2[i]);
        }
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals(strSet2, strSet);
    }

    @Test
    public void addToSetAvoidingSubstrings2() {
        Set<String> strSet = new Set1L<>();
        String[] objects = { "cat", "dog", "pig" };
        for (int i = 0; i < objects.length; i++) {
            strSet.add(objects[i]);
        }

        String str = "do";
        Set<String> strSet2 = new Set1L<>();
        String[] objects2 = { "cat", "dog", "pig" };
        for (int i = 0; i < objects2.length; i++) {
            strSet2.add(objects2[i]);
        }
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals(strSet2, strSet);
    }

    @Test
    public void addToSetAvoidingSubstrings3() {
        Set<String> strSet = new Set1L<>();
        String[] objects = { "cat", "dog", "pig" };
        for (int i = 0; i < objects.length; i++) {
            strSet.add(objects[i]);
        }

        String str = "donkey";
        Set<String> strSet2 = new Set1L<>();
        String[] objects2 = { "cat", "dog", "pig", "donkey" };
        for (int i = 0; i < objects2.length; i++) {
            strSet2.add(objects2[i]);
        }
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals(strSet2, strSet);
    }

    @Test
    public void addToSetAvoidingSubstrings4() {
        Set<String> strSet = new Set1L<>();
        String[] objects = { "cat", "catt", "pig" };
        for (int i = 0; i < objects.length; i++) {
            strSet.add(objects[i]);
        }

        String str = "pigg";
        Set<String> strSet2 = new Set1L<>();
        String[] objects2 = { "catt", "pigg" };
        for (int i = 0; i < objects2.length; i++) {
            strSet2.add(objects2[i]);
        }
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals(strSet2, strSet);
    }

}
