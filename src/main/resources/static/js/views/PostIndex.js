import createView from "../createView.js";

const BLOGS_URL = "http://localhost:8080/api/posts";

export default function PostIndex(props) {
    // HTML
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
            <div id = "blogPostDiv">
                ${props.posts.map(post => `<h3>${post.title}</h3>`).join('')} 
                <button id = "editBlogPostButton" type="button" class="btn btn-success">Edit</button>
                <button id = "deleteBlogPostButton" type="button" class="btn btn-danger">Delete</button>  
            </div>
            <form>
                <div  id =  "newBlogContainer" class="form-group">
                   <label for="newBlogEntryTitle">Email address</label>
                   <input type="text" class="form-control" id="newBlogEntryTitle" placeholder="Blog Title">
                </div>
               <div class="form-group">
                 <label for="newBlogEntryBodyArea">Blog Body</label>
                 <textarea class="form-control" id="newBlogEntryBodyArea" rows="5"></textarea>
               </div>
               <button id = "newBlogPostSubmit" type="button" class="btn btn-primary">Post</button>
               <button id = "editBlogPostButton" type="button" class="btn btn-success">Edit</button>
               
           </form>
           
        </main>
    `;
}///CLOSES POSTINDEX FUNCTION

export function PostsEvent(){
    submitNewPost();
    // editCurrentPost();
    // deleteCurrentPost();

}///CLOSE POSTSEVENT FUNCTION

function submitNewPost(){
$('#newBlogPostSubmit').click(function(){
    const NEW_BLOG_INFO = {
        title: $('#newBlogEntryTitle').val(),
        content: $('#newBlogEntryBodyArea').val
    }
    const OPTIONS = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(NEW_BLOG_INFO),
    };
    fetch(BLOGS_URL, OPTIONS)
        .then(function (res){
            console.log(res);
            createView("/posts")
        }).catch(function (reason){
        console.log(reason);
        createView("/posts")
    })
    console.log("New blog post button clicked")
})
}///CLOSE OF SUBMITNEWPOST


function editCurrentPost(){
    $('#editBlogPostButton').click(function ())
}
