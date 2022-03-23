package tothemystery;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import tothemystery.HibernateUtil;
import tothemystery.User;
import tothemystery.Score;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.stage.Stage;
import org.hibernate.*;
  
public class Main  extends Application{

    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();

       // Parent root=FXMLLoader.load(getClass().getResource("planetsList.fxml"));
        Parent root=FXMLLoader.load(getClass().getResource("intro.fxml"));
        
        Scene scene = new Scene(root,900, 660);
        
        primaryStage.setTitle("To The Mystery");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static final  Media sound = new Media(new File("src/tothemystery/RPReplay_Final1638632089.mp3").toURI().toString());
    public static final  MediaPlayer player = new MediaPlayer(sound);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}