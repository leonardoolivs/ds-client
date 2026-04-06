package com.devsuperior.dsclient.services;

import com.devsuperior.dsclient.dtos.ClientDTO;
import com.devsuperior.dsclient.entities.Client;
import com.devsuperior.dsclient.exceptions.ResourceNotFoundException;
import com.devsuperior.dsclient.repositories.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id not found"));

        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> client = clientRepository.findAll(pageable);

        return client.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id not found"));

        dto.copyDtoToEntity(client);

        clientRepository.save(client);

        return new ClientDTO(client);
    }

    @Transactional
    public void delete(Long id){
        if(!clientRepository.existsById(id)){
            throw new ResourceNotFoundException("Id not found");
        }

        clientRepository.deleteById(id);
    }
}
