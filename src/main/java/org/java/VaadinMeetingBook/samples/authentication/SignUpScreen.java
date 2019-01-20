package org.java.VaadinMeetingBook.samples.authentication;

import java.io.Serializable;

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

        loginForm.addStyleName("login-form");
        loginForm.setSizeUndefined();
        loginForm.setMargin(false);

        loginForm.addComponent(username = new TextField("Username", "admin"));
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
//                try {
//                    login();
//                } finally {
//                    login.setEnabled(true);
//                }
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

 


  
}
