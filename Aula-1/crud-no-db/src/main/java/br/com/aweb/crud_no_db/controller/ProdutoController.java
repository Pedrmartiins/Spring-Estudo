package br.com.aweb.crud_no_db.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aweb.crud_no_db.dto.ProdutoDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private Map<Long, ProdutoDTO> produtos = new HashMap<>();

    private Long nextId = 1L;

    // listar todos produtos
    @GetMapping
    public List<ProdutoDTO> allProducts() {
        return new ArrayList<>(produtos.values());
    }

    // buscar produto por id

    @GetMapping("/{id}")
    public ProdutoDTO getProductById(@PathVariable Long id) {
        return produtos.get(id);
    }

    @PostMapping
    public ProdutoDTO createProduct(@RequestBody ProdutoDTO produto) {
        produto.setId(nextId++);
        produtos.put(produto.getId(), produto);

        return produto;
    }

    //remover produto
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        if (produtos.remove(id)!=null){
            return "Produto Removido";
        }
        return "Produto não encontrado";
    }

}
