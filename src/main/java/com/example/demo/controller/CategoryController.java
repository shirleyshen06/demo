package com.example.demo.controller;

import com.example.demo.SRO.CategorySRO;
import com.example.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;



//    @Autowired(required=true)
//    private CategoryService categoryService;

    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping("/categories")
    public Flux<CategorySRO> categories(@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo
    ) {
        return categoryService.getCategoriesByPage(pageNo);
    }


    @GetMapping("/categories/{id}/{subid}")
    public ResponseEntity<Mono<CategorySRO>> getCategoryByIdAndSubId(@PathVariable("id") long id,
                                                                     @PathVariable("subid") long subid) {


        return ResponseEntity.ok(categoryService.getCategoriesByIdAndSubId(id, subid));
    }


    @GetMapping("/categories/{id}")
    public Flux<CategorySRO> getCategoryById(@PathVariable("id") long id) {

        return categoryService.getCategoriesById(id);

    }

    @PutMapping("/categories/{id}/{subid}")
    public ResponseEntity<CategorySRO> updateTutorial(@PathVariable("id") long id,
                                                      @PathVariable("subid") long subid, @RequestBody CategorySRO categorySRO) {

        CategorySRO categoryData = categoryService.updateCategory(id, subid, categorySRO);


        return new ResponseEntity<>(categoryData, HttpStatus.OK);
    }
}