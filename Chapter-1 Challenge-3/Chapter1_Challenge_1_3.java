import java.util.Random;
import java.util.Scanner;

public class Chapter1_Challenge_1_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int health = 100; // Player starts with 100 HP

        // Simulate 5 rooms
        for (int room = 1; room <= 5; room++) {
            System.out.println("\nEntering room " + room + "...");

            int event = rand.nextInt(3) + 1; // Random event: 1, 2, or 3

            switch (event) {

                case 1: // Trap
                    health -= 20;
                    System.out.println("A trap sprung! Health is now " + health + ".");
                    break;

                case 2: // Healing potion
                    int oldHealth = health;
                    health += 15;

                    if (health > 100) {
                        System.out.println(
                            "You found a healing potion! Health is now "
                            + oldHealth + " -> capped to 100."
                        );
                        health = 100;
                    } else {
                        System.out.println(
                            "You found a healing potion! Health is now " + health + "."
                        );
                    }
                    break;

                case 3: // Monster encounter
                    System.out.println(
                        "A monster appears! Guess a number (1-5) to defeat it:"
                    );

                    int monsterNumber = rand.nextInt(5) + 1;
                    int guess;

                    do {
                        guess = sc.nextInt();
                        if (guess != monsterNumber) {
                            System.out.print("Wrong! Try again: ");
                        }
                    } while (guess != monsterNumber);

                    System.out.println("You defeated the monster!");
                    break;
            }

            // Check if player is dead
            if (health <= 0) {
                System.out.println("You have been defeated in room " + room + ".");
                break;
            }
        }

        // Final result
        if (health > 0) {
            System.out.println(
                "\nYou cleared the dungeon! Victorious with " + health + " health!"
            );
        }

        sc.close();
    }
}
