package com.cupk.controller;

import com.cupk.common.Result;
import com.cupk.mapper.BookMapper;
import com.cupk.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/books")
    Result selectAll(){
        List<Book> bookList=bookMapper.selectList(null);
        for(Book book:bookList){
            System.out.println(book);
        }
        return Result.success(bookList);
    }

    //根据id查询
    @GetMapping("/books/{id}")
    Result selectById(@PathVariable Integer id){
        Book book=bookMapper.selectById(id);
        if(book!=null){
            System.out.println("数据查询成功！");
            return Result.success(book);
        }else {
            System.out.println("数据查询失败！");
            return Result.error();
        }
    }
    //添加数据
    @PostMapping("/books")
    Result insertBook(@RequestBody Book book){
        int i =bookMapper.insert(book);
        if(i>0){
            System.out.println("数据添加成功！");
            return Result.success();
        }else{
            System.out.println("数据添加失败！");
            return Result.error();
        }
    }

    //修改数据
    @PutMapping("/books")
    Result updateBook(@RequestBody Book book){
        int i =bookMapper.updateById(book);
        if(i>0){
            System.out.println("数据修改成功！");
            return Result.success();
        }else{
            System.out.println("数据修改失败！");
            return Result.error();
        }
    }

    //根据id删除
    @DeleteMapping("/books/{id}")
    Result deleteById(@PathVariable Integer id){
        int  i =bookMapper.deleteById(id);
        if(i>0){
            System.out.println("数据删除成功！");
            return Result.success();
        }else {
            System.out.println("数据删除失败！");
            return Result.error();
        }
    }

}
