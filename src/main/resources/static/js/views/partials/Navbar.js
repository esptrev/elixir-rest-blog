import {isLoggedIn} from "../../auth.js";



export default function Navbar(props) {
    const loggedIn = isLoggedIn();

    let html= `
         <nav>
            <a href="/" data-link>Home</a>
            <a href="/about" data-link>About</a>`;

    if(loggedIn){

        html = html + `<a href="/posts" data-link>Posts</a>
                        <a href="/user" data-link>Profile</a>
                        <a href="/logout" data-link>Log Out</a>`;
    }else  {
        html = html + `<a href="/login" data-link>Login</a>
                       <a href="/register" data-link>Register</a>`

    }
    html = html + `</nav>`;
    return html;
}