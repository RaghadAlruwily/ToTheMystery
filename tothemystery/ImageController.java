/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tothemystery;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vip
 */
public class ImageController implements Initializable {
    @FXML
    public Pane pane;

    @FXML
    public Node rocketImage;
    @FXML
    public ImageView asteroidImage;
    @FXML
    public ImageView marsImage;
    @FXML
    public ImageView neptuneImage;
    @FXML
    public ImageView purplezoidImage;
    @FXML
    public ImageView duneImage;
    @FXML
    public ImageView saturnImage;

    @FXML
    public Node rozImage;
    @FXML
    public Node roboImage;
    @FXML
    public Node rohe0Image;
    @FXML
    public Node rokheImage;
    @FXML
    public Node rohe2Image;
    @FXML
    public Node roctImage;
    
    @FXML
    private Pane rocketButton;

    @FXML
    void goToNext(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("intoRocketGame.fxml"));
       
        Parent intoRocketParent  = loader.load();
        Scene into_Scene=new Scene(intoRocketParent); 
        
        IntoRocketGameController controller = loader.getController();//to get the controller
        controller.player(currentUser);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(into_Scene);
        
         Media sound = new Media(new File("src/tothemystery/transition.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.autoPlayProperty();
        player.play();

    }

    @FXML
    void mouseOnButton(MouseEvent event) {
        rocketButton.setMinHeight(rocketButton.getHeight()*1.3);
        rocketButton.setMinWidth(rocketButton.getWidth()*1.3);

    }

    @FXML
    void mouseOutButton(MouseEvent event) {
        rocketButton.setMinHeight(rocketButton.getHeight()/1.3);
        rocketButton.setMinWidth(rocketButton.getWidth()/1.3);
        

    }

    private final List<SnappyNode> snappyNodes = new ArrayList<>();

    private User currentUser;
 
    public void player(User u){
        currentUser = u;
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane.widthProperty().addListener((obs, oldWidth, width) -> widthUpdated(width.doubleValue()));
        pane.heightProperty().addListener((obs, oldHeight, height) -> heightUpdated(height.doubleValue()));

        snappyNodes.add(new SnappyNode(rocketImage, rozImage, new Point2D(0, 381)));
        snappyNodes.add(new SnappyNode(rocketImage, roboImage, new Point2D(23, 233)));
        snappyNodes.add(new SnappyNode(rocketImage, rohe0Image, new Point2D(24, 146)));
        snappyNodes.add(new SnappyNode(rocketImage, rokheImage, new Point2D(13, 83)));
        snappyNodes.add(new SnappyNode(rocketImage, roctImage, new Point2D(-2, 62)));
        snappyNodes.add(new SnappyNode(rocketImage, rohe2Image, new Point2D(11, 6)));
    }

    private void widthUpdated(double width) {
        rocketImage.setLayoutX(0.6 * width);

        asteroidImage.setFitWidth(width);
        marsImage.setFitWidth(width * 0.1);
        marsImage.setLayoutX(width * 0.45);
        neptuneImage.setFitWidth(width * 0.1);
        neptuneImage.setLayoutX(width * 0.3);
        saturnImage.setFitWidth(width * 0.1);
        saturnImage.setLayoutX(width * 0.2);
        purplezoidImage.setFitWidth(width * 0.05);
        purplezoidImage.setLayoutX(width * 0.7);
        duneImage.setFitWidth(width * 0.025);
        duneImage.setLayoutX(width * 0.8);
    }

    private void heightUpdated(double height) {
        rocketImage.setLayoutY(0.12 * height);

        asteroidImage.setLayoutY(height * 0.5);
        marsImage.setLayoutY(height * 0.3);
        saturnImage.setLayoutY(height * 0.2);
        neptuneImage.setLayoutY(height * 0.3);
        purplezoidImage.setLayoutY(height * 0.1);
        duneImage.setLayoutY(height * 0.2);
    }
}
