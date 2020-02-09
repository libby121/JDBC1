package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import beans.Book;

@Component
public class BookDBDAO implements RowMapper<Book>{

	@Autowired
	private JdbcTemplate jbt;
	
	
	public void addBook(Book b) {
		jbt.update("insert into books (id,title,pages,authorID) values(?,?,?,?)",
				b.getId(),b.getTitle(),b.getPages(),b.getAuthorID());
		System.out.println("added!");
	}
	
	
	public void deleteBook(int id) {
		jbt.update("delete from books where id="+id);
				System.out.println("deleted!");
	}

	public void updateBook(Book b) {
		jbt.update("update books set title=?,pages=?,authorId=? where id=?",
		b.getTitle(),b.getPages(),b.getAuthorID(),b.getId());
		System.out.println("updated!");
	}

	public Book getOne(int id) {
		return jbt.queryForObject("select * from books where id="+id, this);
	}

	
	public List<Book>getAll(){
		return jbt.query("select * from books",this);
	}


	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Book(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
	}
}
