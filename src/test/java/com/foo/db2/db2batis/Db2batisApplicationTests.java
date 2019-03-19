package com.foo.db2.db2batis;

import com.foo.db2.db2batis.model.AddressLog;
import com.foo.db2.db2batis.service.AddressLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
//@Sql(scripts="/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class Db2batisApplicationTests {

    @Autowired
    private AddressLogRepository repository;

    @SpringBootApplication
    static class MockApplication {
        public static void main(String[] args) {
            SpringApplication.run(MockApplication.class, args);
        }
    }

    @Test
    public void testSimpleQuery() {
        List<AddressLog> res = repository.findAll();
        System.out.println(res.toString());
//        res.forEach(w->log.debug(w.toString()));


    }


    @Test
    public void testStoredProcedure() {
        List<AddressLog> res1 = new ArrayList<>();
        repository.findLastUpdateByName("sophie", res1);
        System.out.println(res1.toString());

    }

}
