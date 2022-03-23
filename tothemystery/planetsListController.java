
package tothemystery;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class planetsListController implements Initializable {
 
    @FXML
    private ImageView satellite;

    @FXML
    private ImageView astronaut;
    
    @FXML
    private ImageView rock;
    
    @FXML
    private ImageView saturn;
    

    @FXML
    private ImageView uranus;

    @FXML
    private ImageView mars;
    
    @FXML
    private Pane group1;
    
    @FXML
    private Pane group2;
    
    @FXML
    private Pane bubblePane;
    
    @FXML
    private Pane backPane;
    
    

    @FXML
    void mouseOnMars(MouseEvent event) {
        
         Media sound = new Media(new File("src/tothemystery/Cartoon Accent.mp3").toURI().toString());
         MediaPlayer player = new MediaPlayer(sound);
         player.autoPlayProperty();
         player.play();
        mars.setFitHeight(mars.getFitHeight()*1.5);
        mars.setFitWidth(mars.getFitWidth()*1.5);
       
        
        
        Glow glow= new Glow();
        mars.setEffect(glow);
        glow.setLevel(0.5);
        
        bubblePane.setVisible(true);
        translateBubble(bubblePane);
        
    }

    @FXML
    void mouseOnSaturn(MouseEvent event) {
        
         Media sound = new Media(new File("src/tothemystery/Cartoon Accent.mp3").toURI().toString());
         MediaPlayer player = new MediaPlayer(sound);
         player.autoPlayProperty();
         player.play();
        saturn.setFitHeight(saturn.getFitHeight()*1.5);
        saturn.setFitWidth(saturn.getFitWidth()*1.5);
        
        
        Glow glow = new Glow();
        saturn.setEffect(glow);
        glow.setLevel(0.5);
        
        bubblePane.setVisible(true);
       translateBubble(bubblePane);
        

    }

    @FXML
    void mouseOnUranus(MouseEvent event) {
        
         Media sound = new Media(new File("src/tothemystery/Cartoon Accent.mp3").toURI().toString());
         MediaPlayer player = new MediaPlayer(sound);
         player.autoPlayProperty();
         player.play();
        uranus.setFitHeight(uranus.getFitHeight()*1.5);
        uranus.setFitWidth(uranus.getFitWidth()*1.5);
       
        
        Glow glow = new Glow();
        uranus.setEffect(glow);
        glow.setLevel(0.5);
        
        bubblePane.setVisible(true);
        translateBubble(bubblePane);
        

    }

    @FXML
    void mouseOutMars(MouseEvent event) {
        
        mars.setFitHeight(mars.getFitHeight()/1.5);
        mars.setFitWidth(mars.getFitWidth()/1.5);
       
        Glow glow = new Glow();
        mars.setEffect(glow);
        glow.setLevel(0.0);
        
        bubblePane.setVisible(false);
        
        

    }

    @FXML
    void mouseOutSaturn(MouseEvent event) {
        
        saturn.setFitHeight(saturn.getFitHeight()/1.5);
        saturn.setFitWidth(saturn.getFitWidth()/1.5);
        
        Glow glow = new Glow();
        saturn.setEffect(glow);
        glow.setLevel(0.0);
        
        bubblePane.setVisible(false);
        


    }

    @FXML
    void mouseOutUranus(MouseEvent event) {
        
        
        uranus.setFitHeight(uranus.getFitHeight()/1.5);
        uranus.setFitWidth(uranus.getFitWidth()/1.5);
        
        Glow glow = new Glow();
        uranus.setEffect(glow);
        glow.setLevel(0.0);
        
        bubblePane.setVisible(false);
        

    }
    
    
    @FXML
    void selectMars(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("infMarssGame.fxml"));
       
        Parent mars_parent = loader.load();
        Scene mars_Scene=new Scene(mars_parent); 
        
        InfMarssGameController controller = loader.getController();//to get the controller
        controller.player(currentUser);
      
      
   
     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     
     window.setScene(mars_Scene);

    }

    @FXML
    void selectSaturn(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("infSaturninsGame.fxml"));
       
        Parent saturn_parent = loader.load();
        Scene saturn_Scene=new Scene(saturn_parent); 
        
        infSaturninsGame controller = loader.getController();//to get the controller
        controller.player(currentUser);
      
      
   
     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     
     window.setScene(saturn_Scene);

    }

    @FXML
    void selectUranus(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("infUarnusGame.fxml"));
       
        Parent saturn_parent = loader.load();
        Scene saturn_Scene=new Scene(saturn_parent); 
        
        InfUarnusGameController controller = loader.getController();//to get the controller
        controller.player(currentUser);
      
      
   
     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     
     window.setScene(saturn_Scene);

    }
    
     @FXML
    void backToMenu(MouseEvent event) throws IOException {
        
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

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        

    }
    
     @FXML
    void mouseOnButton(MouseEvent event) {
        backPane.setMinHeight(backPane.getMinHeight()*1.2);
        backPane.setMinWidth(backPane.getMinWidth()*1.2);

    }
    
     @FXML
    void mouseOutButton(MouseEvent event) {
        backPane.setMinHeight(backPane.getMinHeight()/1.2);
        backPane.setMinWidth(backPane.getMinWidth()/1.2);

    }

    private User currentUser;
 
    public void player(User u){
        currentUser = u;
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        translateRock(group1);
        translateRock(group2);
        translateRock(rock);
        translateRock(astronaut);
        translateRock(satellite);
        translateSatellite(satellite);
        bubblePane.setVisible(false);
       
    }    
    
    public void translateRock(Node n){
        TranslateTransition t = new TranslateTransition();
        t.setAutoReverse(true);
        t.setNode(n);
        t.setDuration(Duration.millis(1200));
        t.setCycleCount(INDEFINITE);
        t.setByY(10);
        t.play();
        
    }
    
    public void translateBubble(Node n){
        TranslateTransition t = new TranslateTransition();
        t.setAutoReverse(true);
        t.setNode(n);
        t.setDuration(Duration.millis(1200));
        t.setCycleCount(INDEFINITE);
        t.setByY(-3);
        t.play();
        
    }
    
    public void translateSatellite(Node n){
        TranslateTransition t = new TranslateTransition();
        //t.setAutoReverse(true);
        t.setNode(n);
        t.setDuration(Duration.millis(45000));
        t.setCycleCount(INDEFINITE);
        //t.setByY(10);
        t.setByX(900);
        t.play();
        
    }
   
    
}
