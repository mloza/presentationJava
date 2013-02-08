package pl.edu.pk.wieik.pwj.presentation.frontend;

import com.sun.webpane.webkit.JSObject;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
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
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
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
        scene = new Scene(new Browser(), 750, 500, Color.web("#666970"));
        stage.setScene(scene);
        //scene.getStylesheets().add("webviewsample/BrowserToolbar.css");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Browser extends Region {

    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    public Browser() {
        //apply the styles
        //getStyleClass().add("browser");
        // load the web page

        webEngine.load("http://google.com");

        String scrollScript = "<script type=\"text/javascript\">i = 0; setTimer(100, scroll); function scroll() { window.scrollTo(0, i+1); }</script>";

        webEngine.loadContent(((HtmlSlide) Slide.factory().get(3).getExtend()).getContent()+scrollScript);
        //add the web view to the scene
        getChildren().add(browser);



        //System.out.println(webEngine.getDocument().getElementById("para"));
        //JSObject p = (JSObject) webEngine.executeScript("document.getElementsByTagName('h1')[0]");
        //System.out.println(p);
        //p.setAttribute("style", "font-weight: bold");
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

