import CreateView from "../createView.js"
import {getHeaders} from "../auth.js";

const USER_URI = "http://localhost:8080/api/user/create"

export default function Register(props) {
    return `
    <!DOCTYPE html>
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Register</title>
            </head>
            <body>
                <h1>Register</h1>
        
                <form id="register-form">
                    <label for="username">Username</label>
                    <input id="username" name="username" type="text"/>
                    <label for="email">Email</label>
                    <input id="email" name="email" type="email">
                    <label for="password">Password</label>
                    <input id="password" name="password" type="password"/>
                    <button id="register-btn" type="button">Register</button>
                </form>
            </body>
        </html>
`;
}

export function RegisterEvent() {
    $("#register-btn").click(function () {
///creates new user object from input fields on register form
        let newUser = {
            username: $("#username").val(),
            email: $("#email").val(),
            password: $("#password").val()
        }

        console.log(newUser);
///makes post request
        let request = {
            method: "POST",
            headers: getHeaders(),
            body: JSON.stringify(newUser)
        }
///sends to backend
        fetch(USER_URI, request)
            .then(response => {
                console.log(response.status);
                CreateView("/");
            })

    })
}