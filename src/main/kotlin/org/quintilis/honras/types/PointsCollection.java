package org.quintilis.honras.types;

import org.bukkit.entity.Player;

public class PointsCollection {
    private String _id;
    private Integer points;
    
    public PointsCollection(String _id,Integer points) {
        this._id = _id;
        this.points = points;
    }
    
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