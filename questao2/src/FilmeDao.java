import java.sql.*;
import java.util.Scanner;

public class FilmeDao {

    private Connection con = new ConnectionFactory().getConnection();

    public FilmeDao() throws SQLException {
    }

    public void salvarFilme() throws SQLException {

        Statement stm = con.createStatement();
        stm.execute("DROP TABLE IF EXISTS FILMES_LISTA");
        stm.execute("CREATE TABLE FILMES_LISTA (id int auto_increment, nome varchar(100) NOT NULL, descricao varchar(255), ano YEAR, primary key (id)) Engine = InnoDB;");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('BRANCA DE NEVE E OS SETE ANOES', 'INFANTIL', '1937')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('PSICOSE', 'TERROR', '1960')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('ALIEN, O 8º PASSAGEIRO', 'TERROR', '1979')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('INVOCAÇÃO DO MAL', 'TERROR', '2013')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('O EXORCISTA', 'TERROR', '1974')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('OS OUTROS', 'TERROR', '2001')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('O ILUMINADO', 'TERROR', '1980')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('INVOCACÃO DO MAL 2', 'TERROR', '2016')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('O LABIRINTO DO FAUNO', 'TERROR', '2006')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('ENTREVISTA COM O VAMPIRO', 'INFANTIL', '1994')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('CONSTANTINE', 'TERROR', '2005')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('UM LUGAR SILENCIOSO', 'TERROR', '2018')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('IT A COISA', 'TERROR', '2017')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('INVASÃO ZUMBI', 'TERROR', '2016')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('JOGOS MORTAIS', 'TERROR', '2005')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('PÂNICO', 'TERROR', '1997')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('FRAGMENTADO', 'TERROR', '2017')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('OS PASSÁROS', 'TERROR', '2014')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('O HOMEM NAS TREVAS', 'TERROR', '2016')");
        stm.execute("INSERT INTO FILMES_LISTA(NOME, DESCRICAO, ANO) VALUES ('A HORA DO PESADELO', 'TERROR', '1986')");
        stm.close();
    }

    public void listarFilme() throws SQLException {

        PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO, ANO FROM FILMES_LISTA");
        stm.execute();
        //Listando os filmes do banco de dados
        ResultSet rst = stm.getResultSet();
        while (rst.next()) {

            Integer id = rst.getInt("ID");
            String nome = rst.getString("NOME");
            String descricao = rst.getString("DESCRICAO");
            Integer ano = rst.getInt("ANO");
            System.out.println("\nID DO FILME: " + id);
            System.out.println("NOME DO FILME: " + nome);
            System.out.println("DESCRIÇÃO DO FILME: " + descricao);
            System.out.println("ANO: " + ano + "\n");
        }
        rst.close();
        stm.close();
    }

    public void paginacao() throws SQLException {

        Scanner sc = new Scanner(System.in);
        Integer quantidadeDeFilmesPorPagina = 0;
        Integer paginaRequerida = null;
        double paginasDisponivel = 0;
        Integer filmesDisponiveis = 20;
        Integer inicioCont = 0;
        Integer fimCont = 0;

        System.out.println("\nDigite a quantidade de filmes que deseja ver por página!");
        quantidadeDeFilmesPorPagina = sc.nextInt();
        System.out.println("\nDigite a página para acessar e ver os filmes pertencentes a ela!");
        paginaRequerida = sc.nextInt();
        paginasDisponivel = Math.ceil(filmesDisponiveis / (float)quantidadeDeFilmesPorPagina);

        if (quantidadeDeFilmesPorPagina <= 20 && quantidadeDeFilmesPorPagina > 0 && paginaRequerida <= paginasDisponivel) {
            for (int i = 0; i <= paginasDisponivel; i++) {
                if (i == paginaRequerida) {
                    inicioCont = quantidadeDeFilmesPorPagina * i - quantidadeDeFilmesPorPagina;
                    fimCont = quantidadeDeFilmesPorPagina;
                    break;
                }
            }
            PreparedStatement stm = con.prepareStatement("SELECT * FROM FILMES_LISTA LIMIT ?, ?");
            stm.setInt(1, inicioCont);
            stm.setInt(2, fimCont);
            stm.execute();

            ResultSet rst = stm.getResultSet();
            while (rst.next()) {

                Integer id = rst.getInt("ID");
                String nome = rst.getString("NOME");
                String descricao = rst.getString("DESCRICAO");
                Integer ano = rst.getInt("ANO");
                System.out.println("\nID DO FILME: " + id);
                System.out.println("NOME DO FILME: " + nome);
                System.out.println("DESCRIÇÃO DO FILME: " + descricao);
                System.out.println("ANO: " + ano + "\n");
            }
        }
        else{
                System.out.println("Lembrando, o máximo de filmes disponiveis por página são 20 e o número de páginas " +
                        "disponveis são " + paginasDisponivel);
            }

        }
    }

