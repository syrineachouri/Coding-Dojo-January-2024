const express = require("express");
const app = express();
const { faker } = require('@faker-js/faker');
// req is short for request
// res is short for response

const CreateUser = () => {
    const User = {
        password: faker.internet.password(),
        email: faker.internet.email(),
        phoneNumber: faker.phone.number(),
        lastName: faker.person.lastName(),
        firstName: faker.person.firstName(),
        _id: faker.number.int(),
    };
    return User;
}
const fakeUser = CreateUser();
console.log(fakeUser);

const CreateCompany = () => {

    const address = {
        street: faker.location.street(),
        city: faker.location.city(),
        state: faker.location.state(),
        zipCode: faker.location.zipCode(),
        country: faker.location.country(),
    };
    const Company = {
        name: faker.company.name(),
        _id: faker.number.int(),
        address: address,
    }
    return Company


}
const fakeCompany = CreateCompany();
console.log(fakeCompany);



app.get("/api/users/new", (req, res) => {
    res.json(fakeUser)
});
app.get("/api/companies/new", (req, res) => {
    res.json(fakeCompany)
});
app.get("/api/user/company", (req, res) => {
    res.json({ company: fakeCompany, user: fakeUser })
});

const server = app.listen(3000, () =>
    console.log(`Server is locked and loaded on port ${server.address().port}!`)
);
