package com.br.elton.k8s.application.service;

import com.br.elton.k8s.domain.model.GameResponse;
import com.br.elton.k8s.domain.model.GameWithConsoleResponse;

import java.util.List;

public interface GameService {

    public abstract GameWithConsoleResponse saveGame(GameWithConsoleResponse gameWithConsoleResponse);

    public abstract List<GameWithConsoleResponse> getAllGames();

    public abstract List<GameResponse> getAllGamesByConsole(Long consoleId);
}
