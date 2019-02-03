package org.java.VaadinMeetingBook.samples.BookMeeting;


import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.server.Page;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

/**
 * A form for editing a single product.
 *
 * Using responsive layouts, the form can be displayed either sliding out on the
 * side of the view or filling the whole screen - see the theme for the related
 * CSS rules.
 */
public class NewtonGridForm extends NewtonFormDesign {

    private NewtonCrudLogic viewLogic;
    private Binder<MeetingFields> binder;
    private MeetingFields currentproduct;
    


    public NewtonGridForm(NewtonCrudLogic newtonCrudLogic) {
        super();
        addStyleName("product-form");
        viewLogic = newtonCrudLogic;
        
        binder= new BeanValidationBinder<>(MeetingFields.class);
        
        
        
      binder.forField(date).bind("date");
      binder.forField(meetingRoom).bind("meetingRoom");
      binder.forField(meetingVenue).bind("meetingVenue");
      
      binder.forField(meetingStartTime).bind("startTime");
      binder.forField(meetingEndTime).bind("endTime");
      binder.forField(meetingPurpose).bind("meetingPurpose");
      binder.forField(userName).bind("userName");
    
      
      

       
      binder.bindInstanceFields(this);
      
      
      
      binder.addStatusChangeListener(listener ->{
    	  
    	  boolean isvalid = !listener.hasValidationErrors();
    	  
    	  boolean haschanges = binder.hasChanges();
    	  
    	  Modify.setEnabled(haschanges && isvalid);
    	  
    	  discard.setEnabled(haschanges);
      });
      
      
      discard.addClickListener(listener -> viewLogic.editProduct(currentproduct));
      
      cancel.addClickListener(listener -> viewLogic.cancelProduct());
      
      
    }

public void editProduct(MeetingFields product) {
	  if (product == null) {
      product = new MeetingFields();
  }
  currentproduct = product;
  binder.readBean(product);

  // Scroll to the top
  // As this is not a Panel, using JavaScript
  String scrollScript = "window.document.getElementById('" + getId()
          + "').scrollTop = 0;";
  Page.getCurrent().getJavaScript().execute(scrollScript);
		
	}
      
      
      
      

}
