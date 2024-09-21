package com.httpferret.adapter.v1.controller

import com.httpferret.domain.usecase.GetFerretUseCase
import com.httpferret.domain.usecase.impl.GetFerretUseCaseImpl
import io.quarkus.logging.Log
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.core.Response

@Path("v1/status")
class FerretStatusController(@Inject private val getFerretUseCaseImpl: GetFerretUseCase) {

    @GET
    @Path("/{code}")
    fun getStatusCode(@PathParam("code") code: Int): Response {
        Log.info("$code")
        return Response.ok().build()
    }
}