package laboratorio2.exemplos.exemplo1;

import java.util.List;
import java.util.stream.Collectors;

public class Exemplo1 {


    public static void exemploComLambdaAnonimo() {
        List<User> users = User.getUsers();
        List<User> usersWithAllPermissions = users.stream().filter(u -> {
            return u.getPermissions().contains(PermissionType.READ) &&
                    u.getPermissions().contains(PermissionType.WRITE) &&
                    u.getPermissions().contains(PermissionType.REMOVE);

        }).collect(Collectors.toList());
        usersWithAllPermissions.forEach(u -> System.out.println(u));
    }

    public static void exemploComMetodoNomeado() {
        List<User> users = User.getUsers();
        List<User> usersWithAllPermissions = users.stream()
                .filter(Exemplo1::getUserWithAllPermissions)
                .collect(Collectors.toList());
        usersWithAllPermissions.forEach(u -> System.out.println(u));
    }

    public static boolean getUserWithAllPermissions(User user) {
        return user.getPermissions().contains(PermissionType.READ) &&
                user.getPermissions().contains(PermissionType.WRITE) &&
                user.getPermissions().contains(PermissionType.REMOVE);
    }

    public static void main(String[] args) {
        exemploComLambdaAnonimo();
        exemploComMetodoNomeado();
    }

}
