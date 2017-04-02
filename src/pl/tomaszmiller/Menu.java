package pl.tomaszmiller;

/**
 * Created by Peniakoff on 02.04.2017.
 */

public class Menu {

	Main app = new Main();

	public String welcome() {
		return "------------------------------------------------\n" +
				"------" + app.ANSI_GREEN + " The master's eye fattens the horse " + app.ANSI_RESET + "------\n" +
				"------------------------------------------------\n" +
				app.ANSI_GREEN + " Welcome in the application to menage your farm \n" + app.ANSI_RESET +
				"------------------------------------------------";
	}

	public String showMenu() {
		return "\nWhat do you want to do?\n" +
				"(1) add the new barn\n" +
				"(2) remove the barn\n" +
				"(3) add the new animal\n" +
				"(4) remove the animal\n" +
				"(5) show the oldest animal\n" +
				"(6) show the youngest animal\n" +
				"(7) show the most animal species\n\n" +
				"(8) close the application\n\n" +
				((app.animalsList.size() > 0) ? "Currently number of your animals: " + app.animalsList.size() + "\n" : "You don't have animals for this moment!\n");
	}

}
