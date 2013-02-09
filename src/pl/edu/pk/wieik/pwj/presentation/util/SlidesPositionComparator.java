package pl.edu.pk.wieik.pwj.presentation.util;

import java.util.Comparator;

import pl.edu.pk.wieik.pwj.presentation.model.Slide;

public class SlidesPositionComparator implements Comparator<Slide>{
	public int compare(Slide s1, Slide s2) { 
        if (s1.getPosition() > s2.getPosition())
	        return 1;  
        
	    else if (s1.getPosition() < s2.getPosition())
	       return -1; 
        
	    return 0; 
	} 
}
