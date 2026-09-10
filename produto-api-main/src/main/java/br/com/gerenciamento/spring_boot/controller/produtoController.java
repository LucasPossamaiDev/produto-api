package br.com.gerenciamento.spring_boot.controller;


import br.com.gerenciamento.spring_boot.model.Produtos;
import br.com.gerenciamento.spring_boot.service.produtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/produtos")
public class produtoController {

    private final produtoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produtos>findALl(){
        return produtoService.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produtos salvar(@RequestBody Produtos produtos){
        return produtoService.salvar(produtos);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produtos buscarPorID(@PathVariable Integer id) {
        return produtoService.buscarPorID(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produtos atualizar(@PathVariable Integer id, @RequestBody Produtos produtos) {
        return produtoService.atualizar(id, produtos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Integer id) {
        produtoService.deletar(id);
    }

}
