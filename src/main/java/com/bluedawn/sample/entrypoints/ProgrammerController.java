package com.bluedawn.sample.entrypoints;
import com.bluedawn.sample.core.Person;
import com.bluedawn.sample.core.ProgrammerUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProgrammerController {

    private final ProgrammerUseCase programmerUseCase;

    /*
    단일데이터 Mono
    리스트 Flux
     */

    @PostMapping("/init")
    public void init() {
        programmerUseCase.init();
    }

    @GetMapping("/programmers/{name}")
    public Mono<Person> findByName(@PathVariable("name") String name) {
        try {
            log.info("qweqwe: " + name);
            return Mono.just(programmerUseCase.findByName(name));
        }
        catch (Exception e){
            log.error("error" + e.toString());
            return null;
        }
    }

    //TODO:Person List 를 Flux<Person> 으로 변환하여 리턴
    @GetMapping("/programmers")
    public Flux<Person> findAll() {
        return null;
    }

}