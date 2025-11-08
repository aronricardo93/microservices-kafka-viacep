package com.escola.matriculas.service;

import com.escola.matriculas.domain.dto.AddressDetails;
import com.escola.matriculas.exceptions.ZipCodeNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ZipCodeService {

    private final WebClient webClient;

    public ZipCodeService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://viacep.com.br/ws")
                .build();
    }

    public AddressDetails requestCEP(String zipCode){
        AddressDetails addressDetails = webClient.get()
                                            .uri("/{zipCode}/json",zipCode)
                                            .retrieve()
                                            .onStatus(HttpStatusCode::is4xxClientError, err -> Mono.error(new ZipCodeNotFoundException()))
                                            .bodyToMono(AddressDetails.class)
                                            .block();
        if(addressDetails.getZipCode() == null){
            throw new ZipCodeNotFoundException("Zip Code invalid!");
        }

        return addressDetails;
    }
}
