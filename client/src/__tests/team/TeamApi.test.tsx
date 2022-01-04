import nock from 'nock';
import {getTeams, Team} from "../../team/TeamApi";
// works but idk why
import httpAdapter from "axios/lib/adapters/http";
import axios from "axios";

axios.defaults.adapter = httpAdapter;

describe('Team Api', () => {
    it('gets all teams', async () => {
        const scope = nock('http://localhost:8080')
            .get('/api/teams')
            .reply(200, [mockTeam]);

        const response = await getTeams();

        expect(scope.isDone()).toBeTruthy();
        expect(response).toEqual([mockTeam]);
    });
})

const mockTeam: Team = {
    id: 3,
    name: "mock team"
}