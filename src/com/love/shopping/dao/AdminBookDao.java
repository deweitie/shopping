package com.love.shopping.dao;

import java.util.List;

import com.love.shopping.po.Book;
import com.love.shopping.po.BookPager;

public interface AdminBookDao {

	public List getAllBooks();
	public boolean addBook(Book book);
	public boolean checkBookNameIsExist(String bookName);
	public boolean checkISBNIsExist(String ISBN);
	public BookPager searchBook(String bookName);
	public List getAllBookName();
	public BookPager getBookPager(int index,int pageSize);
	public boolean deleteBook(int[] bookIds);
}
