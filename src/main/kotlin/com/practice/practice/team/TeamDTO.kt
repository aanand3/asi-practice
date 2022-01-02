package com.practice.practice.team

data class TeamDTO(
    val id: Long,
    val name: String,
) {
    fun toEntity() : Team {
        return Team(
            id = this.id,
            name = this.name,
        )
    }
}