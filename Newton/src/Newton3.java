import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program calculates outputs the square root of a number the user inputs.
 *
 * @author Charles Zhang
 *
 */
public final class Newton3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton3() {
    }

    /**
     * Calculates the square root of the user-inputted number.
     */
    private static double sqrt(double x, double e) {
        double root = x;
        double error = (Math.pow(root, 2) - x) / x;
        double n = Math.pow(e, 2);
        while (error > n) {
            root = (root + x / root) / 2;
            error = (Math.pow(root, 2) - x) / x;
        }
        return root;
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
        out.print("What would you like the error value to be?");
        double errorValue = in.nextDouble();
        String yesNo = "y";
        while (yesNo.equals("y")) {
            out.print("Input the number you'd like the calculate the root of:");
            double input = in.nextDouble();
            double root = sqrt(input, errorValue);
            out.println("The root is: " + root);
            out.println(
                    "Would you like to calculate the root of another number?(y for yes)");
            yesNo = in.nextLine();
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
