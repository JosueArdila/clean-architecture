package org.example.usecase.updatepet;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.Pet;
import org.example.model.pet.gateways.PetRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdatePetUseCase {

    private final PetRepository repository;

    public Mono<Pet> execute(Pet pet) {
        var petInfo = repository.findById(pet.getId());
        return null;
    }
}
