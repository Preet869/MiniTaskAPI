import React from 'react';
import { useState } from "react";


function App() {
   const[title, setTitle] = useState("");
   const[tasks, setTasks] = useState([]);

  return (
    <div>
      <h1><center>Task Manager</center></h1>
      <label>
          Task Input
          <input value={title} onChange={(e) => setTitle(e.target.value)}/>
      </label>
    </div>
  );
}

export default App;