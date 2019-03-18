package com.foo.db2.db2batis.service;

import com.foo.db2.db2batis.model.AddressLog;
import com.foo.db2.db2batis.model.AddressLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AddressLogRepository implements AddressLogMapper{

    private AddressLogMapper mapper;


    public AddressLogRepository(AddressLogMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    @Transactional(readOnly = true)
    public List<AddressLog> findByName(String name) {
        return mapper.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressLog> findAll() {
        return mapper.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressLog> findLastUpdateByName(String name) {
        return mapper.findLastUpdateByName(name);
    }

}
