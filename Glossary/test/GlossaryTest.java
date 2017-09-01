import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

public class GlossaryTest {

    @Test
    public void nextWordOrSeparator1() {
        SimpleReader input = new SimpleReader1L("data/terms.txt");
        String text = input.nextLine();
        Set<Character> sep = new Set1L<>();
        sep.add('\n');
        String firstLine = Glossary.nextWordOrSeparator(text, 0, sep);

        assertEquals(firstLine, "meaning");
    }

}
