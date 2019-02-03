package org.java.VaadinMeetingBook.samples.BookMeeting;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.stream.Collectors;


import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.HtmlRenderer;
import com.vaadin.ui.renderers.NumberRenderer;

/**
 * Grid of products, handling the visual presentation and filtering of a set of
 * items. This version uses an in-memory data source that is suitable for small
 * data sets.
 */
public class NewtonGrid extends Grid<MeetingFields> {

    public NewtonGrid() {
        setSizeFull();

   
     
        
  
        
        addColumn(MeetingFields::getStartTime).setCaption("Meeting Start Time");
        addColumn(MeetingFields::getEndTime).setCaption("Meeting End Time");
        addColumn(MeetingFields::getMeetingPurpose).setCaption("Prupose");
        addColumn(MeetingFields::getMeetingRoom).setCaption("MeetingRoom");
        addColumn(MeetingFields::getuserName).setCaption("username");
        

       
    }

    public MeetingFields getSelectedRow() {
        return asSingleSelect().getValue();
    }

    public void refresh(MeetingFields product) {
        getDataCommunicator().refresh(product);
    }
    
}
