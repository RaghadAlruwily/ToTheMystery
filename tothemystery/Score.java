package tothemystery;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table(name="score")
public class Score implements java.io.Serializable{

   
    @Id
    @Column(name="gameId")
    private int gameId;
    @Column(name="GameName")
    private String gameName;
    @Column(name="score")
    private int score =0;
    @Column(name="Name")
    private String userName ;

    
   // int id=0;
    public Score() {
    }

    public Score(int gameId, String gameName, int score, String userName) {
        this.gameId= gameId;
        this.gameName = gameName;
        this.score = score;
        this.userName = userName;

    }

    public String getGameName() {
        return gameName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public int getGameId() {
        return gameId;
    }
    
    public void setGameId(int gameId) {
        this.gameId=gameId;
    }

   // public int getNextId() {
     //   return id;
    //}
    
   // public void setNextId(int id) {
   //     this.id = id;
   // }

    
}

