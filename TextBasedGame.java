import java.util.Random;
import java.util.Scanner;

public class TextBasedGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		//Enemy Variable
		String[] enemies = {"Zombie", "Skeleton", "Warrior", "Assassin"};
		int maxHealth = 75;
		int enemyAttackDamage = 25;
		int enemyDefeated = 0;

		//Player Variable
		int health = 100;
		int attackDamage = 30;
		int numHealthPotions = 3;
		int healthPotionHealAmount = 40;
		int healthPotionDropChance = 50; //Percentage

		boolean running = true;

		System.out.println("---Welcome to Dungeon!---");

		while (running){
			System.out.println("-------------------------");

			int enemyHealth = rand.nextInt(maxHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("# " + enemy + " has appeared! #");

			GAME:
			while (enemyHealth > 0) {
				System.out.println("Your HP: " + health);
				System.out.println(enemy + "'s HP: " + enemyHealth);
				System.out.println("\n");
				System.out.println("What would you like to do?");
				System.out.println("1. Attack");
				System.out.println("2. Use Potion");
				System.out.println("3. Run");
				System.out.println();

				String input = sc.nextLine();

				if(input.equals("1")) {
						int damageDealt = rand.nextInt(attackDamage);
						int damageTaken = rand.nextInt(enemyAttackDamage);

						enemyHealth -= damageDealt;
						health -= damageTaken;

						System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
						System.out.println("\t> You receive " + damageTaken + " damage in retaliation.\n");

						if (health < 1) {
							System.out.println("\t> You have taken too much damage, you are too weak to go on");
//							if (numHealthPotions > 0){
//								System.out.println("You can use Potions to increase health");
//							}
							break;
						}
					}
				else if(input.equals("2")){
						if (numHealthPotions > 0) {
							health += healthPotionHealAmount;
							if (health > 100) {
								health = 100;
							}
							numHealthPotions--;
							System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + ".");
							System.out.println("\t> You now have " + health + " HP.");
							System.out.println("\t> You are left with " + numHealthPotions + " health potions.");
						} else {
							System.out.println("\t> You are left with 0 Health Potions.");
						}
					}
				else if(input.equals("3")){
						System.out.println("\t You run away from " + enemy + "!");
						break;
					}
				else {
						System.out.println("\t Invalid Option!");
					}
				}
			if (health < 1) {
				System.out.println("\t> You are out of the Dungeon. Better Luck next Time!!");
				break;
			}

			System.out.println("-------------------------");
			if (enemyHealth < 0) {
				System.out.println("# " + enemy + " was defeated! #");
				enemyDefeated++;
			}

			if(rand.nextInt(100) < healthPotionDropChance) {
				numHealthPotions++;
				System.out.println("# The " + enemy + " dropped a health potion.");
				System.out.println("# You now have " + numHealthPotions + " health potions. #");
			}

			System.out.println("------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue Fighting");
			System.out.println("2. Exit Dungeon");

			String input = sc.nextLine();

			while (!input.equals("1") && !input.equals("2")){
				System.out.println("Invalid command!!!");
				input = sc.nextLine();
			}

			if (input.equals("1")){
				System.out.println("You continue on your Adventure!");
			} else if (input.equals("2")) {
				System.out.println("You exit the dungeon successfully from the ");
				break;
			}
		}

		System.out.println("########################");
		System.out.println("#  THANKS FOR PLAYING  #");
		if (enemyDefeated > 1) {
			System.out.println("# You defeated " + enemyDefeated + " enemies #");
		} else {
			System.out.println("# You defeated " + enemyDefeated + " enemy #");
		}
		System.out.println("########################");
		}
	}