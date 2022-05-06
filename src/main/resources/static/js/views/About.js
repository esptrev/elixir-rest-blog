import {showNotification} from "../messages.js";

export default function About(props) {
    return `
        <header>
            <h1>About Page</h1>
        </header>
        <main>
            <div>
                <p>About page is here.</p>  
            </div>
        </main>
    `;
}

export function AboutEvents(){
    showNotification("Danger,Danger","danger");
}