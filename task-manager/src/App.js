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
    setTitle("");
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
        <li key = {task.id}>
        {task.title}
        </li>
        )}
      </ul>
    </div>
  );
}

export default App;