import axios from "axios";

export const getTeams = async (): Promise<Team[]> => {
    return (await axios.get<Team[]>("http://localhost:8080/api/teams")).data
}

export const createTeam = async (name: string) : Promise<void> => {
    await axios.post(`http://localhost:8080/api/teams/create/${name}`)
}

export interface Team {
    id: number,
    name: string,
}
