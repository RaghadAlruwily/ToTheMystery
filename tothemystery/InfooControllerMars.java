/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tothemystery;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author blacks
 */
public class InfooControllerMars implements Initializable {
    
       @FXML
       Text text;
       @FXML
       ImageView image;
    
       
       @FXML
       ImageView roccketback;
    
       
       @FXML
    void goToMenu(MouseEvent event) throws IOException {
         Media sound = new Media(new File("src/tothemystery/transition.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.autoPlayProperty();
        player.play();
             
             
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("planetsList.fxml"));
       
        Parent menuParent = loader.load();
            
        Scene menuScene=new Scene(menuParent); 
        
        planetsListController controller = loader.getController();//to get the controller
        controller.player(currentUser);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);

    }
       
       
       
       
       
       private User currentUser;
 
    public void player(User u){
        currentUser = u;
        
        
    }
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String words = "Here we are on Mars, Mars is the fourth planet from the sun after Mercury,"
                + " Venus, and Earth. The average distance between the Sun and "
                + "\n Mars is about 228.53 million km, and its size is half the size of the Earth."
                + " Similar of the Earth in terms of composition and in terms of having four"
                + " seasons during the year, and layers of ice cover \nits southern and northern poles.. "
                + "that it is like the earth. I really feel one day.. we may live on the surface of Mars,\nwho knows  ";
        
        text.setFont(Font.font(null, FontWeight.BOLD,20));
        text.setFill(Color.BLACK);
        text.setTranslateX(5);
        //text.setTranslateY(20);
        
        
        
        
        
        
        //ctrae typewriter effect on text 
        
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
        
         Duration.seconds(0.1),
                event->{
                
                 if(i.get()>words.length()){
                 
                 timeline.stop();
                 
                 
                 }else{
                 
                      text.setText(words.substring(0, i.get()));
                      i.set(i.get()+4);

                 
                 
                 
                 
                 }
                
                }
        
        
        
        );
        
        
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        
        
         
             TranslateTransition tr = new TranslateTransition();
             tr.setNode(image);
             tr.setDuration(Duration.millis(1500));
             tr.setCycleCount(Animation.INDEFINITE);
             tr.setAutoReverse(true);
            // tr.setByX(100);
            // tr.setByX(20);
             
             tr.setByY(-15);
             
             tr.play();
             
        TranslateTransition tr2 = new TranslateTransition();
             tr2.setNode(text);
             tr2.setDuration(Duration.millis(1500));
             tr2.setCycleCount(Animation.INDEFINITE);
             tr2.setAutoReverse(true);
           //  tr2.setByX(100);
           //  tr2.setByX(20);
             
             tr2.setByY(-15);
             
             tr2.play();
        
           
             
        // TODO
    }    
    
}
