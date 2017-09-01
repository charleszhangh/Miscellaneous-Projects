import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program uses the de Jager formula to calculate an inputed number.
 *
 * @author Charles Zhang
 *
 */
final class ABCDGuesser2 {
    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser2() {
    }

    /**
     * private method that uses the de Jager formula to calculate an inputed
     * value using four other inputed values.
     *
     * @param input
     *            the number that is trying to be reached using the four other
     *            numbers
     * @param w
     *            the first base value
     * @param x
     *            the second base value
     * @param y
     *            the third base value
     * @param z
     *            the fourth base value
     */
    private static void deJagerFormula(double input, double w, double x,
            double y, double z) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        double a = 0, b = 0, c = 0, d = 0;//4 exponent values
        double[] abcd = { -5, -4, -3, -2, -1, -.5, -(1 / 3), -(1 / 4), 0,
                (1 / 4), (1 / 3), (1 / 2), 1, 2, 3, 4, 5 };//set of all possible abcd values
        double product = 0;//initial value for product after using the de Jager formula
        double finalproduct = 0;//most accurate product
        double error = 1;
        double lowesterror = 1;//error of most accurate product
        int counta, countb, countc, countd;//counters for 4 for loops
        for (counta = 0; counta < 17; counta++) {//for loops go though every possible combination of a,b,c,d
            for (countb = 0; countb < 17; countb++) {
                for (countc = 0; countc < 17; countc++) {
                    for (countd = 0; countd < 17; countd++) {
                        product = Math.pow(w, abcd[counta])//de Jager's formula
                                * Math.pow(x, abcd[countb])
                                * Math.pow(y, abcd[countc])
                                * Math.pow(z, abcd[countd]);
                        error = Math.abs((product - input) / input);//error formula
                        if (error < lowesterror) {//changes lowesterror and final product if it's closest to true value
                            lowesterror = error;
                            finalproduct = product;
                            a = abcd[counta];
                            b = abcd[countb];
                            c = abcd[countc];
                            d = abcd[countd];
                        }
                    }
                }
            }
        }
        out.println("The values of a,b,c,d:");//outputs all values
        out.println("a: " + a);
        out.println("b: " + b);
        out.println("c: " + c);
        out.println("d: " + d);
        out.println("De Jager Product: " + String.format("%.0f", finalproduct));
        out.println("Relative Error: "
                + String.format("%.2f", 100 * lowesterror) + "%");//outputs error with 2 decimal places
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
        double input;//number that needs to be reached
        double w, x, y, z;//4 base values
        out.print("Please enter a constant to approximate:");//asks user for w,x,y,z
        input = in.nextDouble();
        out.print("Please enter a constant w:");
        w = in.nextDouble();
        out.print("Please enter a constant x:");
        x = in.nextDouble();
        out.print("Please enter a constant y:");
        y = in.nextDouble();
        out.print("Please enter a constant z:");
        z = in.nextDouble();
        deJagerFormula(input, w, x, y, z);//utilized the de Jager method

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}
