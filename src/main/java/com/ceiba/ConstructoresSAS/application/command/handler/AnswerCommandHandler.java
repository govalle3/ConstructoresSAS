package com.ceiba.ConstructoresSAS.application.command.handler;

import org.springframework.transaction.annotation.Transactional;

public interface AnswerCommandHandler<C, R> {

        @Transactional
        R execute(C command);
}
