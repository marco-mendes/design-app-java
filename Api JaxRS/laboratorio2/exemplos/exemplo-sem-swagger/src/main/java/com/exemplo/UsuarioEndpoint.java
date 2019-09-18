package com.exemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
public class UsuarioEndpoint {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(path="users")
    public ResponseEntity<List<Usuario>> getAllUsers() {
        List<Usuario> allUsers = usuarioService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping(path="user/{id}")
    public ResponseEntity<Usuario> getUser(@PathVariable("id") int id) {
        Usuario user = usuarioService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PostMapping(path="user")
    public ResponseEntity<?> addUser(@RequestBody Usuario user) {
        usuarioService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path="user/{id}")
    public ResponseEntity<?> updateUser (@PathVariable("id") int id, @RequestBody Usuario user) {
        usuarioService.updateUser(id, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path="user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        usuarioService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
