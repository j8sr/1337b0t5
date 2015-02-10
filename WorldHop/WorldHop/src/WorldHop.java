
import org.powerbot.script.Condition;
import org.powerbot.script.Mouse;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;

public class WorldHop extends Task<ClientContext>{
	private int[] worlds = {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19, 20, 22, 23, 24, 25, 26, 27, 28, 29, 30, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62};
	private int world = 1;
	private Mouse ourMouse = new Mouse(ctx);
	
	public WorldHop(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return !ctx.widgets.widget(378).component(17).valid();
	}

	@Override
	public void execute() {
		if(world > 56){
			world = 0;
		}
		
		if(loginCheck())
			return;
		ourMouse.click(Random.nextGaussian(200 + (((worlds[41] - 1) / 17) * 93), 285 + (((worlds[41] - 1) / 17) * 93), 10),Random.nextGaussian(62 + (((worlds[41] - 1) % 17) * 24), 78 + (((worlds[41] - 1) % 17) * 24), 10), true);
		if(loginCheck())
			return;
		ourMouse.click(Random.nextGaussian(200 + (((worlds[41] - 1) / 17) * 93), 285 + (((worlds[41] - 1) / 17) * 93), 10),Random.nextGaussian(62 + (((worlds[41] - 1) % 17) * 24), 78 + (((worlds[41] - 1) % 17) * 24), 10), true);
		if(loginCheck())
			return;
		ourMouse.click(Random.nextGaussian(200 + (((worlds[41] - 1) / 17) * 93), 285 + (((worlds[41] - 1) / 17) * 93), 10),Random.nextGaussian(62 + (((worlds[41] - 1) % 17) * 24), 78 + (((worlds[41] - 1) % 17) * 24), 10), true);
		if(loginCheck())
			return;
		
		ourMouse.click(Random.nextGaussian(391, 527, 10), Random.nextGaussian(273, 305, 10), true);
		Condition.sleep(Random.getDelay() + 400);
		
		if(loginCheck())
			return;
		
		ctx.input.sendln("username");
		ctx.input.send("password");
		
		
		ourMouse.click(Random.nextGaussian(8, 99, 50), Random.nextGaussian(466, 493, 50), true);
		
		
		int wx = Random.nextGaussian(200 + (((worlds[world] - 1) / 17) * 93), 285 + (((worlds[world] - 1) / 17) * 93), 10), wy =  Random.nextGaussian(62 + (((worlds[world] - 1) % 17) * 24), 78 + (((worlds[world] - 1) % 17) * 24), 10);
		ourMouse.click(wx, wy,  true);

		Condition.sleep(Random.getDelay());
		
		ctx.input.sendln("");
		ctx.input.sendln("");
		
		world++;
		if(world > 56){
			world = 0;
		}	
		long startTime = System.currentTimeMillis(); //fetch starting time
		while(!ctx.widgets.widget(378).component(17).valid() && (System.currentTimeMillis() - startTime)<6000){}
	}
	
	private boolean loginCheck(){
		return ctx.widgets.widget(378).component(17).valid();
	}
}
