package com.br.elton.k8s.adapter.repository;

import com.br.elton.k8s.adapter.entity.ConsoleEntity;
import com.br.elton.k8s.adapter.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {

    public List<GameEntity> findAllByConsole(ConsoleEntity console);

}