package com.example.service;

import com.example.Category;
import com.example.demo.SRO.CategorySRO;
import com.example.repo.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class CategoryService {

        @Autowired
        private CategoryRepository categoryRepository;

        public Flux<CategorySRO> getCategoriesByPage(int pageNo){
            return  Flux.empty();
//            int currpage = 1, size =10;
//            Slice<Category> slice = categoryRepository.findAll(CassandraPageRequest.first(size));
//            while(slice.hasNext() && currpage < pageNo){
//                slice = categoryRepository.findAll(slice.nextPageable());
//                currpage++;
//            }
//            return (Flux<CategorySRO>) slice.getContent().stream().map(this::convertEntityToSRO).collect(Collectors.toList());
        }
        // return  categories by a given categoryId
        public Flux<CategorySRO> getCategoriesById(long id){
            return (Flux<CategorySRO>) categoryRepository.findByKeyId(id).toStream()
                    .map(this::convertEntityToSRO).collect(Collectors.toList());
        }
        // return by a given categoryId and subcategoryId
        public Mono<CategorySRO> getCategoriesByIdAndSubId(long id, long subid){
            return categoryRepository.findByKeyIdAndKeySubCategoryId(id,subid).map(this::convertEntityToSRO);

            //orElseThrow(()->
            // new ResourceNotFoundException("Category", "subid", subid));
        }
        // update by a given id and subid
        public CategorySRO updateCategory(long id , long subid, CategorySRO categorySRO) {

            Mono<Category> categoryData= categoryRepository.findByKeyIdAndKeySubCategoryId(id, subid);

            Category category1 = categoryData.block();
            category1.setName(categorySRO.getName());
            category1.setSignSize(categorySRO.getSignSize());
            category1.setParmCheck(categorySRO.getParmCheck());
            category1.setUpdatedDate(LocalDateTime.now());
            Category updatedCategory = categoryRepository.save(category1);
            return convertEntityToSRO(updatedCategory);
        }
        private CategorySRO convertEntityToSRO(Category category){
            CategorySRO categorySRO = new CategorySRO();
            categorySRO.setId(category.getKey().getId());
            categorySRO.setSubCategoryId(category.getKey().getSubCategoryId());
            categorySRO.setName(category.getName());
            categorySRO.setSignSize(category.getSignSize());
            categorySRO.setParmCheck(category.getParmCheck());
            categorySRO.setUpdateBy(category.getUpdateBy());
            categorySRO.setCreatDate(category.getCreatDate());
            categorySRO.setUpdatedDate(category.getUpdatedDate());
            return categorySRO;
        }
    }

