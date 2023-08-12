 package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Product;

public class ProductDAO {
	
	private Connection conn;

	public ProductDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	 
	public boolean addProduct(Product product) {
		
		boolean f =false;
		
		try {
			
			String sql ="INSERT INTO product(ProductName, Description, Quantity, UnitPrice)VALUES(?,?,?,?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getDescription());
			ps.setInt(3, product.getQuantity());
			ps.setInt(4, product.getUnitPrice());
			
			int i= ps.executeUpdate();
			
			if(i==1) {
				
				f=true;
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	public List<Product> getAllProducts(){
		List<Product> list=new ArrayList<Product>();
		Product p=null;
		try {
		    String sql="select * from product";
		    PreparedStatement ps=conn.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		    
		    while(rs.next()) {
		    	
		    	p=new Product();
		    	p.setPid(rs.getInt(1));
		    	p.setProductName(rs.getString(2));
		    	p.setQuantity(rs.getInt(3));
		    	p.setUnitPrice(rs.getInt(4));
		    	p.setDescription(rs.getString(5));
		    	
		    	list.add(p);
		    }
		    
		 } catch (Exception e) {
		    e.printStackTrace();
		

	}
		return list;
	
}
	public Product getProductById(int Pid) {
		
		Product p = null;
		try {
		    String sql="select * from product where Pid=?";
		    PreparedStatement ps=conn.prepareStatement(sql);
		    ps.setInt(1,Pid);
		    ResultSet rs=ps.executeQuery();
		    
		    while(rs.next()) {
		    	
		    	p=new Product();
		    	p.setPid(rs.getInt(1));
		    	p.setProductName(rs.getString(2));
		    	p.setQuantity(rs.getInt(3));
		    	p.setUnitPrice(rs.getInt(4));
		    	p.setDescription(rs.getString(5));
		    	
		    }
		    
		 } catch (Exception e) {
		    e.printStackTrace();
		

	}
		
		return p;
	}
public boolean updateProduct(Product product) {
		
		boolean f =false;
		
		try {
			
			String sql ="update product set ProductName=?,Quantity=?, UnitPrice=? where Pid=?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
		//	ps.setString(2, product.getDescription());
			ps.setInt(2, product.getQuantity());
			ps.setInt(3, product.getUnitPrice());
			ps.setInt(4, product.getPid());
			
			int i= ps.executeUpdate();
			
			if(i==1) {
				
				f=true;
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

public boolean deleteProduct(int Pid) {
	boolean f =false;
	
	
	try {
		String sql="delete from product where Pid=?;";
		
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setInt(1, Pid);
		int i= ps.executeUpdate();
		
		if(i==1) {
			
			f=true;
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return f;
}
	}
	
