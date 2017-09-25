package dao.IFS;

import java.util.List;

import entity.Book;

public interface BookIFS {

	public List<Book> getAllBook();
	public Book getBookById(Integer bid);
}
