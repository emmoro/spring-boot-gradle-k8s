package com.br.elton.k8s.application.service.impl;

import com.br.elton.k8s.adapter.entity.ConsoleEntity;
import com.br.elton.k8s.adapter.repository.ConsoleRepository;
import com.br.elton.k8s.application.service.ConsoleService;
import com.br.elton.k8s.domain.model.ConsoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("consoleService")
public class ConsoleServiceImpl implements ConsoleService {

    @Autowired
    private ConsoleRepository consoleRepository;

    @Transactional(readOnly = false)
    @Override
    public ConsoleResponse saveConsole(ConsoleResponse consoleResponse) {
        ConsoleEntity consoleEntity =
                consoleRepository.saveAndFlush(new ConsoleEntity(null, consoleResponse.getName(), consoleResponse.getReleaseYear()));
        return new ConsoleResponse(consoleEntity);
    }

    @Override
    public ConsoleResponse getConsole(Long consoleId) {
        Optional<ConsoleEntity> consoleOptional = consoleRepository.findById(consoleId);
        if (!consoleOptional.isPresent()) {
            throw new RuntimeException("Console with id " + consoleId + " was not found");
        }
        return new ConsoleResponse(consoleOptional.get());
    }

    @Override
    public List<ConsoleResponse> getAllConsoles() {
        List<ConsoleResponse> consoleResponses = new ArrayList<ConsoleResponse>();
        try {
            List<ConsoleEntity> consoles = consoleRepository.findAll();
            consoles.stream().forEach(con -> {
                consoleResponses.add(new ConsoleResponse(con));
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return consoleResponses;
    }

}
