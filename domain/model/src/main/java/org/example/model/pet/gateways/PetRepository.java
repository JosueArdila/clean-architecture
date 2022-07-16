package org.example.model.pet.gateways;

import org.example.model.pet.Pet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PetRepository {

    public Mono<Pet> save(Pet pet);
    public Flux<Pet> findAll();
    public Mono<Void> deleteById(String id);
    public Mono<Pet> findById(String id);
}
