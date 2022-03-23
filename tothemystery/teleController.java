
package tothemystery;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
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
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Dell
 */
public class teleController implements Initializable {
   double opacity=1;
   double opacity1=1;
   double opacity2=1;
  
    @FXML
    private AnchorPane telescope_pane;

    @FXML
    private Circle star1;

    @FXML
    private Circle star2;

    @FXML
    private Circle star3;

    @FXML
    private Circle star4;

    @FXML
    private Circle planet1;

    @FXML
    private Circle planet2;

    @FXML
    private Circle planet3;

    @FXML
    private Circle planet4;

    @FXML
    private Circle star5;

    @FXML
    private Circle planet5;
    
    @FXML
    private AnchorPane Qoes_Scene;
    
    @FXML
    private ImageView clicPlanet;

    @FXML
    private ImageView clicStar;
    
    @FXML
    private RadioButton RadPlanet;

    @FXML
    private RadioButton RadStar;
    
    @FXML
    private AnchorPane Qoes_Scene1;

    @FXML
    private ImageView clicPlanet1;

    @FXML
    private ImageView clicStar1;

    @FXML
    private RadioButton RadPlanet1;

    @FXML
    private RadioButton RadStar1;

    @FXML
    private AnchorPane Qoes_Scene2;

    @FXML
    private ImageView clicPlanet2;

    @FXML
    private ImageView clicStar2;

    @FXML
    private RadioButton RadPlanet2;

    @FXML
    private RadioButton RadStar2;
    

    @FXML
    private AnchorPane telescopeInfo;
    
    @FXML
    private Text textInfo;
    
    @FXML
    private ImageView image_Start;
    
    @FXML
    private ImageView imageInfo;
     
    @FXML
    private AnchorPane telescope_pane1;

    @FXML
    private Circle planet11;

    @FXML
    private Circle planet21;

    @FXML
    private Circle planet31;

    @FXML
    private Circle planet41;

    @FXML
    private Circle planet51;

    @FXML
    private Circle star11;

    @FXML
    private Circle star21;

    @FXML
    private Circle star31;

    @FXML
    private Circle star41;

    @FXML
    private Circle star51;

    @FXML
    private Label msg1;
    
    @FXML
    private AnchorPane telescope_pane11;

    @FXML
    private Circle planet111;

    @FXML
    private Circle planet211;

    @FXML
    private Circle planet311;

    @FXML
    private Circle planet411;

    @FXML
    private Circle planet511;

    @FXML
    private Circle star111;

    @FXML
    private Circle star211;

    @FXML
    private Circle star311;

    @FXML
    private Circle star411;

    @FXML
    private Circle star511;

    @FXML
    private Label msg11;
    
    @FXML
    private Pane scorePane;

    @FXML
    private ImageView imageScore;

    @FXML
    private Text textScore;

    @FXML
    private ImageView score1;

    @FXML
    private ImageView score3;

    @FXML
    private ImageView score2;

    @FXML
    private ImageView win1;

    @FXML
    private ImageView win3;

    @FXML
    private ImageView win2;
    
    @FXML
    private ImageView imageBack;
    
    User currentUser;
    
    int sco=0;

    List<Score> scList;

    public void player(User u){
        currentUser = u;
        
    }

    
    
    @FXML
    void MouseOnPlant1(MouseEvent event) {
        planet1.setRadius(planet1.getRadius()*5);
        planet11.setRadius(planet11.getRadius()*5);
        planet111.setRadius(planet111.getRadius()*5);
        
    }
    @FXML
    void MouseOutPlant1(MouseEvent event) {
        planet1.setRadius(planet1.getRadius()/5);
        planet11.setRadius(planet11.getRadius()/5);
        planet111.setRadius(planet111.getRadius()/5);
    }
    @FXML
    void MouseOnPlant2(MouseEvent event) {
        planet2.setRadius(planet2.getRadius()*5);
        planet21.setRadius(planet21.getRadius()*5);
        planet211.setRadius(planet211.getRadius()*5);
        
    }
    @FXML
    void MouseOutPlant2(MouseEvent event) {
        planet2.setRadius(planet2.getRadius()/5);
        planet21.setRadius(planet21.getRadius()/5);
        planet211.setRadius(planet211.getRadius()/5);
        
    }
    @FXML
    void MouseOnPlant3(MouseEvent event) {
        planet3.setRadius(planet3.getRadius()*5);
        planet31.setRadius(planet31.getRadius()*5);
        planet311.setRadius(planet311.getRadius()*5);
        
    }
    @FXML
    void MouseOutPlant3(MouseEvent event) {
        planet3.setRadius(planet3.getRadius()/5);
        planet31.setRadius(planet31.getRadius()/5);
        planet311.setRadius(planet311.getRadius()/5);
        
    }
    @FXML
    void MouseOnPlant4(MouseEvent event) {
        planet4.setRadius(planet4.getRadius()*5);
        planet41.setRadius(planet41.getRadius()*5);
        planet411.setRadius(planet411.getRadius()*5);
        
    }
    @FXML
    void MouseOutPlant4(MouseEvent event) {
        planet4.setRadius(planet4.getRadius()/5);
        planet41.setRadius(planet41.getRadius()/5);
        planet411.setRadius(planet411.getRadius()/5);
        
    }
    @FXML
    void MouseOnPlant5(MouseEvent event) {
        planet5.setRadius(planet5.getRadius()*5);
        planet51.setRadius(planet51.getRadius()*5);
        planet511.setRadius(planet511.getRadius()*5);
        
    }
    @FXML
    void MouseOutPlant5(MouseEvent event) {
        planet5.setRadius(planet5.getRadius()/5);
        planet51.setRadius(planet51.getRadius()/5);
        planet511.setRadius(planet511.getRadius()/5);
        
    }
    @FXML
    void MouseOnStar1(MouseEvent event) {
        star1.setRadius(star1.getRadius()*5);
        star11.setRadius(star11.getRadius()*5);
        star111.setRadius(star111.getRadius()*5);
        
    }
    @FXML
    void MouseOutStar1(MouseEvent event) {
        star1.setRadius(star1.getRadius()/5);
        star11.setRadius(star11.getRadius()/5);
        star111.setRadius(star111.getRadius()/5);
        
    }
    @FXML
    void MouseOnStar2(MouseEvent event) {
        star2.setRadius(star2.getRadius()*5);
        star21.setRadius(star21.getRadius()*5);
        star211.setRadius(star211.getRadius()*5);
        
    }
    @FXML
    void MouseOutStar2(MouseEvent event) {
        star2.setRadius(star2.getRadius()/5);
        star21.setRadius(star21.getRadius()/5);
        star211.setRadius(star211.getRadius()/5);
        
    }
    @FXML
    void MouseOnStar3(MouseEvent event) {
        star3.setRadius(star3.getRadius()*5);
        star31.setRadius(star31.getRadius()*5);
        star311.setRadius(star311.getRadius()*5);
        
    }
    @FXML
    void MouseOutStar3(MouseEvent event) {
        star3.setRadius(star3.getRadius()/5);
        star31.setRadius(star31.getRadius()/5);
        star311.setRadius(star311.getRadius()/5);
        
    }
    @FXML
    void MouseOnStar4(MouseEvent event) {
        star4.setRadius(star4.getRadius()*5);
        star41.setRadius(star41.getRadius()*5);
        star411.setRadius(star411.getRadius()*5);
        
    }
    @FXML
    void MouseOutStar4(MouseEvent event) {
        star4.setRadius(star4.getRadius()/5);
        star41.setRadius(star41.getRadius()/5);
        star411.setRadius(star411.getRadius()/5);
        
    }
    @FXML
    void MouseOnStar5(MouseEvent event) {
        star5.setRadius(star5.getRadius()*5);
        star51.setRadius(star51.getRadius()*5);
        star511.setRadius(star511.getRadius()*5);
        
    }
    @FXML
    void MouseOutStar5(MouseEvent event) {
        star5.setRadius(star5.getRadius()/5);
        star51.setRadius(star51.getRadius()/5);
        star511.setRadius(star511.getRadius()/5);
        
    }
    
    boolean star , planet;
     @FXML
    void MouseClicPlanet1(MouseEvent event) {
       Qoes_Scene.setVisible(true); 
       planet=true;
       
    }

    @FXML
    void MouseClicPlanet2(MouseEvent event) {
       Qoes_Scene.setVisible(true);  
       planet=true;
       
    }

    @FXML
    void MouseClicPlanet3(MouseEvent event) {
       Qoes_Scene.setVisible(true);  
       planet=true;
       
    }

    @FXML
    void MouseClicPlanet4(MouseEvent event) {
       Qoes_Scene.setVisible(true); 
       planet=true;
       
    }
    

    @FXML
    void MouseClicPlanet5(MouseEvent event) {
       Qoes_Scene.setVisible(true); 
       planet=true;
      
    }
    
    @FXML
    void MouseClicStar1(MouseEvent event) {
       Qoes_Scene.setVisible(true);   
       star=true; 
    }

    @FXML
    void MouseClicStar2(MouseEvent event) {
        Qoes_Scene.setVisible(true); 
        star=true;  
    }

    @FXML
    void MouseClicStar3(MouseEvent event) {
        Qoes_Scene.setVisible(true);   
        star=true;
    }

    @FXML
    void MouseClicStar4(MouseEvent event) {
        Qoes_Scene.setVisible(true); 
        star=true;
    }

    @FXML
    void MouseClicStar5(MouseEvent event) {
       Qoes_Scene.setVisible(true);  
       star=true;
    }
    
    @FXML
    void MouseClicPlanet11(MouseEvent event) {
       Qoes_Scene1.setVisible(true); 
       planet=true;
       
    }

    @FXML
    void MouseClicPlanet22(MouseEvent event) {
       Qoes_Scene1.setVisible(true);  
       planet=true;
       
    }

    @FXML
    void MouseClicPlanet33(MouseEvent event) {
       Qoes_Scene1.setVisible(true);  
       planet=true;
       
    }

    @FXML
    void MouseClicPlanet44(MouseEvent event) {
       Qoes_Scene1.setVisible(true); 
       planet=true;
       
    }
    

    @FXML
    void MouseClicPlanet55(MouseEvent event) {
       Qoes_Scene1.setVisible(true); 
       planet=true;
      
    }
    
    @FXML
    void MouseClicStar11(MouseEvent event) {
       Qoes_Scene1.setVisible(true);   
       star=true; 
    }

    @FXML
    void MouseClicStar22(MouseEvent event) {
        Qoes_Scene1.setVisible(true); 
        star=true;  
    }

    @FXML
    void MouseClicStar33(MouseEvent event) {
        Qoes_Scene1.setVisible(true);   
        star=true;
    }

    @FXML
    void MouseClicStar44(MouseEvent event) {
        Qoes_Scene1.setVisible(true); 
        star=true;
    }

    @FXML
    void MouseClicStar55(MouseEvent event) {
       Qoes_Scene1.setVisible(true);  
       star=true;
    }
    
    @FXML
    void MouseClicPlanet111(MouseEvent event) {
       Qoes_Scene2.setVisible(true); 
       planet=true;
       
    }

    @FXML
    void MouseClicPlanet222(MouseEvent event) {
      Qoes_Scene2.setVisible(true);
      planet=true;
       
    }

    @FXML
    void MouseClicPlanet333(MouseEvent event) {
       Qoes_Scene2.setVisible(true); 
       planet=true;
       
    }

    @FXML
    void MouseClicPlanet444(MouseEvent event) {
       Qoes_Scene2.setVisible(true);
       planet=true;
       
    }
    

    @FXML
    void MouseClicPlanet555(MouseEvent event) {
       Qoes_Scene2.setVisible(true); 
       planet=true;
      
    }
    
    @FXML
    void MouseClicStar111(MouseEvent event) {
       Qoes_Scene2.setVisible(true);   
       star=true; 
    }

    @FXML
    void MouseClicStar222(MouseEvent event) {
        Qoes_Scene2.setVisible(true);
        star=true;  
    }

    @FXML
    void MouseClicStar333(MouseEvent event) {
        Qoes_Scene2.setVisible(true);  
        star=true;
    }

    @FXML
    void MouseClicStar444(MouseEvent event) {
        Qoes_Scene2.setVisible(true);
        star=true;
    }

    @FXML
    void MouseClicStar555(MouseEvent event) {
       Qoes_Scene2.setVisible(true);  
       star=true;
    }
    
    @FXML    
     void MouseClicPlanet(MouseEvent event) {
       
        if(planet){
            planet=false;
            Qoes_Scene.setVisible(false); 
            telescope_pane1.setVisible(true);
            msg1.setVisible(true);
            msg1.setText("");
            AnimationTimer timer = new Timer();
            timer.start();
            msg1.setText("Goood!"); 

            sco++;
        }
        else{
            Qoes_Scene.setVisible(false); 
            telescope_pane1.setVisible(true);
            msg1.setVisible(true);
            msg1.setText("");
            AnimationTimer timer = new Timer();
            timer.start();
            msg1.setText("Try Again");  
            
           
        }
       
    }

   
    
    
    @FXML
    void MouseClicStar(MouseEvent event) {
       
        if(star){
            star=false;
            Qoes_Scene.setVisible(false); 
            telescope_pane1.setVisible(true);
            msg1.setVisible(true);
            msg1.setText("");
            AnimationTimer timer = new Timer();
            timer.start();
            msg1.setText("Goood!"); 
            sco++;
            System.out.println(sco);

        }
        else{
            Qoes_Scene.setVisible(false);
            telescope_pane1.setVisible(true);
            msg1.setVisible(true);
            msg1.setText("");
            AnimationTimer timer = new Timer();
            timer.start();
            msg1.setText("Try Again");  

         
        }
     
          
    }
    
    
    @FXML    
     void MouseClicPlanet0(MouseEvent event) {
        
        if(planet){
            planet=false;
            Qoes_Scene1.setVisible(false); 
            telescope_pane11.setVisible(true);
            msg11.setVisible(true);
            msg11.setText("");
            AnimationTimer timer = new Timer1();
            timer.start();
            msg11.setText("Goood!"); 
            sco++;
            
            
        }
        else{
            Qoes_Scene1.setVisible(false); 
            telescope_pane11.setVisible(true);
            msg11.setVisible(true);
            msg11.setText("");
            AnimationTimer timer = new Timer1();
            timer.start();
            msg11.setText("Try Again");  
            
            
           
        }
      
          
    }
     
     @FXML
    void MouseClicStar0(MouseEvent event) {
          if(star){
            star=false;
            Qoes_Scene1.setVisible(false); 
            telescope_pane11.setVisible(true);
            msg11.setVisible(true);
            msg11.setText("");
            AnimationTimer timer = new Timer1();
            timer.start();
            msg11.setText("Goood!");
            sco++;
        }
        else{
            Qoes_Scene1.setVisible(false);
            telescope_pane11.setVisible(true);
            msg11.setVisible(true);
            msg11.setText("");
            AnimationTimer timer = new Timer1();
            timer.start();
            msg11.setText("Try Again");  
         
        }
       
    }
    
    
    @FXML    
     void MouseClicPlanet6(MouseEvent event) {
        
        if(planet){
            planet=false;
            Qoes_Scene2.setVisible(false); 
            telescope_pane11.setVisible(true);
            msg11.setVisible(true);
            msg11.setText("");
            AnimationTimer timer = new Timer2();
            timer.start();
            msg11.setText("Goood!"); 
            sco++;

            if(sco==0)
                textScore.setText("You Lose!");
            else if(sco==1){
                win1.setVisible(true);
                textScore.setText("You Win!");}
            else if(sco==2){
                win1.setVisible(true);
                win2.setVisible(true);
            textScore.setText("You Win!");}
            else if(sco==3){
                win1.setVisible(true);
                win2.setVisible(true);
                win3.setVisible(true);
                textScore.setText("You Win!");
            }
            
        }
        else{
            Qoes_Scene2.setVisible(false); 
            telescope_pane11.setVisible(true);
            msg11.setVisible(true);
            msg11.setText("");
            AnimationTimer timer = new Timer2();
            timer.start();
            msg11.setText("Try Again"); 

            if(sco==0)
                textScore.setText("You Lose!");
            else if(sco==1){
                win1.setVisible(true);
                textScore.setText("You Win!");}
            else if(sco==2){
                win1.setVisible(true);
                win2.setVisible(true);
            textScore.setText("You Win!");}
            else if(sco==3){
                win1.setVisible(true);
                win2.setVisible(true);
                win3.setVisible(true);
                textScore.setText("You Win!");
            }
            scorePane.setVisible(true);
            
           
        }
      
       
    }

   
    
    
    @FXML
    void MouseClicStar6(MouseEvent event) {
        
          if(star){
            star=false;
            Qoes_Scene2.setVisible(false); 
            telescope_pane11.setVisible(true);
            msg11.setVisible(true);
            msg11.setText("");
            AnimationTimer timer = new Timer2();
            timer.start();
            msg11.setText("Goood!"); 
            sco++;

            if(sco==0)
                textScore.setText("You Lose!");
            else if(sco==1){
                win1.setVisible(true);
                textScore.setText("You Win!");}
            else if(sco==2){
                win1.setVisible(true);
                win2.setVisible(true);
            textScore.setText("You Win!");}
            else if(sco==3){
                win1.setVisible(true);
                win2.setVisible(true);
                win3.setVisible(true);
                textScore.setText("You Win!");
            }
            scorePane.setVisible(true);
          
        }
        else{
            Qoes_Scene2.setVisible(false);
            telescope_pane11.setVisible(true);
            msg11.setVisible(true);
            msg11.setText("");
            AnimationTimer timer = new Timer2();
            timer.start();
            msg11.setText("Try Again");

            if(sco==0)
                textScore.setText("You Lose!");
            else if(sco==1){
                win1.setVisible(true);
                textScore.setText("You Win!");}
            else if(sco==2){
                win1.setVisible(true);
                win2.setVisible(true);
            textScore.setText("You Win!");}
            else if(sco==3){
                win1.setVisible(true);
                win2.setVisible(true);
                win3.setVisible(true);
                textScore.setText("You Win!");
            }
            scorePane.setVisible(true);  
         
        }
       
        
    }

    @FXML
    void MouseClicStart(MouseEvent event){
       Qoes_Scene.setVisible(false); 
       telescopeInfo.setVisible(false);
       telescope_pane.setVisible(true);
    }
    
    @FXML
    void backMenu(MouseEvent event) throws IOException {
        Media sound = new Media(new File("src/tothemystery/transition.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.autoPlayProperty();
        player.play();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryStr1 = "from Score ";
        Query query1 = session.createQuery(queryStr1);
        scList =  query1.list();
        session.close();
        int id=0;
        boolean exist=false;
        for(Score s: scList){
            if(s.getUserName().equals(currentUser.getName())){
                if(s.getGameName().equals("telescope")){
                    exist=true;
                    id=s.getGameId();
                    break;
                }
                    

            }
            id=s.getGameId();
        }
         System.out.println(exist);
         System.out.println(id);
         
         if(exist){
           Session session1 = HibernateUtil.getSessionFactory().openSession(); 
           session1.beginTransaction();
           Score s2 = null;
           s2 =(Score)session1.get(Score.class, id);
           s2.setScore(sco);
           session1.getTransaction().commit();
           session1.close();
         }else{
         Score s= new Score();
         s.setGameId(++id);
         s.setGameName("telescope");
         s.setUserName(currentUser.getName());
         s.setScore(sco);
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx4 = session2.beginTransaction();
        session2.save(s);
        tx4.commit();
        session2.close();
         }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("menu.fxml"));
       
        Parent menuParent = loader.load();
        Scene menuScene=new Scene(menuParent); 
        
        MenuController controller = loader.getController();//to get the controller
        controller.player(currentUser);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        String addwor = "The main difference between a planet and a star is that "
                 + "the planet is illuminated only by reflected light "
                 + "As for the star, it emits the light it produces, "
                 + "based on the nuclear reaction that takes place in the depths "
                 + "If you notice a bright point in the sky, focus your eyes on it"
                 + "If it flashes, it is a star, but if its brightness is constant, "
                 + "it does not change, then it is a planet.\n" 
                 +"In this game, try to distinguish between them "
                 + "by placing your mouse and clicking on it                   ";
        
        
        textInfo.setFont(Font.font(null, FontWeight.BOLD,21));
        textInfo.setFill(Color.BLACK);
        textInfo.setTranslateX(5);

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
        
        
         
             TranslateTransition tr = new TranslateTransition();
             tr.setNode(imageInfo);
             tr.setDuration(Duration.millis(1500));
             tr.setCycleCount(Animation.INDEFINITE);
            
            tr.setAutoReverse(true);
              tr.setByY(160);
             tr.setByY(15);
             
             tr.play();
             
        TranslateTransition tr2 = new TranslateTransition();
             tr2.setNode(textInfo);
             tr2.setDuration(Duration.millis(1500));
             tr2.setCycleCount(Animation.INDEFINITE);
           
           tr2.setAutoReverse(true);
              tr2.setByY(160);
             tr2.setByY(15);
             
             tr2.play();
       
       ToggleGroup group = new ToggleGroup();
       RadPlanet.setToggleGroup(group);
       RadStar.setToggleGroup(group);
       
       ToggleGroup group1 = new ToggleGroup();
       RadPlanet1.setToggleGroup(group1);
       RadStar1.setToggleGroup(group1);
       
       ToggleGroup group2 = new ToggleGroup();
       RadPlanet2.setToggleGroup(group2);
       RadStar2.setToggleGroup(group2);
       
       
     
   
           
     
     
    } 
    public class Timer extends AnimationTimer{
        
        @Override
        public void handle(long now) {
           doHandle();
        }
        public void doHandle(){
            opacity -= 0.008;
            msg1.opacityProperty().set(opacity);
            
            if(opacity <= 0){
                stop();
                
                
            }
        }
}
    
    public class Timer1 extends AnimationTimer{
        
        @Override
        public void handle(long now) {
           doHandle();
        }
        public void doHandle(){
            opacity1 -= 0.008;
            msg11.opacityProperty().set(opacity1);
            
            if(opacity1 <= 0){
                stop();
                
                
            }
        }
}
    
     public class Timer2 extends AnimationTimer{
        
        @Override
        public void handle(long now) {
           doHandle();
        }
        public void doHandle(){
            opacity2 -= 0.008;
            msg11.opacityProperty().set(opacity2);
            
            if(opacity2 <= 0){
                stop();
                
                
            }
        }
}
    
}
