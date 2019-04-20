package com.resource;

import java.util.ArrayList;
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

@Path("posts")
public class MyResource {

	static ArrayList<Post> posts = new ArrayList<>();

	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getPosts() {
		return posts;
	}

	@Path("add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Post> addPost(Post newPost) {
		posts.add(newPost);
		return posts;
	}

	@Path("edit")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Post> editPost(Post editedPost) {

		Object[] arr = posts.toArray();
		for (int i = 0; i < arr.length; i++) {
			if (((Post) arr[i]).getId() == editedPost.getId()) {
				posts.set(i, editedPost);
				break;
			}
		}
		return posts;
	}

	@Path("delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> deletePost(@PathParam("id") int id) {

		Object[] arr = posts.toArray();
		for (int i = 0; i < arr.length; i++) {
			if (((Post) arr[i]).getId() == id) {
				posts.remove(arr[i]);
				break;
			}
		}
		return posts;
	}
}