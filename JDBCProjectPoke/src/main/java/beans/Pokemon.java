package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Pokemon {

	
private int id;
//@Autowired
private Type type;
private String name;
private int ponts;
private int defense;

public Pokemon(int id,  String name, Type type, int ponts, int defense) {
	super();
	this.id = id;
	this.type = type;
	this.name = name;
	this.ponts = ponts;
	this.defense = defense;
}
public Type getType() {
	return type;
}
public void setType(Type type) {
	this.type = type;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPonts() {
	return ponts;
}
public void setPonts(int ponts) {
	this.ponts = ponts;
}
public int getDefense() {
	return defense;
}
public void setDefense(int defense) {
	this.defense = defense;
}
public int getId() {
	return id;
}
@Override
public String toString() {
	return "Pokemon [id=" + id + ", type=" + type + ", name=" + name + ", ponts=" + ponts + ", defense=" + defense
			+ "]";
}



}
