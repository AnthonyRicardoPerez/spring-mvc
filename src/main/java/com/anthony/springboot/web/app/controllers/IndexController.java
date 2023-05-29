package com.anthony.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anthony.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping(value="/index")
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework!");
		return "index";
	}
	
	@GetMapping(value="/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Anthony");
		usuario.setApellido("Ricardo");
		usuario.setEmail("anthony@gmail.com");
		
		model.addAttribute("titulo", "Perfil del usuario: " .concat(usuario.getNombre()));
		model.addAttribute("usuario", usuario);
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
	
		model.addAttribute("titulo", "Listado de usuarios!");
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuario(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Anthony","Ricardo","anthony@Gmail.com"));
		usuarios.add(new Usuario("Andy","Garcia","andy@Gmail.com"));
		usuarios.add(new Usuario("Jorge","Sanchez","george@Gmail.com"));
		usuarios.add(new Usuario("Graciela","Perez","chela@Gmail.com"));
		return usuarios;
	}
}

