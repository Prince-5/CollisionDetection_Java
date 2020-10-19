import animation.Scene;
import animation.SceneObject;
import animation.View;
import imt2018054.*;
import imt2018026.*;
import imt2018079.*;
import imt2018512.*;
import imt2018519.*;

// Driver class to set up and exercise the animation
public class AllDemo {

	public static void main(String[] args) {
		Scene scene = new imt2018054.TestScene(); // replace with your implementation

		// populate the scene with objects implemented by the team
		for (int i = 0; i < 6; i++) {
			SceneObject s = new imt2018054.TestObject(); // replace with your implementation
			s.setPosition(i * 50, i * 50);
			scene.addObstacle(s); // using appropriate derived classes
		}
		
		SceneObject gayatri=new imt2018026.TestObject();
		gayatri.setPosition(100,100);
		gayatri.setDestPosition(50,50);
		scene.addActor(gayatri);

		SceneObject tarun=new imt2018079.TestObject();
		tarun.setPosition(200,200);
		tarun.setDestPosition(150,150);
		scene.addActor(tarun);

		SceneObject harsha=new imt2018512.TestObject();
		harsha.setPosition(300,300);
		harsha.setDestPosition(250,250);
		scene.addActor(harsha);

		/*SceneObject rutvi=new imt2018519.TestObject();
		rutvi.setPosition(400,400);
		rutvi.setDestPosition(350,350);
		scene.addActor(rutvi);*/


		// View view = new DemoTextView();
		View view = new DemoSwingView();

		scene.setView(view);

		view.init();

	}

}
