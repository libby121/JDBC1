package tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Author;
import beans.Book;
import configs.SpringConfig;
import db.AuthoDBDAO;
import db.BookDBDAO;

public class Program {
	public static void main(String[] args) {




		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)){

			AuthoDBDAO authorDBD= ctx.getBean(AuthoDBDAO.class);
			//authorDBD.addAuthor(ctx.getBean(Author.class,12345,"meir","meir@walla.com",56));
			//		authorDBD.addAuthor(ctx.getBean(Author.class,12677,"shelly","shelly@gmail.com",34));
			//		authorDBD.addAuthor(ctx.getBean(Author.class,12377,"maya","mayahoo@gmail.com",36));
			//		authorDBD.addAuthor(ctx.getBean(Author.class,1245,"lior","lior@gmail.com",76));
			//		authorDBD.addAuthor(ctx.getBean(Author.class,125,"orna","ornaa@gmail.com",36));

			//authorDBD.deleteAuthor(12345);

			//authorDBD.updateAuthor(ctx.getBean(Author.class,1245,"meir","meir@walla.com",56));

			//		System.out.println(authorDBD.getOne(12677));
			//	
			//		
			//		for (Author a : authorDBD.getAll()) {
			//			System.out.println(a);

			BookDBDAO bookDBD= ctx.getBean(BookDBDAO.class);
			//			//bookDBD.addBook(ctx.getBean(Book.class,12333,"romance",234,125));
			//			bookDBD.addBook(ctx.getBean(Book.class,12335,"romance",236,125));
			//			bookDBD.addBook(ctx.getBean(Book.class,12334,"romance",78,12377));
			//			bookDBD.addBook(ctx.getBean(Book.class,12,"romance",34,12677));

			bookDBD.deleteBook(12333);

			bookDBD.updateBook(ctx.getBean(Book.class, 12335,"adventures",569,125));

			System.out.println(bookDBD.getOne(12335));
			
			for (Book b : bookDBD.getAll()) {
				System.out.println(b);
			}
		}
	}}
