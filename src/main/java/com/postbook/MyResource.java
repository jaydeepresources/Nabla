package com.postbook;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.Post;
import com.model.Status;

import dao.PostsDAOImpl;

@Path("postbook")
public class MyResource {

	PostsDAOImpl impl = new PostsDAOImpl();

	@Path("posts/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getPosts() {
		return impl.getPosts();
	}

	@Path("posts/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Post addPost(Post post) {
		return impl.addPost(post);
	}

	@Path("posts/edit")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Status editPost(Post post) {
		return impl.updatePost(post);
	}

	@Path("posts/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Status deletePost(@PathParam("id") int id) {
		return impl.deletePost(new Post(id, "", ""));
	}

	@Path("posts/search/{title}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getPosts(@PathParam("title") String title) {
		return impl.searchPosts(new Post(0, title, ""));
	}

}
