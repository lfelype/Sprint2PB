import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        FilmeDao filmeDao = new FilmeDao();
        System.out.println("----------------------------");
        System.out.println("BEM VINDO AO BANCO DE DADOS DE FILMES!");
        System.out.println("----------------------------");

        int opcao = 0;

        //Chamada de funções da escolha do usuário
        while (opcao != 3) {
            opcao = menu();
            switch (opcao) {
                case 1:
                    filmeDao.salvarFilme();
                    filmeDao.listarFilme();
                    break;
                case 2:
                    filmeDao.paginacao();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("\nDigite uma opcao válida, por favor!");
            }
        }
    }

    //Menu de entrada para o usuário
    static int menu() {
        Scanner sc = new Scanner(System.in);
        int leitura;
        System.out.println("\nInicialmente, digite 1 para salvar os 20 filmes no banco de dados e, posteriormente, " +
                "irei lista-los para você!\n");
        System.out.println("Digite 2 para entrar na paginação!!\n");
        System.out.println("Digite 3 para sair!");
        leitura = sc.nextInt();
        return leitura;
    }
}


