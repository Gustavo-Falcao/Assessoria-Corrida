package assessoria.model;

public class Aluno extends Pessoa{

    public Aluno() {super();}

    public Aluno(int id, String nome, String cpf, int idade) {
        super(id, nome, cpf, idade);
    }

    public Aluno(int id, String nome, String email, String cpf, int idade, String telefone) {
        super(id, nome, email, cpf, idade, telefone);
    }


}