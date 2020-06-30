package com.spring.app.controlers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.app.configuration.Pages;
import com.spring.app.model.Post;

//@Controller le indica a spring boot que esta clase va a ser un controlador 
@Controller
//@RequestMapping le indica a spring boot el endpoint como parte del path para el url
@RequestMapping("/home")
public class ControllerBasic {
	
//	con @GetMapping se le indica a indica a spring boot que a continuacion se encuentra 
//	el método Get para optener recursos
	@GetMapping(path= {"/posts","/"})

	/*
	 * Declaración abierta org.springframework.ui.Model
	 * 
	 * Interfaz específica de Java-5 que define un titular para los atributos del
	 * modelo. Diseñado principalmente para agregar atributos al modelo. Permite
	 * acceder al modelo general como java.util.Map. 
	 * 
	 * Desde: 2.5.1 Autor: Juergen Hoeller
	 */	
//	generador de objetos post para el index
	public String inicio(Model model) {
		model.addAttribute("posts", getPost());
		return "index";
	}
	
//	Poblando las instancias 
	public List<Post> getPost(){
		
		ArrayList<Post> post = new ArrayList<>(); 
		post.add(new Post(1,"Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut consequuntur debitis quo repellat incidunt earum quaerat suscipit sed molestias dicta minima fugiat numquam, quibusdam porro mollitia autem adipisci exercitationem. Incidunt.","http://localhost:8080/img/champions.jpg",new Date(),"Desarrollo web"));
		post.add(new Post(2,"Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut consequuntur debitis quo repellat incidunt earum quaerat suscipit sed molestias dicta minima fugiat numquam, quibusdam porro mollitia autem adipisci exercitationem. Incidunt.","http://localhost:8080/img/champions.jpg",new Date(),"Desarrollo Backend"));
		post.add(new Post(3,"Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut consequuntur debitis quo repellat incidunt earum quaerat suscipit sed molestias dicta minima fugiat numquam, quibusdam porro mollitia autem adipisci exercitationem. Incidunt.","http://localhost:8080/img/champions.jpg",new Date(),"Desarrollo Frontend"));
		post.add(new Post(4,"Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut consequuntur debitis quo repellat incidunt earum quaerat suscipit sed molestias dicta minima fugiat numquam, quibusdam porro mollitia autem adipisci exercitationem. Incidunt.","http://localhost:8080/img/champions.jpg",new Date(),"Desarrollo Fullstack"));
		return post;
	}
//	en el siguiente método se ve atra manera de aplicar el modelo usando ModelAndView
//	además al constructor del ModelAndView se mando la variable static HOME 
	@GetMapping(path="/public")
	public ModelAndView post() {
		ModelAndView modelAndView = new ModelAndView(Pages.HOME); 
		modelAndView.addObject("posts", getPost());
		return modelAndView;
	}
//	método para ver los post individualmente
	
	@GetMapping(path= {"/post"})
	public ModelAndView getPostIndividual(@RequestParam(defaultValue="1", name="id", required=false) int id) {
//		se instancia un ModelAndView donde la vista esta indicada en el constructor
		ModelAndView modelAndView = new ModelAndView(Pages.POST);
//		a continuacion se aplicará un filtro para señalar el post que vamos a solicitar

		List<Post> postFiltrado = getPost()
				.stream()
				.filter((postParam)->{
					return postParam.getId() == id;
				}).collect(Collectors.toList()); 
		
		modelAndView.addObject("post", postFiltrado.get(0));
		return modelAndView;
		 
	}
	
	@GetMapping("/postNew")
	public ModelAndView getForm() {
		return new ModelAndView("form").addObject("post", new Post()); 
	}
	
	@PostMapping("/addNewPost")
	public String addNewPost(Post post,Model model) {
		List<Post> posts = getPost();
		posts.add(post); 
		model.addAttribute("posts", posts);
		return "index";
	}
}
