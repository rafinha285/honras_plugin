package org.quintilis.honras.types;

import org.bson.types.ObjectId;

public class PlayerCollection {
	private ObjectId clanId;
	private String name;
	private String _id;
	
	public PlayerCollection() {}
	
	public String getId(){
		return _id;
	}
	public String getName(){
		return name;
	}
	public ObjectId getClanId(){
		return clanId;
	}
	
	
	public void setId(String id){
		this._id = id;
	}
	public void setClan(ObjectId clan){
		this.clanId = clan;
	}
	public void setName(String name){
		this.name = name;
	}
}
