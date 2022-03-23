/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tothemystery;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Khulood Alyaf3Y
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private Label lb_about;
   @FXML
     private ImageView planet1;
   private ImageView image;
    @FXML
    private ImageView planet2;
     @FXML
     private ImageView planet3;
     @FXML
    private AnchorPane telescope_pane;
       
   @FXML
    private AnchorPane planets_pane;
      @FXML
    private ImageView image_setting; 
       
      @FXML
    private AnchorPane rocket_pane;
    @FXML
    private ImageView i; 
     @FXML
    private ImageView telscop;   
    @FXML
    private ImageView rocet;  
 
    @FXML
    private Pane scorePane;
    @FXML
    private Label player;
    
    @FXML
    private ImageView s1;

    @FXML
    private ImageView s2;

    @FXML
    private Text t1;


    private User currentUser;
 
    public void player(User u){
        currentUser = u;
        player.setText(player.getText()+u.getName());
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
        
                
          planets_pane.widthProperty().addListener((observable, oldvalue, newvalue)->{
                  planet1.setFitWidth((Double)newvalue/3.5); 
                  planet2.setFitWidth((Double)newvalue/3.5);
                  planet3.setFitWidth((Double)newvalue/3.5);
         
         });
         
         
         planets_pane.heightProperty().addListener( (observable, oldvalue, newvalue)-> {
            planet1.setFitHeight((Double)newvalue/3.5);
           planet2.setFitHeight((Double)newvalue/3.5);
            planet3.setFitHeight((Double)newvalue/3.5);
        
                });
         
        
        telescope_pane.widthProperty().addListener((observable, oldvalue, newvalue)->{
                  telscop.setFitWidth((Double)newvalue/1.3); 
                
         
         });
         
         
         telescope_pane.heightProperty().addListener( (observable, oldvalue, newvalue)-> {
            telscop.setFitHeight((Double)newvalue/1.3);
          
        
                });
        rocket_pane.widthProperty().addListener((observable, oldvalue, newvalue)->{
                  rocet.setFitWidth((Double)newvalue/1.3); 
                
         
         });
         
         
         rocket_pane.heightProperty().addListener( (observable, oldvalue, newvalue)-> {
            rocet.setFitHeight((Double)newvalue/1.3);
          
        
                });   
         scorePane.widthProperty().addListener( (observable, oldvalue, newvalue)-> {
            s1.setFitWidth((Double)newvalue/1.3);
            s2.setFitWidth((Double)newvalue/1.3);
            
            
          
        
                }); 
         scorePane.heightProperty().addListener( (observable, oldvalue, newvalue)-> {
            s1.setFitHeight((Double)newvalue/1.3);
            s2.setFitHeight((Double)newvalue/1.3);
           
            
          
        
                });  
         
         
         
          TranslateTransition tr = new TranslateTransition();
             tr.setNode(image);
             tr.setDuration(Duration.millis(1500));
             tr.setCycleCount(20);
           tr.setAutoReverse(true);
              tr.setByY(160);
             tr.setByY(15);
             tr.setAutoReverse(true);
             tr.play();
      
    } 
    
        @FXML
    void aboutScene(MouseEvent e) throws IOException {
        

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("about_app.fxml"));
       
        Parent about_parent = loader.load();
        Scene about_Scene=new Scene(about_parent); 
        
        About_appController controller = loader.getController();//to get the controller
        controller.player(currentUser);
      
      
   
     Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
     
     window.setScene(about_Scene);

    }
  

     public void settingScene(MouseEvent e) throws IOException{
     
 
      
      FXMLLoader loder=new FXMLLoader(getClass().getResource("setting.fxml"));
      
      Parent settingScene=loder.load();
 
    
     Stage stage=new Stage();
     stage.setScene(new Scene(settingScene));
     stage.setTitle("Stting");
     stage.show();
     }
    
     
     public void instrctionScene(MouseEvent e) throws IOException{ 
      
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("instarctions.fxml"));
       
        Parent instractionParent  = loader.load();
        Scene ins_Scene=new Scene(instractionParent); 
        
        InstarctionsController controller = loader.getController();//to get the controller
        controller.player(currentUser);

        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(ins_Scene);

     }
     
   

    @FXML
    void MouseOnSetting(MouseEvent event) {
    
         Media sound = new Media(new File("src/tothemystery/Cartoon Accent.mp3").toURI().toString());
         MediaPlayer player = new MediaPlayer(sound);
         player.autoPlayProperty();
         player.play();
         
         
        image_setting.setFitHeight(image_setting.getFitHeight()*1.3);
        image_setting.setFitWidth(image_setting.getFitWidth()*1.3);
    
    }

    @FXML
    void MouseOutSetting(MouseEvent event) {
        
         image_setting.setFitHeight(image_setting.getFitHeight()/1.3);
        image_setting.setFitWidth(image_setting.getFitWidth()/1.3);
      

    }
    
     @FXML
    void MouseOnAbout(MouseEvent event) {
         Media sound = new Media(new File("src/tothemystery/Cartoon Accent.mp3").toURI().toString());
         MediaPlayer player = new MediaPlayer(sound);
         player.autoPlayProperty();
         player.play();
    
       lb_about.setFont(Font.font("System",FontWeight.BOLD,30));
       
    
    }

    @FXML
    void MouseOutAbout(MouseEvent event) {
       
       lb_about.setFont(Font.font("System",FontWeight.BOLD,22));
    }
   
     @FXML
    void MouseOninstrction(MouseEvent event) {
    
         Media sound = new Media(new File("src/tothemystery/Cartoon Accent.mp3").toURI().toString());
         MediaPlayer player = new MediaPlayer(sound);
         player.autoPlayProperty();
         player.play();
       
         i.setFitHeight(i.getFitHeight()*1.2);
        i.setFitWidth(i.getFitWidth()*1.2);
    }

    @FXML
    void MouseOutinstrction(MouseEvent event) {
        
      
         i.setFitHeight(i.getFitHeight()/1.2);
        i.setFitWidth(i.getFitWidth()/1.2);

    }
    
    

  
    @FXML
    void MouseOnRocketPane(MouseEvent event) {

         Media sound = new Media(new File("src/tothemystery/Cartoon Accent.mp3").toURI().toString());
         MediaPlayer player = new MediaPlayer(sound);
         player.autoPlayProperty();
         player.play();
         rocket_pane.setMinHeight(rocket_pane.getHeight()*1.3);
        rocket_pane.setMinWidth(rocket_pane.getWidth()*1.3);
        
    }


    @FXML
    void MouseOutRocketPane(MouseEvent event) {

        
         rocket_pane.setMinHeight(rocket_pane.getHeight()/1.3);
        rocket_pane.setMinWidth(rocket_pane.getWidth()/1.3);
        
    }

    
    
    @FXML
    void MouseOutPlanetsPane(MouseEvent event) {
        planets_pane.setMinHeight(planets_pane.getHeight()/1.3);
        planets_pane.setMinWidth(planets_pane.getWidth()/1.3);
        
  
    }
    @FXML
    void MouseOnPlanetsPane(MouseEvent event) {
         Media sound = new Media(new File("src/tothemystery/Cartoon Accent.mp3").toURI().toString());
         MediaPlayer player = new MediaPlayer(sound);
         player.autoPlayProperty();
         player.play();
     
         planets_pane.setMinHeight(planets_pane.getHeight()*1.3);
        planets_pane.setMinWidth(planets_pane.getWidth()*1.3);
        
        
       
    }

    
    
    @FXML
    void MouseOnTelescopePane(MouseEvent event) {
        
         Media sound = new Media(new File("src/tothemystery/Cartoon Accent.mp3").toURI().toString());
         MediaPlayer player = new MediaPlayer(sound);
         player.autoPlayProperty();
         player.play();
     telescope_pane.setMinHeight(telescope_pane.getHeight()*1.3);
     telescope_pane.setMinWidth(telescope_pane.getWidth()*1.3);
    }
    
     @FXML
    void MouseOutTelescopePane(MouseEvent event) {

         telescope_pane.setMinHeight(telescope_pane.getHeight()/1.3);
     telescope_pane.setMinWidth(telescope_pane.getWidth()/1.3);
        
    }
    
    @FXML
    void goToScore(MouseEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ScoreFXML.fxml"));
       
        Parent score_Parent  = loader.load();
        Scene score_Scene=new Scene(score_Parent); 
        
        ScoreFXMLController controller = loader.getController();//to get the controller
        controller.player(currentUser);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(score_Scene);

       
    }

    @FXML
    void mouseOnScore(MouseEvent event) { 
           scorePane.setMinWidth(scorePane.getWidth()*1.2);
            scorePane.setMinHeight(scorePane.getHeight()*1.2);

    }

    @FXML
    void mouseOutScore(MouseEvent event) {   
           scorePane.setMinWidth(scorePane.getWidth()/1.2);
           scorePane.setMinHeight(scorePane.getHeight()/1.2);
       
    }
    
     @FXML
    void goToTelescope(MouseEvent event) throws IOException {
      
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("telescope.fxml"));
       
        Parent telescope_Parent  = loader.load();
        Scene tele_Scene=new Scene(telescope_Parent); 
        
        teleController controller = loader.getController();//to get the controller
        controller.player(currentUser);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tele_Scene);


    }
    
       @FXML
    void goToPlanetsList(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("planetsList.fxml"));
       
        Parent planets_Parent  = loader.load();
        Scene planets_Scene=new Scene(planets_Parent); 
        
        planetsListController controller = loader.getController();//to get the controller
        controller.player(currentUser);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(planets_Scene);

    }
    
      @FXML
    void goToRocket(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("IntoPuzzleGame.fxml"));
       
        Parent rocketPuzzle_Parent  = loader.load();
        Scene rocketPuzzle_Scene=new Scene(rocketPuzzle_Parent); 
        
        IntoPuzzleGameController controller = loader.getController();//to get the controller
        controller.player(currentUser);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(rocketPuzzle_Scene);

    }
    
    
}

