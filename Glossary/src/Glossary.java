import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program creates a glossary of words and definitions.
 *
 * @author Charles Zhang
 *
 */
public final class Glossary {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Glossary() {
    }

    /**
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     *
     * @param str
     *            the given {@code String}
     * @param strSet
     *            the {@code Set} to be replaced
     * @replaces strSet
     * @ensures strSet = entries(str)
     */
    public static void generateElements(String str, Set<Character> strSet) {
        assert str != null : "Violation of: str is not null";
        assert strSet != null : "Violation of: strSet is not null";
        for (int i = 0; i < str.length(); i++) {
            if (!strSet.contains(str.charAt(i))) {
                strSet.add(str.charAt(i));
            }
        }
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures
     *
     *          <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     *          </pre>
     */
    public static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        assert text != null : "Violation of: text is not null";
        assert separators != null : "Violation of: separators is not null";
        assert 0 <= position : "Violation of: 0 <= position";
        assert position < text.length() : "Violation of: position < |text|";

        boolean sep = false;
        String nextWord = "";
        char nextChar;
        int lastPosition = position;
        if (separators.contains(text.charAt(position))) { //if starts w a sep, then the next word is the sep
            nextWord = Character.toString(text.charAt(position));
        } else {
            while (!sep && lastPosition < text.length()) {
                nextChar = text.charAt(lastPosition);
                if (!separators.contains(nextChar)) {
                    lastPosition++; //last position of the word
                } else {
                    sep = true;
                }

            }
            nextWord = text.substring(position, lastPosition);
        }
        return nextWord;
    }

    /**
     * Outputs the header of the HTML page
     *
     *
     * @param out
     *            to output code into a new file
     */
    public static void outputHeader(SimpleWriter out) {
        int position = 0;
        out.println("<html>");
        out.println("<head><script id=\"\" src=\"\"></script>");
        out.println("<title> Glossary </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Glossary</h2>");
        out.println("<hr />");
        out.println("<h3>Index</h3>");
        out.println("<u1>");
    }

    /**
     * Outputs the footer of the HTML page
     *
     * @param out
     *            to output text into a new file
     * @param strSet
     *            the {@code Set} to be replaced
     */
    public static void outputFooter(SimpleWriter out) {
        out.println("</u1>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Compare {@code String}s in lexicographic order.
     */
    public static class StringLT implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    /**
     * Sorts the code and puts the strings in alphabetical order
     *
     * @param words
     *            a list of the words that can be sorted alphabetically
     * @param wordDefs
     *            a map of words and definitions
     *
     * @replaces wordDefs replaced by a sorted version of itself
     */
    public static void sort(Queue<String> words, Map<String, String> wordDefs) {
        Map<String, String> temp = new Map1L<>();
        Comparator<String> qi = new StringLT();
        words.sort(qi);//sorts the queue
        int count = 0;
        while (count < words.length()) { //sorts the Map in the same order as the queue
            String front = words.dequeue();
            if (wordDefs.hasKey(front)) {
                String definition = wordDefs.value(front);
                temp.add(front, definition);
            }
            count++;
        }
        wordDefs.transferFrom(temp);
    }

    /**
     * Outputs the code for one word HTML page
     *
     * @param word
     *            The word that is being defined
     * @param definition
     *            The definition of the word
     *
     * @param out
     *            to output text into a new file
     */
    public static void processOneWord(String word, String definition,
            SimpleWriter out) {
        out.println("<html>");
        out.println("<head><script id=\"\" src=\"\"></script>");
        out.println("<title>" + word + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2><b><i><font color = \"red\">book</font></i></b></h2>");
        out.println("<blockquote>" + definition + "</blockquote>");
        out.println("<hr />");
        out.println("<p>Return to <a href=\"index\">index</a>.</p>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Creates the body of the HTML page for the glossary
     *
     * @param text
     *            The words and defs that are being included in the glossary
     * @param out
     *            to output text into the HTML file
     */
    public static void processWords(String text, SimpleWriter out) {
        int position = 0;
        Set<Character> sep = new Set1L<>();
        sep.add('\n');
        Map<String, String> wordDefs = new Map1L<>();
        Queue<String> wordList = new Queue1L<>();
        SimpleReader input = new SimpleReader1L(text);
        int count = 0;
        String word = "";
        String definition = "";
        while (!input.atEOS()) {
            String singleLine = input.nextLine();
            if (!singleLine.equals("")) {
                if (count == 0) { //first line of word-definition pair
                    word = singleLine;
                } else {
                    definition += singleLine;
                }
                count++;
            } else { //any line after is part of the definition
                wordDefs.add(word, definition);
                wordList.enqueue(word);
                word = "";
                definition = "";
                count = 0;
            }
        }

        sort(wordList, wordDefs); //puts wordDefs in alphabetical order

        for (Map.Pair<String, String> s : wordDefs) {
            SimpleWriter jOut = new SimpleWriter1L(s.key());
            processOneWord(s.key(), s.value(), jOut);
            out.println(
                    "<li><a href=\"" + s.key() + "\">" + s.key() + "</a></li>");
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();

        out.println("Please input the text file:");
        String input = in.nextLine();
        SimpleWriter fOut = new SimpleWriter1L("Index");//creates new file

        outputHeader(fOut);//executes the outputHeader method
        processWords(input, fOut);
        outputFooter(fOut);//closes the HTML tags

        out.println("Your glossary has been created.");
        in.close();
        out.close();

    }

}
