package com.farmacia_cc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.farmacia_cc.models.Inventario;
import com.farmacia_cc.models.Products;
import com.farmacia_cc.repositories.InventarioRepository;
import com.farmacia_cc.repositories.ProductsRepository;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private InventarioRepository inventarioRepository;
	
	@GetMapping(value="/")
	public String index (Model model) {
		return "index";
	}
	
	@GetMapping(value="/productos")
	public String getProductsData (Model model) {
		model.addAttribute("productos", productsRepository.findAll());
		return "ProductsView";
	}
	
	@GetMapping(value="/productos/{id}/editar")
	public String getProductDataById (Model model, @PathVariable int id) {
		model.addAttribute("producto", productsRepository.getOne(id));
		return "ProductsViewEdit";
	}
	
	@GetMapping(value="/productos/crear")
	public String createView (Model model) {
		return "ProductsViewCreate";
	}
	
	@GetMapping(value="/inventario")
	public String inventarioView (Model model) {
		List<Inventario> inventario = inventarioRepository.findAll();
		ArrayList<HashMap<String, String>> inArr = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> details;
		Products producto;
		for (Inventario in : inventario) {
			details = new HashMap<String, String>();
			producto = productsRepository.getOne(in.getId_producto());
			details.put("id_inventario", String.valueOf(in.getId_inventario()));
			details.put("id_producto", String.valueOf(in.getId_producto()));
			details.put("nombre", producto.getName());
			details.put("cantidad", String.valueOf(in.getCantidad()));
			inArr.add(details);
		}
		model.addAttribute("inventarioArr", inArr);
		return "InventarioView";
	}
	
	@PostMapping(value="/productos/crear", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String createProduct (Model model, @RequestBody Map<String, String> body) {
		String name = body.get("nombre");
		double price = Double.parseDouble(body.get("precio"));
		int estatus = Integer.parseInt(body.get("estatus"));
		
		Products product = productsRepository.save(new Products(name, price, estatus));
		
		model.addAttribute("product", product);
		
		return "ProductsViewCreate";
	}
	
	@PutMapping(value="/productos/{id}/actualizar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateProduct (Model model, @PathVariable int id, @RequestBody Map<String, String> body) {
		
		double price = Double.parseDouble(body.get("precio"));
		int estatus = Integer.parseInt(body.get("estatus"));
		
		Products product = productsRepository.getOne(id);
		product.setName(body.get("nombre"));
		product.setPrice(price);
		product.setEstatus(estatus);
		
		product = productsRepository.save(product);
		
		model.addAttribute("producto", product);
		
		return "ProductsViewEdit";
	}
	
	@PutMapping(value="/inventario/{id}/actualizar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateInventario (Model model, @PathVariable int id, @RequestBody Map<String, String> body) {
		int cantidad = Integer.parseInt(body.get("cantidad"));
		
		Inventario inventario = inventarioRepository.getOne(id);
		inventario.setCantidad(cantidad);
		
		inventarioRepository.save(inventario);
		
		return "InventarioView";
	}
	
	@DeleteMapping(value="/productos/{id}/eliminar")
	public String deleteProduct (Model model, @PathVariable int id) {
		Products product = productsRepository.getOne(id);
		productsRepository.delete(product);
		return "ProductsView";
	}
	
}
