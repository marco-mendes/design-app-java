package laboratorio1.exemplos.exemplo8;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {

    private List<User> usuarios;

    public UserDatabase() {
        this.usuarios = new ArrayList<User>();
        this.usuarios.add(new User("Leandro Ribeiro", "l_ribeiro@gmail.com.br", "12345"));
        this.usuarios.add(new User("Michelle Bastos", "michelle.bastos@gmail.com.br", "90453"));
        this.usuarios.add(new User("Carlos Alberto", "carlos.a@yahoo.com.br", "89167"));
    }

    public List<User> obterUsuarios() {
        return usuarios;
    }

    public void cadastrar(User usuario) {
        this.usuarios.add(usuario);
    }

    public void remover(User usuario) {
        this.usuarios.remove(usuario);
    }

}
