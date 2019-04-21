package dao;

import java.util.List;

import model.Post;
import model.Status;

public interface PostsDAO {

	List<Post> getPosts();
	
	List<Post> searchPosts(Post post);

	Post addPost(Post post);

	Status updatePost(Post post);

	Status deletePost(Post post);
	
}