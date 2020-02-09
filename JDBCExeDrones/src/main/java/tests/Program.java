package tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Drone;
import configs.SpringConfig;
import db.DroneDBDAO;

public class Program {

	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(SpringConfig.class)){
	
			DroneDBDAO DronDB=ctx.getBean(DroneDBDAO.class);
			//DronDB.addDrone(ctx.getBean(Drone.class,1244,"manu","nice",67,89.3,87.9));
//			DronDB.addDrone(ctx.getBean(Drone.class,1245,"manu","nice",67,89.3,87.9));
//			DronDB.addDrone(ctx.getBean(Drone.class,1246,"manu","nice",67,89.3,87.9));
//			DronDB.addDrone(ctx.getBean(Drone.class,1247,"manu","nice",67,89.3,87.9));
//			DronDB.addDrone(ctx.getBean(Drone.class,1248,"manu","nice",67,89.3,87.9));
			
			
			//DronDB.deleteDrone(1245);
//		
//		for (Drone drone : DronDB.getALL()) {
//			System.out.println(drone);
//		}
//		
//		System.out.println(DronDB.getOne(1234));
		
		//	DronDB.getByPrice(30,100);
			
			for (Drone d : DronDB.getByPrice(30, 100)) {
				System.out.println(d);
			}
			
		}
		
		
		
}}
