/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tothemystery;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khulood Alyaf3Y
 */
public class SettingController implements Initializable {

    
      @FXML
    private CheckBox checkBox_sound;

    @FXML
    private Label meut1;

    @FXML
    private Label meut2;

    @FXML
    Slider slider ;
    
   
   MediaPlayer mp3 = Main.player;
  

    
    @FXML
    void isSelect(ActionEvent event) {
        

       if(checkBox_sound.isSelected())
       {
       mp3.stop();
       meut1.setVisible(true);
       meut2.setVisible(true);
       }
       else{
    // player.autoPlayProperty();
       mp3.play();
       meut1.setVisible(false);
       meut2.setVisible(false);
       }  
    }


    
    @Override //code from net
    public void initialize(URL url, ResourceBundle rb) {
     slider.setValue(mp3.getVolume()*100);
     slider.valueProperty().addListener(new InvalidationListener() {
       
    @Override
    public void invalidated(Observable observable) {
        
        mp3.setVolume(slider.getValue()/100);
   
    }

        });
    }    
     
     public void menuScene(ActionEvent e) throws IOException{
     
        Parent menuParent =FXMLLoader.load(getClass().getResource("menu.fxml"));
      Scene menuScene=new Scene(menuParent); 
      
   
     Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
     
     window.setScene(menuScene);
     
      
     }
}
