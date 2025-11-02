package com.escola.matriculas.service;

import com.escola.matriculas.domain.dto.EnderecoDetails;
import com.escola.matriculas.exceptions.CepNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CepService {

    private final WebClient webClient;

    public CepService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://viacep.com.br/ws")
                .build();
    }

    public EnderecoDetails requestCEP(String cep){
        EnderecoDetails enderecoDetails = webClient.get()
                                            .uri("/{cep}/json",cep)
                                            .retrieve()
                                            .onStatus(HttpStatusCode::is4xxClientError, err -> Mono.error(new CepNotFoundException()))
                                            .bodyToMono(EnderecoDetails.class)
                                            .block();
        if(enderecoDetails.getCep() == null){
            throw new CepNotFoundException("CEP inválido!");
        }

        return enderecoDetails;
    }
}
