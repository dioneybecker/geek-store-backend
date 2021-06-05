package com.pim.geekstore.services;


import com.pim.geekstore.models.Produto;
import com.pim.geekstore.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void atualizarProduto(Produto novoProduto){
        var produto = produtoRepository.findById(novoProduto.getId()).get();
        produto.setNome(novoProduto.getNome());
        produto.setCategoria(novoProduto.getCategoria());
        produto.setFabricante(novoProduto.getFabricante());
        produto.setQuantidade(novoProduto.getQuantidade());
        produto.setValor(novoProduto.getValor());
        produto.setPlataforma(novoProduto.getPlataforma());
        produto.setPrazoGarantia(novoProduto.getPrazoGarantia());
        produtoRepository.save(produto);
    }

    public void cadastrarProduto(Produto produto){
        produtoRepository.save(produto);
    }

    public void excluirProduto(long id){
        produtoRepository.deleteById(id);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll().stream().collect(Collectors.toList());
    }

    public Produto listarProduto(long id){
        return produtoRepository.findById(id).get();
    }
}
