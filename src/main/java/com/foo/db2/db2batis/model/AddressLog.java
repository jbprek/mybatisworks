package com.foo.db2.db2batis.model;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class AddressLog {
    private String name;
    private String line1;
    private String line2;
    private String zip;
    private String country;
    private LocalDateTime time;
}
