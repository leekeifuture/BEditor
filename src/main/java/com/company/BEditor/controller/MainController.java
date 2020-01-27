package com.company.BEditor.controller;

import com.company.BEditor.domain.User;
import com.company.BEditor.repo.IMessageRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    private final IMessageRepo iMessageRepo;

    @Autowired
    @Lazy
    public MainController(IMessageRepo iMessageRepo) {
        this.iMessageRepo = iMessageRepo;
    }

    @GetMapping
    public String main(@AuthenticationPrincipal User user, Model model) {
        HashMap<Object, Object> data = new HashMap<>();

        data.put("profile", user);
        data.put("messages", iMessageRepo.findAll());

        model.addAttribute("frontendData", data);

        return "index";
    }
}
