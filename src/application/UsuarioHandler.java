package application;

import java.util.ArrayList;
import java.util.List;

import Models.*;

public class UsuarioHandler implements Listaveis {
    private final List<Usuario> usuarios;
    private Usuario usuarioAtual;
    private static int numeroFuncionarios;

    public UsuarioHandler() {
        usuarios = new ArrayList<Usuario>();
        this.usuarioAtual = null;
        usuarios.add(new Gerente("email", "senha", "nome", 1, "BANANA"));
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        if (usuario instanceof Funcionario) {
            numeroFuncionarios++;
        }
    }

    public boolean removerUsuario(int cpf) {
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

    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }


    @Override
    public void exibirTabulado() {
        System.out.println("| Tipo de Usuário\t|\t Nome\t|\t E-mail\t|\t CPF \t|");
        StringBuilder sBuilder = new StringBuilder();
        for (Usuario usuario : usuarios){
            sBuilder.append("| ");
            if(usuario instanceof Garcom){
                sBuilder.append("Garçom\t|\t");
            } else if(usuario instanceof Cozinheiro){
                sBuilder.append("Cozinheiro\t|\t");
            } else if(usuario instanceof Gerente){
                sBuilder.append("Gerente\t|\t");
            }
            sBuilder.append(usuario.getNome()).append("\t|\t");
            sBuilder.append(usuario.getEmail()).append("\t|\t");
            sBuilder.append(usuario.getCPF()).append("\t|\t");
            sBuilder.append("\n");
        }
        System.out.println(sBuilder);
    }
}
