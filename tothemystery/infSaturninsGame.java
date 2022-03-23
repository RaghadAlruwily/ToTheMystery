
package tothemystery;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class infSaturninsGame implements Initializable {

    @FXML
    private Pane miniWindow;

    @FXML
    private Text textInfo;
    
    @FXML
    void moveScene(ActionEvent e) throws IOException{
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Ssaturn.fxml"));
       
        Parent RocketParent  = loader.load();
        Scene Rocket_Scene=new Scene(RocketParent); 
        
        Ssaturn controller = loader.getController();//to get the controller
        controller.player(currentUser);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(Rocket_Scene);
        
   
    }
    private User currentUser;
 
    public void player(User u){
        currentUser = u;
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String addwor = "To start the game, you must press the Enter button "
                      + "Use arrows ⇦ ⇧ ⇨ ⇩ to controls space The lasers "
                      + " are fired at aliens from the program "
                      + "Increases the speed of the laser aliens by pressing the Enter button "
                      +"Every time you kill an alien you will get a star if you can't "
                      +" kill the alien, it will take away your life\n"
                      +"  Be careful from aliens     ";
        
        
        textInfo.setFont(Font.font("Copperplate Gothic Bold", FontWeight.BOLD,28));
        textInfo.setFill(Color.LIGHTGREY);
        textInfo.setTranslateX(35);
        textInfo.setTranslateY(5);
        
        Media sound = new Media(new File("src/tothemystery/Typewriter.mp3").toURI().toString());
         MediaPlayer player = new MediaPlayer(sound);
         player.autoPlayProperty();
         player.play();
        
         //ctrae typewriter effect on text 
        
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
        
         Duration.seconds(0.1),
                event->{
                
                 if(i.get()>addwor.length()){

                 timeline.stop();

                 }else{
                 
                      textInfo.setText(addwor.substring(0, i.get()));
                      i.set(i.get()+4);
                      

                 }
                
                }
 
        );
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        
    }  
}
