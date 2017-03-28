package eyeq.japanesepoem;

import eyeq.japanesepoem.event.JapanesePoemEventHandler;
import eyeq.util.client.resource.ULanguageCreator;
import eyeq.util.client.resource.lang.LanguageResourceManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

import static eyeq.japanesepoem.JapanesePoem.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
public class JapanesePoem {
    public static final String MOD_ID = "eyeq_japanesepoem";

    @Mod.Instance(MOD_ID)
    public static JapanesePoem instance;

    public static final String I18n_POEM = "msg.poem.txt";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new JapanesePoemEventHandler());
        if(event.getSide().isServer()) {
            return;
        }
        createFiles();
    }
	
    public static void createFiles() {
    	File project = new File("../1.11.2-japanesePoem");
    	
        LanguageResourceManager language = new LanguageResourceManager();

        language.register(LanguageResourceManager.EN_US, I18n_POEM, "Inga-oho!");
        language.register(LanguageResourceManager.JA_JP, I18n_POEM, "インガオホー！");

        ULanguageCreator.createLanguage(project, MOD_ID, language);
    }
}
