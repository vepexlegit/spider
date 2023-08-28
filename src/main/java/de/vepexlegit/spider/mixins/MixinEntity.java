package de.vepexlegit.spider.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class MixinEntity {

    private static Minecraft mc = Minecraft.getMinecraft();

    @Inject(method = "onUpdate", at = @At("HEAD"))
    private void onUpdate(final CallbackInfo ci) {
        if (mc.thePlayer.isCollidedHorizontally) {
            mc.thePlayer.motionY = 0.25;
        }
    }
}
