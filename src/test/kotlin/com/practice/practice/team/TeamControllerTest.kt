package com.practice.practice.team

import com.fasterxml.jackson.databind.ObjectMapper
import io.mockk.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import com.ninjasquad.springmockk.MockkBean
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.Rollback
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import javax.transaction.Transactional

//internal class TeamControllerTest {
//    private lateinit var mockTeamService: TeamService
//    private lateinit var teamController: TeamController
//
//    @BeforeEach
//    fun setup() {
//        mockTeamService = mockk()
//        teamController = TeamController(mockTeamService)
//    }
//
//    @Test
//    fun `getAllTeams calls service layer`() {
//        every { mockTeamService.getAllTeams() } returns emptyList()
//
//        teamController.getAllTeams()
//
//        verify(exactly = 1) { mockTeamService.getAllTeams() }
//    }
//
//    @Test
//    fun `createTeam calls service layer`() {
//        every { mockTeamService.createTeam(any()) } just runs
//
//        teamController.createTeam("teamName")
//
//        verify(exactly = 1) { mockTeamService.createTeam("teamName") }
//    }
//}

@WebMvcTest
@AutoConfigureMockMvc
internal open class TeamControllerTest {
    @Autowired
    private val mockMvc: MockMvc = mockk()

    @MockkBean
    private lateinit var mockTeamService: TeamService

    @Test
    open fun `postMapping works`() {
        every { mockTeamService.createTeam(any()) } just runs

        mockMvc.post("/api/teams/create") {
            contentType = MediaType.TEXT_PLAIN
            content = "hello there"
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { is2xxSuccessful() }
        }

        verify(exactly = 1) { mockTeamService.createTeam("hello there") }
    }
}