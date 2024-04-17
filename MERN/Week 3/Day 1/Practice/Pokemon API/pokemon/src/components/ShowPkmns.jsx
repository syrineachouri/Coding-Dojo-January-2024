const ShowPkmns = ( { pkmns } ) => {
    console.log("pkmns DESDE SHOW: ", pkmns);
    return (
        <div>
            <h2>Pokemons List</h2>
            <ul> 
                {
                    pkmns.map((pkmn, i) => {
                        return <li key={i}>{pkmn}</li>
                    })
                }
            </ul>
        </div>
        
    );
}

export default ShowPkmns;