package com.game.controller.ui;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@AllArgsConstructor
public class UIController {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }




}
