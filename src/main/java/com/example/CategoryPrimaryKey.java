package com.example;


import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;

@PrimaryKeyClass
@Data
public class CategoryPrimaryKey implements Serializable {

    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private long id;

    @PrimaryKeyColumn(name = "sub_category_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private long subCategoryId;
}
