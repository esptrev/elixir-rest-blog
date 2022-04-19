import CreateView from "../createView.js"

const USER_URI = "http://localhost:8080/api/users"


export default function Profile(props) {
    return `
    <!DOCTYPE html>
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Update Profile</title>
            </head>
            <body>
                <h1>User Profile</h1>
                <div id = "user-id-container">This will be user.id</div>
                <form id="profile-info">
                    
                    <label for="username">Username</label>
                    <input id="username" name="username" type="text"/>
                    <label for="email">Email</label>
                    <input id="email" name="email" type="email">
                    <label for="current password"> Current Password</label>
                    <input id="current password" name="current password" type="password"/>
                    <label for="new password">New Password</label>
                    <input id="new password" name="new password" type="password"/>
                    <label for="confirm password">Confirm Password</label>
                    <input id="confirm password" name="confirm password" type="password"/>
                    <button id="update-profile-btn" type="button" class="btn-success">Submit Changes</button>
                    <button id="edit-profile-btn" type="button" class="btn-primary">Edit</button>
                </form>
            </body>
        </html>
`;
}

export function ProfileEvent() {
    $("#update-profile-btn").click(function () {
        const id = $('#user-id-container').val();
/// will update userID, password or email
        let updatedProfile = {
            username: $("#username").val(),
            email: $("#email").val(),
            password: $("#confirm-password").val()
        }

        console.log(updatedProfile);
///makes post request
        let request = {
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(updatedProfile)
        }
///sends to backend
        fetch(`${USER_URI}/${id}`, request)
            .then(response => {
                console.log(response.status);
                CreateView("/api/users/{id}/updatePassword");
            })

    })

}