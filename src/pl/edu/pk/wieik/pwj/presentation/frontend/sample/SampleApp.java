package pl.edu.pk.wieik.pwj.presentation.frontend.sample;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pl.edu.pk.wieik.pwj.presentation.frontend.NewsFeed;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: B
 * Date: 08.02.13
 * Time: 19:02
 * To change this template use File | Settings | File Templates.
 */
public class SampleApp extends Application {

    private FadeTransition fadeTransition;
    private ImageView obrazek;

    private ChangeButtonsSample changeButtonsSample;


    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        stage.setResizable(false);
        stage.setScene(new Scene(root, 280,500));

        NewsFeed newsFeed = new NewsFeed(stage.getScene().getWidth());

        String path =  new File("d:/picture.png").toURI().toString();
        obrazek = new ImageView(new Image(path));

        obrazek.setFitWidth(stage.getScene().getWidth());
        obrazek.setFitHeight(stage.getScene().getHeight() - 50);
        obrazek.setPreserveRatio(true);

        changeButtonsSample = new ChangeButtonsSample();



        changeButtonsSample.vBox.getChildren().add(1,newsFeed.getMowingText());
        root.getChildren().add(changeButtonsSample.vBox);



        stage.show();


    }
    public static void main(String[] args){

        launch(args);
    }

}

