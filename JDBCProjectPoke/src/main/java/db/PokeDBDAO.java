package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import beans.Pokemon;
import beans.Type;

@Component
@Scope("prototype")
public class PokeDBDAO implements RowMapper<Pokemon> {

	@Autowired
	private JdbcTemplate jbt;
	
	public void addPoke(Pokemon po) {
		jbt.update("insert into pokemons(id,name,type, points, defense)values(?,?,?,?,?)", 
	po.getId(),po.getName(),po.getType().toString(),po.getPonts(),po.getDefense());
	System.out.println("added");
	} //conversion from enum to string=>.../.tostring
	
	public void deletePoke(int id) {
		jbt.update("delete from pokemons where id="+id);
		System.out.println("deleted");
	}
	
	public Pokemon getOne(int id) {
		 return jbt.queryForObject("select* from pokemons where id="+id, this);
	}

	public List<Pokemon> getAll(){
		return jbt.query("select * from pokemons", this);
	}
	
	public void UpdatePoke(Pokemon po) {
		jbt.update("update pokemons set name=? where id=?",po.getName(),po.getId());
		System.out.println("updated!");
		
	}
	//conversion from string to enum->type.valueof(*string..)
	public Pokemon mapRow(ResultSet rs, int rowNum) throws SQLException {//bring me the string in 3 column as "type"
		 return new Pokemon(rs.getInt(1),rs.getString(2),Type.valueOf(rs.getString(3)),rs.getInt(4),rs.getInt(5)); 
	}
	
}
