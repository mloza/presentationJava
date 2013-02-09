package pl.edu.pk.wieik.pwj.presentation.frontend;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import pl.edu.pk.wieik.pwj.presentation.model.HtmlSlide;
import pl.edu.pk.wieik.pwj.presentation.model.Slide;

/**
 * Created with IntelliJ IDEA.
 * User: scroot
 * Date: 08.02.13
 * Time: 19:04
 * To change this template use File | Settings | File Templates.
 */
public class Main extends Application {
    private Scene scene;

    @Override
    public void start(Stage stage) {
        // create the scene
        stage.setTitle("Web View");
        scene = new Scene(new HtmlViewBrowser(), 750, 500, Color.web("#666970"));
        stage.setScene(scene);
        //scene.getStylesheets().add("webviewsample/BrowserToolbar.css");
        stage.show();

        stage.setFullScreen(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class HtmlViewBrowser extends Region {

    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    public HtmlViewBrowser() {
        Slide slide = Slide.factory().get(26);
        String scrollScript = "<script type=\"text/javascript\"> var i = 0; function scroll() { scrollTo(0, i++); } setInterval(function() { scroll(); }, "+slide.getDuration()+"/document.getElementsByTagName('body')[0].scrollHeight);</script>";
        webEngine.loadContent(((HtmlSlide) slide.getExtend()).getContent()+scrollScript);
        getChildren().add(browser);
    }

    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }

    @Override
    protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser, 0, 0, w, h, 0, HPos.CENTER, VPos.CENTER);
    }

    @Override
    protected double computePrefWidth(double height) {
        return 750;
    }

    @Override
    protected double computePrefHeight(double width) {
        return 500;
    }
}

