package imt2018054;
import java.util.*;
import animation.Scene;
public class TestScene extends Scene{
	public TestScene(){
		super();
	}
	protected void checkScene(){
		for(int i = 0;i<this.getActors().size();i++)
		{
			for(int j=0;j<this.getActors().size();j++)
			{
				if(this.getActors().get(i) != this.getActors().get(j))
				{
					if(this.getActors().get(i).getBBox().intersects(this.getActors().get(j).getBBox()))
					{
						this.getActors().remove(i);
					}
				}
			}
				
			for(int j=0;j<this.getObstacles().size();j++)
			{
				if(this.getActors().get(i).getBBox().intersects(this.getObstacles().get(j).getBBox()))
				{
					this.getObstacles().remove(j);
				}
			}
		}
	}
}
