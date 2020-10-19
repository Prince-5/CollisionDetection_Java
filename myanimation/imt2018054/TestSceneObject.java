package imt2018054;
import java.util.*;
import java.lang.Math;

import animation.BBox;
import animation.Point;
import animation.SceneObject;

public class TestSceneObject extends SceneObject {

	private String name;
	private Point cpos,dpos;
	private int flag=0;
	private static int count = 0;
	private TestBBox b,b1;
	private ArrayList<SceneObject> a;  
	private ArrayList<SceneObject> o;  

	public TestSceneObject(){
		name = "object"+count;
		cpos = new Point(0,0);
		dpos = new Point(0,0);
		count++;
	}
	@Override
	public String getObjName() {
		return name;
	}

	@Override
	public Point getPosition() {
		return cpos;
	}

	@Override
	public void setPosition(int x, int y) {
		cpos.setPos(x,y);	
	}

	public void setDestPosition(int x, int y) {
		dpos.setPos(x,y);
	}
	
	protected  ArrayList<Point> getOutline(){
		ArrayList<Point> points= new ArrayList<>();
		Point p1=new Point(cpos.getX(),cpos.getY());
		Point p2=new Point(cpos.getX()+20,cpos.getY());
		Point p3=new Point(cpos.getX()+20,cpos.getY()+20);
		Point p4=new Point(cpos.getX(),cpos.getY()+20);
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		return points;
	}

	@Override
	public BBox getBBox() {
		b = new TestBBox(cpos,this.getOutline().get(2));
		return b;
	}
	boolean validmove(ArrayList<SceneObject> a,ArrayList<SceneObject> o){
		for(SceneObject s: a){
			if(s.getObjName()!=this.getObjName())
			{
				if(this.getBBox().intersects(s.getBBox())){
				return false;
				}
			}
		}
		for(SceneObject s: o){
			if(s.getObjName()!=this.getObjName())
			{
				if(this.getBBox().intersects(s.getBBox()))
				return false;
			}
		}
		return true;
	}
	public String toString(){
		return this.getObjName();
	}
	protected void updatePos(int deltaT){
        	a=TestScene.getScene().getActors();
		o=TestScene.getScene().getObstacles();
		    if(this.getPosition().getX()-this.dpos.getX()!=0 && flag==0)
			{
				if(Math.abs(this.getPosition().getX()-this.dpos.getX())<10 )
				{
					b1 = new TestBBox(dpos,this.getOutline().get(2));
					this.setPosition(this.dpos.getX(),this.getPosition().getY());
				}
				else if(this.getPosition().getX()>this.dpos.getX() )
				{
					this.setPosition(this.getPosition().getX()-10,this.getPosition().getY());
					if(!validmove(a,o))
					{
						
						this.setPosition(this.getPosition().getX()+10,this.getPosition().getY()+10);
						if(!validmove(a,o))
						{
							this.setPosition(this.getPosition().getX(),this.getPosition().getY()-20);
							if(!validmove(a,o))
							{
								this.setPosition(this.getPosition().getX(),this.getPosition().getY()+10);
							}
						}
					}
				}
				else if(this.getPosition().getX()<this.dpos.getX() )
				{
					this.setPosition(this.getPosition().getX()+10,this.getPosition().getY());
					if(!validmove(a,o))
					{

						this.setPosition(this.getPosition().getX()-10,this.getPosition().getY()-10);
						if(!validmove(a,o))
						{
							this.setPosition(this.getPosition().getX(),this.getPosition().getY()+20);
							if(!validmove(a,o))
							{
								this.setPosition(this.getPosition().getX(),this.getPosition().getY()-10);
							}
						}
					}
				}
			}
			else if(this.getPosition().getY()-this.dpos.getY()!=0)
			{
				flag=1;
				if(Math.abs(this.getPosition().getY()-this.dpos.getY())<10)
				{
					b1 = new TestBBox(dpos,this.getOutline().get(2));
					this.setPosition(this.getPosition().getX(),this.dpos.getY());
				}
				else if(this.getPosition().getY()<this.dpos.getY())
				{
					this.setPosition(this.getPosition().getX(),this.getPosition().getY()+10);
					if(!validmove(a,o))
					{
						this.setPosition(this.getPosition().getX()+10,this.getPosition().getY()-10);
						if(!validmove(a,o))
						{
							this.setPosition(this.getPosition().getX()-20,this.getPosition().getY());
							if(!validmove(a,o))
							{
								this.setPosition(this.getPosition().getX()+10,this.getPosition().getY());
							}
						}
					}
				}
				else if(this.getPosition().getY()>this.dpos.getY())
				{
					this.setPosition(this.getPosition().getX(),this.getPosition().getY()-10);
					if(!validmove(a,o))
					{
						this.setPosition(this.getPosition().getX()-10,this.getPosition().getY()+10);
						if(!validmove(a,o))
						{
							this.setPosition(this.getPosition().getX()+20,this.getPosition().getY());
							if(!validmove(a,o))
							{
								this.setPosition(this.getPosition().getX()-10,this.getPosition().getY());
							}
						}
					}
				}
				if(this.getPosition().getY()==this.dpos.getY())
				{
					flag=0;
				}
			}		
	}
}





