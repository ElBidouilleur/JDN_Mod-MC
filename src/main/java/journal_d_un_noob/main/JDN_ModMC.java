package journal_d_un_noob.main;

import journal_d_un_noob.main.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDN_ModMC implements ModInitializer {
	public static final String MOD_ID = "jdn_mod-mc";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    
	@Override
	public void onInitialize() {
        ModItems.initialize();
	}
}