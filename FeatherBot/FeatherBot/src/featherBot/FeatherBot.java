package featherBot;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import org.powerbot.script.Condition;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Random;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

/***************************
 *        FeatherBot         *
 *      neverpullout       *
 *   Creation: 2/12/2015    *
 ***************************/

@Script.Manifest(name="FeatherBot", description="Buys feathers | ! Hops worlds ! | avg 2.15 gp/feather | x feather / hour")
public class FeatherBot extends PollingScript<ClientContext> implements PaintListener{
	 
	private List<Task> taskList = new ArrayList<Task>();
	private Task currentTaskw;
	
	@Override
    public void start() {
		taskList.add(new WorldHop(ctx));
		taskList.add(new Shop(ctx));
		
		
		//exit shop
		ctx.widgets.widget(300).component(91).click();
		Condition.sleep(Random.getDelay() + 400);
		//select logout
		ctx.widgets.widget(548).component(41).click();
		Condition.sleep(Random.getDelay());
		//logout
		ctx.widgets.widget(182).component(6).click();
		Condition.sleep(Random.getDelay());
		
		taskList.get(0).execute();
	}
	
	

	@Override
	public void poll() {
		for(int i = 0; i < taskList.size(); i++){
			if(taskList.get(i).activate()){
				taskList.get(i).execute();
			}
		}
	}
	
	

	@Override
	public void repaint(Graphics arg0) {
		
	}
}
