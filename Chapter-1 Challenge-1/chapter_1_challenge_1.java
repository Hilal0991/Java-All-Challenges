import java.util.Scanner;
public class chapter_1_challenge_1 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter the secret integer: ");
int n = sc.nextInt();
// Step 1: Determine the number of digits
int digits = (int) Math.log10(n);
// Step 2: Extract digits using division and modulus
int first = n / (int) Math.pow(10, digits); // First digit
int last = n % 10; // Last digit
int second = (n / (int) Math.pow(10, digits - 1)) % 10; // Second digit
int secondLast = (n / 10) % 10; // Second-last digit
// Step 3: Perform required operations
int product = first * last;
int sum = second + secondLast;
// Step 4: Concatenate results to form the final code
String finalCode = String.valueOf(product) +
String.valueOf(sum);
// Step 5: Output the decrypted code
System.out.println("The decrypted code is: " + finalCode);
sc.close();
}
}