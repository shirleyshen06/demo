package com.example;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;


@Table(value = "category")
@Data
public class Category implements Serializable {

    @PrimaryKey
    private CategoryPrimaryKey key;

    @Column("name")
    private String name;

    @Column("signsize")
    private String signSize;



    @Column("parmcheck")
    private int parmCheck;



    @Column("create_date")
    private LocalDateTime creatDate;


    @Column("updated_by")
    private String updateBy;


    @Column("last_updated")
    private LocalDateTime updatedDate;


}
