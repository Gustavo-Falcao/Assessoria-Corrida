package assessoria.model.dao;

import assessoria.model.entidades.Administrador;
import java.util.Map;

public class AdministradorDAO extends GenericDAO<Administrador>{

    public AdministradorDAO() {
        super(Administrador.class, "src/main/java/assessoria/model/dados/users/administrador/administrador.json");
    }

    @Override
    public void inserirDadosNoArquivo(Map<String, Administrador> administradorMap) {
        super.inserirDadosNoArquivo(administradorMap);
    }

    @Override
    public Map<String,Administrador> lerDadosDoArquivo() {
        return super.lerDadosDoArquivo();
    }

}