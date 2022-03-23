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
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import tothemystery.User;

/**
 * FXML Controller class
 *
 * @author blacks
 */
public class WinControllerSaturn implements Initializable {

    /**
     * Initializes the controller class.
     * 
     * 
     * 
     * 
     */
    
    @FXML
    ImageView rocketback;
    
    @FXML
    Pane root;
    
    
    @FXML
    ImageView rocketmsg;
    
   
  
    
    
    
    @FXML
    Text tt;
    
    
    
    //@FXML
    //Text texttakemsg;
    
    @FXML
    ImageView image;
    
    private User currentUser;
 
    public void player(User u){
        currentUser = u;
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       // Media sound = new Media(new File("src/astorunt/RPReplay_Final1638028413 2.mp3").toURI().toString());
   //MediaPlayer player = new MediaPlayer(sound);
  // player.play();
       
        TranslateTransition tr = new TranslateTransition();
             tr.setNode(image);
             tr.setDuration(Duration.millis(1500));
             tr.setCycleCount(Animation.INDEFINITE);
             tr.setAutoReverse(true);
            // tr.setByX(100);
            // tr.setByX(20);
             // tr.setByY(160);
             tr.setByY(-20);
             
             tr.play();
        
        
       
        
        
        
           
             TranslateTransition tr3 = new TranslateTransition();
             tr3.setNode(rocketmsg);
             tr3.setDuration(Duration.millis(1500));
             tr3.setCycleCount(Animation.INDEFINITE);
             tr3.setAutoReverse(true);
            // tr.setByX(100);
            // tr.setByX(20);
              tr3.setByY(-20);
            // tr3.setByX(40);
             
             tr3.play();
             
             
             
             
             
              TranslateTransition tr4 = new TranslateTransition();
             tr4.setNode(tt);
             tr4.setDuration(Duration.millis(1500));
             tr4.setCycleCount(Animation.INDEFINITE);
             tr4.setAutoReverse(true);
            // tr.setByX(100);
            // tr.setByX(20);
            //  tr4.setByY(160);
             tr4.setByY(-20);
             
             tr4.play();
             
             
             
             
             
             
             
             
             
             
             
    // bt.setOnAction(eh->{
     
     
     
     
    // try {
                      //   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/astorunt/FXMLDocument.fxml"));

                            
                            
                           // Parent root1 = (Parent)fxmlLoader.load();
                           // Stage stage = new Stage();
                           // stage.setScene(new Scene(root1));
                           // stage.show();
                       // } catch (IOException ex) {
                            
                            
                          //  System.out.print("jj");
                       // }

     
     
     
     
     
     
     
     
     
     
    // });
             
             
    

     
     rocketmsg.setOnMouseClicked(eh->{
     
     
     
    // rocketmsg.setFitHeight(rocketmsg.getFitHeight()/1.5);
        //rocketmsg.setFitWidth(rocketmsg.getFitWidth()/1.5);
        
       // Glow glow = new Glow();
       // rocketmsg.setEffect(glow);
       // glow.setLevel(0.0);

     
     
      Media sound = new Media(new File("src/tothemystery/transition.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.autoPlayProperty();
        player.play();
  
  
   FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mssgsaturn.fxml"));
       
        Parent mssS_parent = null;
            try {
                mssS_parent = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(WinControllerSaturn.class.getName()).log(Level.SEVERE, null, ex);
            }
        Scene mssS_Scene=new Scene(mssS_parent); 
        
        MssgControllerSaturn controller = loader.getController();//to get the controller
        controller.player(currentUser);
      
      
   
     Stage window = (Stage)((Node)eh.getSource()).getScene().getWindow();
     
     window.setScene(mssS_Scene);
     
     
     });
     
        // TODO
    }    
    
}

