package eyeq.japanesepoem.event;

import eyeq.japanesepoem.JapanesePoem;
import eyeq.util.client.MinecraftUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class JapanesePoemEventHandler {
    @SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event) {
        EntityLivingBase entity = event.getEntityLiving();
        if(entity == MinecraftUtils.getPlayerMP()) {
            ITextComponent text = new TextComponentTranslation(JapanesePoem.I18n_POEM);
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(text);
        }
    }
}
