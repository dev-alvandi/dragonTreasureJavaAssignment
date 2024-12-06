import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * * Class for navigating the dungeon. The playGame method is here which 
 * * contains loops for keeping the game running until player exits or quits.
 */

public class Dungeon {

    // instance variables
    private Room currentRoom;
    private String welcomeMessage;
    private List<String> directions = new ArrayList<>(List.of("ö", "n", "s", "v"));
    private boolean playerHasEnteredARoom;

    // constructor initializing the dungeon along with a welcome message
    public Dungeon() {
        this.welcomeMessage = "Välkommen till Dragon Treasure\n" +
                "Skriv ditt namn och tryck på [Enter] för att starta ett nytt spel...";
    }

    // method for setting up the game
    public void playGame() {
        // create and initialize DragonTreasure object
        DragonTreasure dragonTreasure = new DragonTreasure();
        // create the rooms, which are stored in an array list
        dragonTreasure.setupGame();

        currentRoom = dragonTreasure.getRooms().get(0);

        System.out.println(welcomeMessage);

        // create scanner object for reading name and directions
        Scanner scanner = new Scanner(System.in);

        // initialize player with scanner input from player
        Player player = new Player(scanner.nextLine());
        currentRoom = dragonTreasure.getRooms().get(0);

        // print opening instructions
        System.out.printf("Välkommen %s till din skattjakt.%n", player.getName());
        System.out.println("Du står utanför en grotta. Det luktar svavel från öppningen");
        System.out.println("Grottöppningen är österut. Skriv \"ö\" och tryck på [Enter] för att komma in i grottan");

        // game runs until the player chooses the exit door/room
        while (true) {
            // Convert input to lowercase to simplify comparison logic
            String nextDirection = scanner.nextLine().toLowerCase();

            // At this point player has not entered the chosen room
            playerHasEnteredARoom = false;

            // User may exit the program using q or Q
            if (nextDirection.equals("q")) {
                break;
            }

            // Giving an error message in case user does not use one of 4 directions.
            if (!directions.contains(nextDirection)) {
                System.out.println("Du får bara skriva en av dessa fyra bokstäver för att navigera genom rum, nämligen \"ö\", \"v\", \"s\", eller \"n\". Försök igen!");
                continue;
            }

            // end the game when player chooses the exit door
            if (currentRoom.equals(dragonTreasure.getRooms().get(3)) && nextDirection.equals("ö")) {
                System.out.println("Du lämnar grottan med livet i behåll. Grattis, du förlorade inte!");
                break;
            }

            // output for if player chooses a door within the dungeon
            for (Door door : currentRoom.getDoors()) {

                // if player chooses an unlocked door, proceed with narrative for the next room
                if (door.getPosition().equals(nextDirection) && !door.isLocked()) {
                    currentRoom = door.getDestination();
                    System.out.println(currentRoom.getRoomDesc());
                    currentRoom.doNarrative();
                    playerHasEnteredARoom = true;

                // or if player chooses a locked door, then show picture and reprint current room narrative
                } else if (door.getPosition().equals(nextDirection) && door.isLocked()) {
                    System.out.println("Du har ingen nyckel som passar.\n" +
                            "Du kikar genom nyckelhålet och ser en skattkista full med guld.\n" +
                            "                  _.--.\n"+
                            "              _.-'_:-'||\n"+
                            "          _.-'_.-::::'||\n"+
                            "     _.-:'_.-::::::'  ||\n"+
                            "   .'`-.-:::::::'     ||\n"+
                            "  /.'`;|:::::::'      ||_\n"+
                            " ||   ||::::::'      _.;._'-._\n"+
                            " ||   ||:::::'   _.-!oo @.!-._'-.\n"+
                            " \'.  ||:::::.-!() oo @!()@.-'_.||\n"+
                            "   '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n"+
                            "     `>'-.!@%()@'@_%-'_.-o _.|'||\n"+
                            "      ||-._'-.@.-'_.-' _.-o  |'||\n"+
                            "      ||=[ '-._.-\\U/.-'    o |'||\n"+
                            "      || '-.]=|| |'|      o  |'||\n"+
                            "      ||      || |'|        _| ';\n"+
                            "      ||      || |'|    _.-'_.-'\n"+
                            "      |'-._   || |'|_.-'_.-'\n"+
                            "      '-._'-.|| |' `_.-'\n"+
                            "           '-.||_/.-'\n");
                    currentRoom.doNarrative();
                    playerHasEnteredARoom = true;
                }
            }

            // Exception is thrown if player chooses wrong direction
            if (!playerHasEnteredARoom) {
                System.out.println("Du har gått in i fel riktning. Försök igen!");
                continue;
            }
        }
    }
}
