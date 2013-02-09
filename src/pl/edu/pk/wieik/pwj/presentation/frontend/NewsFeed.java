package pl.edu.pk.wieik.pwj.presentation.frontend;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.util.Duration;
import pl.edu.pk.wieik.pwj.presentation.model.Model;
import pl.edu.pk.wieik.pwj.presentation.model.News;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: B
 * Date: 08.02.13
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public class NewsFeed {
     Timeline timeline = new Timeline();
     Text text=new Text();
    public Text getMowingText() {
        return text;
    }



    public NewsFeed(double widthOfWindow) {
        List<Model> all = News.factory().getAll();
        String newsString = "";
        for (Model a : all) {
            News news = (News) a;

            newsString += " *** " + news.getContent();
        }
        text = new Text(0, 20, newsString);
        timeline.getKeyFrames().addAll
                (new KeyFrame(Duration.ZERO,
                        new KeyValue(text.translateXProperty(), widthOfWindow)),
                        new KeyFrame(Duration.millis((text.getLayoutBounds().getWidth()) * 10),
                                new KeyValue(text.translateXProperty(), -text.getLayoutBounds().getWidth())));

        timeline.play();
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                timeline.play();
            }
        });

    }
}
