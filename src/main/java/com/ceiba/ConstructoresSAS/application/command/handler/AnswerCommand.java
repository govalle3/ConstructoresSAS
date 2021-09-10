package com.ceiba.ConstructoresSAS.application.command.handler;

public class AnswerCommand<T> {

    private T value;

    public AnswerCommand(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
