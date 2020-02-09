package db;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Pokemon;
import beans.Type;
import configs.SpringConfig;

public class Program {
	
	public static void main(String[] args) {
		
		
		try(AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(SpringConfig.class)){
			
			PokeDBDAO pokeDB= ctx.getBean(PokeDBDAO.class);
			Pokemon po=ctx.getBean(Pokemon.class,1245,"pooo",Type.Air, 13,123);
			pokeDB.addPoke(po);
	//pokeDB.addPoke(ctx.getBean(Pokemon.class,1242,"pokikkoo",Type.Air,12,34));
//			pokeDB.addPoke(ctx.getBean(Pokemon.class,1239,"pikType","pokikkoo",12,34));
//			pokeDB.addPoke(ctx.getBean(Pokemon.class,1240,"pikType","pokikkoo",12,34));
	//System.out.println(pokeDB.getOne(1236));
	//pokeDB.getAll();
//	for (Pokemon po : pokeDB.getAll()) {
//		System.out.println(po);
//	}
//			pokeDB.deletePoke(1236);
			
		//	pokeDB.deletePoke(1238);
	//System.out.println(pokeDB.getOne(1239));
	//System.out.println(pokeDB.getAll());
		//pokeDB.UpdatePoke(ctx.getBean(Pokemon.class, 1240,"pikType","new name",12,25));
	
		}
		
	
	
	}

}
