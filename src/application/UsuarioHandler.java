package application;

import java.util.ArrayList;
import java.util.List;

public class UsuarioHandler {
    private List<Usuario> usuarios;
    private Usuario usuarioAtual;

    public UsuarioHandler() {
        usuarios = new ArrayList<Usuario>();
        this.usuarioAtual = null;
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public boolean login(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(login) && usuario.getSenha().equals(senha)) {
                usuarioAtual = usuario;
                return true;
            }
        }
        return false;
    }

    public Usuario getUsuarioAtual(){
        return usuarioAtual;
    }

    public boolean hasActiveUser(){
        return this.usuarioAtual != null;
    }





}
