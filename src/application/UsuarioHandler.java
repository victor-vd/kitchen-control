package application;

import java.util.ArrayList;
import java.util.List;

import Models.Cozinheiro;
import Models.Funcionario;
import Models.Garcom;
import Models.Gerente;
import Models.Usuario;

public class UsuarioHandler implements Listaveis {
    private final List<Usuario> usuarios;
    private Usuario usuarioAtual;
    private static int numeroFuncionarios;

    public UsuarioHandler() {
        usuarios = new ArrayList<Usuario>();
        this.usuarioAtual = null;
        inicializarUsuarios();
    }

    // Método para inicializar a lista de usuários com dados predefinidos
    public void inicializarUsuarios() {
        // Adicionando 10 Gerentes
        usuarios.add(new Gerente("alice.silva@example.com", "senha123", "Alice Silva", 123456789, "G001"));
        usuarios.add(new Gerente("bruno.souza@example.com", "senha123", "Bruno Souza", 987654321, "G002"));
        usuarios.add(new Gerente("carla.pereira@example.com", "senha123", "Carla Pereira", 456789123, "G003"));
        usuarios.add(new Gerente("daniel.oliveira@example.com", "senha123", "Daniel Oliveira", 789123456, "G004"));
        usuarios.add(new Gerente("elena.rodrigues@example.com", "senha123", "Elena Rodrigues", 321654987, "G005"));
        usuarios.add(new Gerente("fabio.almeida@example.com", "senha123", "Fabio Almeida", 654987321, "G006"));
        usuarios.add(new Gerente("gabriela.lima@example.com", "senha123", "Gabriela Lima", 159753486, "G007"));
        usuarios.add(new Gerente("henrique.martins@example.com", "senha123", "Henrique Martins", 753159486, "G008"));
        usuarios.add(new Gerente("isabela.fernandes@example.com", "senha123", "Isabela Fernandes", 951357486, "G009"));
        usuarios.add(new Gerente("joao.costa@example.com", "senha123", "João Costa", 357951486, "G010"));

        // Adicionando 10 Cozinheiros
        usuarios.add(new Cozinheiro(25363, "Lucas Santos", "lucas.santos@example.com", "senha123", 123123123));
        usuarios.add(new Cozinheiro(26346, "Mariana Gomes", "mariana.gomes@example.com", "senha123", 321321321));
        usuarios.add(new Cozinheiro(32526, "Pedro Carvalho", "pedro.carvalho@example.com", "senha123", 456456456));
        usuarios.add(new Cozinheiro(62356, "Ana Paula", "ana.paula@example.com", "senha123", 654654654));
        usuarios.add(new Cozinheiro(23456, "Rafael Costa", "rafael.costa@example.com", "senha123", 789789789));
        usuarios.add(new Cozinheiro(46386, "Beatriz Almeida", "beatriz.almeida@example.com", "senha123", 987987987));
        usuarios.add(new Cozinheiro(62535, "Thiago Lima", "thiago.lima@example.com", "senha123", 147147147));
        usuarios.add(new Cozinheiro(36654, "Fernanda Souza", "fernanda.souza@example.com", "senha123", 258258258));
        usuarios.add(new Cozinheiro(34565, "Rodrigo Oliveira", "rodrigo.oliveira@example.com", "senha123", 369369369));
        usuarios.add(new Cozinheiro(63384, "Juliana Pereira", "juliana.pereira@example.com", "senha123", 741741741));

        // Adicionando 10 Garçons
        usuarios.add(new Garcom(62653, "Carlos Mendes", "carlos.mendes@example.com", "senha123", 852852852));
        usuarios.add(new Garcom(25362, "Patricia Silva", "patricia.silva@example.com", "senha123", 963963963));
        usuarios.add(new Garcom(32563, "Felipe Araújo", "felipe.araujo@example.com", "senha123", 741852963));
        usuarios.add(new Garcom(46325, "Larissa Costa", "larissa.costa@example.com", "senha123", 852963741));
        usuarios.add(new Garcom(55563, "Ricardo Lima", "ricardo.lima@example.com", "senha123", 159753852));
        usuarios.add(new Garcom(25636, "Vanessa Rocha", "vanessa.rocha@example.com", "senha123", 357159852));
        usuarios.add(new Garcom(32567, "Gustavo Martins", "gustavo.martins@example.com", "senha123", 951753852));
        usuarios.add(new Garcom(63528, "Camila Fernandes", "camila.fernandes@example.com", "senha123", 753951852));
        usuarios.add(new Garcom(96352, "Eduardo Oliveira", "eduardo.oliveira@example.com", "senha123", 159357852));
        usuarios.add(new Garcom(15630, "Renata Souza", "renata.souza@example.com", "senha123", 357951852));

        usuarios.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));
        exibirTabulado();
    }

    // Método para adicionar um novo usuário à lista
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        if (usuario instanceof Funcionario) {
            numeroFuncionarios++;
        }
    }

    // Método para remover um usuário da lista com base no CPF
    public boolean removerUsuario(int cpf) {
        System.out.println("Usuário a ser removido: \n");
        System.out.printf("| %-15s | %-20s | %-30s | %-11s |\n", "Tipo de Usuário", "Nome", "E-mail", "CPF");
        for (Usuario usuario : usuarios) {
            if (cpf == usuario.getCPF()) {
                String tipoUsuario = "";
                if (usuario instanceof Garcom) {
                    tipoUsuario = "Garçom";
                } else if (usuario instanceof Cozinheiro) {
                    tipoUsuario = "Cozinheiro";
                } else if (usuario instanceof Gerente) {
                    tipoUsuario = "Gerente";
                }
                System.out.printf("| %-15s | %-20s | %-30s | %-11d |\n\n", tipoUsuario, usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getCPF());
            }
        }

        boolean removed = usuarios.removeIf(pojo -> pojo.getCPF() == cpf);
        return removed;
    }

    // Método para realizar login de um usuário
    public boolean login(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(login) && usuario.getSenha().equals(senha)) {
                usuarioAtual = usuario;
                return true;
            }
        }
        return false;
    }

    // Método para obter o usuário atualmente logado
    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    // Método para verificar se há um usuário ativo
    public boolean hasActiveUser() {
        return this.usuarioAtual != null;
    }

    // Método para obter o número de funcionários
    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    // Método para exibir a lista de usuários em formato tabulado
    @Override
    public void exibirTabulado() {
        System.out.printf("| %-15s | %-20s | %-30s | %-11s |\n", "Tipo de Usuário", "Nome", "E-mail", "CPF");
        for (Usuario usuario : usuarios) {
            String tipoUsuario = "";
            if (usuario instanceof Garcom) {
                tipoUsuario = "Garçom";
            } else if (usuario instanceof Cozinheiro) {
                tipoUsuario = "Cozinheiro";
            } else if (usuario instanceof Gerente) {
                tipoUsuario = "Gerente";
            }
            System.out.printf("| %-15s | %-20s | %-30s | %-11d |\n", tipoUsuario, usuario.getNome(), usuario.getEmail(),
                    usuario.getCPF());
        }
    }
}
