package org.flights.util;


import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

@Component
public class DataLoaderUtil {

    private static final String SQL_FILE_PATH = "data.sql";
    private static final String STATEMENT_DELIMITER = ";";

    private final JdbcTemplate jdbcTemplate;

    public DataLoaderUtil(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void loadData() {
        try {
            ClassPathResource resource = new ClassPathResource(SQL_FILE_PATH);
            InputStream inputStream = resource.getInputStream();
            String sqlScript = readScriptFromInputStream(inputStream);
            executeSqlScript(sqlScript);
        } catch (IOException e) {
            // Handle the exception
        }
    }

    private String readScriptFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private void executeSqlScript(String sqlScript) {
        Connection connection = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            Arrays.stream(sqlScript.split(STATEMENT_DELIMITER))
                    .map(String::trim)
                    .filter(statement -> !statement.isEmpty())
                    .forEach(statement -> jdbcTemplate.execute(statement));
        } catch (SQLException e) {
            // Handle the exception
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Handle the exception
                }
            }
        }
    }
}
