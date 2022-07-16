package org.example.usecase.deletepet;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.gateways.PetRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeletePetUseCase {

    private final PetRepository repository;

    public Mono<Void> execute(String id) {
        return repository.deleteById(id);
    }
}
