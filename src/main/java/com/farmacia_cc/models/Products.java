package com.farmacia_cc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Products {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_producto")
	private int id;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "precio")
	private double price;
	
	private int estatus;
	
	public Products () {}
	
	public Products (int id) {
		this.id = id;
	}
	
	public Products(String name, double price, int estatus) {
		this.name = name;
		this.price = price;
		this.estatus = estatus;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	
}
