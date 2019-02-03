package org.java.VaadinMeetingBook.samples.BookMeeting;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;






import org.java.VaadinMeetingBook.samples.authentication.CurrentUser;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class BookMeeting extends CssLayout implements View{


	private static String cluster_host = "192.168.50.198";

	private static String key_space = "hr_payroll";



	DateField birthdate = new DateField ("Date to Book");


	ComboBox userName = new ComboBox("Meeting Starttime");


	Label seperator = new Label(":");



	Label seperatorone = new Label(":");

	ComboBox minutesComboBox = new ComboBox("");

	ComboBox meridianComboBox = new ComboBox("");


	ComboBox password = new ComboBox("Meeting Endtime");

	Label seperatorforendtime = new Label(":");

	Label seperateforendtimeone = new Label(":");

	ComboBox endtimeminutecombobox = new ComboBox("");

	ComboBox endtimeampmcombobox = new ComboBox("");

	ComboBox requireRoom = new ComboBox("MeetingRoomNumber");

	ComboBox venue = new ComboBox("Meeting Venue");

	TextField meetingpurposefield =new TextField ("Purpose of meeting");



	Button login = new Button ("Book the Time");

	Button selectButton = new Button("Cancel the Booking");

	Button checkAvailability = new Button("Check Avalibility");

	public static final String view_name = "Book the Meeting";


	public BookMeeting() {

		buildUI();
	}


	private void buildUI() {
		addStyleName("book-screen");

		
		
		addStyleName("book-information");

		Component loginForm = buildLoginForm();

		VerticalLayout centeringLayout = new VerticalLayout();

		centeringLayout.setMargin(false);
		

	        centeringLayout.setSpacing(false);
	        centeringLayout.setStyleName("centering-layout");


		centeringLayout.addComponent(loginForm);
		centeringLayout.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);

		 addComponent(centeringLayout);

	}


	private Component buildLoginForm() {

		//addStyleName("book-information");
		FormLayout loginLayout = new FormLayout();

		loginLayout.addStyleName("book-form");

		loginLayout.setSizeUndefined();
		
		 

		loginLayout.setMargin(false);

		VerticalLayout vertical = new VerticalLayout();

		List<String>Hours = Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12");

		List<String>Minutes = Arrays.asList("00","15","30","45","60");

		List<String>Meridian = Arrays.asList("AM","PM");

		CssLayout birthdatelayout = new CssLayout();


		loginLayout.addComponent(birthdatelayout);


		birthdatelayout.addComponent(birthdate);

		birthdate.addStyleName("datebook");
		birthdate.setWidth(15,Unit.EM);

		/////////////////////////////
		CssLayout starttimebuttons = new CssLayout();

		loginLayout.addComponent(starttimebuttons);
	
		
		userName.setWidth(15,Unit.EM);


		userName.setItems(Hours);




		userName.addStyleName("starttimestyle");

	
		starttimebuttons.addComponent(userName);
		starttimebuttons.addComponent(seperator);
		
		minutesComboBox.setItems(Minutes);
		
		starttimebuttons.addComponent(minutesComboBox);
		
		minutesComboBox.addStyleName("minutescomboboxstyle");
		starttimebuttons.addComponent(seperatorone);
		


		

		meridianComboBox.setItems(Meridian);
		starttimebuttons.addComponent(meridianComboBox);
		//////////////////////////////

		CssLayout endtimebutton = new CssLayout();

		loginLayout.addComponent(endtimebutton);
		endtimebutton.addComponent(password);

		password.setWidth(15,Unit.EM);

		password.setItems(Hours);



		password.addStyleName("endtimestyle");

		endtimebutton.addComponent(seperatorforendtime);

		endtimebutton.addComponent(endtimeminutecombobox);



		

		endtimeminutecombobox.setItems(Minutes);



		endtimebutton.addComponent(seperateforendtimeone);

		endtimebutton.addComponent(endtimeampmcombobox);

		


		endtimeampmcombobox.setItems(Meridian);


		////////////////////////////

		CssLayout venuelayout = new CssLayout();


		ComboBox cb = new ComboBox("Meeting Venue");


		cb.setTextInputAllowed(false);
		cb.setItems("Newton","Edison");

		loginLayout.addComponent(venuelayout);


		venuelayout.addComponent(cb);


		cb.setWidth(15,Unit.EM);





		cb.addStyleName("venuesecondstyle");


		/////////////////////////////////


		List<String> newtonFloorlist = Arrays.asList("N2" , "N3");

		List<String>RoomNumber = Arrays.asList("Room1","Room2","Room3","Room4","Room5");

		CssLayout roomlayout = new CssLayout();

		loginLayout.addComponent(roomlayout);

		ComboBox requiredRoom = new ComboBox("Room Number");

		requiredRoom.setItems(RoomNumber);
		roomlayout.addComponent(requiredRoom);

		requiredRoom.addStyleName("roomstyle");

		requiredRoom.setWidth(15,Unit.EM);

		requiredRoom.setTextInputAllowed(false);

		requiredRoom.setItems(RoomNumber);
		Label lbl = new Label();


		// Handle selection change
//		cb.addValueChangeListener(event ->{
//
//			Object kkk = event.getValue();
//
//			if(kkk.equals("Newton")) {
//
//				requiredRoom.setItems(newtonFloorlist);
//
//			}
//
//			else {
//
//				requiredRoom.setItems(RoomNumber);
//			}
//		});


		//////////////////

		CssLayout meetingPurpose = new CssLayout();

		loginLayout.addComponent(meetingPurpose);

		meetingPurpose.addComponent(meetingpurposefield);

		meetingpurposefield.addStyleName("meetingpurposefield");

		//////////////////////////

		CssLayout datelayoutone = new CssLayout();


		loginLayout.addComponent(datelayoutone);

		datelayoutone.addComponent(vertical);


		///


		CssLayout buttonslayout = new CssLayout();


		login.addStyleName(ValoTheme.BUTTON_FRIENDLY);

		selectButton.addStyleName(ValoTheme.BUTTON_LINK);

		buttonslayout.addComponent(login);
		buttonslayout.addComponent(selectButton);

		buttonslayout.addComponent(checkAvailability);

		loginLayout.addComponent(buttonslayout);

		setSizeUndefined();

		loginLayout.setMargin(true);
		
		userName.setRequiredIndicatorVisible(true);

	

		password.setRequiredIndicatorVisible(true);

		

		cb.setRequiredIndicatorVisible(true);
		requiredRoom.setRequiredIndicatorVisible(true);


		meetingpurposefield.setRequiredIndicatorVisible(true);
		
		
		login.addClickListener(new ClickListener() {


		@Override
			public void buttonClick(ClickEvent event) {

				String bookeddatedb = birthdate.getValue().toString();

				String meetingstartimedb = userName.getValue() + seperator.getValue() + minutesComboBox.getValue()

						+ meridianComboBox.getValue();

				String meetingendtimedb = password.getValue() + seperatorforendtime.getValue() +

						endtimeminutecombobox.getValue() + endtimeampmcombobox.getValue();


				//String  meetingvenudb = cb.getValue().toString();

				String meetingpurposefieldvaluedb = meetingpurposefield.getValue();

				String meetingRoomDb = requiredRoom.getValue().toString();
				
				String currentusername = CurrentUser.get().toString();
				
				System.out.println(currentusername +"currentusernamecurrentusername");

			
///insert in to the db..
				
				
				
					
					
					String auth_user="viswa", auth_pwd = "viswa@123";
					String encoded_pwd = "";
					try {
						encoded_pwd = URLEncoder.encode(auth_pwd, "UTF-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					String client_url =
							"mongodb://" + auth_user + ":" + encoded_pwd 
							+ "@" + "ds163764.mlab.com" + ":" + 63764 + ""
							+ "/" + "pickmeeting";
					
					if(!bookeddatedb.isEmpty() && !meetingstartimedb.isEmpty()
							&&!meetingendtimedb.isEmpty()
							&&!meetingpurposefieldvaluedb.isEmpty() 
							&& !meetingRoomDb.isEmpty()
						    ){

				MongoClientURI uri = new MongoClientURI(client_url);
				
				MongoClient mongoClient = new MongoClient(uri);
				
				DB viswadbconnection = mongoClient.getDB("pickmeeting");
				
				DBCollection collection = viswadbconnection.getCollection("MeetingViewCollection");
				
				
				System.out.println(collection.getDB()+"collection get initiated");
				
				
				BasicDBObject document = new BasicDBObject();
				
				document.put("BookedDate", bookeddatedb);	
				document.put("MeetingStartTime", meetingstartimedb);
				document.put("MeetingEndTime", meetingendtimedb);
				document.put("MeetingRoomNumber", meetingRoomDb);
				document.put("MeetingPurpose", meetingpurposefieldvaluedb);
				document.put("BookedUser", currentusername);
			    
			    collection.insert(document);  
			    
				}
				
				 
				
			}
		
			    });
		return loginLayout;
		
	}
		
	
	private void showNotification(Notification notification) {
		// keep the notification visible a little while after moving the
		// mouse, or until clicked
		notification.setDelayMsec(2000);
		notification.show(Page.getCurrent());
	}

	}
