package com.example.demoadvisor.controller.proposed;

import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@RequiredArgsConstructor
public abstract class AdvisorHelper <A> {

    private final A advisor;

    public <T> T advice(Supplier<Boolean> predicate,
                        Function<A, T> adviceFunction,
                        Supplier<T> real) {

        return Optional.ofNullable(advisor)
                .filter(ignored -> predicate.get())
                .map(adviceFunction)
                .orElseGet(real);
    }

}
