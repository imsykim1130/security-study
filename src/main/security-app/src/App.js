import './App.css';
import {useEffect, useState} from "react";

function App() {
  const [message, setMessage] = useState("");
  useEffect(() => {
    fetch("/login")
        .then(res => res.text())
        .then(message => setMessage(message))
  }, []);
  return (
      <div className="App">
        <h1>{message}</h1>
      </div>
  );
}

export default App;
