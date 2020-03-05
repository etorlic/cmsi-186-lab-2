public class PiEstimator {

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException("Exactly one argument required");
            }
            int darts = Integer.parseInt(args[0]);
            System.out.println(estimate(darts)); //Parses the command line argument and calls your estimate function
        } catch (NumberFormatException e) {
              System.err.println("Argument must be an integer"); // Takes care of a possible non-integer argument.
        } catch (IllegalArgumentException e) {
              System.err.println(e.getMessage()); //Takes care of the exception thrown above.
        }
    }

    public static double estimate(int darts)
    {
        if (darts < 1)
            throw new IllegalArgumentException("At least one dart required");

        int insideDarts = 0;

        for (int i = 0; i < darts; i++) {
            if (Math.hypot(Math.random(), Math.random()) <= 1) {
                insideDarts++;
            }
        }
        return (double)insideDarts/darts * 4;
    }
}
