import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDao {

    private Connection con = new ConnectionFactory().getConnection();

    public ProdutoDao() throws SQLException {
    }

    public void salvarProduto() throws SQLException {

        Statement stm = con.createStatement();
        stm.execute("DROP TABLE IF EXISTS PRODUTO");
        stm.execute("CREATE TABLE PRODUTO (id int auto_increment, nome varchar(50), descricao varchar(250), quantidade int, preco float, primary key (id)) Engine = InnoDB");
        stm.execute("INSERT INTO PRODUTO(NOME, DESCRICAO, QUANTIDADE, PRECO) VALUES ('ABACATE', 'ABACATE MADURO', 1, 5.99)");
        stm.execute("INSERT INTO PRODUTO(NOME, DESCRICAO, QUANTIDADE, PRECO) VALUES ('LIMAO', 'LIMAO ARDIDO', 3, 1.99)");
        stm.execute("INSERT INTO PRODUTO(NOME, DESCRICAO, QUANTIDADE, PRECO) VALUES ('LARANJA', 'LARANJA LIMA', 5, 2.99)");
        stm.close();
    }

    public void listaProduto() throws SQLException{

        PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO, QUANTIDADE, PRECO FROM PRODUTO");
        stm.execute();

        ResultSet rst = stm.getResultSet();
        while(rst.next()) {

            Integer id = rst.getInt("ID");
            String nome = rst.getString("NOME");
            String descricao = rst.getString("DESCRICAO");
            Integer quantidade = rst.getInt("QUANTIDADE");
            Double preco = rst.getDouble("PRECO");
            System.out.println("\nID DO PRODUTO: " + id);
            System.out.println("NOME DO PRODUTO: " + nome);
            System.out.println("DESCRIÇÃO DO PRODUTO: " + descricao);
            System.out.println("QUANTIDADE: " + quantidade);
            System.out.println("PREÇO DO PRODUTO: " + preco + "\n");
        }
        rst.close();
        stm.close();

    }

    public void excluirProduto() throws SQLException {

        Statement stm = con.createStatement();
        stm.execute("DELETE FROM PRODUTO WHERE ID = 2");
        stm.close();
    }

    public void alterarProduto() throws SQLException {

        Statement stm = con.createStatement();
        stm.execute("UPDATE PRODUTO SET NOME = 'ABACATE PODRE', preco = '1.99', descricao = 'CUIDADO AO COMER' WHERE ID = 1");
        stm.close();
    }
}