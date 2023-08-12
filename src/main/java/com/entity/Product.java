package com.entity;

public class Product {

	private int Pid;
	private String ProductName;
	private String Description;
	private int Quantity;
	private int UnitPrice;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String productName,String description, int quantity, int unitPrice) {
		super();
		ProductName = productName;
        Description = description;
		Quantity = quantity;
		UnitPrice = unitPrice;
	}
	
	public Product(String productName,String description,int quantity, int unitPrice,int pid) {
		super();
		Pid = pid;
		ProductName = productName;
		Description = description;
		Quantity = quantity;
		UnitPrice = unitPrice;
	}
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		UnitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "Product [Pid=" + Pid + ", ProductName=" + ProductName + ", Description=" + Description 
				+ ", Quantity=" + Quantity + ", UnitPrice=" + UnitPrice + "]";
	}
	
}
