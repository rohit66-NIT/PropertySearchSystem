package com.amdocs.propertysearch.main;
import com.amdocs.propertysearch.dao.PropertyDAO;
import com.amdocs.propertysearch.exception.*;
import com.amdocs.propertysearch.model.*;

import java.util.*;

class Main{

	public static void main(String args[]) throws PropertyNotFoundException{

	Scanner sc = new Scanner(System.in);
	
	
	

	while(true)
	{
		
		
		System.out.println("1. ADD Property");
		System.out.println("2. DELETE Property");
		System.out.println("3. UPDATE Property Search");
		System.out.println("4. Search By City");
		System.out.println("5. Show All Properties");
		System.out.println("6. Search By Cost");
		System.out.println("7. Search By Rooms and city");
		System.out.println("8. Exit :");
		
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
		int choice=sc.nextInt();
		
		switch(choice){

		case 1:{
			System.out.println("Enter PropertyID:");
			int propertyId = sc.nextInt();
			System.out.println("Enter noOfRooms:");
			String noOfRooms = sc.next();
			System.out.println("Enter Area In Sqft:");
			double areaInSqft = sc.nextDouble();
			System.out.println("Enter floorNo:");
			int floorNo = sc.nextInt();
			System.out.println("Enter city:");
			String city = sc.next();
			System.out.println("Enter state:");
			String state = sc.next();
			System.out.println("Enter cost:");
			double cost = sc.nextDouble();
			System.out.println("Enter ownerName:");
			String ownerName = sc.next();
			System.out.println("Enter ownerContactNo :");
			String ownerContactNo = sc.next();
			Property p = new Property(propertyId ,noOfRooms ,areaInSqft ,floorNo ,city ,state ,cost ,ownerName ,ownerContactNo );
			PropertyDAO pdao = new PropertyDAO();
			pdao.addProperty(p);
			System.out.println("");
			System.out.println("Details added Successfully");
			System.out.println("");
			System.out.println("");
			

			
			break; 
			}
		case 2:{
			
			System.out.println("Enter PropertyID:");
			int pdel = sc.nextInt();
			PropertyDAO pdao = new PropertyDAO();
			int x=0;
			 x=pdao.deleteProperty(pdel);
			System.out.println("");
			if(x!=0)
			System.out.println("Property details deleted of ID :"+pdel);
			else System.out.println("Wrong Property ID, PLEASE ENTER VALID ID");
			System.out.println("");
			System.out.println("");
			break;
			}
		case 3:{
			
			System.out.println("Enter PropertyID and Updated Cost:");
			int pId = sc.nextInt();
			double ucost = sc.nextDouble();
			PropertyDAO pdao = new PropertyDAO();
			
			boolean x= pdao.updatePropertyCost(pId,ucost);
			System.out.println("");
			if(x)
			System.out.println("Property cost updated for ID :"+pId);
			else System.out.println("Wrong Property ID, PLEASE ENTER VALID ID");
			System.out.println("");
			System.out.println("");
			break;
			}
		case 4:{
			
			System.out.println("Enter City Name:");
			String city = sc.next();
			PropertyDAO pdao = new PropertyDAO();
			List<Property> pro = pdao.searchByCity(city);
			
			for(Property p:pro) System.out.println(p);
			System.out.println("");
			try {
				if(pro.size()==0)throw new PropertyNotFoundException();
				}
				catch(Exception e) {
					continue;
				}
			System.out.println("");
			System.out.println("");
			break;
			}
		case 5:{
			PropertyDAO pdao = new PropertyDAO();
			
			List<Property> pro = pdao.showAllProperties();
			
			for(Property p:pro) System.out.println(p);
			System.out.println("");
			try {
				if(pro.size()==0)throw new PropertyNotFoundException();
				}
				catch(Exception e) {
					continue;
				}
			System.out.println("");
			System.out.println("");
			
			break;
			}
		case 6:{
			
			double start = sc.nextDouble();
			double end = sc.nextDouble();
			PropertyDAO pdao = new PropertyDAO();
			List<Property> pro = pdao.searchByCost(start,end);
			try {
				if(pro.size()==0)throw new PropertyNotFoundException();
				}
				catch(Exception e) {
					continue;
				}
			
			for(Property p:pro) System.out.println(p);
			System.out.println("");
			System.out.println("");
			System.out.println("");
		
			break;
			}
		case 7:{
			int rooms = sc.nextInt();
			String city = sc.next();
			
			PropertyDAO pdao = new PropertyDAO();
			//PropertyDAO pdao = new PropertyDAO();
			List<Property> pro = pdao.searchByNoOfRoomsAndCity(rooms,city);
			try {
			if(pro.size()==0)throw new PropertyNotFoundException();
			}
			catch(Exception e) {
				continue;
			}
			for(Property p:pro) System.out.println(p);
			System.out.println("");
			System.out.println("");
			System.out.println("");
		//	
			break;
			}
		case 8:{
			return;
			
			}
		default:{
			System.out.println("Choose Vaild Options . ");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			break;
			}
		



}

	}
	







	
	


	}}

	