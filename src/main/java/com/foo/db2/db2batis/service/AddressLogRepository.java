package com.foo.db2.db2batis.service;

import com.foo.db2.db2batis.model.AddressLog;
import com.foo.db2.db2batis.model.AddressLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class AddressLogRepository /*implements AddressLogMapper*/{

    private AddressLogMapper mapper;


    public AddressLogRepository(AddressLogMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<AddressLog> findByName(String name) {
        return mapper.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<AddressLog> findAll() {
        return mapper.findAll();
    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<AddressLog> findLastUpdateByName(String name) {
//        ResultSet set;
//        return mapper.findLastUpdateByName(name, set);
//    }

    public void findLastUpdateByName(String name, List<AddressLog> resultSet) {
        mapper.findLastUpdateByName(name, resultSet);
    }
}
