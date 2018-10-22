package com.company;

import java.util.function.Supplier;

public interface DefaultFactory {

    static Default create(Supplier<Default> supplier){
        return supplier.get();
    }
}
