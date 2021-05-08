import React, { useState } from 'react'

const HookForm = props => {
    const [fName, setFname] = useState("");
    const [lName, setLname] = useState("");
    const [email, setEmail] = useState("");
    const [pw, setPw] = useState("");
    const [confirmPw, setConfirmPw] = useState("");
    const [formSubmitted, setFormSubmitted] = useState(false);

    const submitForm = (e) => {
        e.preventDefault();
        setFormSubmitted(true);
    };

    return(
        <div class="App">
            <form onSubmit = {submitForm}>
                <div class="row">
                    <label htmlFor="fName">First Name</label>
                    <input type="text" onChange= {(e) => setFname(e.target.value)} value={fName}/>
                </div>
                <div class="row">
                    <label htmlFor="lName">Last Name</label>
                    <input type="text" onChange= {(e) => setLname(e.target.value)} value={lName}/>
                </div>
                <div class="row">
                    <label htmlFor="email">Email</label>
                    <input type="text" onChange= {(e) => setEmail(e.target.value)} value={email}/>
                </div>
                <div class="row">
                    <label htmlFor="pw">Password</label>
                    <input type="password" onChange= {(e) => setPw(e.target.value)} value={pw}/>
                </div>
                <div class="row">
                    <label htmlFor="confirmPw">Confirm Password</label>
                    <input type="password" onChange= {(e) => setConfirmPw(e.target.value)} value={confirmPw}/>
                </div>
            </form>

            <h3>Your Form Data</h3>
            <div class="row">
                <h3>First Name:</h3>
                <p>{fName}</p>
            </div>
            <div class="row">
                <h3>Last Name:</h3>
                <p>{lName}</p>
            </div>
            <div class="row">
                <h3>Email</h3>
                <p>{email}</p>
            </div>
            <div class="row">
                <h3>password</h3>
                <p>{pw}</p>
            </div>
            <div class="row">
                <h3>Confirm Password</h3>
                <p>{confirmPw}</p>
            </div>
        </div> // return div end
    );
}

export default HookForm;