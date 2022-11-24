//Dorin Tihon

/**
 Player class to define the player object to represent the player general information
 */
public class Player {

    //Variables
    private String name;
    private int score;

    //Default constructor
    public Player()
    {
        this.name = "No Name";
        this.score = 0;
    }

    //Parameter constructor
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    //getName() method that returns the name variable
    public String getName() {
        return name;
    }

    //setName() method that sets the name variable to the given parameter
    public void setName(String name) {
        this.name = name;
    }

    //getScore() method that returns the score variable
    public int getScore() {
        return score;
    }

    //setScore() method that sets the score variable to the given parameter
    public void setScore(int score) {
        this.score = score;
    }

    //toString method to print the Player object information
    @Override
    public String toString() {
        return "\nPlayer name: " + name +
                " (Score: " + score + ")";
    }

    //equals method
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (this.getClass() == obj.getClass()) {
            Player other = (Player) obj;
            return name.equals(other.getName()) &&
                    score == other.getScore();
        }
        return false;
    }


}
