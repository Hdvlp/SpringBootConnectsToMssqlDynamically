package com.springbootconnectstomssqldynamically.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootconnectstomssqldynamically.demo.service.DataService;

import java.util.List;

@RestController
public class WebController {

    private DataService dataService;

    public WebController(DataService dataService){
        this.dataService = dataService;
    }

    @GetMapping("/")
    public String getIndex() {
        List<String> items = dataService.getData();
        String res = "";
        for (String item : items){
            res += String.format("<div>%s</div>", item);
        }
        return res;
    }
    
}
