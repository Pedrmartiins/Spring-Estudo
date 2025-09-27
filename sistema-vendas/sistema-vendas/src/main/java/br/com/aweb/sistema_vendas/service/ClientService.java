package br.com.aweb.sistema_vendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aweb.sistema_vendas.model.Client;
import br.com.aweb.sistema_vendas.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


    //criar

public Client salvar(Client client){
    return clientRepository.save(client);
}








//ler
public List<Client> listarTodos(){
    return clientRepository.findAll();
}


    public Optional<Client> buscarPorId(Long id) {
        return clientRepository.findById(id);
    }



    
}
