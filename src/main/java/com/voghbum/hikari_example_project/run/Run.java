package com.voghbum.hikari_example_project.run;

import com.voghbum.hikari_example_project.configuration.DataSource;
import com.voghbum.hikari_example_project.data.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class Run implements CommandLineRunner {
    public static List<Employee> fetchData() throws SQLException {
        String SQL_QUERY = "select * from EMP";
        List<Employee> employees;
        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement( SQL_QUERY );
             ResultSet rs = pst.executeQuery();) {
            employees = new ArrayList<>();
            Employee employee;
            while ( rs.next() ) {
                employee = new Employee();
                employee.setEmpNo( rs.getInt( "empno" ) );
                employee.setEname( rs.getString( "ename" ) );
                employee.setJob( rs.getString( "job" ) );
                employee.setMgr( (long) rs.getInt( "mgr" ) );
                employee.setHiredate( rs.getDate( "hiredate" ) );
                employee.setSal( (long) rs.getInt( "sal" ) );
                employee.setComm( (long) rs.getInt( "comm" ) );
                employee.setDeptno( rs.getInt( "deptno" ) );
                employees.add( employee );
            }
        }
        return employees;
    }

/*    @Override
    public void run(String... args) throws Exception {

    }*/

    @Override
    public void run(String... args) throws Exception {
        fetchData();
    }
}
