import java.io.*;
import java.util.*;
//Dorin Tihon

/**
 The class TopScorers read all players information from an input file and
 stores it in an ArrayList. This class has methods to help sort and get specific information
 about one or more players.
 */

public class TopScorers extends Player{

    //Variables
    public ArrayList<Player> scoreList;
    String[] topNames;
    ArrayList<Player> topFiveScorer;
    int[] sortedArray;

    //Default constructor
    public TopScorers() {
        scoreList = new ArrayList<>();
        topNames = new String[0];
        topFiveScorer = new ArrayList<>();
    }

    //Parameter constructor
    public TopScorers(String fileName) {

        scoreList = new ArrayList<>();
        // reading the file and cathing the File not found Exception
        try {
            FileInputStream fileByteStream = new FileInputStream(fileName);
            Scanner inFS = new Scanner(fileByteStream);
            //reading the file and storing inside scoreList
            while (inFS.hasNext()) {
                String name = inFS.next();
                int score = inFS.nextInt();
                Player player = new Player(name, score);
                scoreList.add(player);
            }

        } catch (FileNotFoundException x) {
            System.out.println("The file " + fileName + " was not found.");
            System.exit(0);
        }


    }

    //playerScore() method which takes a name and returns the score for that player
    public int playerScore(String name) {
        int score = 0;
        for(Player player: scoreList) {
            if(player.getName().equals(name)) {
                score = player.getScore();
            }
        }
        return score;
    }



    //sort() method that sorts the Arraylist into an array to make it possible to get
    // topScores and topNames array as requested
    //Sorting the players in descending order
    public void sort(){
        sortedArray = new int[10];
        for (int i = 0; i < scoreList.size(); i++) {
            sortedArray[i] = scoreList.get(i).getScore();
        }
        Arrays.sort(sortedArray);

        //reversing the sorted array
        for (int i = 0; i < sortedArray.length / 2; i++) {

            int temp = sortedArray[i];

            sortedArray[i] = sortedArray[sortedArray.length - i - 1];

            sortedArray[sortedArray.length - i - 1] = temp;
        }
    }

    //getTopScores() method which returns an array of scores of the top players
    // in descending order of their scores
    public int[] getTopScores() {
        int[] topScore = new int[5];
        int count = 0;
        sort();
        for (int i = 0; i <= sortedArray.length; i++) {
            topScore[i] = sortedArray[i];
            count++;
            if (count == 5) {
                break;
            }
        }
        return topScore;
    }

    //getTopNames() method which returns an array of the names of the top players
    // in descending order of their score
    public String[] getTopNames() {

        topNames = new String[5];
        int count = 0;
        sort();
        for (int i = 0; i <= sortedArray.length; i++) {
            for (Player player : scoreList) {
                if (sortedArray[i] == player.getScore()) {
                    topNames[i] = player.getName();
                    count++;
                }

            }
            if (count == 5) {
                break;
            }

        }
        return topNames;
    }


    //getTopFive() method which returns an array of top five scorer Player objects
    public ArrayList<Player> getTopFive() {
        topFiveScorer = new ArrayList<>();
        int count = 0;
        for (String topName : topNames) {
            for (Player player : scoreList) {
                if (topName.equals(player.getName())) {
                    topFiveScorer.add(player);
                    count++;
                }
                if (count == 5) {
                    break;
                }
            }

        }
        return topFiveScorer;
    }

    //topFiveToFile() method which writes the information of top five scorers to a file.
    public void topFiveToFile(String filename) throws IOException {
        FileWriter outputFile = new FileWriter(filename);
        for (String topName : topNames) {
            for (Player player : scoreList)
                if (topName.equals(player.getName())) {
                    outputFile.write(player.toString());
                }

        }

        outputFile.close();
    }


}