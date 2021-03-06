

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.suvha.libraryManagementSystem.model.User;
import com.suvha.libraryManagementSystem.service.UserService;
import com.suvha.libraryManagmentSystemMysql.model.Book;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

	public static final String BASE_URL = "/api/V1/user";
	
	@Autowired
	UserService userService;
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(value=HttpStatus.CREATED)
	public User create(@RequestBody @Valid  User user) {
		return userService.create(user);
	}
	
	@GetMapping
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	public Map<String, String> delete(@PathVariable String id) {
		return userService.delete(id);
	}
	
	@DeleteMapping
	@ResponseStatus(value=HttpStatus.OK)
	public void deleteAll() {
		userService.deleteAll();
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User getByid(@PathVariable int id) {
		return userService.getById(id);
	}
}
