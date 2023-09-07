package com.br.api.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.projeto.model.Usuario;

public interface IUsuario extends JpaRepository<Usuario, Integer> {

}
