import {fireEvent, render, screen, waitFor} from "@testing-library/react";
import {TeamForm} from "../../team/TeamForm";
import {type} from "@testing-library/user-event/dist/type";
import {createTeam, getTeams} from "../../team/TeamApi";

jest.mock('../../team/TeamApi')
const mockCreateTeam = createTeam as jest.MockedFunction<typeof createTeam>

describe('team creation form', () => {
    it('should render form field and submit button', async function () {
        render(<TeamForm/>);

        await waitFor(() => {
            expect(screen.getByLabelText(/team name/i)).toBeVisible()
            expect(screen.getByRole('textbox', {name: 'team name'})).toBeVisible()
            expect(screen.getByRole('button', {name: 'Submit'})).toBeVisible()
        })
    });

    it('should call post request on submit', async () => {
        render(<TeamForm />)
        mockCreateTeam.mockResolvedValue()

        const inputField = screen.getByRole('textbox')
        type(inputField, "team 1")
        fireEvent.click(screen.getByRole('button', {name: 'Submit'}));

        await waitFor(() => {
            expect(mockCreateTeam).toHaveBeenCalledWith("team 1")
        })
    });
});