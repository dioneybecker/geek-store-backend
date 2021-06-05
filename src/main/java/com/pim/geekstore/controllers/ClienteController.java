package com.pim.geekstore.controllers;

import com.pim.geekstore.models.Cliente;
import com.pim.geekstore.repositories.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
@CrossOrigin
public class ClienteController {
    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable("id") int id, @RequestBody Cliente novoCliente) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(novoCliente.getNome());
            cliente.setEndereco(novoCliente.getEndereco());
            cliente.setTelefone(novoCliente.getTelefone());
            cliente.setCpf(novoCliente.getCpf());
            cliente.setRg(novoCliente.getRg());
            cliente.setEmail(novoCliente.getEmail());
            var clienteSalvo = this.clienteRepository.save(cliente);
            return ResponseEntity.ok().body(clienteSalvo);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        cliente.setDataCadastro(new Date());
        return this.clienteRepository.save(cliente);
    }

    @DeleteMapping(path = "/{id}")
    public void excluirCliente(int id) {
        this.clienteRepository.deleteById(id);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") int id) {
        return clienteRepository.findById(id).map(cliente -> ResponseEntity.ok().body(cliente)).orElse(ResponseEntity.notFound().build());
    }
}
