package controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.enums.PlasticSurgeryProcedure;


@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/procedures")
    public List<PlasticSurgeryProcedure> getProcedures(){
        return Arrays.asList(PlasticSurgeryProcedure.values());
    }
    
}