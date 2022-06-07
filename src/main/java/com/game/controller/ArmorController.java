package com.game.controller;

import com.game.core.repo.armor.CreateArmorService;
import com.game.core.repo.armor.FindArmorByOwnerService;
import com.game.dto.armor.CreateArmorRequest;
import com.game.dto.armor.CreateArmorResponse;
import com.game.dto.armor.FindArmorByOwnerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/armor")
@RequiredArgsConstructor
public class ArmorController {

    private final CreateArmorService createArmorService;
    private final FindArmorByOwnerService findArmorByOwnerService;

    @PostMapping(value = "/")
    public CreateArmorResponse createArmor(@RequestBody @Valid CreateArmorRequest request) {
        return createArmorService.createArmor(request);
    }

    @GetMapping(value = "/{owner}")
    public FindArmorByOwnerResponse getArmor(@PathVariable String owner) {
        return findArmorByOwnerService.findByOwner(owner);
    }

}
