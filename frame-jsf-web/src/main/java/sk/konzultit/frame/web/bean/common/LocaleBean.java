package sk.konzultit.frame.web.bean.common;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Locale Bean
 * 
 */
@ManagedBean(name = "localeBean")
@SessionScoped
public class LocaleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Locale locale;
		
	@PostConstruct
	public void init() {
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	}

	public Locale getLocale() {
		return locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void setLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
	
	public static String getLocalizedLabel(String key) {  
		ResourceBundle msgBundle = FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "entitylabel");
		if (key == null || key.equals("")) {
			return "";
		} else {
			return msgBundle.getString(key);
		}
	}
	
	public static String getLocalizationKey(String label) {
		ResourceBundle msgBundle = FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "entitylabel");
    	Enumeration<String> keys = msgBundle.getKeys();
    	if(label == null || label.equals("")) {
    		return "";
    	}
    	while(keys.hasMoreElements()) {
    		String key = keys.nextElement();
    		if(label.equals(msgBundle.getString(key))) {
    			return key;
    		}
    	}
		return "";
	}
}
