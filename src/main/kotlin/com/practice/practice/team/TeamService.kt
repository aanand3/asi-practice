package com.practice.practice.team

import org.springframework.stereotype.Service

@Service
class TeamService(
    private val teamRepository: TeamRepository
) {
    // design note: all outputs should be DTO

    fun getAllTeams(): List<TeamDTO> {
        return teamRepository.findAll().map { it.toDTO() }
    }

    fun createTeam(teamName: String) {
        teamRepository.save(
            Team(
                name = teamName
            )
        )
    }
}