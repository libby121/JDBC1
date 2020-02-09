package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import beans.Author;

@Component
public class AuthoDBDAO implements RowMapper<Author> {


	@Autowired
	private JdbcTemplate jbt;

	public void addAuthor(Author a) {
		jbt.update("insert into authors(id,name,email,age)values(?,?,?,?)",
				a.getId(),a.getName(),a.getEmail(),a.getAge());
		System.out.println("added!");
	}

	public void deleteAuthor(int id) {
		jbt.update("delete from authors where id="+id);
		System.out.println("deleted!");
	}

	public void updateAuthor(Author a) {
		jbt.update("update authors set name=?,email=?,age=? where id=?",
				a.getName(),a.getEmail(),a.getAge(),a.getId());
		System.out.println("updated!");
	}

	public Author getOne(int id) {
		return jbt.queryForObject("select * from authors where id="+id, this);
	}

	public List<Author>getAll(){
		return jbt.query("select* from authors", this);
	}

	public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Author(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
	}
}
