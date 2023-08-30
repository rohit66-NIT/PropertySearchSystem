package com.amdocs.propertysearch.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.propertysearch.model.*;

public class PropertyDAO {

	DBConnection dbObj = new DBConnection();
	Connection c = dbObj.getConnection();

public int addProperty(Property p)
{
	
	int count=0;
	try{
		
		PreparedStatement pst = c.prepareStatement("insert into property values(?,?,?,?,?,?,?,?,?)");
		pst.setInt(1,p.getPropertyId());
		pst.setString(2,p.getNoOfRooms());
		pst.setDouble(3,p.getAreaInSqft());
		pst.setInt(4,p.getFloorNo());
		pst.setString(5,p.getCity());
		pst.setString(6,p.getState());
		pst.setDouble(7,p.getCost());
		pst.setString(8,p.getOwnerName());
		pst.setString(9,p.getOwnerContactNo());
		
		count=pst.executeUpdate();
	}
	catch(Exception e){System.out.println("e");}
	
	
	return count;
}

public int deleteProperty(int pid){
	int count=0;
	try {
		PreparedStatement pst = c.prepareStatement("delete from property where propertyId="+pid);
		count=pst.executeUpdate();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return count;


}
public boolean updatePropertyCost(int pId,double cost){
	int count=0;
	PreparedStatement pst;
	try {
		pst = c.prepareStatement("update property set cost=? where propertyId=?");
		pst.setDouble(1, cost);
		pst.setInt(2, pId);
		count=pst.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;}
	
	public List<Property> searchByCity(String city)
{
		List<Property> p = new ArrayList<>();
		
		PreparedStatement pst;
		try {
			pst = c.prepareStatement("select * from property where city=?");
			pst.setString(1,city);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				System.out.println();
				Property pro = new Property(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9));
				p.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	return p;

		
}

public List<Property> showAllProperties()
{
	List<Property> p = new ArrayList<>();
	PreparedStatement pst;
	try {
		pst = c.prepareStatement("select * from property");
		
		
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			//System.out.println();
			Property pro = new Property(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9));
			p.add(pro);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return p;


}

public List<Property> searchByCost(double x , double y )
{
	List<Property> p = new ArrayList<>();
	PreparedStatement pst;
	try {
		pst = c.prepareStatement("select * from property where cost between ? and ?");
		
		pst.setDouble(1, x);
		pst.setDouble(2, y);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			//System.out.println();
			Property pro = new Property(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9));
			p.add(pro);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return p;

}

public List<Property>  searchByNoOfRoomsAndCity(int rooms,String city)
{

	List<Property> p = new ArrayList<>();
	PreparedStatement pst;
	try {
		pst = c.prepareStatement("select * from property where noOfRooms=? and city=? ");
		
		pst.setInt(1, rooms);
		pst.setString(2, city);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			//System.out.println();
			Property pro = new Property(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getString(8),rs.getString(9));
			p.add(pro);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return p;
}


}
