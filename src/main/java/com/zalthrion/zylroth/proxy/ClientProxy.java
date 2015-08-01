package com.zalthrion.zylroth.proxy;

import com.zalthrion.zylroth.entity.*;
import com.zalthrion.zylroth.entity.mount.*;
import com.zalthrion.zylroth.model.entity.*;
import com.zalthrion.zylroth.model.entity.mount.*;
import com.zalthrion.zylroth.reference.RenderIDs;
import com.zalthrion.zylroth.render.BlockTESRRenderer;
import com.zalthrion.zylroth.render.entity.*;
import com.zalthrion.zylroth.render.entity.mount.*;
import com.zalthrion.zylroth.render.tile.*;
import com.zalthrion.zylroth.tile.TileEntityInfuser;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

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
	public void registerRenderers() {
		float shadowSize = 0.5F;
		
		
		// ANIMALS
		
		RenderingRegistry.registerEntityRenderingHandler(EntityBird.class, new RenderBird(new ModelBird(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityRainbowPig.class, new RenderRainbowPig(new ModelRainbowPig(), new ModelRainbowPig(), shadowSize));

		
		// MOBS
		
		RenderingRegistry.registerEntityRenderingHandler(EntityEmpoweredTenebraeGolem.class, new RenderMutantTenebraeGolem(new ModelMutantTenebraeGolem(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPyroKnight.class, new RenderPyroKnight(new ModelUndead(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadWarrior.class, new RenderUndeadWarrior(new ModelUndead(), shadowSize, shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityUndeadMinion.class, new RenderUndeadMinion(new ModelUndead(), shadowSize, shadowSize));
				
		RenderingRegistry.registerEntityRenderingHandler(EntityTenebraeGolem.class, new RenderTenebraeGolem(new ModelTenebraeGolem(), shadowSize));
				
		RenderingRegistry.registerEntityRenderingHandler(EntityVoidDragon.class, new RenderVoidDragon());
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalHorse.class, new RenderSkeletalHorse(new ModelSkeletalHorse(), shadowSize));
		
		
		//MOUNTS
		
		RenderingRegistry.registerEntityRenderingHandler(MountDeathcharger.class, new RenderDeathcharger(new ModelDeathcharger(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountPlaguedHorse.class, new RenderPlaguedHorse(new ModelPlaguedHorse(), shadowSize));
		
		RenderingRegistry.registerEntityRenderingHandler(MountWarTortoise.class, new RenderWarTortoise(new ModelWarTortoise(), shadowSize));


	}
	
	public void registerBlockRenderers() {
		RenderIDs.setIDs();
		
		// BLOCKS
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfuser.class, new RenderTileEntityInfuser());
		RenderingRegistry.registerBlockHandler(new BlockTESRRenderer(new TileEntityInfuser(), RenderIDs.blockInfuserRI));
		
	}
	
}