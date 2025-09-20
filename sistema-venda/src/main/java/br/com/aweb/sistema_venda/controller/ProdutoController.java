package br.com.aweb.sistema_venda.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.aweb.sistema_venda.model.Produto;
import br.com.aweb.sistema_venda.repository.ProdutoRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;


    @GetMapping("/novo")
    public ModelAndView create(){
        return new ModelAndView ("produto/form", Map.of("produto", new Produto()));
    
    }

    @PostMapping("/novo")
    public String create(@Valid Produto produto, BindingResult result){
        if (result.hasErrors()) {
            return "produto/form";
        }
        produtoRepository.save(produto);
        return"redirect:/produtos";
    }

}
