/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tothemystery;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author blacks
 */

public class Mars implements Initializable {
    
    
   //all code from net
    
     
    @FXML
    ImageView test;
    
    
     
   
    
    @FXML
    ImageView rocketwin;
    
    
    
     
    @FXML
    ImageView rocketback;

    
    @FXML
    ImageView staryello;
    
    
    @FXML
    ImageView staryello2;
    
    @FXML
    ImageView staryello3;
    
    @FXML
    ImageView starblack;
    
    
    @FXML
    ImageView l0;//lives
    
    @FXML
    ImageView l1;//lives
    
    
    @FXML
    ImageView l2;//lives
    
    
    @FXML
    ImageView l3;//score
    
    
    @FXML
    ImageView l4;//score
    
    
    @FXML
    ImageView l5;//score
    
    
    
    @FXML
    ImageView l6;//score
    
    
     @FXML
    ImageView l7;//score
    
    
      @FXML
    ImageView l8;//score
    
     @FXML
    ImageView blackstar;
    
     
    
     
    @FXML
    ImageView blackstar2;
    
    
     
    @FXML
    ImageView blackstar3;
    
    
    
    
    @FXML
    Text textlose;
    
    
    @FXML
    Text textwin;
    
    
     @FXML
    Text back;
    
    
    
    @FXML
     private static final String HERO_weapon ="/image/pngegg.png";
    
    @FXML
    private static final String Vealin_loc ="/image/alien-12.png";
    
    @FXML
    private ImageView heroimage;
    
    
    @FXML
    private ArrayList<Node> villian = new ArrayList<Node>();
    
     @FXML
    private ArrayList<Node> weapons = new ArrayList<Node>();
    
    @FXML
  private ImageView  weaponimage = new ImageView(HERO_weapon);

    
    private User currentUser;
 
    public void player(User u){
        currentUser = u;
        
        
    }
    List<Score> scList;

    Boolean h = true;
    
   
    
    Image image = new Image("/image/as.png", 500, 500, false, false);
   


    
    
  @FXML
  private ImageView  valiniamge = new ImageView(Vealin_loc);

    
    int modifier = 150;
    int villianCpunter = modifier-1;
    int dVillian = -2;           
               
               
     
    
    @FXML
    ImageView aWeapon;
    
      @FXML
      Button b;
    @FXML
    Pane root ;
   int score = 0;
                          
  int lives = 3;
@FXML
 Text  scoreText = new Text(110,10,"SCORE:"+score);
        
@FXML
 Text  liveText = new Text(110,20,"live:"+lives);
    
//Score s2 = null;
int sco=0;
    
        boolean throwing=true;

    private int dWeapon =10;
    @FXML 
    ImageView hero;
    
    
     ObservableList<Integer> obIds= FXCollections.observableArrayList();
     int id=0;
    
    @FXML
    
      public  void keyPressed(KeyEvent event) throws Exception{
        

          
          if(event.getCode()==KeyCode.UP&hero.getLayoutY()>80){
          
          
          
          hero.setLayoutY(hero.getLayoutY()-50);
          
          
          System.out.print("hi");
          
          }
          
          
          
          
           if(event.getCode()==KeyCode.ENTER & h==true){
          
           
           
           Score s2 = null;
          
           AnimationTimer timer = new AnimationTimer() {
            
              


              @Override
              public void handle(long now) {

               
                villianCpunter++;
                if(villianCpunter%modifier==0){
                
                 if(modifier>20) modifier--;
                  
                  
                  Node newVillian = new ImageView (Vealin_loc) ;
               newVillian.relocate(900, (int)(Math.random()*500+40));
                villian.add ( newVillian ) ;
                root.getChildren ( ) .add ( newVillian ) ;
                  
                }
                  
                  
                 throwWeapon(dWeapon);
                  
                  moveVilin(dVillian);
                
                    checklit( ) ; 
                
                
     
                if ( score == 6) {
                    throwing=false;
                    h= false;
                    this.stop();
                   
             
                
                      textwin.setVisible(true);
                   
                System.out.print("take a message");
                
                
                  this.stop();
                 
                for(int i = 0 ; i<villian.size();i++){
                   root.getChildren().remove(villian.get(i));
                    villian.remove(i);
                    }


                  
           

        }
            
              
                     
                if ( lives == 0 ) {
                  throwing=false;
                  h= false;
                                   this.stop();
                                   
                 sco=0;
                 Session session = HibernateUtil.getSessionFactory().openSession();
        String queryStr1 = "from Score ";
        Query query1 = session.createQuery(queryStr1);
        scList =  query1.list();
        session.close();
        
        boolean exist=false;
        for(Score s: scList){
            if(s.getUserName().equals(currentUser.getName())){
                if(s.getGameName().equals("mars")){
                    exist=true;
                    id=s.getGameId();
                    break;
                }
                   
            } id=s.getGameId();
        }
         System.out.println(exist);
         System.out.println(id);
         
         if(exist){
           Session session1 = HibernateUtil.getSessionFactory().openSession(); 
           session1.beginTransaction();
           Score s2 =(Score)session1.get(Score.class, id);
           s2.setScore(sco);
           session1.getTransaction().commit();
           session1.close();
         }else{
         Score s= new Score();
         s.setGameId(++id);
         s.setGameName("mars");
         s.setUserName(currentUser.getName());
         s.setScore(sco);
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx4 = session2.beginTransaction();
        session2.save(s);
        tx4.commit();
        session2.close();
         }
                                   
                  
back.setVisible(true);
blackstar.setVisible(true);
blackstar2.setVisible(true);
blackstar3.setVisible(true);                        

                  test.setVisible(true);
                rocketback.setVisible(true);

        
        textlose.setVisible(true);
        
       // rocketgameagain.setVisible(true);
    for(int i = 0 ; i<villian.size();i++){
    
    root.getChildren().remove(villian.get(i));
    villian.remove(i);
      
    }
      
     
         
         
         rocketback.setOnMouseClicked(eh->{
            
        
          
     
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
                          Logger.getLogger(Mars.class.getName()).log(Level.SEVERE, null, ex);
                      }
            
        Scene menuScene=new Scene(menuParent); 
        
        planetsListController controller = loader.getController();//to get the controller
        controller.player(currentUser);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(menuScene);


     });
         
         
         
         
         
         
         
         
         
         
                //  this.stop ( ) ;
               

               this.stop(); }
                
            
                }
              
                


          };
           timer.start();
          
          
       sco=3;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryStr1 = "from Score ";
        Query query1 = session.createQuery(queryStr1);
        scList =  query1.list();
        session.close();
        int id=0;
        boolean exist=false;
        for(Score s: scList){
            if(s.getUserName().equals(currentUser.getName())){
                if(s.getGameName().equals("mars")){
                    exist=true;
                    id=s.getGameId();
                    break;
                }
                   
            } id=s.getGameId();
        }
         System.out.println(exist);
         System.out.println(id);
         
         if(exist){
           Session session1 = HibernateUtil.getSessionFactory().openSession(); 
           session1.beginTransaction();
           //Score s2 = null;
           s2 =(Score)session1.get(Score.class, id);
           s2.setScore(sco);
           session1.getTransaction().commit();
           session1.close();
         }else{
         Score s= new Score();
         s.setGameId(++id);
         s.setGameName("mars");
         s.setUserName(currentUser.getName());
         s.setScore(sco);
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx4 = session2.beginTransaction();
        session2.save(s);
        tx4.commit();
        session2.close();
         }
          
          
          }
          
          
          
          
          
          
          
          
          
          if(event.getCode()==KeyCode.DOWN&hero.getLayoutY()<580){
          
          
          
          hero.setLayoutY(hero.getLayoutY()+50);
          
          
          System.out.print("go");
          
          }
          
          
          
          if(event.getCode()==KeyCode.LEFT&hero.getLayoutX()>10){
          
          
          
          hero.setLayoutX(hero.getLayoutX()-50);
          
          
          System.out.print("J");
          
          }
          
          
          if(event.getCode()==KeyCode.RIGHT&hero.getLayoutX()<630){
          
          
          
          hero.setLayoutX(hero.getLayoutX()+50);
          
          
          System.out.print("K");
          
          }
          
          if(event.getCode()==KeyCode.SPACE & throwing==true){
              
             Media sound = new Media(new File("src/tothemystery/RPReplay_Final1638108053.mp3").toURI().toString());
             MediaPlayer player = new MediaPlayer(sound);
             player.autoPlayProperty();
             player.play();
        
           
              
          

              
         throwWeapon(dWeapon);
         aWeapon = new ImageView(HERO_weapon);
         Node newWeapon = aWeapon;
         newWeapon.relocate(hero.getLayoutX()+hero.getBoundsInLocal().getWidth(), hero.getLayoutY());
          weapons.add(newWeapon);
          root.getChildren().add(newWeapon);
          
          
          
         
          }
          
    
      
 }

      
          @FXML
    void winScene(MouseEvent event) throws IOException {
        Media sound = new Media(new File("src/tothemystery/transition.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.autoPlayProperty();
        player.play();
        
  
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("winmars.fxml"));
       
        Parent winM_parent = loader.load();
        Scene winM_Scene=new Scene(winM_parent); 
        
        WinControllerMars controller = loader.getController();//to get the controller
        controller.player(currentUser);
      
      
   
     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     
     window.setScene(winM_Scene);
   

    }
    
     
    
    
    
    @FXML 
    private void moveVilin(int delta) {
    
    
    
    for(int i = 0 ; i<villian.size();i++){
    
    if(villian.get(i).getLayoutX()>-villian.get(i).getBoundsInLocal().getWidth()){
                    villian.get(i).relocate(villian.get(i).getLayoutX()+delta, villian.get(i).getLayoutY());
          
      
    }
    else{
    
    
    root.getChildren().remove(villian.get(i));
    villian.remove(i);
    lives--;
    
    if(lives==1){
    
        l1.setVisible(false);

    
    }
    if(lives==0){
    
        l2.setVisible(false);

    
    }
    
    
    if(lives==2){
    
        l0.setVisible(false);

    
    }
    
    
   
      
    }
    
  
    
    }
    }
    
    
    
     
     @FXML 
    private void throwWeapon(int delta) {
                 
                 for(int i =0;i<weapons.size();i++){
                    if(weapons.get(i).getLayoutX()<900){
                    weapons.get(i).relocate(weapons.get(i).getLayoutX()+delta, weapons.get(i).getLayoutY());
                    
                    
                    }
                    else weapons.remove(i);
                
                
                
                
                }
                
                 
                 
                 
              }    
    
         
            private void checklit() {
                
                for(int i =0;i<weapons.size();i++){
                    
                for(int j=0;j<villian.size();j++){
                    if(weapons.get(i).getBoundsInParent().intersects(villian.get(j).getBoundsInParent())){
                     root.getChildren().remove(villian.get(j));
                     villian.remove(j);
                     
                     
                    root.getChildren().remove(weapons.get(i));
                    weapons.remove(i);
                    
                     
                     
    
                     
                    score++;
                    
                    if(score==1){
    
        l3.setVisible(true);

    
    }
           if(score==2){
    
        l4.setVisible(true);

    
    }          
         if(score==3){
    
        l5.setVisible(true);

    
    }   
         
         if(score==4){
    
        l6.setVisible(true);

    
    }       
         if(score==5){
    
        l7.setVisible(true);

    
    }       
         
         
         if(score==6){
             
                  l8.setVisible(true);
   
             
        test.setVisible(true);
        
        
        
        
        staryello.setVisible(true);
        staryello2.setVisible(true);
        staryello3.setVisible(true);
        
        
             
        
        rocketwin.setVisible(true);
        
             
             aWeapon.setVisible(false);
             
   
    
    }
                    
                    
                    
                 
                    }
                    
                
                
                
                
                }
                
                
                
                }
                
    
    }       
                  


    

    public void initialize(URL url, ResourceBundle rb) {
        
       
}   
    
    
    
}