package br.com.uni.web.controle.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.uni.modelo.User;

@ManagedBean(name = "userBean")
public class UserControler {

	private User user = new User();
	
	public void validateEmail(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException {
		String emailStr = (String) value;
		if (-1 == emailStr.indexOf("@")) {
			FacesMessage message = new FacesMessage("Invalid emailaddress");
			throw new ValidatorException(message);
		}
	}

	public String addConfirmedUser() {
		boolean added = true; // actual application may fail to add user
		FacesMessage doneMessage = null;
		String outcome = null;
		if (added) {
			doneMessage = new FacesMessage("Successfully added new user");
			outcome = "done";
		} else {
			doneMessage = new FacesMessage("Failed to add new user");
			outcome = "register";
		}
		FacesContext.getCurrentInstance().addMessage(null, doneMessage);
		return outcome;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
}
