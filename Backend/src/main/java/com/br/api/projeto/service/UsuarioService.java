package com.br.api.projeto.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.api.projeto.model.Usuario;
import com.br.api.projeto.repository.IUsuario;

@Service
public class UsuarioService {

	private IUsuario repository;
	private PasswordEncoder passwordEncoder;

	public UsuarioService(IUsuario repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public List<Usuario> listarUsuario() {
		List<Usuario> lista = repository.findAll();
		return lista;
	}

	public Usuario criarUsuario(Usuario usuarios) {
		String encoder = this.passwordEncoder.encode(usuarios.getSenha());
		usuarios.setSenha(encoder);
		Usuario usuarioNovo = repository.save(usuarios);
		return usuarioNovo;
	}

	public Usuario editarUsuario(@RequestBody Usuario usuarios) {
		Usuario usuarioNovo = repository.save(usuarios);
		return usuarioNovo;
	}
	public Boolean excluirUsuario(Integer id) {
		repository.deleteById(id);
		return true;
	}
	public Boolean validarSenha(Usuario usuarios) {
		String senha = repository.getReferenceById(usuarios.getId()).getSenha();
		Boolean valid = passwordEncoder.matches(usuarios.getSenha(), senha);
		return valid;
	}
}
