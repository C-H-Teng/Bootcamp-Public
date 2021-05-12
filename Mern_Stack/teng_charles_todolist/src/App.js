import React, {useState} from 'react';
import './App.css';
import TaskForm from './components/TaskForm';
import ListDisplay from './components/ListDisplay';


function App() {
  const [toDoList, setToDoList] = useState([]);

  const addTaskToList = (newTask) => {
    setToDoList([...toDoList, newTask]);
  }

  return (
    <div className="App">
      {/* <p>{JSON.stringify(toDoList)}</p> */}
      <TaskForm 
        submitTask = {addTaskToList}
      />

      <ListDisplay 
        toDoList = {toDoList}
        setToDoList = {setToDoList}
      />
    </div>
  );
}

export default App;
