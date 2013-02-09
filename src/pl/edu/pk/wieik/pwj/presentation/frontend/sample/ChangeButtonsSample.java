package pl.edu.pk.wieik.pwj.presentation.frontend.sample;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import pl.edu.pk.wieik.pwj.presentation.frontend.EndSlideListener;
import pl.edu.pk.wieik.pwj.presentation.frontend.PresentationManager;
import pl.edu.pk.wieik.pwj.presentation.model.Presentation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: B
 * Date: 08.02.13
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 */
public class ChangeButtonsSample implements EndSlideListener{
    VBox vBox=new VBox(2);
    public Button actualSlide;
    public int actualSlideIndex=0;
    List<Button> buttons=new ArrayList<Button>();
    private  PresentationManager presentationManager;


    public ChangeButtonsSample() {
        this.vBox=vBox;
        presentationManager = new PresentationManager(Presentation.factory().get(1),this);
        for(int i=0;i<5;i++){
            buttons.add(new Button("guzik nr: "+i));
        }
        actualSlide=buttons.get(0);
        vBox.getChildren().add(0,actualSlide);
    }


    @Override
    public void actionEndSlide() {

        actualSlide=buttons.get((actualSlideIndex++)%5);
        vBox.getChildren().remove(0);
        vBox.getChildren().add(0,actualSlide);
    }
}
