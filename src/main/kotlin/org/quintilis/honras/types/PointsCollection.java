package org.quintilis.honras.types;

import org.bukkit.entity.Player;

public class PointsCollection {
    private String _id;
    private Integer points;
    
    public PointsCollection() {}
    
    public String getId(){
        return _id;
    }
    public Integer getPoints(){
        return points;
    }
    
    public void setId(String id){
        this._id = id;
    }
    
    public void setPoints(Integer points){
        this.points = points;
    }
}