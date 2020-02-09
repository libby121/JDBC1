package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import beans.Drone;

@Component
public class DroneDBDAO implements RowMapper<Drone> {

	@Autowired
	private JdbcTemplate jbt;
	
	
	public List<Drone>getByPrice(double min,double max){
		return jbt.query("select * from drones where price between " +min + " and " +max, this);//if i need a string i have to wrap it with ''
	}
	
	public void addDrone(Drone dro) {
		jbt.update("insert into drones(id,manufacturer, model,camerPixel,flight_range,price) values(?,?,?,?,?,?)",
				dro.getId(),dro.getManufacturer(),dro.getModel(),dro.getCameraPixel(),dro.getFlightRange(),dro.getPrice());
	System.out.println("added!");
	
	
	}
	
	public void deleteDrone(int id) {
		jbt.update("delete from drones where id="+id);
		System.out.println("deleted!");
	}
	
	public void updateDrone(Drone drone) {
		jbt.update("update drones set manufacturer=?, model=?, camerPixel=?, flight_range=?, price=? where id=?", drone.getManufacturer(),drone.getModel(),drone.getCameraPixel(),drone.getFlightRange(),drone.getPrice(), drone.getId());
	System.out.println("updated!");
	}
	
	
	public Drone getOne(int id) {
		 return jbt.queryForObject("select * from drones where id ="+id, this);
	
	
	}
	public List<Drone> getALL() {
		return jbt.query("select * from drones", this);
		
		
	}

	public Drone mapRow(ResultSet rs, int rowNum) throws SQLException {
		 return new Drone(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getDouble(6));
	}
}
