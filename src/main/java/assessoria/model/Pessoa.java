package assessoria.model;

import assessoria.util.Hash;

import java.util.logging.Handler;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private int idade;
    private String telefone;
    private String senhaHash;
    private Hash hashProvider;

    public Pessoa(){}

    public Pessoa(int id, String nome, String email, String cpf, int idade, String telefone, String senhaHash, Hash hashProvider) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.senhaHash = senhaHash;
        this.hashProvider = hashProvider;
    }

    public Pessoa(int id, String nome, String cpf, int idade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public Pessoa(int id, String nome, String email, String cpf, int idade, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public boolean verificarSenha(String senhaPlana) {
        return hashProvider.verificarHash(senhaPlana, this.senhaHash);
    }

    public void mostrarInfo() {
        System.out.println("Id: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Cpf: " + getCpf());
        System.out.println("Iade: " + getIdade());
        System.out.println("Telefone: " + getTelefone());
    }

}