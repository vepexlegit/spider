package de.vepexlegit.spiderdebug.mixins;

import de.vepexlegit.spiderdebug.Spider;
import de.vepexlegit.spiderdebug.command.SpiderCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.ClientCommandHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class MixinEntity {
    @Inject(method = "onUpdate", at = @At("RETURN"))
    private void startGame(final CallbackInfo ci) {
        ClientCommandHandler.instance.registerCommand(new SpiderCommand());
    }

    private static Minecraft mc = Minecraft.getMinecraft();

    @Inject(method = "onUpdate", at = @At("HEAD"))
    private void onUpdate(final CallbackInfo ci) {
        if (Spider.INSTANCE.isEnabled()) {
            if (mc.thePlayer.isCollidedHorizontally) {
                mc.thePlayer.motionY = 0.25;
            }
        }
    }
}
