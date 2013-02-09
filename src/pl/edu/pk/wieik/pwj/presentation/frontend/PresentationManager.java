package pl.edu.pk.wieik.pwj.presentation.frontend;

import javafx.application.Platform;
import pl.edu.pk.wieik.pwj.presentation.model.Presentation;
import pl.edu.pk.wieik.pwj.presentation.model.Slide;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: scroot
 * Date: 08.02.13
 * Time: 21:13
 * To change this template use File | Settings | File Templates.
 */
public class PresentationManager implements Runnable {
    Presentation presentation;
    List<Slide> slides;
    Integer cursor = 0;
    EndSlideListener endSlideListener;
    Integer time = 0;

    public PresentationManager(Presentation presentation, EndSlideListener endSlideListener) {
        this.presentation = presentation;
        this.endSlideListener = endSlideListener;

        this.slides = presentation.getSlides();
        run();
    }

    public Slide getNext() {
        return slides.get(cursor = ++cursor%slides.size());
    }

    public void run() {
        endSlideListener.actionEndSlide();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(PresentationManager.this);
            }
        }, 5000);
    }
}
