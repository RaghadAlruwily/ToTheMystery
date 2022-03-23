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
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
 * FXML Controller class
 *
 * @author Khulood Alyaf3Y
 */
public class RocketGameController implements Initializable {
 
    @FXML
    ArrayList<ImageView> obstacle = new ArrayList<ImageView>();
    
    @FXML
    private AnchorPane pane;
    
    @FXML
    private ImageView roc;

    @FXML
    private ImageView plan1;

    @FXML
    private ImageView heart1;

    @FXML
    private ImageView hear2;

    @FXML
    private ImageView heart3;
    
    @FXML
    private ImageView heart4;

    @FXML
    private ImageView heart5;

    @FXML
    private ImageView heart6;

    @FXML
    private ImageView heart7;
    
    @FXML
    private ImageView plant3;

    @FXML
    private ImageView plant6;

    @FXML
    private ImageView plant5;

    @FXML
    private ImageView plant4;

    @FXML
    private ImageView plant2;
    
    @FXML
    private ImageView star;
    @FXML
    private ImageView star1;

    @FXML
    private ImageView star2;

    @FXML
    private ImageView star3;

    @FXML
    private ImageView star4;

    @FXML
    private ImageView star5;

    @FXML
    private ImageView star6;
    
    @FXML
    private Pane winPane;
    
    @FXML
    private ImageView astro;
    
    @FXML
    private Text wonText;
    
    @FXML
    private ImageView win1;

    @FXML
    private ImageView win2;

    @FXML
    private ImageView win3;
    
    @FXML
    private Text textInfo;

    @FXML
    private Pane miniWindow;
    
    @FXML
    private ImageView nextButton;
    
    List<Score> scList   ;
    
     @FXML
    void goToMenu(MouseEvent event) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryStr1 = "from Score ";
        Query query1 = session.createQuery(queryStr1);
        scList =  query1.list();
        session.close();
        int id=0;
        boolean exist=false;
        for(Score s: scList){
            if(s.getUserName().equals(currentUser.getName())){
                if(s.getGameName().equals("rocket")){
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
           s2.setScore(rank);
           session1.getTransaction().commit();
           session1.close();
         }else{
         Score s= new Score();
         s.setGameId(++id);
         s.setGameName("rocket");
         s.setUserName(currentUser.getName());
         s.setScore(rank);
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
        
        Media sound = new Media(new File("src/tothemystery/RPReplay_Final1638629434.mp3").toURI().toString());
             MediaPlayer player = new MediaPlayer(sound);
             player.autoPlayProperty();
             player.play();

    }

    

    RotateTransition r6 = new RotateTransition();
    RotateTransition r5 = new RotateTransition();
    RotateTransition r4 = new RotateTransition();
    RotateTransition r3 = new RotateTransition();
    RotateTransition r2 = new RotateTransition();
    RotateTransition r1 = new RotateTransition();
    RotateTransition r = new RotateTransition();
   int j=6,count=3;
   double toWin=548;
   int rank=0;
   double opacity=1; //for timer and mini window
   private User currentUser;
 
    public void player(User u){
        currentUser = u;
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

       ImageView[] herat={heart3,hear2,heart1,heart4,heart5,heart6,heart7};
       obstacle.add(plan1);obstacle.add(plant2);obstacle.add(plant3);obstacle.add(plant4);obstacle.add(plant5);obstacle.add(plant6);obstacle.add(plan1);
       
        //------------$ win state:  $------------   
        
       
        
           

        ArrayList<ImageView> stars=new ArrayList<>();
        stars.add(star);stars.add(star1);stars.add(star2);stars.add(star3);stars.add(star4);stars.add(star5);stars.add(star6);
       for(ImageView n: obstacle){
       
       rotate(n);
        
       
       
       //planets code :
       
         roc.layoutXProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+34>=(n.getLayoutX())&&roc.getLayoutX()-34<=(n.getLayoutX()+10)&&(roc.getLayoutY()+30)>=n.getLayoutY()&&(roc.getLayoutY()-30)<=n.getLayoutY()+40)
                {if(count==0 && j!=-1){
                    herat[j].setVisible(false);
                  j--;count=3;}
                count--;
                
                }
                
                
                
                   });
           roc.layoutYProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+34>=(n.getLayoutX())&&roc.getLayoutX()-34<=(n.getLayoutX()+10)&&(roc.getLayoutY()+30)>=n.getLayoutY()&&(roc.getLayoutY()-30)<=n.getLayoutY()+40)
                {if(count==0 && j!=-1){
                    herat[j].setVisible(false);
                  j--;count=3;}
                count--;
                }   
                
                   });  }
           
      
      // ----------------------- move star : --------------------
        
        AnimationTimer t=new AnimationTimer() { 

           @Override
           public void handle(long now) {
        
        r.setNode(star);
        r.setDuration(Duration.millis(3000));
        r.setCycleCount(TranslateTransition.INDEFINITE);
        r.setInterpolator(Interpolator.LINEAR);
        r.setByAngle(360);
        r.play();
       star.setLayoutY(star.getLayoutY() +0.4);
        
        if (star.getLayoutX() < 0) {
        star.setLayoutX(star.getLayoutX() + pane.getWidth());
    }

    if (star.getLayoutX() > pane.getWidth()) {
        star.setLayoutX(star.getLayoutX() % pane.getWidth());
    }

    if (star.getLayoutY() < 0) {
        star.setLayoutY(star.getLayoutY() + pane.getHeight());
    }

    if (star.getLayoutY() > pane.getHeight()) {
        star.setLayoutY(star.getLayoutY() % pane.getHeight());
    }
     
    star1.setLayoutY(star1.getLayoutY() +0.4);
        
        if (star1.getLayoutX() < 0) {
        star1.setLayoutX(star1.getLayoutX() + pane.getWidth());
    }

    if (star1.getLayoutX() > pane.getWidth()) {
        star1.setLayoutX(star1.getLayoutX() % pane.getWidth());
    }

    if (star1.getLayoutY() < 0) {
        star1.setLayoutY(star1.getLayoutY() + pane.getHeight());
    }

    if (star1.getLayoutY() > pane.getHeight()) {
        star1.setLayoutY(star1.getLayoutY() % pane.getHeight());
    }


    }
        
       };t.start();
       
       roc.layoutXProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star.getLayoutX())&&roc.getLayoutX()-14<=(star.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star.getLayoutY()&&(roc.getLayoutY()-30)<=star.getLayoutY()+20)
                {
                   star.setLayoutX(toWin);
                   star.setLayoutY(23);
                   t.stop();
                   toWin=50+star.getLayoutX();
                   r.stop();
                   
                   
                   
                }     
                 if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
        else if(j==-1){
            //game.stop();
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }
                
                   });
           roc.layoutYProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star.getLayoutX())&&roc.getLayoutX()-14<=(star.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star.getLayoutY()&&(roc.getLayoutY()-30)<=star.getLayoutY()+20)
                {
                   star.setLayoutX(toWin);
                   star.setLayoutY(23);
                   t.stop();
                    toWin=50+star.getLayoutX();
                   r.setByAngle(0);
                   r.stop();
                }   
               if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
        else if(j==-1){
            //game.stop();
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }
                   });
       
       //-----------move star 1 : -------------------------------- 
       
       AnimationTimer t1=new AnimationTimer() { 

           @Override
           public void handle(long now) {
               
        r1.setNode(star1);
        r1.setDuration(Duration.millis(3000));
        r1.setCycleCount(TranslateTransition.INDEFINITE);
        r1.setInterpolator(Interpolator.LINEAR);
        r1.setByAngle(360);
        r1.play();
     
    star1.setLayoutY(star1.getLayoutY() +0.4);
        
        if (star1.getLayoutX() < 0) {
        star1.setLayoutX(star1.getLayoutX() + pane.getWidth());
    }

    if (star1.getLayoutX() > pane.getWidth()) {
        star1.setLayoutX(star1.getLayoutX() % pane.getWidth());
    }

    if (star1.getLayoutY() < 0) {
        star1.setLayoutY(star1.getLayoutY() + pane.getHeight());
    }

    if (star1.getLayoutY() > pane.getHeight()) {
        star1.setLayoutY(star1.getLayoutY() % pane.getHeight());
    }

    }
       };t1.start();
       
       roc.layoutXProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star1.getLayoutX())&&roc.getLayoutX()-14<=(star1.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star1.getLayoutY()&&(roc.getLayoutY()-30)<=star1.getLayoutY()+20)
                {
                   star1.setLayoutX(toWin);
                   star1.setLayoutY(23);
                   t1.stop();
                   toWin=50+star1.getLayoutX();
                   r1.stop();
                }     
                if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
        else if(j==-1){
            //game.stop();
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }
                
                
                   });
           roc.layoutYProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star1.getLayoutX())&&roc.getLayoutX()-14<=(star1.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star1.getLayoutY()&&(roc.getLayoutY()-30)<=star1.getLayoutY()+20)
                {
                   star1.setLayoutX(toWin);
                   star1.setLayoutY(23);
                   t1.stop();
                    toWin=50+star1.getLayoutX();
                   r1.stop();
                }   
                 if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
       else if(j==-1){
            //game.stop();
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }
                
                   });
           
           //-----------move star 2 : -------------------------------- 
       
       AnimationTimer t2=new AnimationTimer() { 

           @Override
           public void handle(long now) {
               
        r2.setNode(star2);
        r2.setDuration(Duration.millis(3000));
        r2.setCycleCount(TranslateTransition.INDEFINITE);
        r2.setInterpolator(Interpolator.LINEAR);
        r2.setByAngle(360);
        r2.play();
     
    star2.setLayoutY(star2.getLayoutY() +1);
        
        if (star2.getLayoutX() < 0) {
        star2.setLayoutX(star2.getLayoutX() + pane.getWidth());
    }

    if (star2.getLayoutX() > pane.getWidth()) {
        star2.setLayoutX(star2.getLayoutX() % pane.getWidth());
    }

    if (star2.getLayoutY() < 0) {
        star2.setLayoutY(star2.getLayoutY() + pane.getHeight());
    }

    if (star2.getLayoutY() > pane.getHeight()) {
        star2.setLayoutY(star2.getLayoutY() % pane.getHeight());
    }

    }
       };t2.start();
       
       roc.layoutXProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star2.getLayoutX())&&roc.getLayoutX()-14<=(star2.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star2.getLayoutY()&&(roc.getLayoutY()-30)<=star2.getLayoutY()+20)
                {
                   star2.setLayoutX(toWin);
                   star2.setLayoutY(23);
                   t2.stop();
                   toWin=50+star2.getLayoutX();
                   r2.stop();
                }     
                 if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
       else if(j==-1){
            //game.stop();
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }                
                
                   });
           roc.layoutYProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star2.getLayoutX())&&roc.getLayoutX()-14<=(star2.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star2.getLayoutY()&&(roc.getLayoutY()-30)<=star2.getLayoutY()+20)
                {
                   star2.setLayoutX(toWin);
                   star2.setLayoutY(23);
                   t2.stop();
                    toWin=50+star2.getLayoutX();
                   r2.stop();
                }   
                 if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
       else if(j==-1){
            
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }
                   });
           
           //-----------move star 3 : -------------------------------- 
       
       AnimationTimer t3=new AnimationTimer() { 

           @Override
           public void handle(long now) {
               
        r3.setNode(star3);
        r3.setDuration(Duration.millis(3000));
        r3.setCycleCount(TranslateTransition.INDEFINITE);
        r3.setInterpolator(Interpolator.LINEAR);
        r3.setByAngle(360);
        r3.play();
     
    star3.setLayoutY(star3.getLayoutY() +0.7);
        
        if (star3.getLayoutX() < 0) {
        star3.setLayoutX(star3.getLayoutX() + pane.getWidth());
    }

    if (star3.getLayoutX() > pane.getWidth()) {
        star3.setLayoutX(star3.getLayoutX() % pane.getWidth());
    }

    if (star3.getLayoutY() < 0) {
        star3.setLayoutY(star3.getLayoutY() + pane.getHeight());
    }

    if (star3.getLayoutY() > pane.getHeight()) {
        star3.setLayoutY(star3.getLayoutY() % pane.getHeight());
    }

    }
       };t3.start();
       
       roc.layoutXProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star3.getLayoutX())&&roc.getLayoutX()-14<=(star3.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star3.getLayoutY()&&(roc.getLayoutY()-30)<=star3.getLayoutY()+20)
                {
                   star3.setLayoutX(toWin);
                   star3.setLayoutY(23);
                   t3.stop();
                   toWin=50+star3.getLayoutX();
                   r3.stop();
                }     
                 if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
       else if(j==-1){
            //game.stop();
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }     
                
                   });
           roc.layoutYProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star3.getLayoutX())&&roc.getLayoutX()-14<=(star3.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star3.getLayoutY()&&(roc.getLayoutY()-30)<=star3.getLayoutY()+20)
                {
                   star3.setLayoutX(toWin);
                   star3.setLayoutY(23);
                   t3.stop();
                    toWin=50+star3.getLayoutX();
                   r3.stop();
                }   
                 if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
      else  if(j==-1){
            //game.stop();
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }
                   });
           
           //-----------move star 4 : -------------------------------- 
       
       AnimationTimer t4=new AnimationTimer() { 

           @Override
           public void handle(long now) {
               
        r4.setNode(star4);
        r4.setDuration(Duration.millis(3000));
        r4.setCycleCount(TranslateTransition.INDEFINITE);
        r4.setInterpolator(Interpolator.LINEAR);
        r4.setByAngle(360);
        r4.play();
     
    star4.setLayoutY(star4.getLayoutY() +0.55);
        
        if (star4.getLayoutX() < 0) {
        star4.setLayoutX(star4.getLayoutX() + pane.getWidth());
    }

    if (star4.getLayoutX() > pane.getWidth()) {
        star4.setLayoutX(star4.getLayoutX() % pane.getWidth());
    }

    if (star4.getLayoutY() < 0) {
        star4.setLayoutY(star4.getLayoutY() + pane.getHeight());
    }

    if (star4.getLayoutY() > pane.getHeight()) {
        star4.setLayoutY(star4.getLayoutY() % pane.getHeight());
    }

    }
       };t4.start();
       
       roc.layoutXProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star4.getLayoutX())&&roc.getLayoutX()-14<=(star4.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star4.getLayoutY()&&(roc.getLayoutY()-30)<=star4.getLayoutY()+20)
                {
                   star4.setLayoutX(toWin);
                   star4.setLayoutY(23);
                   t4.stop();
                   toWin=50+star4.getLayoutX();
                   r4.stop();
                }     
                 if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
       else if(j==-1){
            //game.stop();
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }
                
                   });
           roc.layoutYProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star4.getLayoutX())&&roc.getLayoutX()-14<=(star4.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star4.getLayoutY()&&(roc.getLayoutY()-30)<=star4.getLayoutY()+20)
                {
                   star4.setLayoutX(toWin);
                   star4.setLayoutY(23);
                   t4.stop();
                    toWin=50+star4.getLayoutX();
                   r4.stop();
                }   
                 if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
       else if(j==-1){
            //game.stop();
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }
                   });
           
           //-----------move star 5 : -------------------------------- 
       
       AnimationTimer t5=new AnimationTimer() { 

           @Override
           public void handle(long now) {
               
        r5.setNode(star5);
        r5.setDuration(Duration.millis(3000));
        r5.setCycleCount(TranslateTransition.INDEFINITE);
        r5.setInterpolator(Interpolator.LINEAR);
        r5.setByAngle(360);
        r5.play();
     
    star5.setLayoutY(star5.getLayoutY() +0.9);
        
        if (star5.getLayoutX() < 0) {
        star5.setLayoutX(star5.getLayoutX() + pane.getWidth());
    }

    if (star5.getLayoutX() > pane.getWidth()) {
        star5.setLayoutX(star5.getLayoutX() % pane.getWidth());
    }

    if (star5.getLayoutY() < 0) {
        star5.setLayoutY(star5.getLayoutY() + pane.getHeight());
    }

    if (star5.getLayoutY() > pane.getHeight()) {
        star5.setLayoutY(star5.getLayoutY() % pane.getHeight());
    }

    }
       };t5.start();
       
       roc.layoutXProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star5.getLayoutX())&&roc.getLayoutX()-14<=(star5.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star5.getLayoutY()&&(roc.getLayoutY()-30)<=star5.getLayoutY()+20)
                {
                   star5.setLayoutX(toWin);
                   star5.setLayoutY(23);
                   t5.stop();
                   toWin=50+star5.getLayoutX();
                   r5.stop();
                }     
                if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
      else  if(j==-1){
            
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }
                   });
           roc.layoutYProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star5.getLayoutX())&&roc.getLayoutX()-14<=(star5.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star5.getLayoutY()&&(roc.getLayoutY()-30)<=star5.getLayoutY()+20)
                {
                   star5.setLayoutX(toWin);
                   star5.setLayoutY(23);
                   t5.stop();
                    toWin=50+star5.getLayoutX();
                   r5.stop();
                }   
                if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
       else if(j==-1){
            //game.stop();
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }
                   });
           
           //-----------move star 6 : -------------------------------- 
       
       AnimationTimer t6=new AnimationTimer() { 

           @Override
           public void handle(long now) {
               
        
        r6.setNode(star6);
        r6.setDuration(Duration.millis(3000));
        r6.setCycleCount(TranslateTransition.INDEFINITE);
        r6.setInterpolator(Interpolator.LINEAR);
        r6.setByAngle(360);
        r6.play();
     
    star6.setLayoutY(star6.getLayoutY() +0.67);
        
        if (star6.getLayoutX() < 0) {
        star6.setLayoutX(star6.getLayoutX() + pane.getWidth());
    }

    if (star6.getLayoutX() > pane.getWidth()) {
        star6.setLayoutX(star6.getLayoutX() % pane.getWidth());
    }

    if (star6.getLayoutY() < 0) {
        star6.setLayoutY(star6.getLayoutY() + pane.getHeight());
    }

    if (star6.getLayoutY() > pane.getHeight()) {
        star6.setLayoutY(star6.getLayoutY() % pane.getHeight());
    }

    }
       };t6.start();
       
       roc.layoutXProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star6.getLayoutX())&&roc.getLayoutX()-14<=(star6.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star6.getLayoutY()&&(roc.getLayoutY()-30)<=star6.getLayoutY()+20)
                {
                   star6.setLayoutX(toWin);
                   star6.setLayoutY(23);
                   t6.stop();
                   toWin=50+star6.getLayoutX();
                   r6.stop();
                   
                }     
                
                 if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
       else if(j==-1){
            //game.stop();
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }
                   });
           roc.layoutYProperty().addListener((observable)->{
            
                if(roc.getLayoutX()+14>=(star6.getLayoutX())&&roc.getLayoutX()-14<=(star6.getLayoutX()+10)&&(roc.getLayoutY()+30)>=star6.getLayoutY()&&(roc.getLayoutY()-30)<=star6.getLayoutY()+20)
                {
                   star6.setLayoutX(toWin);
                   star6.setLayoutY(23);
                   t6.stop();
                    toWin=50+star6.getLayoutX();
                   r6.stop();
                }   
                 if(toWin==898.0){
            
            winPane.setVisible(true);
            
            if(j==6){
                win3.setVisible(true);
                win2.setVisible(true);
                win1.setVisible(true);
                rank=3;
            }
            else if(j>=3){
                win2.setVisible(true);
                win1.setVisible(true);
                rank=2;
            }
            else if(j>=0){
                win1.setVisible(true);
                rank=1;
            }
            
        }
        
       else if(j==-1){
            //game.stop();
            winPane.setVisible(true);
            wonText.setText("You Lose!");
            
        }
                   });
           
           
          
           
      AnimationTimer game = new AnimationTimer() { //ذا الكود عشان تتحرك الكواكب 

           @Override
           public void handle(long now) {
        
        obstacle.forEach(n -> 
        {
     
    n.setLayoutY(n.getLayoutY() +0.7);
        
    if (n.getLayoutX() < 0) {
    n.setLayoutX(n.getLayoutX() + pane.getWidth());
    }

    if (n.getLayoutX() > pane.getWidth()) {
        n.setLayoutX(n.getLayoutX() % pane.getWidth());
    }

    if (n.getLayoutY() < 0) {
        n.setLayoutY(n.getLayoutY() + pane.getHeight());
    }

    if (n.getLayoutY() > pane.getHeight()) {
        n.setLayoutY(n.getLayoutY() % pane.getHeight());
    }
        
        });
         }};game.start();
         
          
       
         
        
            
    }
    
 
void rotate(ImageView i){
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(i);
        rotate.setDuration(Duration.millis(3000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.play();
    }
    
    @FXML
    void rocketMovement(KeyEvent event) throws Exception {
        
      if(event.getCode()==KeyCode.UP & roc.getLayoutY()>20)      
      {  ;
          roc.setLayoutY(roc.getLayoutY()-10 );
          
             
            }
          
          if(event.getCode()==KeyCode.DOWN & roc.getLayoutY()<580) 
            {
            
             roc.setLayoutY(roc.getLayoutY()+10);
            
                 
             }
          
            if(event.getCode()==KeyCode.LEFT & roc.getLayoutX()>5)
            {
             
             roc.setLayoutX(roc.getLayoutX()-10);
            
            
               }
             if(event.getCode()==KeyCode.RIGHT & roc.getLayoutX()<780)
            { ;
              
              roc.setLayoutX(roc.getLayoutX()+10);
             
              
            
            }
     
}
    
}