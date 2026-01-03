public class Chapter_1_Challenge_2 {
    public static void main(String[] args) {

        String[] winningNumbers = {
            "12-34-56-78-90",
            "33-44-11-66-22",
            "01-02-03-04-05",
        };

        double highestAverage = 0;
        String winningTicket = "";

        for (String ticket : winningNumbers) {
            System.out.println("Analyzing: " + ticket);

            String noDash = ticket.replace("-", "");
            char[] digits = noDash.toCharArray();
            int[] numArray = new int[digits.length];

            for (int i = 0; i < digits.length; i++) {
                numArray[i] = Character.getNumericValue(digits[i]);
            }

            int sum = 0;
            for (int num : numArray) {
                sum += num;
            }

            double average = (double) sum / numArray.length;

            System.out.println("Digit Sum: " + sum + ", Digit Average: " + average);

            if (average > highestAverage) {
                highestAverage = average;
                winningTicket = ticket;
            }
        }

        System.out.println(
            "The winning number with the highest average is: "
            + winningTicket + " with an average of " + highestAverage
        );
    }
}
