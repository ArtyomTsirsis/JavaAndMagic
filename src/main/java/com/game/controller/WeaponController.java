package com.game.controller;

import com.game.core.repo.weapon.CreateWeaponService;
import com.game.core.repo.weapon.FindWeaponByOwnerService;
import com.game.dto.weapon.CreateWeaponRequest;
import com.game.dto.weapon.CreateWeaponResponse;
import com.game.dto.weapon.FindWeaponByOwnerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/weapon")
@RequiredArgsConstructor
public class WeaponController {

    private final CreateWeaponService createWeaponService;
    private final FindWeaponByOwnerService findWeaponByOwnerService;

    @PostMapping(value = "/")
    public CreateWeaponResponse createWeapon(@RequestBody @Valid CreateWeaponRequest request) {
        return createWeaponService.createWeapon(request);
    }

    @GetMapping(value = "/{owner}")
    public FindWeaponByOwnerResponse getWeaponByOwner(@PathVariable String owner) {
        return findWeaponByOwnerService.findByOwner(owner);
    }


}
