package com.practice.practice.team

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/teams")
class TeamController(
    private val teamService: TeamService
) {
    @GetMapping
    fun getAllTeams(): List<TeamDTO> {
        return teamService.getAllTeams()
    }

    @PostMapping("/create/{teamName}")
    fun createTeam(@PathVariable teamName: String) {
        return teamService.createTeam(teamName)
    }
}