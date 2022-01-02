package com.practice.practice.team

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Team(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    val id: Long = 0,
    val name: String = ""
): Serializable {
    fun toDTO() : TeamDTO {
        return TeamDTO(
            id = this.id,
            name = this.name,
        )
    }
}