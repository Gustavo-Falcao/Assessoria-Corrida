package assessoria.model.dao;

import assessoria.model.entidades.Professor;
import assessoria.model.entidades.Professor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ProfessorDAO extends GenericDAO<Professor>{

    public ProfessorDAO() {
        super(Professor.class, "src/main/java/assessoria/model/dados/users/professores/professores.json");
    }

    @Override
    public void inserirDadosNoArquivo(Map<String, Professor> professorMap) {
        super.inserirDadosNoArquivo(professorMap);
    }
    @Override
    public Map<String,Professor> lerDadosDoArquivo() {
        return super.lerDadosDoArquivo();
    }

}
