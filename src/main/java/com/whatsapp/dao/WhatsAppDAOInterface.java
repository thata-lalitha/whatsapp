package com.whatsapp.dao;
import java.util.List;

import com.whatsapp.entity.whatsappUser;

public interface WhatsAppDAOInterface {

	int createProfileDAO(whatsappUser ws);
	
	List<whatsappUser> viewAllProfileDAO();	

	int editProfileDAO(whatsappUser ws);

	int deleteProfileDAO(whatsappUser ws);

	whatsappUser searchProfileDAO(whatsappUser ws);

	whatsappUser viewProfileDAO(whatsappUser ws);

	


}
