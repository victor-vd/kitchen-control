
package Models;

public interface IUsuario {
    String getEmail();
    void setEmail(String email);
    String getSenha();
    void setSenha(String senha);
    String getNome();
    void setNome(String nome);
    int getCPF();
    void setCPF(int cpf);
}