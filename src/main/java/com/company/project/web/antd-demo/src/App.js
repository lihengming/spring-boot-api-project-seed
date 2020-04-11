import React from 'react';
import {Button} from 'antd';
import './App.css';
import Home from "./components/Home";
import New from "./components/New";
import ReactForm from "./components/ReactForm";

const App = () => (
    <div className="App">
        <Button type="primary">Button</Button>
        <h1>我就是纠结多久试试</h1>
        <Home/>
        <New/>
        <ReactForm/>
    </div>
);

export default App;