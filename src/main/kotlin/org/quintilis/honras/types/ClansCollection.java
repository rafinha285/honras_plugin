package org.quintilis.honras.types;

import org.bson.types.ObjectId;

public class ClansCollection {
	private ObjectId _id;
	private String name;
	private String prefix;
	
	public ClansCollection() {}
	
	public ObjectId getId(){
		return _id;
	}
	public String getName(){
		return name;
	}
	public String getPrefix(){
		return prefix;
	}
	
	
	public void set_id(ObjectId id){
		this._id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPrefix(String prefix){
		this.prefix = prefix;
	}
}
