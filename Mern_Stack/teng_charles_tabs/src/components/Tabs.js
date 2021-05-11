import React, {useState} from 'react';
import '../App.css';
// import TabsData from './TabData;';


const Tabs = props => {
    const {tabArr} = props;
    const [tabOne, setTabOne] = useState(false);
    const [tabTwo, setTabTwo] = useState(false);
    const [tabThree, setTabThree] = useState(false);

    const clickHandler = (e, idx) => {
        e.preventDefault();
        if(idx === 0){
            setTabOne(true);
            setTabTwo(false);
            setTabThree(false);
        }
        if(idx === 1){
            setTabTwo(true);
            setTabOne(false);
            setTabThree(false);
        }
        if(idx === 2){
            setTabThree(true);
            setTabOne(false);
            setTabTwo(false);
        }
    }

    const arrData = () => {
        if(tabOne){
            return tabArr[0];
        } else if(tabTwo){
            return tabArr[1];
        } else if(tabThree){
            return tabArr[2];
        }
    }

    return(
        <div id="container">
            <div className="row">
                {
                    tabArr.map( (content, idx) => <button onClick={ (e) => clickHandler(e, idx) } key={idx}>{idx+1}</button>)
                }
            </div>
            {
                <p>{arrData()}</p>
            }
        </div> // container div end
    );
}


export default Tabs