package br.com.aweb.sistema_vendas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.aweb.sistema_vendas.model.Client;
import br.com.aweb.sistema_vendas.service.ClientService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/cliente")
public class ClientController {
    

    @Autowired
    ClientService clientService;

    @GetMapping
    public ModelAndView list(){
        return new ModelAndView("cliente/list", Map.of("cliente", clientService.listarTodos()));
    }

    //cadastra cliente
    @GetMapping("/novo")
    public ModelAndView create(){
        return new ModelAndView("cliente/form", Map.of("cliente", new Client()));
    }

    //salva o cliente
    @PostMapping("/novo")
    public String create(@Valid Client client, BindingResult result) {
        if (result.hasErrors()) {
            return "cliente/form";
        }
        clientService.salvar(client);
        return "redirect:/cliente";
    }

    


}
