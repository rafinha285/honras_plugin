package org.quintilis.honras.types;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.UUID;

public class ClansCollection {
	private ObjectId _id;
	private String name;
	private String prefix;
	private List<UUID> members;
	private List<ObjectId> enemies;
	private List<ObjectId> allies;
	private UUID owner;
	private Integer points;
	
	public ClansCollection(
		ObjectId _id,
		String name
	) {
		this._id = _id;
		this.name = name;
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
	public List<UUID> getMembers(){
		return members;
	}
	public List<ObjectId> getEnemies(){
		return enemies;
	}
	public List<ObjectId> getAllies(){
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
	public void setMembers(List<UUID> members){
		this.members = members;
	}
	public void setEnemies(List<ObjectId> enemies){
		this.enemies = enemies;
	}
	public void setAllies(List<ObjectId> allies){
		this.allies = allies;
	}
	public void setOwner(UUID owner){
		this.owner = owner;
	}
}
