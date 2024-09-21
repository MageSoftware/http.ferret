package com.httpferret.domain.model

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import io.quarkus.runtime.annotations.RegisterForReflection
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id


@Entity
@RegisterForReflection
data class FerretStatus(
    @Id
    private val code: Int,

    @Column
    private val title: String,

    @Column
    private val url: String,
) : PanacheEntityBase {

    companion object: PanacheCompanion<FerretStatus> {
        fun byCode(code: Int) = find("code", code).firstResult()
    }
}
