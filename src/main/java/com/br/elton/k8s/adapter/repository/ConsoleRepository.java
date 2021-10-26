package com.br.elton.k8s.adapter.repository;

import com.br.elton.k8s.adapter.entity.ConsoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<ConsoleEntity, Long> {

}