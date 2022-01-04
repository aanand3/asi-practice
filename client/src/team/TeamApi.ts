import axios from "axios";

export const getTeams = async (): Promise<Team[]> => {
    return (await axios.get<Team[]>("http://localhost:8080/api/teams")).data
}

export interface Team {
    id: number,
    name: string,
}
