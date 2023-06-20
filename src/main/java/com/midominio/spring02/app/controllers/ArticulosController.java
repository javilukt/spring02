package com.midominio.spring02.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.midominio.spring02.app.models.entities.Articulo;
import com.midominio.spring02.app.services.ArticulosService;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/articulos")
public class ArticulosController {
	
	@Autowired
	ArticulosService articuloService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de artículos");
		model.addAttribute("articulos", articuloService.listar());
		return "articulos/listar";
	}
	
	@GetMapping("/editar")
	public String formGet(Model model) {
		model.addAttribute("titulo", "Inserción de una artículo");
		model.addAttribute("articulo", new Articulo());
		return "articulos/form";
	}
	
	@GetMapping("/id/{id}")
	public String listarPorId(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Listado de Artículos");
		model.addAttribute("articulos", articuloService.findById(id));
		return "articulos/listar";		
	}
	
	@GetMapping("/tipo/{tipo}")
	public String listarporTipo(@PathVariable String tipo, Model model) {
		model.addAttribute("titulo", "Listado de Artículos");
		model.addAttribute("articulos", articuloService.findByTipo(tipo));
		return "articulos/listar";		
	}
	
	@GetMapping("/marca/{marca}")
	public String listarPorMarca(@PathVariable String marca, Model model) {
		model.addAttribute("titulo", "Listado de Artículos");
		model.addAttribute("articulos", articuloService.findByMarca(marca));
		return "articulos/listar";		
	}	
	
	@GetMapping("/borrar/{id}")
	public String listarPor(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Listado de Artículos");
		articuloService.delete(id);
		model.addAttribute("articulos", articuloService.listar());
		return "articulos/listar";		
	}	
	
	@GetMapping("/editar/{id}")
	public String formGetById(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Edición de un articulo");
		model.addAttribute("articulo", articuloService.findById(id));
		return "articulos/form";
	}
	
	
	@PostMapping("/form")
	public String guardar(@Valid Articulo articulo, BindingResult result, Model model) {  
		// la anotación para que se habiliten las validaciones
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Edición de un artículo");
			return "articulos/form"; 
		}
		articuloService.save(articulo);
		return "redirect:listar";
	}
	
	
}
