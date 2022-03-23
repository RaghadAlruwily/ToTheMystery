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
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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
 * @author AEliP
 */
public class IntroController implements Initializable {

    
    @FXML
    private Pane chat1;

    @FXML
    private Text text1;

    @FXML
    private Button button1;

    @FXML
    private ImageView emoje1;

    @FXML
    private Pane pane2;

    @FXML
    private Text chat2;

    @FXML
    private Button button2;

    @FXML
    private ImageView emoje2;

    @FXML
    private Pane pane3;

    @FXML
    private Text text3;

    @FXML
    private Button button3;

    @FXML
    private ImageView emoje3;
    
    @FXML
    private ImageView ready;
    
    @FXML
    private Pane readyButton;
    
      @FXML
    private Pane readyPane;

    
      @FXML
    void nextChat1(ActionEvent event) {
        button1.setVisible(false);
        pane2.setVisible(true);
        emojeTranslate(emoje2);
        chatTrans(pane2);
        fade(pane2);
        fade(emoje2);
        
        String addwor = "Hurrah, I bet that you'll have fun with us on this trip and you'll discover the"
                      + " unknown that is above us!! perhaps you'll come out with great information.      ";
        
        
        chat2.setFont(Font.font("Copperplate Gothic Bold", FontWeight.NORMAL,22));
        chat2.setFill(Color.LIGHTGREY);
        chat2.setTranslateX(30);
        chat2.setTranslateY(5);
        
         //ctrae typewriter effect on text 
        
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
        
         Duration.seconds(0.1),
                e->{
                 
        
                 if(i.get()>addwor.length()){
                 
                 timeline.stop();
                 
                 
                 }else{
                 
                      chat2.setText(addwor.substring(0, i.get()));
                      i.set(i.get()+4);
                      

                 }
               
                
                }
        );
       
        
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setDelay(Duration.seconds(3.2));
        timeline.play();
        

    }
    
    @FXML
    void nextChat2(ActionEvent event) {
        button2.setVisible(false);
        pane3.setVisible(true);
        emojeTranslate(emoje3);
        chatTrans(pane3);
        fade(pane3);
        fade(emoje3);
        
        
        String addwor = "please tell me that you're ready to go! I'll guide you until the completion of the trip "
                      + "hhhh ..I can't wait to see your dazzled face XD      ";
        
        
        text3.setFont(Font.font("Copperplate Gothic Bold", FontWeight.NORMAL,22));
        text3.setFill(Color.LIGHTGREY);
        text3.setTranslateX(30);
        text3.setTranslateY(5);
        
         //ctrae typewriter effect on text 
        
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
        
         Duration.seconds(0.1),
                e->{
                
                 if(i.get()>addwor.length()){
                 
                 timeline.stop();
                 
                 
                 }else{
                 
                      text3.setText(addwor.substring(0, i.get()));
                      i.set(i.get()+4);

                 }
                
                }
        );
        
        
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setDelay(Duration.seconds(3.2));
        timeline.play();
        

    }
    
    @FXML
    void readyToStart(ActionEvent event) {
        readyPane.setVisible(true);
        readyPane.setLayoutY(900);
        readyTrans(readyPane);
        System.out.println(readyPane.getLayoutY());
        
        Media sound = new Media(new File("src/tothemystery/Cinematic Whoosh.mp3").toURI().toString());
         MediaPlayer player = new MediaPlayer(sound);
         player.autoPlayProperty();
         player.play();
        
        
           
        }

    
      @FXML
    void loginScene(MouseEvent event) throws IOException {
       Parent login_Parent =FXMLLoader.load(getClass().getResource("login.fxml"));
      Scene login_Scene=new Scene(login_Parent); 
      
   
     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     
     window.setScene(login_Scene);

    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        emojeTranslate(emoje1);
        chatTrans(chat1);
        fade(chat1);
        fade(emoje1);
        
        
        String addwor = "Hi, I guess you are here because you are interested to exper our spaceflight that we offer, right?   ";
        
        
        text1.setFont(Font.font("Copperplate Gothic Bold", FontWeight.NORMAL,22));
        text1.setFill(Color.LIGHTGREY);
        text1.setTranslateX(30);
        text1.setTranslateY(5);
        
        //ctrae typewriter effect on text 
        
        final IntegerProperty i = new SimpleIntegerProperty(0);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(
        
         Duration.seconds(0.1),
                event->{
                
                 if(i.get()>addwor.length()){
                 
                 timeline.stop();
                 
                 
                 }else{
                 
                      text1.setText(addwor.substring(0, i.get()));
                      i.set(i.get()+4);
                      

                 }
               
                }
        );
       
       
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setDelay(Duration.seconds(3.2));
        timeline.play();
       
    }  
    
    public void emojeTranslate(ImageView img){
        TranslateTransition t = new TranslateTransition();
        t.setNode(img);
        t.setAutoReverse(true);
        t.setCycleCount(Animation.INDEFINITE);
        t.setByY(-4);
        t.setDuration(Duration.millis(400));
        t.setDelay(Duration.seconds(3.2));
        t.play();
    }
    
    public void chatTrans(Node n){
        TranslateTransition t = new TranslateTransition();
        t.setNode(n);
        t.setAutoReverse(true);
        t.setByY(-85);
        t.setDuration(Duration.millis(3000));
        t.play();
        if(n.getLayoutY()==37)
            t.stop();
    }
    public void fade(Node n){
        FadeTransition f = new FadeTransition();
        f.setNode(n);
        f.setFromValue(0);
        f.setToValue(1);
        f.setDuration(Duration.millis(3000));
        f.play();
        
    }    
    public void readyTrans(Node n){
        TranslateTransition t = new TranslateTransition();
        t.setNode(n);
        t.setAutoReverse(true);
        t.setByY(-2300);
        t.setDuration(Duration.millis(3000));
        t.play();
        
    }
}
