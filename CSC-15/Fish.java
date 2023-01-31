public class Fish{
private String type;
private double length;
private double distanceFromShore;
 
public Fish(){
type = "";
length = 0;
distanceFromShore = 0;
}
 
public Fish(String type, double length, double distanceFromShore){
this.type = type;
this.length = length;
this.distanceFromShore = distanceFromShore;
}
 
public double getLength(){
return length;
}
 
public String getType(){
return type;
}
 
public double getDistanceFromShore(){
return distanceFromShore;
}
 
public void grow(double scale){
length += scale;
}
 
public void move(double distance){
distanceFromShore += distance;
}
 
public boolean biggerThan(Fish other){
if(this.length>other.length){
return true;
}
else{
return false;
}
}
 
public String toString(){
return "Type : "+type+" | Length: "+length+" | DistanceFromShore: "+distanceFromShore;
}
 
public boolean furtherFrom(Fish other){
if(this.distanceFromShore>other.distanceFromShore){
return true;
}
else{
return false;
}
}
 
}