package br.com.microservices.application.dto;


public record SaveClientRequestDTO(String name, String cpf, Integer age) {
}
