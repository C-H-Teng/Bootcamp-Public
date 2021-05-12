import React, {useState} from 'react'

const TaskForm = props => {
    const {submitTask} = props;
    const [taskTitle, setTaskTitle] = useState("")

    const submitHandler = (e) => {
        e.preventDefault();
        submitTask({
            taskTitle: taskTitle,
            complete: false
        });
        setTaskTitle("");
    }

    return (
        <form onSubmit = {submitHandler}>
            <input type="text" onChange={e => setTaskTitle(e.target.value)} value={taskTitle} />
            <button type="submit" value="submit">Add task</button>
        </form>
    ); // return end
}



export default TaskForm