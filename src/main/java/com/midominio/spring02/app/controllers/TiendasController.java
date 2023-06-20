package com.midominio.spring02.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.midominio.spring02.app.models.dao.TiendaDao;
import com.midominio.spring02.app.models.entities.Tienda;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tiendas")
public class TiendasController {
	
	@Autowired
	TiendaDao tiendaDao;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de tiendas");
		model.addAttribute("tiendas", tiendaDao.listar());
		return "tiendas/listar";		
	}
	
	@GetMapping("/id/{id}")
	public String listarPorId(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Listado de tiendas");
		model.addAttribute("tiendas", tiendaDao.findById(id));
		return "tiendas/listar";		
	}
	
	@GetMapping("/tipo/{tipo}")
	public String listarPorTipo(@PathVariable String tipo, Model model) {
		model.addAttribute("titulo", "Listado de tiendas");
		model.addAttribute("tiendas", tiendaDao.findByTipo(tipo));
		return "tiendas/listar";		
	}	
	
	@GetMapping("/borrar/{id}")
	public String listarPor(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Listado de tiendas");
		tiendaDao.delete(id);
		model.addAttribute("tiendas", tiendaDao.listar());
		return "tiendas/listar";		
	}	
	@GetMapping("/editar")
	public String formGet(Model model) {
		model.addAttribute("titulo", "Inserción de una tienda");
		model.addAttribute("tienda", new Tienda());
		return "tiendas/form";
	}
	
	@GetMapping("/editar/{id}")
	public String formGetById(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Edición de una tienda");
		model.addAttribute("tienda", tiendaDao.findById(id));
		return "tiendas/form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Tienda tienda, BindingResult result, Model model) {  
		// la anotación para que se habiliten las validaciones
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Edición de una tienda");
			return "tiendas/form"; 
		}
		tiendaDao.save(tienda);
		return "redirect:listar";
	}
	
}
