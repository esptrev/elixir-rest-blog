import createView from "../createView.js";


export default function Logout(props){
    console.log("Logging out.....");
    return ``;
}

export function LogoutEvents(){
    console.log("calling logout events");
    window.localStorage.clear();
    createView("/login")
}