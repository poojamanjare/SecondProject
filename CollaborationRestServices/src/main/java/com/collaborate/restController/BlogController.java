package com.collaborate.restController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collaborate.DAO.BlogDAO;
import com.collaborate.model.Blog;

@RestController
public class BlogController 
{
	@Autowired
	BlogDAO blogDAO;
	
	//=========method for getting all blogs=================================
	@GetMapping(value="/getAllBlogs")
	public ResponseEntity<List<Blog>>getAllBlogs()		//<List<Blog>>=list of blogs will be send
	{
		ArrayList<Blog>listBlogs=new ArrayList<Blog>();
		listBlogs=(ArrayList<Blog>)blogDAO.getBlog();		//to call getBlog() method
		return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
	}
	
	//==============method for creating blocks===========================================
	@PostMapping(value="/createBlogs")
	public ResponseEntity<String>createBlogs(@RequestBody Blog blog)
	{
		blog.setStatus("NA");
		blog.setLikes(0);
		blog.setCreateDate(new Date());
		
		if(blogDAO.createBlog(blog))
		{
			return new ResponseEntity<String>("Blog created successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in creating Blog", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	//====================method for 
	
	
	
	
	//=============This method is to check that whether controller runs properly or not(to test controller)
	@GetMapping(value="/test")
	public ResponseEntity<String>testMethod()
	{
		System.out.println("test method");
		return new ResponseEntity<String>("Test RestController", HttpStatus.OK);
	}

}
