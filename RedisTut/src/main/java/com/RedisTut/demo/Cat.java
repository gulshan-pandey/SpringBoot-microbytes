package com.RedisTut.demo;

import lombok.Data;

@Data
public class Cat extends Animal {
    public boolean likesMilk;

    public Cat(String kitty, boolean b) {
        this.name = kitty;
        this.likesMilk = b;
    }
}
