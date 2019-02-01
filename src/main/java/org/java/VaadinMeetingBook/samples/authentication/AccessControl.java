package org.java.VaadinMeetingBook.samples.authentication;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Set;




/**
 * Simple interface for authentication and authorization checks.
 */
public interface AccessControl extends Serializable {

    public boolean signIn(String username, String password);
    public boolean isUserSignedIn();
	public void createAccount(String userName, String password);

 
}
