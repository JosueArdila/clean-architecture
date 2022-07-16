package org.example.usecase.findbyidpet;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.Pet;
import org.example.model.pet.gateways.PetRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindByIdPetUseCase {

    private final PetRepository repository;

    public Mono<Pet> execute(String id) {
        return repository.findById(id);
    }
}
