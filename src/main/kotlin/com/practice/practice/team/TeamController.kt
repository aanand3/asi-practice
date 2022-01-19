package com.practice.practice.team

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/teams")
@CrossOrigin
class TeamController(
    private val teamService: TeamService
) {
    @GetMapping
    fun getAllTeams(): List<TeamDTO> {
        return teamService.getAllTeams().map { it.toDTO() }
    }

    @PostMapping("/create")
    fun createTeam(@RequestBody teamName: String) {
        teamService.createTeam(teamName)
    }
}