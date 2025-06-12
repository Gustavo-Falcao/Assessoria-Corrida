package assessoria.model.dao;

import assessoria.model.entidades.Savable;
import assessoria.util.log.Log;
import assessoria.view.MensagemView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class GenericDAO<T extends Savable> {

    private final Class<T> typeClass;
    private final String caminhoArquivo;

    public GenericDAO(Class<T> typeClass, String caminhoArquivo) {
        this.typeClass = typeClass;
        this.caminhoArquivo = caminhoArquivo;
    }

    public void inserirDadosNoArquivo(Map<String, T> typeMap) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try{
            objectMapper.writeValue(new File(caminhoArquivo), typeMap);

        } catch (IOException e) {
            MensagemView.mostrarErro("Erro ao tentar salvar dados!!");
            Log.registrar("Error", "Falha ao tentar salvar dados ");
            System.out.println(e.getMessage());
        }
    }

    public Map<String,T> lerDadosDoArquivo() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(caminhoArquivo);
        if(!file.exists() || file.length() == 0) {
            return new LinkedHashMap<>();
        }
        try {
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructMapType(LinkedHashMap.class, String.class, typeClass));
            //mensagemView.mostrarSucesso("Map de " + getNomeClass() + "carregado");


        } catch (Exception e) {
            MensagemView.mostrarErro("Erro ao carregar map de " + getNomeClass());
            throw new RuntimeException(e);
        }
    }

    public String getNomeClass() {
        return getTypeClass().getSimpleName();
    }

    public Class<T> getTypeClass() {
        return this.typeClass;
    }
}
