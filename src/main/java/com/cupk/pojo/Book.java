package com.cupk.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@TableName("t_book")
public class Book {
    @TableId(value = "id",type = IdType.AUTO)
    Integer id;
    String name;
    Double price;
    String category;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    Date time;
    String isbn;
    String author;
    String press;
}
