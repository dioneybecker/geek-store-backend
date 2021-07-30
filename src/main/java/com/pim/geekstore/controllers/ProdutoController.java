package com.pim.geekstore.controllers;

import com.pim.geekstore.models.Produto;
import com.pim.geekstore.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
@CrossOrigin
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    /*public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable("id") long id, @RequestBody Produto novoProduto) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(novoProduto.getNome());
                    produto.setCategoria(novoProduto.getCategoria());
                    produto.setFabricante(novoProduto.getFabricante());
                    produto.setQuantidade(novoProduto.getQuantidade());
                    produto.setValor(novoProduto.getValor());
                    produto.setPlataforma(novoProduto.getPlataforma());
                    produto.setPrazoGarantia(novoProduto.getPrazoGarantia());
                    produto.setImageUrl(novoProduto.getImageUrl());
                    return ResponseEntity.ok().body(produtoRepository.save(produto));
                }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable("id") long id) {
        produtoRepository.deleteById(id);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable("id") long id) {
        return produtoRepository.findById(id).get();
    }
}
