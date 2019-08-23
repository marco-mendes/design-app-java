package laboratorio1.exercicios.exercicio1;

import java.util.ArrayList;
import java.util.List;

// Classe responsável por retornar a lista de usuários
public class UserDatabase {

    private static List<Usuario> usuarios;

    public UserDatabase() {
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("Cleber", "cleber@gmail.com", "12345"));
        usuarios.add(new Usuario("Joana", "joana@yahoo.com", "54325"));
        usuarios.add(new Usuario("Wilson Oliveira", "w.oliveira@gmail.com", "85094"));
        usuarios.add(new Usuario("Tales Franco", "tales.franco@gmail.com", "12847"));
    }

    public static List<Usuario> obterTodosUsuarios() {
        return usuarios;
    }

}