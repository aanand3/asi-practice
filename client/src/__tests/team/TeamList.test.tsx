import React from 'react';
import {render, screen, waitFor} from '@testing-library/react';
import {TeamList} from "../../team/TeamList";
import {getTeams, Team} from "../../team/TeamApi";

jest.mock('../../team/TeamApi')
const mockGetTeams = getTeams as jest.MockedFunction<typeof getTeams>


describe('teams list', () => {
    beforeEach(async () => {
        const mockTeam: Team = {
            id: 3,
            name: "mock team"
        }

        mockGetTeams.mockResolvedValue([mockTeam])
    })

    it('fetches the teams on render', async () => {
        render(<TeamList/>);

        await waitFor(() => {
            expect(mockGetTeams).toHaveBeenCalled()
        })
    })

    it('renders the list of teams', async () => {
        render(<TeamList/>);

        await waitFor(() => {
            expect(screen.getByText(/mock team/i)).toBeVisible()
        })
    });
})
