//Dorin Tihon
/**Tester class is the main method class where the TopScorers class is defined
 * and gets the name of input and output file, also it tests the TopScorers methods.
 */
import java.io.IOException;
import java.util.Arrays;


public class Tester {
    public static void main(String[] args) throws IOException {


        //Creating a TopScorers object with the given parameter of input file
        TopScorers test = new TopScorers("in_players.txt");

        System.out.println("Players Info:\n ");
        for(Player player: test.scoreList) {
            System.out.println(player.toString());
        }
        System.out.println("\n");

        //testing playerScore() method
        String PlayerName = "Messi";
        System.out.println(PlayerName + " score is: " + test.playerScore(PlayerName) + "\n");
        PlayerName = "Player3";
        System.out.println(PlayerName + " score is: " + test.playerScore(PlayerName) + "\n");

        System.out.println("\n");

        //testing getTopScores() method
        System.out.println("Top five Scores:\n ");
        System.out.println(Arrays.toString(test.getTopScores()));

        System.out.println("\n");

        //testing getTopNames() method
        System.out.println("Top five Names:\n ");
        System.out.println(Arrays.toString(test.getTopNames()));

        System.out.println("\n");

        //testing getTopFive() method
        System.out.println("Top five Player: \n");
        System.out.println(test.getTopFive());

        //testing topFiveToFile() method
        test.topFiveToFile("topFivePlayers.txt");
    }
}
