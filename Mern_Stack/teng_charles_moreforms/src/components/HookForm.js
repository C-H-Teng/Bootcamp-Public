import React, { useState } from 'react'

const HookForm = props => {
    const [fName, setFName] = useState("");
    const [fNameError, setFNameError] = useState("");

    const valFName = (e) => {
        setFName(e.target.value);
        if(e.target.value.length === 1){
            setFNameError("Last name must have at least 2 characters.");
        } else {
            setFNameError("");
        }
    }

    const [lName, setLName] = useState("");
    const [lNameError, setLNameError] = useState("");

    const valLName = (e) => {
        setLName(e.target.value);
        if(e.target.value.length === 1){
            setLNameError("Last name must have at least 2 characters.");
        } else {
            setLNameError("");
        }
    }

    const [email, setEmail] = useState("");
    const [emailError, setEmailError] = useState("");

    const valEmail = (e) => {
        setEmail(e.target.value);
        if(e.target.value.length > 0 && e.target.value.length < 5){
            setEmailError("Email must have at least 5 characters.");
        } else {
            setEmailError("");
        }
    }

    const [pw, setPw] = useState("");
    const [pwError, setPwError] = useState("");

    const valPw = (e) => {
        setPw(e.target.value);
        if(e.target.value.length > 0 && e.target.value.length < 8){
            setPwError("Password must have at least 8 characters.");
        } else {
            setPwError("");
        }
    }

    const [confirmPw, setConfirmPw] = useState("");
    const [confirmPwError, setConfirmPwError] = useState("");

    const valConfirmPw = (e) => {
        setConfirmPw(e.target.value)
        if(e.target.value.length > 0 && e.target.value !== pw){
            setConfirmPwError("Passwords must match to confirm.");
        } else {
            setConfirmPwError("");
        }
    }

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
                    <input type="text" onChange= {valFName} value={fName}/>
                </div>
                {
                    fNameError ?
                    <p class="error">{fNameError}</p>:
                    ""
                }

                <div class="row">
                    <label htmlFor="lName">Last Name</label>
                    <input type="text" onChange={valLName} value={lName}/>
                </div>
                {
                    lNameError ?
                    <p class="error">{lNameError}</p>:
                    ""
                }

                <div class="row">
                    <label htmlFor="email">Email</label>
                    <input type="text" onChange= {valEmail} value={email}/>
                </div>
                {
                    emailError ?
                    <p class="error">{emailError}</p>:
                    ""
                }

                <div class="row">
                    <label htmlFor="pw">Password</label>
                    <input type="password" onChange= {valPw} value={pw}/>
                </div>
                {
                    pwError ?
                    <p class="error">{pwError}</p>:
                    ""
                }

                <div class="row">
                    <label htmlFor="confirmPw">Confirm Password</label>
                    <input type="password" onChange= {valConfirmPw} value={confirmPw}/>
                </div>
                {
                    confirmPwError ?
                    <p class="error">{confirmPwError}</p>:
                    ""
                }
                {/* <div class="row">
                    <button type="submit" value="submit">Submit form</button>
                </div> */}
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