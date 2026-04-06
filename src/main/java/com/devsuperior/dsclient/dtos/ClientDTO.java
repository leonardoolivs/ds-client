package com.devsuperior.dsclient.dtos;

import com.devsuperior.dsclient.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;
    @NotBlank
    private String name;
    private String cpf;
    private Double income;
    @PastOrPresent
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(Client entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.birthDate = entity.getBirthDate();
        this.cpf = entity.getCpf();
        this.income = entity.getIncome();
        this.children = entity.getChildren();
    }

    public ClientDTO(){}

    public Client dtoToEntity(){
        Client entity = new Client();

        entity.setName(this.name);
        entity.setBirthDate(this.birthDate);
        entity.setCpf(this.cpf);
        entity.setIncome(this.income);
        entity.setChildren(this.children);

        return entity;
    }

    public void copyDtoToEntity(Client entity){
        entity.setName(this.name);
        entity.setBirthDate(this.birthDate);
        entity.setCpf(this.cpf);
        entity.setIncome(this.income);
        entity.setChildren(this.children);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
