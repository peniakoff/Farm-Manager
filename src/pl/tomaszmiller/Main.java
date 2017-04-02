package pl.tomaszmiller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Peniakoff on 17.03.2017.
 *
 * "The master's eye fattens the horse" - application to menage animals in the farm
 *
 */

public class Main {

	public List<Barn> barnsList = new ArrayList<>();
	public List<Animal> animalsList = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	public String ANSI_GREEN = "\u001B[32m";
	public String ANSI_RED = "\u001B[31m";
	public String ANSI_RESET = "\u001B[0m";

	public static void main(String[] args) {
		Main app = new Main();
		Menu menu = new Menu();
		System.out.println(menu.welcome());

		do {
			System.out.println(menu.showMenu());
			System.out.print("Input the number of your choice: ");
			System.out.println();
			int operator;
			Scanner scanner = new Scanner(System.in);
			String scannerOperator = scanner.nextLine();
			try {
				operator = Integer.parseInt(scannerOperator);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				operator = 0;
			}

			switch (operator){
				case 0:
					System.out.print("Input filed. Try again input the right value from the menu.\n");
					break;
				case 1: //add the new barn
					app.addBarn();
					break;
				case 2: //remove the barn
					app.removeBarn();
					break;
				case 3: //add the new animal
					app.addAnimal();
					break;
				case 4: //remove the animal
					app.removeAnimal();
					break;
				case 5: //show the oldest animal
//					app.oldestAnimal();
					break;
				case 6: //show the youngest animal
//					app.youngestAnimal();
					break;
				case 7: //show the most animal species
					app.mostAnimalSpecies();
					break;
				case 8: //exit
					System.out.println("\nThank you for using the program.\nRemember - take care of your animals!");
					return;
				default:
					System.out.println("Input filed. Try again input the right value from the menu.\n");
					break;
			}
		} while (true);

	}

	public void addBarn() {
		int barnId = (barnsList.size() == 0) ? 1 : barnsList.get(barnsList.size() - 1).getBarnId() + 1;
		System.out.print("Input the name of the new barn: ");
		String barnName = scanner.next();
		System.out.print("Input the capacity of the new barn: ");
		int capacity = scanner.nextInt();
		Barn barn = new Barn(barnId, barnName, capacity);
		barnsList.add(barn);
		System.out.println("New barn was created!");
	}

	public void removeBarn() {
		if (barnsList.isEmpty()) {
			System.out.println("\nYou haven't any barn! First you need to add one of them!");
			return;
		}
		System.out.println("\nYour barns:");
		int i = 1;
		for (Barn barn : barnsList){
			System.out.println("(" + ANSI_GREEN + (i++) + ANSI_RESET + ") " + barn.getBarnName() + ", capacity: " + barn.getCapacity());
		}
		System.out.print("\nWhich of one barn would you remove? ");
		barnsList.remove(typeInt(scanner.next()) - 1);
		System.out.print("\nThe barn was successful removed!\n");
	}

	public void addAnimal() {
		if (barnsList.isEmpty()) {
			System.out.println("\nYou can't add an animal, if you havn't any barn. First you need to add one of them!");
			return;
		}
		System.out.print("Input official ID of the new animal (numbers only): ");
		long id = Long.parseLong(scanner.next());
		System.out.print("Input type of the new animal: ");
		String type = scanner.next();
		System.out.print("Input sex of the new animal ('f' or 'm'): ");
		char sex = scanner.next().charAt(0);
		System.out.print("Input birthday of the new animal (yyyy-mm-dd): ");
		String birthday = scanner.next();
		System.out.print("Input ID of the barn for the new animal (barn's ID number): ");
		int barnId = typeInt(scanner.next());
		Animal animal = new Animal(id, type, sex, birthday, barnId);
		animalsList.add(animal);
		System.out.println("New animal (" + type + ") was added to barn " + barnsList.get(animal.getBarnIndex() - 1).getBarnName() + ".");
	}

	public void removeAnimal() {
		if (animalsList.isEmpty()) {
			System.out.println("\nYou haven't any animal! First you need to add one of them!");
			return;
		}
		System.out.println("\nYour animals:");
		int i = 1;
		for (Animal animal : animalsList){
			System.out.println("(" + ANSI_GREEN + (i++) + ANSI_RESET + ") Animal ID: " + animal.getId() + ", Type: " + ANSI_RED + animal.getType() + ANSI_RESET + ", Sex: " + animal.getSex() + ", Birthday: " + animal.getBirthDate() + ", Added: " + animal.getAddDate() + ", Name of the animal's barn: " + barnsList.get(animal.getBarnIndex() - 1).getBarnName());
		}
		System.out.print("\nWhich of one animal would you remove? ");
		animalsList.remove(typeInt(scanner.next()) - 1);
		System.out.print("\nThe animal was successful removed!\n");
	}

/*	public String oldestAnimal() {

	}

	public String youngestAnimal() {

	}*/

	public void mostAnimalSpecies() {
		String mostAnimal = null;
		int counter = 0;
		int counterHelper = 0;
		for (Animal animal : animalsList) {
			for (Animal animal2 : animalsList) {
				if (animal.getType().equalsIgnoreCase(animal2.getType())) counterHelper ++;
			}
			if (counterHelper - 1 > counter) {
				counter = counterHelper;
				mostAnimal = animal.getType();
			}
		}
		System.out.println(mostAnimal);
	}

	public Integer typeInt(String input) {
		while (true) {
			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return null;
			}
			// jeszcze raz wywołać funkcję w razie niepowodzenia!
		}
	}

}
