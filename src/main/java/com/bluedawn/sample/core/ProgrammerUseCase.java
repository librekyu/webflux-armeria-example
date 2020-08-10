package com.bluedawn.sample.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProgrammerUseCase {

    private final Personal personal;

    public void init(){
        try {
            personal.init();
        }catch(Exception e){
            log.error("e: " + e.getMessage());
        }
    }

    public Person findByName(String name){
        return personal.findByName(name);
    }

    public List<Person> findAll(){
        return personal.findAll();
    }

}