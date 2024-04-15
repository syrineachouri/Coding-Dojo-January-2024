const Form = (props) => {
    const [addTodo, todo, setNewTodo] = props;
    return (
      <form onSubmit={addTodo}>
        <label>Todo
        <input value={todo} type='text' onChange={(e)=> setNewTodo(e.target.value)}/>
        </label>  
        <button type='submit'>ADD</button>
      </form>
    )
  }
  
  export default Form