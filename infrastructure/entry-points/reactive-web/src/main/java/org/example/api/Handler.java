package org.example.api;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.Pet;
import org.example.usecase.createpet.CreatePetUseCase;
import org.example.usecase.deletepet.DeletePetUseCase;
import org.example.usecase.findallpet.FindAllPetUseCase;
import org.example.usecase.findbyidpet.FindByIdPetUseCase;
import org.example.usecase.updatepet.UpdatePetUseCase;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class Handler {

    private final CreatePetUseCase createPetUseCase;
    private final FindByIdPetUseCase findByIdPetUseCase;
    private final FindAllPetUseCase findAllPetUseCase;
    private final DeletePetUseCase deletePetUseCase;

    public Mono<ServerResponse> listenGETFindByIdPetUseCase(ServerRequest request) {
        var id = request.pathVariable("id");
        var pet = findByIdPetUseCase.execute(id);

        return pet
                .flatMap(pet1 ->
                        responseOK(pet)
                );
    }

    private Mono<ServerResponse> responseOK(Mono<Pet> pet) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(pet, Pet.class);
    }

    public Mono<ServerResponse> listenDELETEDeletePetUseCase(ServerRequest request) {
        var id = request.pathVariable("id");

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deletePetUseCase.execute(id), Void.class);
    }

    public Mono<ServerResponse> listenGETFindAllPetUseCase(ServerRequest request) {
        var pets = findAllPetUseCase.execute();

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findAllPetUseCase.execute(), Pet.class);
    }

    public Mono<ServerResponse> listenPOSTCreatePetUseCase(ServerRequest request) {
        return request.bodyToMono(Pet.class)
                .flatMap(
                        pet -> createPetUseCase.execute(pet)
                )
                .flatMap(
                        pet1 -> ServerResponse.created(URI.create(""))
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(pet1)
                );
    }
}
