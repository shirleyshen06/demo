package com.example.repo;

import com.example.Category;
import com.example.CategoryPrimaryKey;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;


@Repository
public interface CategoryRepository extends CassandraRepository<Category, CategoryPrimaryKey> {

    Mono<Category> findByKeyIdAndKeySubCategoryId(long id, long subCategoryId);


    //Optional<Category> findCategoriesByKey_Id(long id);
    //Slice<Category> findAll(Pageable pageable);
    ;

//    @Override
//    Slice<Category> findAll(Pageable pageable);


    Flux<Category> findByKeyId(long id)
    ;
}
