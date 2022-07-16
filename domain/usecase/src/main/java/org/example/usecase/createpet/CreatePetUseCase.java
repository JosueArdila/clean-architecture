package org.example.usecase.createpet;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.Pet;
import org.example.model.pet.gateways.PetRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreatePetUseCase {

    private final PetRepository repository;

    public Mono<Pet> execute(Pet pet) {
        return repository.save(pet);
    }
}
