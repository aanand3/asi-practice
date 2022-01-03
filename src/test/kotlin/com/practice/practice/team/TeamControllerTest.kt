package com.practice.practice.team

import io.mockk.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class TeamControllerTest {
    private lateinit var mockTeamService: TeamService
    private lateinit var teamController: TeamController

    @BeforeEach
    fun setup() {
        mockTeamService = mockk()
        teamController = TeamController(mockTeamService)
    }

    @Test
    fun `getAllTeams calls service layer`() {
        every { mockTeamService.getAllTeams() } returns emptyList()

        teamController.getAllTeams()

        verify(exactly = 1) { mockTeamService.getAllTeams() }
    }

    @Test
    fun `createTeam calls service layer`() {
        every { mockTeamService.createTeam(any()) } just runs

        teamController.createTeam("teamName")

        verify(exactly = 1) { mockTeamService.createTeam("teamName") }
    }
}