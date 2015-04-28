package com.zalthrion.zylroth.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.zalthrion.zylroth.entity.EntityBird;
import com.zalthrion.zylroth.entity.EntityMutantTenebraeGolem;
import com.zalthrion.zylroth.entity.EntityPyroKnight;
import com.zalthrion.zylroth.entity.EntityRainbowPig;
import com.zalthrion.zylroth.entity.EntitySkeletalHorse;
import com.zalthrion.zylroth.entity.EntityTenebraeGolem;
import com.zalthrion.zylroth.entity.EntityUndeadMinion;
import com.zalthrion.zylroth.entity.EntityUndeadWarrior;
import com.zalthrion.zylroth.entity.EntityVoidDragon;
import com.zalthrion.zylroth.entity.mount.MountDeathcharger;
import com.zalthrion.zylroth.entity.mount.MountPlaguedHorse;
import com.zalthrion.zylroth.entity.mount.MountWarTortoise;
import com.zalthrion.zylroth.handler.ModelHelper;
import com.zalthrion.zylroth.lib.ModBlocks;
import com.zalthrion.zylroth.lib.ModItems;
import com.zalthrion.zylroth.model.entity.ModelBird;
import com.zalthrion.zylroth.model.entity.ModelMutantTenebraeGolem;
import com.zalthrion.zylroth.model.entity.ModelRainbowPig;
import com.zalthrion.zylroth.model.entity.ModelSkeletalHorse;
import com.zalthrion.zylroth.model.entity.ModelTenebraeGolem;
import com.zalthrion.zylroth.model.entity.ModelUndead;
import com.zalthrion.zylroth.model.entity.mount.ModelDeathcharger;
import com.zalthrion.zylroth.model.entity.mount.ModelPlaguedHorse;
import com.zalthrion.zylroth.model.entity.mount.ModelWarTortoise;
import com.zalthrion.zylroth.reference.RenderIDs;
import com.zalthrion.zylroth.render.entity.RenderBird;
import com.zalthrion.zylroth.render.entity.RenderMutantTenebraeGolem;
import com.zalthrion.zylroth.render.entity.RenderPyroKnight;
import com.zalthrion.zylroth.render.entity.RenderRainbowPig;
import com.zalthrion.zylroth.render.entity.RenderSkeletalHorse;
import com.zalthrion.zylroth.render.entity.RenderTenebraeGolem;
import com.zalthrion.zylroth.render.entity.RenderUndeadMinion;
import com.zalthrion.zylroth.render.entity.RenderUndeadWarrior;
import com.zalthrion.zylroth.render.entity.RenderVoidDragon;
import com.zalthrion.zylroth.render.entity.mount.RenderDeathcharger;
import com.zalthrion.zylroth.render.entity.mount.RenderPlaguedHorse;
import com.zalthrion.zylroth.render.entity.mount.RenderWarTortoise;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void init() {
		super.init();
		this.registerRenderers();
		this.registerBlockRenderers();
	}
	
	@Override
	public void registerRenderInformation() {}
	
	@Override
	public void registerItemRenderers() {
		ModelHelper.registerBlock(ModBlocks.tenebrae_Ore);
		ModelHelper.registerBlock(ModBlocks.tenebrae_Block);
		ModelHelper.registerBlock(ModBlocks.tenebrae_Core);
		ModelHelper.registerBlock(ModBlocks.chiseled_Tenebrae);
		ModelHelper.registerBlock(ModBlocks.infused_Tenebrae);
		ModelHelper.registerBlock(ModBlocks.ash_Block);
		/* Tenebrae */
		ModelHelper.registerItem(ModItems.raw_Tenebrae);
		ModelHelper.registerItem(ModItems.raw_Tenebrae_Ingot);
		ModelHelper.registerItem(ModItems.tenebrae_Ingot);
		ModelHelper.registerItem(ModItems.unstable_Tenebrae_Core);
		ModelHelper.registerItem(ModItems.stable_Tenebrae_Core);
		/* Mounts */
		ModelHelper.registerItem(ModItems.Empty_SC);
		ModelHelper.registerItem(ModItems.SC_Deathcharger);
		ModelHelper.registerItem(ModItems.SC_PlaguedHorse);
		ModelHelper.registerItem(ModItems.SC_WarTortoise);
		/* Portals */
		ModelHelper.registerItem(ModItems.void_Talisman);
		ModelHelper.registerItem(ModItems.rainbow_Talisman);
		/* Others */
		ModelHelper.registerItem(ModItems.dark_Shard);
		ModelHelper.registerItem(ModItems.soul_Essence);
		ModelHelper.registerItem(ModItems.cursed_Soul_Essence);
		ModelHelper.registerItem(ModItems.void_Gem);
		ModelHelper.registerItem(ModItems.void_Essence);
	}
	
	@Override
	public void registerRenderers() {
		float shadowSize = 0.5F;
		
		
		// ANIMALS
		
		RenderManager rm = Minecraft.getMinecraft().getRenderManager();
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBird.class, new RenderBird(rm, new ModelBird(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityRainbowPig.class, new RenderRainbowPig(rm, new ModelRainbowPig(), shadowSize));

		
		// MOBS
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMutantTenebraeGolem.class, new RenderMutantTenebraeGolem(rm, new ModelMutantTenebraeGolem(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPyroKnight.class, new RenderPyroKnight(rm, new ModelUndead(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadWarrior.class, new RenderUndeadWarrior(rm, new ModelUndead(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadMinion.class, new RenderUndeadMinion(rm, new ModelUndead(), shadowSize, shadowSize));
				
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeGolem.class, new RenderTenebraeGolem(rm, new ModelTenebraeGolem(), shadowSize));
				
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidDragon.class, new RenderVoidDragon(rm));
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalHorse.class, new RenderSkeletalHorse(rm, new ModelHorse(), new ModelSkeletalHorse(), shadowSize));
		
		
		//MOUNTS
		
		RenderingRegistry.registerEntityRenderingHandler(MountDeathcharger.class, new RenderDeathcharger(rm, new ModelHorse(), new ModelDeathcharger(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountPlaguedHorse.class, new RenderPlaguedHorse(rm, new ModelHorse(), new ModelPlaguedHorse(), shadowSize));

		RenderingRegistry.registerEntityRenderingHandler(MountWarTortoise.class, new RenderWarTortoise(rm, new ModelWarTortoise(), shadowSize));
		
	}
	
	public void registerBlockRenderers() {
		RenderIDs.setIDs();
	}
}