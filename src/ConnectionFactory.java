
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	// classe para sempre conectar ao banco, não precisando por no principal
			private static final String user = "root";//Usuário do BD
			private static final String password = "sonia12021996";//Senha BD
			private static final String url = "jdbc:mysql://localhost/despesa";//Compartilhamento do drive do banco com o portão de ligação
			
			private static Connection connection = null;

			public static Connection  getConnection() {
				try {
					if (connection == null || connection.isClosed()) {
						Class.forName("com.mysql.jdbc.Driver");
						connection = DriverManager.getConnection(url, user, password);//conexão BD e Programa
					}
				} catch (Exception e) {
					throw new IllegalArgumentException("Erro ao pegar Conexão com o Banco de Dados!");
				}
				
			
				return connection;
}}
