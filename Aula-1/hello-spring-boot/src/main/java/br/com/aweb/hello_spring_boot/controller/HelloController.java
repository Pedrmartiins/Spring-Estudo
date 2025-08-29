package br.com.aweb.hello_spring_boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class HelloController {
    @GetMapping
    public String sayHello(){
        return "Ola mundo Spring Boot!";
    }

    @GetMapping("/ola")
    public String sayHelloCustom() {
        return "Ola endpoint especifico";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(defaultValue = "name") String userName) {
        return "Olá, "+ userName + "! Bem-vindo";
    }
    
    @GetMapping("/calc")
    public int calc(@RequestParam int num1, @RequestParam int num2, @RequestParam(defaultValue = "soma") String op) 
    {
        int rs;
        
        if (op.equals("subtracao") ){
            rs = num1 - num2;
        }
        else{
            rs = num1 + num2;
        }
        return rs;
    }
    

    @GetMapping("/mensagem")
    public String getMethodName(@RequestParam(defaultValue = "Visitante") String usuario, @RequestParam(defaultValue = "pt")String idioma) {

        if(idioma.equals("en")){
            return "Hi, " + usuario + " Welcome";
        }
        else{

        }
        return "Olá, " + usuario + " Bem-vindo"; 
    }
}
