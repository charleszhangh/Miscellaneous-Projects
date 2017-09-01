import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Charles Zhang
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires
     *
     *           <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     *           </pre>
     *
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";
        NaturalNumber answer = new NaturalNumber2(); //return value
        NaturalNumber firstnumber; //first child of xml tree
        NaturalNumber secondnumber; //second child of xml tree
        NaturalNumber zero = new NaturalNumber2();
        if (!exp.label().equals("number")) {
            firstnumber = evaluate(exp.child(0)); //evaluate its first child
            secondnumber = evaluate(exp.child(1)); //evaluate its second child
            /*
             * does various math operations based on the label of the node
             */
            if (exp.label().equals("plus")) {
                firstnumber.add(secondnumber);
                answer = new NaturalNumber2(firstnumber);
            } else if (exp.label().equals("minus")) {
                /*
                 * Checks if first number is greater or equal to the second
                 */
                if (firstnumber.compareTo(secondnumber) < 0) {
                    Reporter.fatalErrorToConsole("Error: answer is negative"); //terminates the program if answer is less than 0
                }
                firstnumber.subtract(secondnumber);
                answer = new NaturalNumber2(firstnumber);
            } else if (exp.label().equals("times")) {
                firstnumber.multiply(secondnumber);
                answer = new NaturalNumber2(firstnumber);
            } else if (exp.label().equals("divide")) {
                /*
                 * Checks if first number is being divided by zero
                 */
                if (secondnumber.equals(zero)) {
                    Reporter.fatalErrorToConsole("Error: Divided by zero"); //terminates the program and prints out the error message
                }
                firstnumber.divide(secondnumber);
                answer = new NaturalNumber2(firstnumber);
            }
        } else {
            answer = new NaturalNumber2(
                    Integer.parseInt(exp.attributeValue("value"))); //if the node label is number
        }
        return answer;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0))); //executes evaluate method
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }
        in.close();
        out.close();
    }

}