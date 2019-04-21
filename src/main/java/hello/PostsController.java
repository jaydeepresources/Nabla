package hello;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Post;
import model.Status;

@RestController
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT })
@RequestMapping("/posts")
public class PostsController {

	dao.PostsDAOImpl impl = new dao.PostsDAOImpl();

	@RequestMapping("/all")
	@GetMapping
	public List<Post> getPosts() {

		return impl.getPosts();

	}

	@RequestMapping("/get/{title}")
	@GetMapping
	public List<Post> getPostsByTitle(@PathVariable String title) {

		return impl.searchPosts(new Post(0, title, ""));
	}

	@RequestMapping("/add")
	@PostMapping
	public Post addPost(@RequestBody Post post) {

		return impl.addPost(post);
	}

	@RequestMapping("/update")
	@PutMapping
	public Status updatePost(@RequestBody Post post) {

		return impl.updatePost(post);

	}

	@RequestMapping("/delete/{id}")
	@DeleteMapping
	public Status deletePost(@PathVariable int id) {

		return impl.deletePost(new Post(id, "", ""));

	}
}