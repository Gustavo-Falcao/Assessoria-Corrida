package assessoria.dao;

import assessoria.model.Professor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ProfessorDAO {

    private final String arquivoProfessor = "src/main/java/assessoria/util/users/professor.json";

    public void inserirProfessorNoArquivo(Map<String, Professor> professorMap) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try{
            objectMapper.writeValue(new File(arquivoProfessor), professorMap);
            System.out.println("Arquivo escrito com sucesso");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo");
            System.out.println(e.getMessage());
        }
    }
}
