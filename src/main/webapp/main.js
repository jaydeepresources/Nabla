var posts;

function mapPosts() {
    var list = '';
    for (var i = 0; i < posts.length; i++) {
        list += "<li class='list-group-item'>"
            + posts[i].title
            + "</li>"
    }
    document.getElementById('list').innerHTML = list;
}

function getPosts() {
    fetch('http://localhost:8080/postbook/webapi/postbook/posts/all')
        .then(res => res.json())
        .then(res => {
            posts = res;
            mapPosts();
        })
}