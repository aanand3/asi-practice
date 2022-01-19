import {useState} from "react";
import {createTeam} from "./TeamApi";

interface TeamFormProps {

}

export const TeamForm = (props: TeamFormProps) => {
    const {} = props
    const [inputValue, setInputValue] = useState("")

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setInputValue(event.target.value)
    }

    const handleSubmit = async () => {
        await createTeam(inputValue).then(() => {
            console.log('posted')
        })
    }

    return (
        <div>
            <input aria-label="team name" type="text" onChange={handleChange} />
            <button onClick={handleSubmit}>Submit</button>
        </div>
    )
}