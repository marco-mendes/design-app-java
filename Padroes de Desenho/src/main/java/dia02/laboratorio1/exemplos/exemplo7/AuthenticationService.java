package dia02.laboratorio1.exemplos.exemplo7;

import java.util.List;

public class AuthenticationService {

    private UserDatabase userDatabase = new UserDatabase();

    public boolean authenticateUser(User usuario) {
        List<User> usuarios = this.userDatabase.obterUsuarios();
        boolean usuarioAutenticado =  usuarios.stream()
                .filter(user -> user.getEmail().equals(usuario.getEmail()) &&
                        user.getSenha().equals(usuario.getSenha()))
                .findFirst()
                .isPresent();

        if(usuarioAutenticado) {
            System.out.println("Usuário autenticado com sucesso!");
        } else {
            System.out.println("Falha ao autenticar usuário!");
        }

        return usuarioAutenticado;
    }

}
