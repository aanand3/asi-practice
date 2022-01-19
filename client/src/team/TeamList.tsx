import {useEffect, useState} from "react";
import {getTeams, Team} from "./TeamApi";

interface TeamListProps {

}

export const TeamList = (props: TeamListProps) => {
    const {} = props
    const [teams, setTeams] = useState<Team[]>([])

    useEffect(() => {
        getTeams().then(
            teams =>
                setTeams(teams)
        )
    }, [])

    const listOfTeams = (
        <ul>
            {teams.map(team =>
                <li key={team.name}>{team.name}</li>
            )}
        </ul>
    )

    return (
        <div>
            {listOfTeams}
        </div>
    )
}