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
public class InfooControllerSaturn implements Initializable {
    
       @FXML
       Text text;
       @FXML
       ImageView image;
    
       
       @FXML
       ImageView roccketback;
    
       
       
       
       
       
       
       
       private User currentUser;
 
    public void player(User u){
        currentUser = u;
        
        
    }
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String word = " Do you know you are now on the planet Saturn?\n" +
"It is the second largest planet in the solar system, with a diameter of 120,000 km,\n which is ten times the diameter of the Earth.\n Oh how wide it is!!" +
"Look at its wonderful rings. Did you know that Saturn can be seen with the naked eye as a dull point of light in the sky of the Earth, despite the far distance.Do you know the distance between them? It's about 1,277,400,000 kilometers,and you can also see these beautiful rings of it through the telescope ";
        
        text.setFont(Font.font(null, FontWeight.BOLD,20));
        text.setFill(Color.BLACK);
        text.setTranslateX(10);
       // text.setTranslateY(20);
        
        
        
        
        
        
        //ctrae typewriter effect on text 
        
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
        
         Duration.seconds(0.1),
                event->{
                
                 if(i.get()>word.length()){
                 
                 timeline.stop();
                 
                 
                 }else{
                 
                      text.setText(word.substring(0, i.get()));
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
        
           
             
             roccketback.setOnMouseClicked(eh->{
     
              Media sound = new Media(new File("src/tothemystery/transition.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.autoPlayProperty();
        player.play();
  
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("planetsList.fxml"));
       
        Parent menuParent = null;
            try {
                menuParent = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(InfooControllerSaturn.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        Scene menuScene=new Scene(menuParent); 
        
        planetsListController controller = loader.getController();//to get the controller
        controller.player(currentUser);

        Stage window = (Stage)((Node)eh.getSource()).getScene().getWindow();
        window.setScene(menuScene);

        
       
     
     });
             
             
        // TODO
    }    
    
}
