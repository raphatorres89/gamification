package com.raphaowl.gamification.controller;

import com.raphaowl.gamification.model.GameConfig;
import com.raphaowl.gamification.service.GameService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class GameConfigController {

    private final GameService service;

    @GetMapping()
    @ResponseBody
    public GameConfig getConfig() {
        return service.getConfig();
    }

    @PutMapping()
    @ResponseBody
    public GameConfig updateConfig(@RequestBody GameConfig request) {
        return service.updateConfig(request);
    }

}
