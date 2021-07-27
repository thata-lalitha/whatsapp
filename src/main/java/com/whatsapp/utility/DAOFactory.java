package com.whatsapp.utility;
import com.whatsapp.dao.WhatsAppDAO;
import com.whatsapp.dao.WhatsAppDAOInterface;

public class DAOFactory {
	public static WhatsAppDAOInterface myMethod() {
		// TODO Auto-generated method stub
		return new WhatsAppDAO();
	}



}
