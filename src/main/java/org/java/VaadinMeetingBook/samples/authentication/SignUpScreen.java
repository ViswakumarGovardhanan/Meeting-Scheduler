package org.java.VaadinMeetingBook.samples.authentication;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;



import org.java.VaadinMeetingBook.MyUI;

import com.vaadin.event.ShortcutAction;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * UI content when the user is not logged in yet.
 */
public class SignUpScreen extends CssLayout {

	private TextField username;

	Boolean flag =false;
	private PasswordField password;
	Button login = new Button ("create a account");
	Button cancelsignup = new Button ("cancel");

	private AccessControl accessControl;
	//
	//    public SignUpScreen(AccessControl accessControl, LoginListener loginListener) {
	//        this.loginListener = loginListener;
	//        this.accessControl = accessControl;
	//        buildUI();
	//        username.focus();
	//    }

	public SignUpScreen(MyUI myUI) {

		buildUI();
		// TODO Auto-generated constructor stub
	}

	private void buildUI() {
		addStyleName("signup-screen");
		addStyleName("signup-information");

		// login form, centered in the available part of the screen
		Component loginForm = buildLoginForm();

		// layout to center login form when there is sufficient screen space
		// - see the theme for how this is made responsive for various screen
		// sizes
		VerticalLayout centeringLayout = new VerticalLayout();
		centeringLayout.setMargin(false);
		centeringLayout.setSpacing(false);
		centeringLayout.setStyleName("centering-layout");
		centeringLayout.addComponent(loginForm);
		centeringLayout.setComponentAlignment(loginForm,
				Alignment.MIDDLE_CENTER);

		// information text about logging in
		//  CssLayout loginInformation = buildLoginInformation();

		addComponent(centeringLayout);
		//  addComponent(loginInformation);
	}

	private Component buildLoginForm() {
		FormLayout loginForm = new FormLayout();
		loginForm.addStyleName("signup-form");
		loginForm.setSizeUndefined();
		loginForm.setMargin(false);

		loginForm.addComponent(username = new TextField("Username"));
		username.setWidth(15, Unit.EM);
		loginForm.addComponent(password = new PasswordField("Password"));
		password.setWidth(15, Unit.EM);
		password.setDescription("Write anything");
		CssLayout buttons = new CssLayout();
		buttons.setStyleName("buttons");
		loginForm.addComponent(buttons);

		buttons.addComponent(login);
		login.setDisableOnClick(true);

		login.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {

				if(username.getValue() != null & password.getValue() != null){

					//boolean	accountExisting=accountAlreadyExist(username.getValue(),password.getValue());
				signup(username.getValue(),password.getValue());
					
				

				}
			}




		});
		login.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		login.addStyleName(ValoTheme.BUTTON_FRIENDLY);

		buttons.addComponent(cancelsignup);


		cancelsignup.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(Button.ClickEvent event) {
				VaadinSession.getCurrent().getSession().invalidate();

				Page.getCurrent().reload();
			}
		});


		cancelsignup.addStyleName(ValoTheme.BUTTON_PRIMARY);
		return loginForm;
	}

	public boolean signup(String username,String password) {

		if(!username.isEmpty() && !password.isEmpty()){
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

//			MongoClientURI uri = new MongoClientURI(client_url);
//			
//			MongoClient mongoClient = new MongoClient(uri);
//			
//			DB viswadbconnection = mongoClient.getDB("pickmeeting");
//			
//			DBCollection collection = viswadbconnection.getCollection("UserNames");
//			
//			BasicDBObject whereQuery = new BasicDBObject();
//			
//		    whereQuery.put("userName", username);
//		    
//		    BasicDBObject fields = new BasicDBObject();
//		    
//		    whereQuery.put("password", password);
//		    
//		    DBCursor cursor = collection.find(whereQuery);
		    
//		   boolean sadfa = cursor.hasNext();
//		   
//		   
//		   if(cursor.hasNext()) {
//			   
//		        System.out.println("");
//		        
//		        
//		        showNotification(new Notification("Account existed Already",
//						"",
//						Notification.Type.ERROR_MESSAGE)); 
//		        login.focus();
//		    }
//		   else{
//			   BasicDBObject document = new BasicDBObject();
//				document.put("userName",username);
//				document.put("password",password);
//				collection.insert(document);
//
//				showNotification(new Notification("Account Created Sucessfully",
//						"",
//						Notification.Type.HUMANIZED_MESSAGE));  
//		   }
//		    
//		
//			

		

			

			
			


			




			/**** Insert ****/
			// create a document to store key and value
			
			//			Set<String> collectionname = viswadbconnection.getCollectionNames();
			//			
			//			
			//
			//
			//			System.out.println(collectionname +"collectionnamecollectionname");

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			// DB db = mongoClient.getDB("testdb");
			//  mongoClient.getDatabaseNames().forEach(System.out::println);
			/**** Get collection / table from 'testdb' ****/
			// if collection doesn't exists, MongoDB will create it for you
			//  DBCollection collection = db.getCollection("users");
			/**** Insert ****/
			// create a document to store key and value
			// BasicDBObject document = new BasicDBObject();
			//		         document.put("firstName", "Dharam");
			//		         document.put("lastName", "Rajput");
			// collection.insert(document);


			///////////////






			return true;



		}

		else{

			return false;
		}

	}

	private void showNotification(Notification notification) {
		// keep the notification visible a little while after moving the
		// mouse, or until clicked
		notification.setDelayMsec(2000);
		notification.show(Page.getCurrent());
	}

	private CssLayout buildLoginInformation() {
		CssLayout loginInformation = new CssLayout();
		loginInformation.setStyleName("login-information");
		Label loginInfoText = new Label(
				"<h1>Login Information</h1>"
						+ "Log in as &quot;admin&quot; to have full access. Log in with any other username to have read-only access. For all users, any password is fine",
						ContentMode.HTML);
		loginInfoText.setSizeFull();
		loginInformation.addComponent(loginInfoText);
		return loginInformation;
	}


	public interface LoginListener extends Serializable {
		void loginSuccessful();
	}


}
