import CreateView from "../createView.js"
import {getHeaders} from "../auth.js";

const USER_URI = "http://localhost:8080/api/users"


export default function Profile(props) {
    console.log(props);
    return `
            <header>  
                <title>Update Profile</title>
            </header>
            <main>
                <h1>User Profile</h1>
                <div id = "user-id-container">${props.users.id}
                    <form id="profile-info">
                        <label for="username">Username</label>
                        <input id="username" name="username" value= "${props.users.username}"><br>
                        <label for="email" >Email</label>
                        <input id="email" name="email" type="email" value = "${props.users.email}"><br>
                        <label for="current password"> Current Password</label>
                        <input id="current password" name="current password" type="password"/><br>
                        <label for="new password">New Password</label>
                        <input id="new password" name="new password" type="password"/><br>
                        <label for="confirm password">Confirm Password</label>
                        <input id="confirm password" name="confirm password" type="password"/>
                        <button id="update-profile-btn" type="button" class="btn-success">Submit Changes</button>
                        <button id="edit-profile-btn" type="button" class="btn-primary">Edit</button>
                    </form>               
                </div>
                 <div id = "blogPostDiv"> ${props.user.posts.map(post => {return `<h3>${post.title}</h3>`}).join('')} </div>
             </main> `;
}

export function ProfileEvent() {
    $("#update-profile-btn").click(function () {
        const id = 1;
        const newPassword = $("#confirm-password").val()

///makes post request
        let request = {
            method: "PUT",
            headers: getHeaders()
        }
///sends to backend
        fetch(`${USER_URI}/${id}/updatePassword?newPassword=${newPassword}`, request)
            .then(response => {
                console.log(response.status);
                CreateView("/api/users/{id}/updatePassword");
            })

    });

}