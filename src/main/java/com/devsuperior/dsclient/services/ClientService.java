package com.devsuperior.dsclient.services;

import com.devsuperior.dsclient.dtos.ClientDTO;
import com.devsuperior.dsclient.entities.Client;
import com.devsuperior.dsclient.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client client = dto.dtoToEntity();

        clientRepository.save(client);

        return new ClientDTO(client);
    }

    public ClientDTO findById(Long id){
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new Enti
    }
}
