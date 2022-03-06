import java.sql.SQLException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException {

        ProdutoDao produtoDao = new ProdutoDao();
        System.out.println("----------------------------");
        System.out.println("BEM VINDO AO BANCO DE DADOS!");
        System.out.println("----------------------------");

        int opcao = 0;

        //Chamada de funções da escolha do usuário
        while (opcao != 5) {
            opcao = menu();
            switch (opcao) {
                case 1:
                    produtoDao.salvarProduto();
                    produtoDao.listaProduto();
                    break;
                case 2:
                    produtoDao.alterarProduto();
                    break;
                case 3:
                    produtoDao.excluirProduto();
                    break;
                case 4:
                    produtoDao.listaProduto();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("\nDigite uma opcao válida, por favor!");

            }
        }
    }

    //Menu de entrada para o usuário
    static int menu(){
        Scanner sc = new Scanner(System.in);
        int leitura;
        System.out.println("Digite 1 para salvar os produtos e também para listar eles!");
        System.out.println("Digite 2 para alterar o primeiro produto cadastrado!");
        System.out.println("Digite 3 para excluir o segundo produto cadastrado!");
        System.out.println("Digite 4 para listar todos os produtos!");
        System.out.println("Digite 5 para sair!");
        leitura = sc.nextInt();
        return leitura;

    }
}

