package com.derick.application.controllers;

import com.derick.domain.Country;
import com.derick.service.ICountryService;
import com.derick.service.implemetation.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class HomeController {

    @Autowired
    ICountryService countryService;

    @GetMapping("")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("KARIBU BLOCK");
    }

    @GetMapping("/countries")
    public List<Country> countries() {
        try{
            return countryService.getAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
