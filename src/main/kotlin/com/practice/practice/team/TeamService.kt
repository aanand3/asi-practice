package com.practice.practice.team

import org.springframework.stereotype.Service

@Service
class TeamService(
    private val teamRepository: TeamRepository
) {
    fun getAllTeams(): List<Team> {
        return teamRepository.findAll()
    }

    fun createTeam(teamName: String) {
        teamRepository.save(
            Team(
                name = teamName
            )
        )
    }
}