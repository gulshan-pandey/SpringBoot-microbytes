package com.RedisTut.demo;

import lombok.Data;

@Data
public class Dog extends Animal {
    public String breed;

    public Dog(String bruno, String husky) {
        this.name = bruno;
        this.breed = husky;
    }
}
