package com.hu.testspringboot;

import com.hu.testspringboot.bean.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class TestSpringbootApplication {
//
//	@Value(value = "${book.author}")
//	private String bookAuthor;
//
//	@Value(value = "${book.name}")
//	private String bookName;
//
//	@Value(value = "${book.pinyin}")
//	private String bookPinyin;
	@Autowired
	private BookBean bookBean;

	public static void main(String[] args) {
		SpringApplication.run(TestSpringbootApplication.class, args);
	}

	/*@RequestMapping(value = "/" ,produces = "text/plain;charset=UTF-8")
	String index(){
	return "Hello Spring Boot ! The bookName is "+bookName+",bookAuthor is "+bookAuthor+",bookPinyin is "+bookPinyin;
	//	return "Hello Spring Boot! The BookName is "+bookBean.getName()+";and Book Author is "+bookBean.getAuthor()+";and Book price is "+bookBean.getPrice();
	}*/
	@RequestMapping("/book")
	public String book(){
		return "Hello World";
	}
}

