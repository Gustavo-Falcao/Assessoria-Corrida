package assessoria.model.dao;

import assessoria.model.entidades.Treino;

import java.util.Map;

public class TreinoDAO extends GenericDAO<Treino> {

    public TreinoDAO() {
        super(Treino.class, "src/main/java/assessoria/model/dados/treino/treinos.json");
    }

    @Override
    public void inserirDadosNoArquivo(Map<String, Treino> typeMap) {
        super.inserirDadosNoArquivo(typeMap);
    }

    @Override
    public Map<String, Treino> lerDadosDoArquivo() {
        return super.lerDadosDoArquivo();
    }



}
