package assessoria.app;

import assessoria.controller.ProfessorController;

import assessoria.model.dao.ProfessorDAO;
import assessoria.model.entidades.Aluno;
import assessoria.model.entidades.Professor;
import assessoria.model.entidades.Treino;
import assessoria.service.ProfessorService;

import assessoria.model.entidades.Professor;
import assessoria.util.helpers.BCryptHash;

import assessoria.util.helpers.InputHelper;
import assessoria.util.log.Log;
import assessoria.view.ProfessorView;
import assessoria.view.MensagemView;

import java.time.DayOfWeek;

public class ProfessorApp {

    private final ProfessorView professorView;
    private final ProfessorController professorController;

    public ProfessorApp(ProfessorView professorView, ProfessorController professorController) {
        this.professorView = professorView;
        this.professorController = professorController;
    }

    public void carregarMap() {
        professorView.getProfessorController().carregarMap();
    }

    public void executarCadastro() {
        professorView.mostrarMenuCadastrarProfessor();
        professorView.pegarDadosProfessor();
    }

    public void executarLogin() {
        professorView.mostrarMenuLoginProfessor();
        executarAcao(professorView.pegarEtratarDadosLogin());
    }

    public void executarUpdate(Professor professor) {
        int opcao;
        do {
            professorView.mostrarMenuUpdate();
            opcao = InputHelper.lerOpcao();
            tratarOpcaoMenuUpdate(opcao, professor);
        }while(opcao != 0);
    }

    private void tratarOpcaoMenuUpdate(int opcao, Professor professor) {
        switch (opcao) {
            case 1:
                String nome = InputHelper.pegarNome();
                professor.setNome(nome);
                break;
            case 2:
                String email = InputHelper.pegarEmail();
                professor.setEmail(email);
                break;
            case 3:
                String senha = InputHelper.pegarSenhaToCadastro();
                professor.setSenhaHash(senha);
                BCryptHash bCryptHash = new BCryptHash();
                String hash = bCryptHash.gerarHash(senha);
                professor.setHashProvider(hash);
                break;
            case 4:
                String telefone = InputHelper.pegarTelefone();
                professor.setTelefone(telefone);
                break;
            case 5:
                String cpf = InputHelper.pegarCpf();
                professor.setCpf(cpf);
                break;
            case 0:
                MensagemView.mostrarMensagem("Encerrando update...");
                break;
            default:
                MensagemView.mostrarErro("Escolha uma opção válida!!");
                break;
        }
        professorController.salvarProfessor(professor);
        professorView.atualizarProfessorNoMapTreino(professor);
    }

    private void executarAcao(Professor professor) {
        Log.registrar("info", professor.getNome() + " fez login");
        int opcao;
        do {
            professorView.mostrarMenuAcoes();
            opcao = InputHelper.lerOpcao();
            tratarOpcaoMenuAcoes(opcao, professor);
        }while(opcao != 0);

    }

    private void tratarOpcaoMenuAcoes(int opcao, Professor professor) {
        switch (opcao) {
            case 1 -> professorView.mostrarDadosProfessor(professor);
            case 3 -> professorView.mostrarAlunos(professor);
            case 4 -> executarCriacaoTreino(professor);
            case 5 -> executarUpdate(professor);
            case 6 -> executarModificacaoTreino(professor);
            // adicionar mais acoes aqui
            case 0 -> MensagemView.mostrarMensagem("Encerrando login...");
            default -> MensagemView.mostrarErro("Escolha uma opção válida!!");
        }
    }

    private void executarModificacaoTreino(Professor professor) {
        int opExecutarModTreino;
        do {
            professorView.mostrarMenuModificarTreino();
            opExecutarModTreino = InputHelper.lerOpcao();
            tratarOpModificarTreino(opExecutarModTreino, professor);
        }while(opExecutarModTreino != 0);
    }

    private void tratarOpModificarTreino(int op, Professor professor) {
        switch (op) {
            case 1 -> modificarTreino(professor);
            case 0 -> MensagemView.mostrarMensagem("Voltando...");
            default -> MensagemView.mostrarErro("Escolha uma opção válida!!");
        }
    }

    private void modificarTreino(Professor professor) {
        Treino treino = professorView.escolherAlunoPorCpfComTreino();
        int opModificarTreino;
        do {
            professorView.mostrarMenuOpDiaTreino();
            opModificarTreino = InputHelper.lerOpcao();
            tratarOpDiaTreino(opModificarTreino, treino);
        }while (opModificarTreino != 0);
        professorView.salvarTreino(treino);
    }

    private void executarCriacaoTreino(Professor professor) {
        int opExecutarCriacaoTreino;
        do {
            professorView.mostrarMenuCriarTreino();
            opExecutarCriacaoTreino = InputHelper.lerOpcao();
            tratarOpCriacaoTreino(opExecutarCriacaoTreino, professor);
        }while(opExecutarCriacaoTreino != 0);
    }

    private void tratarOpCriacaoTreino(int opCriacaoTreino, Professor professor) {
        switch (opCriacaoTreino) {
            case 1 -> criarTreino(professor);
            case 0 -> MensagemView.mostrarMensagem("Voltando...");
            default -> MensagemView.mostrarErro("Escolha uma opção válida!!");
        }
    }


    private void criarTreino(Professor professor) {
        Aluno aluno = professorView.escolherAlunoPorCpf();
        Treino treino = professorView.pegarTreinoPorID(professorView.criarTreino(aluno, professor));
        int opCriarTreino;
        do {
            professorView.mostrarMenuOpDiaTreino();
            opCriarTreino = InputHelper.lerOpcao();
            tratarOpDiaTreino(opCriarTreino, treino);
        }while(opCriarTreino != 0);
        professorView.salvarTreino(treino);
        professorView.salvarTreinoMap();
    }

    private void tratarOpDiaTreino(int opDia, Treino treino) {
        DayOfWeek day = null;
        boolean saindo = false;
        switch (opDia) {
            case 1:
                day = DayOfWeek.MONDAY;
            break;
            case 2:
                day = DayOfWeek.TUESDAY;
            break;
            case 3:
                day = DayOfWeek.WEDNESDAY;
            break;
            case 4:
                day = DayOfWeek.THURSDAY;
            break;
            case 5:
                day = DayOfWeek.FRIDAY;
            break;
            case 6:
                day = DayOfWeek.SATURDAY;
            break;
            case 7:
                day = DayOfWeek.SUNDAY;
            break;
            case 0:
                MensagemView.mostrarMensagem("Voltando...");
                saindo = true;
            break;
            default:
                MensagemView.mostrarErro("Escolha uma opção válida!!");
            break;
        }
        if(!saindo) adicionarAtividades(day, treino);
    }

    private void adicionarAtividades(DayOfWeek day, Treino treino) {
        int opAdicionarAtv;
        do {
            treino.mostrarTreino();
            professorView.mostrarMenuAdicionarAtividades();
            opAdicionarAtv = InputHelper.lerOpcao();
            tratarOpAddAtv(opAdicionarAtv, day, treino);
        }while(opAdicionarAtv != 0);
    }

    private void tratarOpAddAtv(int opAdd, DayOfWeek day, Treino treino) {
        switch (opAdd) {
            case 1 -> professorView.adicionarLinha(day, treino);
            case 2 -> professorView.removerLinha(day, treino);
            case 0 -> MensagemView.mostrarMensagem("Voltando...");
            default -> MensagemView.mostrarErro("Escolha uma opção válida!!!");
        }
    }

    public void mostrarProfessor() {
        professorView.mostrarProfessorCadastrados();
    }
}
