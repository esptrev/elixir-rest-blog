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
                ${props.posts.map(post => `<h3 id = "title-${post.id}">${post.title}</h3>
                 <p id = "content-${post.id}">${post.content}</p>
                 <p id = "author-post">${post.author.username}</p>
                 <button type="button" class="edit-btn btn btn-success" data-id = "${post.id}">Edit</button>
                 <button type="button" class="delete-btn btn btn-danger" data-id = "${post.id}">Delete</button><br>
            </div>`
    ).join('')} 
                  
            </div>
            <form>
                <div  id =  "newBlogContainer" class="form-group">
                   <div id ="blog-post-id"></div>
                   <label for="newBlogEntryTitle">Blog Title</label>
                   <input type="text" class="form-control" id="newBlogEntryTitle" placeholder="Blog Title">
                </div>
               <div class="form-group">
                 <label for="newBlogEntryBodyArea">Content</label>
                 <textarea class="form-control" id="newBlogEntryBodyArea" rows="5" placeholder="Blog Content"></textarea>
               </div>
               <button id = "newBlogPostSubmit" type="button" class="btn btn-primary">Post</button>
               <button id = "editBlogPostButton" type="button" class="btn btn-success">Edit</button>
               
           </form>
           
        </main>
    `;
}///CLOSES POSTINDEX FUNCTION

export function PostsEvent(){
    submitNewPost();
    grabBlogToEdit();
    deleteCurrentPost();
}///CLOSE POSTSEVENT FUNCTION

function submitNewPost(){
$('#newBlogPostSubmit').click(function(){
    const NEW_BLOG_INFO = {

        title: $('#newBlogEntryTitle').val(),
        content: $('#newBlogEntryBodyArea').val()
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

})
}///CLOSE OF SUBMITNEWPOST

function grabBlogToEdit(){
    $('.edit-btn').click(function (){

        const id = $(this).data("id");
        const title = $("#title-" + id).text();
        const content = $("#content-" + id).text();
        $('#blog-post-id').val(id);
        $('#newBlogEntryTitle').val(title);
        $('#newBlogEntryBodyArea').val(content);

        $('#editBlogPostButton').click(function (){
            editCurrentPost();
        })
    })
}

function editCurrentPost(){
   const id = $('#blog-post-id').val();

    // const id = $(this).data("id");
    console.log(id);

        const BLOG_INFO_TO_EDIT = {
            id: $('#blog-post-id').val(),
            title: $('#newBlogEntryTitle').val(),
            content: $('#newBlogEntryBodyArea').val
        }

        const OPTIONS = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(BLOG_INFO_TO_EDIT),
        };

        fetch(`${BLOGS_URL}/${id}`,OPTIONS)
            .then(function (res){
                console.log(res);
                 createView("{blogPostId}")
            }).catch(function (reason){
            console.log(reason);

        }).finally(()=>{
            console.log("Edit blog button clicked");
            createView("/posts");
        })

}////END OF EDIT

function deleteCurrentPost(){
    $('.delete-btn').click(function (){
        const id = $(this).data("id");

        const OPTIONS = {
            method: 'DELETE',
        }
        fetch(`${BLOGS_URL}/${id}`,OPTIONS)
            .then(function (res){
                console.log(res);
                createView("{blogPostId}")
            }).catch(function (reason){
            console.log(reason);
        }).finally(()=>{
        console.log("Delete button clicked");
        createView("/posts");
        })
    })
}
