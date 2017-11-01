package groovy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class GroovyExcutor implements IGameGroovy {
	private static Logger log = LogManager.getLogger("ACTION");
	@Override
	public void execute() {
		try {
//			Player player= PlayerManager.getInstance().getPlayer(9289845);
//			if(player!=null){
//				log.info("这个玩家9289845-->"+player.getClick_manygame());
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
