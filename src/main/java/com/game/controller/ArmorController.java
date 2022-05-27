package com.game.controller;

import com.game.dto.armor.CreateArmorRequest;
import com.game.dto.armor.FindArmorByOwnerResponse;
import com.game.core.repo.armor.CreateArmorService;
import com.game.core.repo.armor.DeleteArmorByOwnerService;
import com.game.core.repo.armor.FindArmorByOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/armor")
@RequiredArgsConstructor
public class ArmorController {

    private final CreateArmorService createArmorService;
    private final FindArmorByOwnerService findArmorByOwnerService;
    private final DeleteArmorByOwnerService deleteArmorByOwnerService;

    @PostMapping(value = "/")
    public void createArmor(@RequestBody @Valid CreateArmorRequest request) {
        createArmorService.createArmor(request);
    }

    @GetMapping(value = "/{owner}")
    public FindArmorByOwnerResponse getArmor(@PathVariable String owner) {
        return findArmorByOwnerService.findByOwner(owner);
    }

    @DeleteMapping(value = "/{owner}")
    public void deleteArmor(@PathVariable String owner) {
        deleteArmorByOwnerService.deleteByOwner(owner);
    }

}
