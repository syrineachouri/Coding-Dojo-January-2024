import logo from './logo.svg';
import React, {useState} from 'react'
import './App.css';
import Form from './components/Form';
import Todos from './components/Todos';
function App() {
  
  const [newTodo, setNewTodo] = useState("")
  const [todos, setTodos] = useState([])



  const handleNewTodoSubmit = (e) => {
    e.preventDefault();

    if(newTodo.length === 0) {
      return;
    }
    const todoItem = {
      text: newTodo,
      complete: false
    }
    setTodos([...todos,todoItem])
    setNewTodo("")
  }

  

  const handleTodoDelete = (delId) => {
    const filteredTodos = todos.filter((todo,i)=>{
      return i !== delId;
    });
    setTodos(filteredTodos);
  }

  const handleToggleComplete = (idx) => {
    const updatedTodos = todos.map((todo,i)=>{
      if(idx === i){
        return {...todo,complete: !todo.complete};
        
      }
      return todo;
    })
    setTodos(updatedTodos);
  }
  return (
    
      <div style={{textAlign: "center"}}>
      <form onSubmit={(e)=> 
        handleNewTodoSubmit(e)
      }>
        <input onChange={(e)=>{
          setNewTodo(e.target.value);
        }} type="text" value={newTodo} />
        <br/>
        <button>Add</button>
      </form>
      <hr/>
      {
        todos.map((todo, i) =>{
          const todoClasses = []
          if(todo.complete){
            todoClasses.push("line-through")
          }
          return <div key={i}>
            <input onChange={(e)=>{
              handleToggleComplete(i);
            }} checked={todo.complete} type="checkbox"/>
            <span className={todoClasses.join(" ")}>{todo.text}</span>
            
            <button onClick={(e)=> {
              handleTodoDelete(i);
            }} style={{backgroundColor:"red",marginLeft:"10px"}}>Delete</button>
          </div>

        })
      }
      </div>
      
    
  );
}

export default App;