import React, { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [title, setTitle] = useState("");
  const [tasks, setTasks] = useState([])
  const [editingId, setEditingId] = useState(null);
  const [editTitle, setEditTitle] = useState("");

  useEffect(() => {
  fetch('http://localhost:8081/tasks').then(response => response.json()).then(data => setTasks(data))
  }, []);

  function addTask() {
      const newTask = { title: title, completed: false };
      fetch('http://localhost:8081/tasks', {
          method: 'POST',
          headers: {'Content-Type': 'application/json'},
          body: JSON.stringify(newTask)
      })
      .then(() => fetch('http://localhost:8081/tasks'))
      .then(response => response.json())
      .then(data => setTasks(data))
      .catch(error => console.error('POST Error:', error));
      setTitle("");
  }

  function toggleCompleted(id, currentCompleted) {
      const updatedTask = { completed: !currentCompleted };
      fetch(`http://localhost:8081/tasks/${id}`, {
          method: 'PUT',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(updatedTask)
      })
      .then(() => fetch('http://localhost:8081/tasks'))
      .then(response => response.json())
      .then(data => setTasks(data))
      .catch(error => console.error('Toggle Error:', error));
  }

  function startEdit(task) {
      setEditingId(task.id);
      setEditTitle(task.title);
  }

  function saveEdit(id) {
      const updatedTask = { title: editTitle };
      fetch(`http://localhost:8081/tasks/${id}`, {
          method: 'PUT',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(updatedTask)
      })
      .then(() => fetch('http://localhost:8081/tasks'))
      .then(response => response.json())
      .then(data => {
          setTasks(data);
          setEditingId(null); // Exit edit mode
          setEditTitle(""); // Clear edit field
      })
      .catch(error => console.error('Edit Error:', error));
  }

    function deleteTask(id) {
      fetch('http://localhost:8081/tasks/' + id, { method: 'DELETE' }).then(() => fetch('http://localhost:8081/tasks')).then(response => response.json()).then(data => setTasks(data))
    }

  return (
    <div className="app-container">
      <h1>TODO List</h1>
      <div className="input-group">
      <label htmlFor="task-input">Add Task</label>
      <input id="task-input" value={title} onChange={(e) => setTitle(e.target.value)} />
      <button onClick={addTask}>Add Task</button>
      </div>
      <ul className="task-list">
      {tasks
          .slice() // Create a copy to avoid mutating state directly
          .sort((a, b) => a.completed - b.completed)
          .map(task => (
              <li key={task.id}>
                  <div className="task-item">
                      <input
                          type="checkbox"
                          checked={task.completed}
                          onChange={() => toggleCompleted(task.id, task.completed)}
                      />
                      {editingId === task.id ? (
                          <input
                              value={editTitle}
                              onChange={(e) => setEditTitle(e.target.value)}
                          />
                      ) : (
                          <span className={task.completed ? "completed" : ""}>
                              {task.title}
                          </span>
                      )}
                      <button onClick={() => deleteTask(task.id)}>Delete</button>
                      {editingId === task.id ? (
                          <button onClick={() => saveEdit(task.id)}>Save</button>
                      ) : (
                          <button onClick={() => startEdit(task)}>Edit</button>
                      )}
                  </div>
              </li>
          ))}
      </ul>
    </div>
  );
}
export default App;