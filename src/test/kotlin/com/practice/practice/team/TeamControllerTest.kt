package com.practice.practice.team

import com.fasterxml.jackson.databind.ObjectMapper
import io.mockk.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.test.annotation.Rollback
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import javax.transaction.Transactional

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

@SpringBootTest
@AutoConfigureMockMvc
internal class TeamControllerMVCTest {
    @Autowired
    private val mockMvc: MockMvc = mockk()

    @Autowired
    private val teamRepository: TeamRepository = mockk()

    @Transactional
    @Rollback
    @Test
    fun `postMapping works`() {
        val objectMapper = ObjectMapper()
        mockMvc.post("/api/teams/create") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString("hello there")
            accept = MediaType.APPLICATION_JSON
        }
    }
}