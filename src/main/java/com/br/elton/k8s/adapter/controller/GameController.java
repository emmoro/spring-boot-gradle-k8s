package com.br.elton.k8s.adapter.controller;

import com.br.elton.k8s.application.service.GameService;
import com.br.elton.k8s.config.Path;
import com.br.elton.k8s.domain.model.GameResponse;
import com.br.elton.k8s.domain.model.GameWithConsoleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Path.API)
public class GameController {

    private static final Logger log = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameService gameService;

    @RequestMapping(value = Path.GAMES, method = RequestMethod.GET)
    public ResponseEntity<List<GameWithConsoleResponse>> getAllGames() {
        log.info("Execute Find all");
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @RequestMapping(value = Path.CONSOLE_GAMES, method = RequestMethod.GET)
    public ResponseEntity<List<GameResponse>> getAllGamesByConsole(@PathVariable("id") Long id) {
        log.info("Get game By Id: " + id);
        return ResponseEntity.ok(gameService.getAllGamesByConsole(id));
    }

    @RequestMapping(value = Path.GAMES, method = RequestMethod.POST)
    public ResponseEntity<GameWithConsoleResponse> saveGame(@RequestBody GameWithConsoleResponse gameWithConsoleResponse) {
        log.info("Save new GameWithConsoleResponse: " + gameWithConsoleResponse);
        return ResponseEntity.ok(gameService.saveGame(gameWithConsoleResponse));
    }

}
