package tothemystery;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author Khulood Alyaf3Y
 */
public class LoginController implements Initializable {
    @FXML
    private ImageView image;
    
    @FXML
    private TextField user_name;

    @FXML
    private TextField email;
    @FXML
    private Label lb_error;
  
    @FXML
    private AnchorPane message;

    @FXML
    private Button yesB;

    @FXML
    private Button noB;
    
    User u1=new User();

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = user_name.getText();
    }
    
    
  
  ObservableList<String> obEmail= FXCollections.observableArrayList();
 // ObservableList<String> obName= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         TranslateTransition tr = new TranslateTransition();
             tr.setNode(image);
             tr.setDuration(Duration.millis(1500));
             tr.setCycleCount(Animation.INDEFINITE);
            tr.setAutoReverse(true);
              tr.setByY(160);
             tr.setByY(15);
             tr.setAutoReverse(true);
             tr.play();
  
             
    } 
    
     public void move_about(ActionEvent e) throws IOException{
     
         
        User new_us=new User();
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        List<User> ulist = null;
     
        String queryStr = "from User";
        Query query = session1.createQuery(queryStr);
        ulist =  query.list();
        session1.close();
        
   if(user_name.getText().isEmpty()||email.getText().isEmpty())
     {lb_error.setVisible(true);
     return;}
     
    int state=0;
   if(validEmail(email.getText())){
     for(User u: ulist){ 
       if(u.getEmail().equals(email.getText()) && u.getName().equals(user_name.getText()))
        {  state=1;
           break;
      
        }else if(u.getName().equals(user_name.getText()) && u.getEmail()!=email.getText()){
           state=2;
           break;
         
        
       }else if(u.getName()!=user_name.getText() && u.getEmail().equals(email.getText())){
           state=3;
           break;
         
                }
       else{state=0;}

       }//end of loop
       System.out.println("state: "+state);
     if(state==1){
          Session session = HibernateUtil.getSessionFactory().openSession(); session.beginTransaction();
           User s2 =new User();
           s2.setEmail(email.getText());
           s2.setName(user_name.getText());
           /*
           String name=user_name.getText();
           s2 = (User)session.get(User.class, name);
           s2.setEmail(email.getText());
           session.getTransaction().commit();
           session.close();*/
           
        Media sound = new Media(new File("src/tothemystery/transition.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.autoPlayProperty();
        player.play();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("menu.fxml"));
       
        Parent menuParent = loader.load();
        Scene menuScene=new Scene(menuParent); 
        
        MenuController controller = loader.getController();//to get the controller
        controller.player(s2);
      
   
       Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
     
       window.setScene(menuScene);
       
      
     }
     else if(state==2){
          lb_error.setText("erorr name is not match with your email account");
          lb_error.setVisible(true);
         
     }
     else if(state==3){
          lb_error.setText("erorr email is not match with your name account");
          lb_error.setVisible(true);
     }
     else if(state==0){
               
         // User use=new User();
          u1.setName(user_name.getText());
          u1.setEmail(email.getText());
          
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx4 = session2.beginTransaction();
        session2.save(u1);
        tx4.commit();
        session2.close();
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("menu.fxml"));
       
        Parent menuParent = loader.load();
        Scene menuScene=new Scene(menuParent); 
        
        MenuController controller = loader.getController();//to get the controller
        controller.player(u1);
      
   
       Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
     
       window.setScene(menuScene);
             //}
}
     }else{
            lb_error.setText("erorr email is not correct ");
          lb_error.setVisible(true);
          }
   
        Media sound = new Media(new File("src/tothemystery/transition.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.autoPlayProperty();
        player.play();
     }
     
     
     
     public static boolean validEmail(String email_user){
    
     String corret_email="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
     Pattern emailpt=Pattern.compile(corret_email);
      Matcher  match =emailpt.matcher(email_user);
     
      return match.matches();
     }
 
      @FXML
    private Button bt_star;

    @FXML
    void MouseOutStar(MouseEvent event) {
 
        bt_star.setStyle("-fx-background-color:  #c9b97a;-fx-border-radius:20;-fx-background-radius:20");
    }


    @FXML
    void mouseOnStar(MouseEvent event) {

       bt_star.setStyle("-fx-background-color:  #c9b97a; -fx-border-color:#7485ab; -fx-border-width: 3;-fx-border-radius:20;-fx-background-radius:20;");
    }
    
    @FXML
    void clickNo(ActionEvent event) {
        message.setVisible(false);
        user_name.setText("");
        email.setText("");
        
        

    }

    @FXML
    void clickYes(ActionEvent event) throws IOException {
       Session session1 = HibernateUtil.getSessionFactory().openSession();
        List<User> user_list = null;
        String queryStr = "from User";
        Query query = session1.createQuery(queryStr);
        user_list =  query.list();
        session1.close(); 
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("menu.fxml"));
       
        Parent menuParent = loader.load();
        Scene menuScene=new Scene(menuParent); 
        
        MenuController controller = loader.getController();//to get the controller
        controller.player(u1);
      
   
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     
       window.setScene(menuScene);

    }
    
   
    }
    
    

     
