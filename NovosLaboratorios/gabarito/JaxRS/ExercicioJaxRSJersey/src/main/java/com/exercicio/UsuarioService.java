package com.exercicio;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioService {

    private List<Usuario> usuarioDatabase;

    public UsuarioService() {
        this.initUserDatabase();
    }

    public List<Usuario> getAllUsers() {
        return this.usuarioDatabase;
    }

    // Get
    public Usuario getUserById(int id) {
        return this.usuarioDatabase.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .get();
    }

    // Post
    public void addUser(Usuario user) {
        this.usuarioDatabase.add(user);
    }

    // Put
    public void updateUser(int id, Usuario user) {
        Usuario userToUpdate = this.getUserById(id);
        int indexOfUser = this.usuarioDatabase.indexOf(userToUpdate);
        this.usuarioDatabase.set(indexOfUser, user);
    }

    // Delete
    public void removeUser(int id) {
        Usuario usuario = this.getUserById(id);
        this.usuarioDatabase.remove(usuario);
    }

    private void initUserDatabase() {
        this.usuarioDatabase = new ArrayList<>();
        this.usuarioDatabase.add(new Usuario(1, "Marcela Oliveira", "marcela.oliveira@gmail.com"));
        this.usuarioDatabase.add(new Usuario(2, "Arthur Malta", "art.malta@hotmail.com"));
        this.usuarioDatabase.add(new Usuario(3, "Carlos Faria", "c.faria@gmail.com"));
        this.usuarioDatabase.add(new Usuario(4, "Alberto Souza", "albertosouza@gmail.com"));
        this.usuarioDatabase.add(new Usuario(5, "Isabel Maia", "isa.maia@gmail.com"));
    }

}
