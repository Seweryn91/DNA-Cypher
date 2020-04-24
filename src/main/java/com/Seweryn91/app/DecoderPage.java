package com.Seweryn91.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/")
public class DecoderPage {

    @GetMapping(value = "/foo")
    @ResponseBody
    public String hello() {
        return "Hello world!";
    }
}
