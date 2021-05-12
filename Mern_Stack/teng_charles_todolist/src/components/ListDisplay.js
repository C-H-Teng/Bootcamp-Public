import React from "react";
import '../App.css';

const ListDisplay = props => {
    const {toDoList, setToDoList} = props;

    const completeCheck = (idx) => {
        const copiedList = [...toDoList];
        copiedList[idx].complete = !copiedList[idx].complete;
        setToDoList(copiedList);
    }

    const deleteHandler = (idx) => {
        console.log(idx);
        const newList = toDoList.filter( (task, i) => i !== idx)
        // (i !== idx) = return all items with index (i) not matching idx
        setToDoList(newList);
    }

    return (
            toDoList.map( (task, idx) => 
                <p key={idx}>
                    <span style={{textDecoration:task.complete ? "line-through" : "none"}}>{task.taskTitle}</span>
                    <input type="checkbox" checked={task.complete} onChange={() => completeCheck(idx)} />
                    <button onClick={() => deleteHandler(idx)}>Delete</button>
                </p>
            )
    ) // return end
} // function end

export default ListDisplay