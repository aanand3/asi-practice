package com.practice.practice.team

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class TeamServiceTest {
    lateinit var mockTeamRepository: TeamRepository
    lateinit var teamService: TeamService

    @BeforeEach
    fun setup() {
        mockTeamRepository = mockk()
        teamService = TeamService(mockTeamRepository)
    }

    @Test
    fun `get teams returns list of teams`() {
        val teamList = listOf(
            Team(
                id = 0,
                name = "team 1"
            ),
            Team(
                id = 1,
                name = "team 2"
            )
        )
        val expectedResult = teamList.map { it.toDTO() }

        every { mockTeamRepository.findAll() } returns teamList

        assertThat(teamService.getAllTeams()).isEqualTo(expectedResult)
    }

    @Test
    fun `saves a team to the repo`() {
        every {mockTeamRepository.save(any())} answers { firstArg() }

        teamService.createTeam("team 1")

        verify { mockTeamRepository.save(Team(
            id = 0,
            name = "team 1"
        ))}
    }
}