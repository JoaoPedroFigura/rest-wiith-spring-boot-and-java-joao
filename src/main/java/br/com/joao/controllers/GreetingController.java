package br.com.joao.controllers;

import br.com.joao.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "você tem: %s anos";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "idade", defaultValue = "Não identificado")
            String idade) {
        return new Greeting(counter.incrementAndGet(), String.format(template, idade));
    }

}
