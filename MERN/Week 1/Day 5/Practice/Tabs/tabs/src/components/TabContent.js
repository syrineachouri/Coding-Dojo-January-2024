import React from 'react';


const TabContent = (props) => {
    const { tab, setTab} = props;

    const onClickHandler = (index) => {
        setTab({
        ...tab,
        selectedTab: index,
        })
    
    }

    return (
        <div>
            <nav className= "nav nav-pills nav-justified justify-content-center">
            {
                tab.content.map((tab, index)=>(
                    <div className= { "nav-item nav-link border border-dark"} onClick={() => onClickHandler(index)}>
                        Tab {index +1}
                    </div>
                
                ))

            }
            
            </nav>
            <div className="border border-dark mt-5">
            <p> {props.tab.content[props.tab.selectedTab]}</p>
            </div>
        </div>

    )

}

export default TabContent;