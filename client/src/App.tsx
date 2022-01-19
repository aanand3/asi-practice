import React from 'react';
import logo from './logo.svg';
import './App.css';
import {TeamList} from "./team/TeamList";
import {TeamForm} from "./team/TeamForm";

function App() {
  return (
    <div className="App">
      <TeamList />
      <TeamForm />
    </div>
  );
}

export default App;
