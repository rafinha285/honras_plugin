package org.quintilis.honras.types;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.UUID;

public class ClansCollection {
	private ObjectId _id;
	private String name;
	private List<String> members;
	private String prefix;
	private List<String> enemies;
	private List<String> allies;
	private UUID owner;
	private Integer points;
	
	public ClansCollection(
		ObjectId _id,
		String name,
		String prefix,
		List<String> members,
		List<String> enemies,
		List<String> allies,
		UUID owner,
		Integer points
	) {
		this._id = _id;
		this.name = name;
		this.members = members;
		this.points = points;
		this.enemies = enemies;
		this.allies = allies;
		this.owner = owner;
		this.prefix = prefix;
	}
	
	public ObjectId getId(){
		return _id;
	}
	public String getName(){
		return name;
	}
	public String getPrefix(){
		return prefix;
	}
	public List<String> getMembers(){
		return members;
	}
	public List<String> getEnemies(){
		return enemies;
	}
	public List<String> getAllies(){
		return allies;
	}
	public UUID getOwner(){
		return owner;
	}
	
	
	
	public void setId(ObjectId id){
		this._id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPrefix(String prefix){
		this.prefix = prefix;
	}
	public void setMembers(List<String> members){
		this.members = members;
	}
	public void setEnemies(List<String> enemies){
		this.enemies = enemies;
	}
	public void setAllies(List<String> allies){
		this.allies = allies;
	}
	public void setOwner(UUID owner){
		this.owner = owner;
	}
}
