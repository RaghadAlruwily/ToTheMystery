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
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author blacks
 */



    

public class MssgControllerMars implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
   
    
    
    
   private Stage stage1;
    private Scene scene1 ;
    private Parent root1 ;
    
    
    @FXML
    Pane pane ;
    
    @FXML
    ImageView imageView;
    
    @FXML
    ImageView ii;
    
    private User currentUser;
 
    public void player(User u){
        currentUser = u;
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
             imageView.setPickOnBounds(true);
             
             imageView.setOnMouseClicked((MouseEvent event)-> {
                 
                 
               //  Alert a = new Alert(Alert.AlertType.INFORMATION);
                // a.setContentText("hi");
                // a.show();
                
                
                
                makeFadeOut();
                
                
                
                
                
                
                
                
                
                
                
              //  Parent root1 = null;
                
               Media sound = new Media(new File("src/tothemystery/transition.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.autoPlayProperty();
        player.play();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("infoomars.fxml"));
       
        Parent mssM_parent = null;
            try {
                mssM_parent = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(WinControllerMars.class.getName()).log(Level.SEVERE, null, ex);
            }
        Scene mssM_Scene=new Scene(mssM_parent); 
        
        InfooControllerMars controller = loader.getController();//to get the controller
        controller.player(currentUser);
      
      
   
     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     
     window.setScene(mssM_Scene);
        

                 
             });
             
             
             
             
             
             
             
             TranslateTransition tr = new TranslateTransition();
             tr.setNode(imageView);
             tr.setDuration(Duration.millis(1500));
             tr.setCycleCount(Animation.INDEFINITE);
             tr.setAutoReverse(true);
             tr.setByX(100);
             tr.setByX(20);
              tr.setByY(160);
             tr.setByY(20);
             
             tr.play();
             
             
             
              
             TranslateTransition tr2 = new TranslateTransition();
             tr2.setNode(ii);
             
             tr2.setDuration(Duration.millis(1500));
             tr2.setCycleCount(1);
             tr2.setByX(380);
            // tr2.setByX(20);
             // tr2.setByY(160);
            // tr2.setByY(20);
             
             tr2.play();
             
             
        
        // TODO
    }    

    private void makeFadeOut() {
        
        
        FadeTransition fd = new FadeTransition();
        fd.setDuration(Duration.millis(1000));
        fd.setNode(pane);
        fd.setFromValue(1);
        fd.setToValue(0);
        fd.play();
    }
    
}

        
       
            
       
     
     
     
    

