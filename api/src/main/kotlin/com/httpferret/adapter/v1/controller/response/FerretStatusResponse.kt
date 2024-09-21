package com.httpferret.adapter.v1.controller.response

import com.fasterxml.jackson.annotation.JsonProperty

data class FerretStatusResponse(
    @JsonProperty("status_code") val statusCode: Int,
    @JsonProperty("title") val title: String,
    @JsonProperty("url") val url: String
)
