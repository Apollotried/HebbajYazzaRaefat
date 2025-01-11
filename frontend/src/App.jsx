import { useState } from 'react'
import './App.css'
import Header from "./components/Header/header.jsx";
import Main from "./components/Main/Main.jsx";
import "./index.css"

function App() {
  const [count, setCount] = useState(0)

  return (
      <div className="container">
          <Header />
          <Main />
      </div>

  )
}

export default App
