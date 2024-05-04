package br.com.portifoliounopar.crud.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.portifoliounopar.crud.entities.User;
import br.com.portifoliounopar.crud.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		
        List<User> list = ( service).findAll();
	    return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	
	public ResponseEntity<User> findbyId(@PathVariable Long id) {
		
		User usuario = service.findbyId(id);
		
		return ResponseEntity.ok(null).Body().(usuario);
		
	}
	
	public ResponseEntity<User> insert(@RequestBody User usuario){
		usuario = service.insert(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(usuario);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResposeEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<user> updated(@PathVariable Long id, @RequestBody User usuario){
		usuario = service.update(id, usuario)
		return  ResponseEntity.ok()).@RequestBody(usuario);
	}

}
