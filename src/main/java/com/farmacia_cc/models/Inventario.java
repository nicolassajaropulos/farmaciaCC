package com.farmacia_cc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventario")
public class Inventario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_inventario;
	private int id_producto;
	private int cantidad;
	private int estatus;
	
	public Inventario () {}
	
	public Inventario (int id_producto, int cantidad, int estatus) {
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.estatus = estatus;
	}

	public int getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	
}
