const express = require("express");
const cors = require('cors');
const faker = require('faker');
const app = express();

app.use(cors())

app.get("/api", (req, res) => {
    res.json({message: "HelloWorld"});
})


class User {
    constructor(firstName, lastName, phoneNumber, email, password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
}


class Company {
    constructor(name, street, city, state, zipCode, country){
        this.name = name;
        this.address = {
            "name": name,
            "street": street,
            "city": city,
            "state": state,
            "zipCode": zipCode,
            "country": country
        };
    }
}


app.get("/api/users/new", (req, res) => {
    let user = new User(faker.name.firstName(), faker.name.lastName(), faker.phone.phoneNumber(), faker.internet.email(), faker.internet.password());
    res.json({user: user})
});

app.get("/api/company/new", (req, res) => {
    let company = new Company(faker.company.companyName(), faker.address.streetAddress(), faker.address.city(), faker.address.state(), faker.address.zipCode(), faker.address.country());
    res.json({company: company})
});

app.get("/api/user/company", (req, res) => {
    let user = new User(faker.name.firstName(), faker.name.lastName(), faker.phone.phoneNumber(), faker.internet.email(), faker.internet.password());

    let company = new Company(faker.company.companyName(), faker.address.streetAddress(), faker.address.city(), faker.address.state(), faker.address.zipCode(), faker.address.country());

    res.json({user: user, company: company})
});

app.listen(8000, () => console.log(`Listening on port: 8000`));