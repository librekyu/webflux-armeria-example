package com.bluedawn.sample.core;

import java.util.List;

public interface Personal {
    void init();
    Person findByName(String name);
    List<Person> findAll();
}