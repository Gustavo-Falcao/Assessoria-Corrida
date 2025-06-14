package assessoria;
import assessoria.app.Aplicacao;
import assessoria.util.log.Log;
import org.apache.commons.logging.LogFactory;

public class Main {

    public static void main(String[] args) {
        Aplicacao app = new Aplicacao();
        Log.registrar("info", "Sistema iniciado.");
        app.inicializarDados();
        app.mostrarDados();
        app.executarPrograma();
        app.salvarDados();
        Log.registrar("Info", "Sistema encerrado.");
    }
}