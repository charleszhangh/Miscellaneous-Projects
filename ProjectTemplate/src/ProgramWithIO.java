import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 * 
 * @author Put your name here
 * 
 */
public final class ProgramWithIO {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramWithIO() {
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
        double input;
        double w, x, y, z;
        double a = 0, b = 0, c = 0, d = 0;
        double[] abcd = { -5, -4, -3, -2, -1, -1 / 2, -1 / 3, -1 / 4, 0, 1 / 4,
                1 / 3, 1 / 2, 1, 2, 3, 4, 5 };
        double product = 0;
        double error = 1;
        double lowesterror = 1;
        out.print("Please enter a constant to approximate:");
        input = in.nextDouble();
        out.print("Please enter a constant w:");
        w = in.nextDouble();
        out.print("Please enter a constant x:");
        x = in.nextDouble();
        out.print("Please enter a constant y:");
        y = in.nextDouble();
        out.print("Please enter a constant z:");
        z = in.nextDouble();
        int counta = 0, countb = 0, countc = 0, countd = 0;
        while (counta < 17) {
            while (countb < 17) {
                while (countc < 17) {
                    while (countd < 17) {
                        product = Math.pow(w, abcd[counta])
                                * Math.pow(x, abcd[countb])
                                * Math.pow(y, abcd[countc])
                                * Math.pow(z, abcd[countd]);
                        error = (product - input) / input;
                        if (error < lowesterror) {
                            lowesterror = error;
                            a = counta;
                            b = countb;
                            c = countc;
                            d = countd;
                        }
                        countd++;
                    }
                    countc++;
                }
                countb++;
            }
            counta++;
        }
        out.println("The values of a,b,c,d:");
        out.println("a: " + a);
        out.println("b: " + b);
        out.println("c: " + c);
        out.println("d: " + d);
        out.println("De Jager Product: " + product);
        out.println("Relative Error: %d%.2" + 100 * error + "%");
        in.close();
        out.close();
    }

}
