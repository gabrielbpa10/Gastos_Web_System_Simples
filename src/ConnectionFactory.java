
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	// classe para sempre conectar ao banco, n�o precisando por no principal
			private static final String user = "root";//Usu�rio do BD
			private static final String password = "sonia12021996";//Senha BD
			private static final String url = "jdbc:mysql://localhost/despesa";//Compartilhamento do drive do banco com o port�o de liga��o
			
			private static Connection connection = null;

			public static Connection  getConnection() {
				try {
					if (connection == null || connection.isClosed()) {
						Class.forName("com.mysql.jdbc.Driver");
						connection = DriverManager.getConnection(url, user, password);//conex�o BD e Programa
					}
				} catch (Exception e) {
					throw new IllegalArgumentException("Erro ao pegar Conex�o com o Banco de Dados!");
				}
				
			
				return connection;
}}
