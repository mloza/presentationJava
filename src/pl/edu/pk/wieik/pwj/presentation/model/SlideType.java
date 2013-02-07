package pl.edu.pk.wieik.pwj.presentation.model;

/**
 * Created with IntelliJ IDEA.
 * User: scroot
 * Date: 06.02.13
 * Time: 15:21
 * To change this template use File | Settings | File Templates.
 */
public enum SlideType {
    VIDEO(0),
    IMAGE(1),
    HTML(2);
    private final Integer number;

    public static SlideType getByNumber(Integer number) {
        for(SlideType i: values()) {
            if (i.number == number) return i;
        }
        return null;
    }

    SlideType(Integer i) {
        this.number = i;
    }
}
