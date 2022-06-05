import {showNotification} from "../messages.js";
import {getUserRole} from "../auth.js";

export default function Home(props) {
    console.log("The frontend did it. HER FAULT");
    return `
        <header>
            <h1>Home Page</h1>
        </header>
        <main>
            <div>
                <p>
                    This is the home page text.
                </p>    
            </div>
        </main>
    `;
}

export function HomeEvents(){
    const authority = getUserRole();
    showNotification(authority, "info");
}