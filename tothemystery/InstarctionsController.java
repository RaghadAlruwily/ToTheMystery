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
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Khulood Alyaf3Y
 */
public class InstarctionsController implements Initializable {



    /**
     * Initializes the controller class.
     */
 @FXML
    private ImageView image;
    @FXML
    private ImageView back;
  
    @FXML
    private ScrollPane scrol;
    
    User currentUser;
    
     public void player(User u){
        currentUser = u;
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
         TranslateTransition tr = new TranslateTransition();
             tr.setNode(image);
             tr.setDuration(Duration.millis(1500));
             tr.setCycleCount(20);
           tr.setAutoReverse(true);
              tr.setByY(160);
             tr.setByY(15);
             
             tr.play();
             
              TranslateTransition tr2 = new TranslateTransition();
             tr2.setNode(scrol);
             tr2.setDuration(Duration.millis(1500));
             tr2.setCycleCount(20);
           tr2.setAutoReverse(true);
              tr2.setByY(160);
             tr2.setByY(15);
             
             tr2.play();
             
        
    }
     
     public void menuScene(MouseEvent e) throws IOException{
     
          Media sound = new Media(new File("src/tothemystery/transition.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.autoPlayProperty();
        player.play();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("menu.fxml"));
       
        Parent menuParent = loader.load();
        Scene menuScene=new Scene(menuParent); 
        
        MenuController controller = loader.getController();//to get the controller
        controller.player(currentUser);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(menuScene);
     }
    
    @FXML
    void MouseOnBackn(MouseEvent event) {
    
        back.setFitHeight(back.getFitHeight()*1.3);
        back.setFitWidth(back.getFitWidth()*1.3);
    
    }

    @FXML
    void MouseOutBack(MouseEvent event) {
        
         back.setFitHeight(back.getFitHeight()/1.3);
        back.setFitWidth(back.getFitWidth()/1.3);
      

    }
}
