package com.br.api.projeto.DAO;

import org.springframework.data.repository.CrudRepository;

import com.br.api.projeto.model.Usuario;

public interface IUsuario extends CrudRepository<Usuario, String> {
	
}
