package com.generation.org.br.acoli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.org.br.acoli.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

}
