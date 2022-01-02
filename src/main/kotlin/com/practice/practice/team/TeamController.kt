package com.practice.practice.team

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/teams")
class TeamController(
    private val teamRepository: TeamRepository
) {
    @GetMapping
    fun getAllTeams(): List<TeamDTO> {
        return teamRepository.findAll().map { it.toDTO() }
    }
}