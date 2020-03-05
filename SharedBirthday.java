public class SharedBirthday {

    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                throw new IllegalArgumentException("Exactly three arguments required");
            }
            int people = Integer.parseInt(args[0]);
            int days = Integer.parseInt(args[1]);
            int trials = Integer.parseInt(args[2]);
            System.out.println(probabilityEstimate(people, days, trials));
        } catch (NumberFormatException e) {
            System.err.println("Arguments must all be integers");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static double probabilityEstimate(int people, int days, int trials) {
        if (people < 2)
            throw new IllegalArgumentException("At least two people required");
        if (days < 1)
            throw new IllegalArgumentException("At least one day required");
        if (trials < 1)
            throw new IllegalArgumentException("At least one trial required");

        var numShared = 0;

        for (int i = 0; i < trials; i++) {
            if (randTrialHasSharedBirthday(people, days, trials)) {
                numShared++;
            }
        }
        return (double)numShared / trials;
    }

    private static boolean randTrialHasSharedBirthday(int people, int days, int trials) {
        int[] randomBirthdays = new int[people];
        for (int i = 0; i < people; i++) {
            randomBirthdays[i] = (int)(Math.random() * days); //creates an array with random days
        }

        var counter = 0; //counts how many numbers equal each other in an array

        for (int i = 0; i < randomBirthdays.length; i++) {
            for (int v = 0; v < randomBirthdays.length; v++) {
                if (randomBirthdays[i] == randomBirthdays[v]) {
                    counter++;
                    if (i == v)
                        counter--;
                }
            }
        }
        if (counter > 0)
            return true;
        else
            return false;
    }
}
