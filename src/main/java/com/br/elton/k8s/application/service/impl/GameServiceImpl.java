package com.br.elton.k8s.application.service.impl;

import com.br.elton.k8s.adapter.entity.ConsoleEntity;
import com.br.elton.k8s.adapter.entity.GameEntity;
import com.br.elton.k8s.adapter.repository.ConsoleRepository;
import com.br.elton.k8s.adapter.repository.GameRepository;
import com.br.elton.k8s.application.service.GameService;
import com.br.elton.k8s.domain.model.GameResponse;
import com.br.elton.k8s.domain.model.GameWithConsoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("gameService")
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ConsoleRepository consoleRepository;

    @Transactional(readOnly = false)
    @Override
    public GameWithConsoleResponse saveGame(GameWithConsoleResponse gameWithConsoleResponse) {
        GameEntity gameEntity = new GameEntity();
        gameEntity.setTitle(gameWithConsoleResponse.getTitle());
        gameEntity.setReleaseYear(gameWithConsoleResponse.getReleaseYear());
        gameEntity.setConsole(new ConsoleEntity(gameWithConsoleResponse.getConsole().getId(), gameWithConsoleResponse.getConsole().getName(),
                gameWithConsoleResponse.getConsole().getReleaseYear()));

        gameEntity = gameRepository.saveAndFlush(gameEntity);
        return new GameWithConsoleResponse(gameEntity);
    }

    @Override
    public List<GameWithConsoleResponse> getAllGames() {
        List<GameWithConsoleResponse> gameResponses = new ArrayList<GameWithConsoleResponse>();
        List<GameEntity> games = gameRepository.findAll();
        games.stream().forEach(ga -> {
            gameResponses.add(new GameWithConsoleResponse(ga));
        });

        return gameResponses;
    }

    @Override
    public List<GameResponse> getAllGamesByConsole(Long consoleId) {
        List<GameResponse> gameResponses = new ArrayList<GameResponse>();
        Optional<ConsoleEntity> console = consoleRepository.findById(consoleId);
        if (console.isPresent()) {
            List<GameEntity> games = gameRepository.findAllByConsole(console.get());
            games.stream().forEach(ga -> {
                gameResponses.add(new GameResponse(ga));
            });
        }

        return gameResponses;
    }
    
}
