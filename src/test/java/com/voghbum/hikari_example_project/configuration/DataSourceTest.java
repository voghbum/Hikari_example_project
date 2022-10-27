package com.voghbum.hikari_example_project.configuration;

import com.voghbum.hikari_example_project.data.entity.Employee;
import com.voghbum.hikari_example_project.run.Run;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DataSourceTest {
    @Test
    public void givenConnection_thenFetchDbData() throws SQLException {
        List<Employee> employees = Run.fetchData();

        assertEquals( 3, employees.size() );
    }
}
