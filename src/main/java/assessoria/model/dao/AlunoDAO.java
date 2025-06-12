package assessoria.model.dao;

import assessoria.model.entidades.Aluno;

import java.util.Map;

public class AlunoDAO extends GenericDAO<Aluno> {

    public AlunoDAO() {
        super(Aluno.class, "src/main/java/assessoria/model/dados/users/alunos/alunos.json");
    }

    @Override
    public void inserirDadosNoArquivo(Map<String, Aluno> alunoMap) {
        super.inserirDadosNoArquivo(alunoMap);
    }
    @Override
    public Map<String,Aluno> lerDadosDoArquivo() {
       return super.lerDadosDoArquivo();
    }

}

