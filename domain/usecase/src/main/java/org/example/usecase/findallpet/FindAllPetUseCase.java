package org.example.usecase.findallpet;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.Pet;
import org.example.model.pet.gateways.PetRepository;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindAllPetUseCase {

    private final PetRepository repository;

    public Flux<Pet> execute() {
        return repository.findAll();
    }
}
