package com.br.api.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.projeto.DAO.IUsuario;
import com.br.api.projeto.model.Usuario;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private IUsuario dao;

	@GetMapping
	public List<Usuario> listaUsuarios() {
		return (List<Usuario>) dao.findAll();
	}

	@PostMapping
	public Usuario criarUsuario(@RequestBody Usuario usuarios) {
		Usuario usuarioNovo = dao.save(usuarios);
		return usuarioNovo;
	}

	@PutMapping
	public Usuario editarUsuario(@RequestBody Usuario usuarios) {
		Usuario usuarioNovo = dao.save(usuarios);
		return usuarioNovo;
	}
	@DeleteMapping("/{id}")
	public Optional<Usuario> excluirUsuario (@PathVariable Integer id) {
		Optional<Usuario> usuarios = dao.findById(id);
		dao.deleteById(id);
		return usuarios;
	}
}
