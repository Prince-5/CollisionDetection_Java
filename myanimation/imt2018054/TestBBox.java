package imt2018054;
import java.util.*;
import animation.*;
public class TestBBox implements BBox{
	private Point minp,maxp;
	public TestBBox(Point Minp,Point Maxp){
		minp = Minp;
		maxp = Maxp;
	}
	public Point getMinPt(){
		return minp;
	}
	public Point getMaxPt(){
		return maxp;
	}
	public boolean intersects(BBox b){
		if(this.getMinPt().getX()>b.getMaxPt().getX() || this.getMaxPt().getX()<b.getMinPt().getX()){
			return false;
		}
		if(this.getMinPt().getY()>b.getMaxPt().getY() || this.getMaxPt().getY()<b.getMinPt().getY()){
			return false;
		}
		return true;
	}
}
