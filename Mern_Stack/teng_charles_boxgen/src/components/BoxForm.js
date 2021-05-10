import React from 'react'

const BoxForm = props => {
    // const [boxArr, setBoxArr] = props;
    const {color, setColor, size, setSize, submitBox} = props;
    // const [localColor, setLocalColor] = useState("");
    // const [localSize, setLocalSize] = useState("");

    const submitHandler = e => {
        e.preventDefault();
        submitBox();
        setColor("");
        setSize("");
    }

    return (
        <div>
            <form onSubmit={submitHandler}>
                <div class="row">
                    <label htmlFor="color">Color:</label>
                    <input type="text" onChange={e => setColor(e.target.value)} value={color}></input>
                </div>
                <div class="row">
                    <label htmlFor="size">Size:</label>
                    <input type="text" onChange={e => setSize(e.target.value)} value={size}></input>
                </div>
                    <button type="submit" value="submit">Add</button>
            </form>
        </div>
    )
}

export default BoxForm;