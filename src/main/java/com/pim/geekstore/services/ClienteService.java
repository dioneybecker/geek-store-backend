package com.pim.geekstore.services;

import com.pim.geekstore.models.Cliente;
import com.pim.geekstore.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void atualizarCliente(Cliente novoCliente){
        var cliente = clienteRepository.findById(novoCliente.getId()).get();
        cliente.setNome(novoCliente.getNome());
        cliente.setEndereco(novoCliente.getEndereco());
        cliente.setTelefone(novoCliente.getTelefone());
        cliente.setCpf(novoCliente.getCpf());
        cliente.setRg(novoCliente.getRg());
        cliente.setEmail(novoCliente.getEmail());

        this.clienteRepository.save(cliente);
    }

    public void cadastrarCliente(Cliente cliente){
        this.clienteRepository.save(cliente);
    }

    public void excluirCliente(int id){
        this.clienteRepository.deleteById(id);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll().stream().collect(Collectors.toList());
    }

    public Cliente listarCliente(int id){
        return clienteRepository.findById(id).get();
    }
}
