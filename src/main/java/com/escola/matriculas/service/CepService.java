package com.escola.matriculas.service;

import com.escola.matriculas.domain.dto.EnderecoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CepService {

    private final WebClient webClient;

    public CepService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://viacep.com.br/ws")
                .build();
    }

    public EnderecoDetails requestCEP(String cep){
        return webClient.get()
                .uri("/{cep}/json",cep)
                .retrieve()
                .bodyToMono(EnderecoDetails.class)
                .block();
    }
}
