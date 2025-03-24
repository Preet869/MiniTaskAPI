import React, { useState } from 'react';

function App() {
  const [title, setTitle] = useState("");
  const [tasks, setTasks] = useState([]);

  function addTask() {
    const newTask = {
      id: tasks.length + 1,
      title: title,
      completed: false
    };
    setTasks([...tasks, newTask]);
    setTitle(" ");
  }


  function deleteTask(id) {
       setTasks(tasks.filter(task => task.id !== id))
  }

  return (
    <div>
      <h1><center>Task Manager</center></h1>
      <label>
        Task Input
        <input value={title} onChange={(e) => setTitle(e.target.value)} />
      </label>
      <button onClick={addTask}>Add Task</button>
      <ul>
       {tasks.map ( task =>
        <li key = {task.id}> &nbsp;
        {task.title}
         <button onClick={() => deleteTask(task.id)}>Delete</button>
        </li>
        )}

      </ul>
    </div>
  );
}

export default App;