package laboratorio2.exemplos.exemplo1;

import java.util.Arrays;
import java.util.List;

public class User {

    private String nome;
    private List<PermissionType> permissions;

    public User(String nome, List<PermissionType> permissions) {
        this.nome = nome;
        this.permissions = permissions;
    }

    public String getNome() {
        return nome;
    }

    public List<PermissionType> getPermissions() {
        return permissions;
    }

    public void addPermission(PermissionType permissionType) {
        this.permissions.add(permissionType);
    }

    public void removePermission(PermissionType permissionType) {
        this.permissions.remove(permissionType);
    }

    public static List<User> getUsers() {
        List<PermissionType> writer = Arrays.asList(
                PermissionType.READ, PermissionType.WRITE, PermissionType.REMOVE
        );
        List<PermissionType> reader = Arrays.asList(
                PermissionType.READ
        );

        List<User> users = Arrays.asList(
                new User("Marcos", writer),
                new User("Carlos", reader),
                new User("Mateus", reader),
                new User("Alan", writer)
        );

        return users;
    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
