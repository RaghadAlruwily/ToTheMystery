
package tothemystery;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;


public class ScoreFXMLController implements Initializable {

    @FXML
    private ImageView planet2;

    @FXML
    private ImageView planet1;

    @FXML
    private Text title;

    @FXML
    private ImageView saturnStar1;

    @FXML
    private ImageView saturnStar2;

    @FXML
    private ImageView saturnStar3;

    @FXML
    private ImageView uranusStar1;

    @FXML
    private ImageView uranusStar2;

    @FXML
    private ImageView uranusStar3;

    @FXML
    private ImageView marsStar1;

    @FXML
    private ImageView marsStar2;

    @FXML
    private ImageView marsStar3;

    @FXML
    private ImageView rocketStar1;

    @FXML
    private ImageView rocketStar2;

    @FXML
    private ImageView rocketStar3;

    @FXML
    private ImageView telescopeStar1;

    @FXML
    private ImageView telescopeStar2;

    @FXML
    private ImageView telescopeStar3;
    
    @FXML
    private ImageView back;

    @FXML
    void backScene(MouseEvent event) throws IOException {
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
        back.setFitHeight(back.getFitHeight()*1.2);
        back.setFitWidth(back.getFitWidth()*1.2);

    }

    @FXML
    void mouseOutButton(MouseEvent event) {
         back.setFitHeight(back.getFitHeight()/1.2);
        back.setFitWidth(back.getFitWidth()/1.2);

    }
    int saturnSco=0;
    int uranusSco=0;
    int marsSco=0;
    int rocketSco=0;
    int teleSco=0;
    private User currentUser;
 
    public void player(User u){
        currentUser = u;
        
        
    }
       @FXML
    private Rectangle recBoroad;

    @FXML
    private BorderPane scorePane;
    
    @FXML
    private Label label;

     @FXML
    private Button bt_star;
    List<Score> scList;
    
    @FXML
    void show(ActionEvent event) {
        bt_star.setVisible(false);
        recBoroad.setVisible(true);
        scorePane.setVisible(true);
        
        
        label.setText(label.getText()+" "+currentUser.getName());
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String queryStr1 = "from Score ";
        Query query1 = session.createQuery(queryStr1);
        scList =  query1.list();
        session.close();
        
        for(Score s: scList){ 

            if(s.getUserName().equals(currentUser.getName())){
               
                if( s.getGameName().equals("mars")){
                     marsSco=s.getScore();
           
                }
                    
                if(s.getGameName().equals("uranus")){
                     uranusSco=s.getScore();
                 
                }
                    
                if(s.getGameName().equals("saturn")){
                    saturnSco=s.getScore();
                   
                    
                }
                if(s.getGameName().equals("rocket")){
                    rocketSco=s.getScore();
                   
                    
                }
                if(s.getGameName().equals("telescope"))
                    teleSco=s.getScore();
                
            }
        }
         if(marsSco==3){
        marsStar1.setEffect(light);
        marsStar2.setEffect(light);
        marsStar3.setEffect(light);}
        
       if(uranusSco==3){
        uranusStar1.setEffect(light);
        uranusStar2.setEffect(light);
        uranusStar3.setEffect(light);}
       
       if(saturnSco==3){
        saturnStar1.setEffect(light);
        saturnStar2.setEffect(light);
        saturnStar3.setEffect(light);}
       
       if(rocketSco==3){
           rocketStar1.setEffect(light);
           rocketStar2.setEffect(light);
           rocketStar3.setEffect(light);
       }
       if(rocketSco==2){
           rocketStar1.setEffect(light);
           rocketStar2.setEffect(light);
       }
       if(rocketSco==1){
           rocketStar1.setEffect(light);
       }
       
       if(teleSco==3){
           telescopeStar3.setEffect(light);
           telescopeStar2.setEffect(light);
           telescopeStar1.setEffect(light);
 
       }
       if(teleSco==2){
           telescopeStar2.setEffect(light);
           telescopeStar1.setEffect(light);
 
       }
       if(teleSco==1){

           telescopeStar1.setEffect(light);
 
       }
       

          
        
        
    }
    
     Lighting light;

    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       light = new Lighting();
        light.setDiffuseConstant(1.17);
        System.out.println(marsSco+" "+uranusSco+" "+saturnSco);
        
        
    }
    
}
