package com.whatsapp.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.whatsapp.dao.WhatsAppDAO;
import com.whatsapp.dao.WhatsAppDAOInterface;
import com.whatsapp.entity.whatsappUser;

public class WhatsappController implements WhatsappControllerinterface {

	private BufferedReader br;
	private WhatsAppDAOInterface wdao;

	
	public WhatsappController() {
		br=new BufferedReader(new InputStreamReader(System.in));
		wdao=new WhatsAppDAO();

	}

	public void createProfileController() throws Exception {
		System.out.println("enter your name");
		String name=br.readLine();
		
		System.out.println("enter your password");
		String password=br.readLine();
		
		System.out.println("enter your email");
		String email=br.readLine();
		
		System.out.println("enter your address");
		String address=br.readLine();
       whatsappUser ws=new whatsappUser();
       ws.setName(name);
       ws.setAddress(address);
       ws.setEmail(email);
       ws.setPassword(password);
      int i = wdao.createProfileDAO(ws);
			
			if(i>0) {
				System.out.println("registration success");
			}
			else {
				System.out.println("registration fail");
			}
			}
        
		
	

	public void viewProfileController() throws Exception {
		System.out.println("enter your email to view profile");
		String email=br.readLine();
		
		whatsappUser ws=new whatsappUser();
		ws.setEmail(email);
		
		whatsappUser ww=wdao.viewProfileDAO(ws);
		
		if(ww!=null) {
			System.out.println("Name is "+ww.getName());
			System.out.println("Password is "+ww.getPassword());
			System.out.println("Email is "+ww.getEmail());
			System.out.println("Address is "+ww.getAddress());
		}
		else {
			System.out.println("no profile available for given email");
		}
		

		
	}

	public void deleteProfileController() throws Exception {
		
		System.out.println("enter your email to delete profile");
		String email=br.readLine();
		
		whatsappUser ws=new whatsappUser();
		
	       ws.setEmail(email);
	     
		int i=wdao.deleteProfileDAO(ws);
		
	    
	      	if(i>0) 
	      	{
					System.out.println("deleted succesfully");
				}
	
	
				else {
					System.out.println("no profile available");
				}

	}	


	public void editProfileController() throws Exception {
		System.out.println("enter your email to edit profile");
		String email=br.readLine();
		System.out.println("enter your password edit profile");
		String password=br.readLine();
		 whatsappUser ws=new whatsappUser();
		 ws.setEmail(email);
	       
	       ws.setPassword(password);
	      int i = wdao.editProfileDAO(ws);

	      	if(i>0) {
					System.out.println("succesfully edited");
				}
	
				else {
					System.out.println("no edit");
				}
	}

	public void searchProfileController() throws Exception {
		System.out.println("enter your email to search profile");
		String email=br.readLine();
		
		whatsappUser ws=new whatsappUser();
		ws.setEmail(email);
		
		whatsappUser ww=wdao.searchProfileDAO(ws);
		
		if(ww!=null) {
			System.out.println("Name is "+ww.getName());
			System.out.println("Password is "+ww.getPassword());
			System.out.println("Email is "+ww.getEmail());
			System.out.println("Address is "+ww.getAddress());
		}
		else {
			System.out.println("no profile available to search");
		}
		
	}

	public void viewAllProfileController() throws Exception {
		
List<whatsappUser> ww1=wdao.viewAllProfileDAO();
		
		for(whatsappUser ww:ww1) {
			System.out.println("******************************");
			System.out.println("Name is "+ww.getName());
			System.out.println("Password is "+ww.getPassword());
			System.out.println("Email is "+ww.getEmail());
			System.out.println("Address is "+ww.getAddress());
			System.out.println("******************************");
		}

	}
	


}