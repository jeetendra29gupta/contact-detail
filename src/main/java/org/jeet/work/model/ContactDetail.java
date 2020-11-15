package org.jeet.work.model;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

public class ContactDetail extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private long id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;

	public ContactDetail() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	@StringLengthFieldValidator(minLength = "5", message = "First Name must contain at least ${minLength} characters")
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	@StringLengthFieldValidator(minLength = "3", message = "Last Name must contain at least ${minLength} characters")

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	@RequiredStringValidator(message = "Email is required ")
	@EmailValidator(message = "Email address is not valid")
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	@RegexFieldValidator(regex = "^[0-9]{10}$", message = "Mobile number must be of 10 digits")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "ContactDetail [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phone=" + phone + "]";
	}

	public String validationsForm() {
		return SUCCESS;
	}
}
