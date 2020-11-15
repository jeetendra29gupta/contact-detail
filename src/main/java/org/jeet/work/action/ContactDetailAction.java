package org.jeet.work.action;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jeet.work.dao.ContactDetailDAO;
import org.jeet.work.model.ContactDetail;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ContactDetailAction extends ActionSupport implements ModelDriven<ContactDetail> {
	private static final Logger logger = LogManager.getLogger(ContactDetailAction.class);
	private static final long serialVersionUID = 1L;
	private ContactDetail contactDetail = new ContactDetail();
	private List<ContactDetail> contactDetailList;
	private ContactDetailDAO contactDetailDAO = new ContactDetailDAO();

	public String openContactDetailPage() throws Exception {
		try{
			if(contactDetailDAO.checkTable("contact_detail").equals("contact_detail")) {
				contactDetailList = contactDetailDAO.getAllContact();
				logger.info(" openContactDetailPage ");
			}
		}catch (Exception e) {
			logger.error(e);
			contactDetailDAO.createTable();
		}		
		return SUCCESS;
	}

	public String openContactDetailForm() throws Exception {
		return SUCCESS;
	}

	public String saveAndUpdate() throws Exception {
		int ctr = 0;
		if (contactDetail.getId() != 0) {
			ctr = contactDetailDAO.updateContact(contactDetail);
		} else {
			ctr = contactDetailDAO.saveContact(contactDetail);
		}
		if (ctr > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String delete() throws Exception {
		int ctr = 0;
		ctr = contactDetailDAO.deleteContact(contactDetail.getId());
		if (ctr > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String update() throws Exception {
		contactDetailList = contactDetailDAO.getAllContact();
		contactDetail = contactDetailDAO.getContactByID(contactDetail.getId());
		return SUCCESS;
	}

	@Override
	public ContactDetail getModel() {
		return contactDetail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ContactDetail getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(ContactDetail contactDetail) {
		this.contactDetail = contactDetail;
	}

	public List<ContactDetail> getContactDetailList() {
		return contactDetailList;
	}

	public void setContactDetailList(List<ContactDetail> contactDetailList) {
		this.contactDetailList = contactDetailList;
	}

	public ContactDetailDAO getContactDetailDAO() {
		return contactDetailDAO;
	}

	public void setContactDetailDAO(ContactDetailDAO contactDetailDAO) {
		this.contactDetailDAO = contactDetailDAO;
	}
}
