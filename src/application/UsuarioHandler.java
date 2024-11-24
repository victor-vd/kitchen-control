package application;

import java.util.ArrayList;
import java.util.List;

import Models.Usuario;

public class UsuarioHandler {
    private static List<Usuario> usuarios;
    private Usuario usuarioAtual;

    public UsuarioHandler() {
        usuarios = new ArrayList<Usuario>();
        this.usuarioAtual = null;
    }

    public static void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static boolean removerUsuario(int cpf) {
        boolean removed = usuarios.removeIf(pojo -> pojo.getCPF() == cpf);
        return removed;
    }

    public boolean login(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(login) && usuario.getSenha().equals(senha)) {
                usuarioAtual = usuario;
                return true;
            }
        }
        return false;
    }

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public boolean hasActiveUser() {
        return this.usuarioAtual != null;
    }

}
