package com.httpferret.infra

import com.httpferret.domain.usecase.GetFerretUseCase
import com.httpferret.domain.usecase.impl.GetFerretUseCaseImpl
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Singleton
import jakarta.ws.rs.Produces

@ApplicationScoped
class SingletonConfig {

    @Produces
    @Singleton
    fun getFerretUseCase() : GetFerretUseCase {
        return GetFerretUseCaseImpl()
    }
}