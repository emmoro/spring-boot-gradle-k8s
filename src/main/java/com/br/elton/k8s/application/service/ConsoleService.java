package com.br.elton.k8s.application.service;

import com.br.elton.k8s.domain.model.ConsoleResponse;

import java.util.List;

public interface ConsoleService {

    public abstract ConsoleResponse saveConsole(ConsoleResponse consoleResponse);

    public abstract ConsoleResponse getConsole(Long consoleId);

    public abstract List<ConsoleResponse> getAllConsoles();
}
