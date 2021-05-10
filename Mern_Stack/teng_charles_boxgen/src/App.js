import React, { useState } from "react";
import './App.css';
import BoxForm from "./components/BoxForm";
import BoxDisplay from "./components/BoxDisplay";

function App() {
  const [boxArr, setBoxArr] = useState([]);
  const [color, setColor] = useState("");
  const [size, setSize] = useState("");

  const addBoxToArr = () => {
    setBoxArr([...boxArr, {
      "color": color,
      "size": size
    }]);
  }

  return (
    <div className="App">
      {/* Form */}
      <BoxForm
        submitBox={addBoxToArr}
        color={color}
        setColor={setColor}
        size={size}
        setSize={setSize}
      />
      {/* Display */}
      <BoxDisplay
        boxArr={boxArr}
      />
    </div>
  );
}

export default App;
