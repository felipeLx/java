package org.codewar;

import java.sql.Connection;

/*
No construtor, neste exemplo, o DBConnectionPool cria as conexões do pool normalmente.
Já no getInstance( ), ele verifica se já existe uma instância da classe, caso não, ele instancia e retorna o objeto.
 Em contrapartida, as classes que implementam o padrão Singleton tornam-se difíceis de serem estendidas,
  mas o seu uso, no geral, é muito benéfico quando necessário em seu programa.
 */
public class DBConnectionPool {

    private static DBConnectionPool instance;

    private DBConnectionPool(){
        //criar conexão com base de dados
    }

    public synchronized static DBConnectionPool getInstance() {
        if( instance == null ){
            instance = new DBConnectionPool();
        }
        return instance;
    }

    public Connection getConnection(){
        Connection conn = null;  //pega uma conexão livre ou uma nova conexão
        return conn;
    }

    public void releaseConnection( Connection conn ){
        //libera a conexão de volta pro pool
    }
}
