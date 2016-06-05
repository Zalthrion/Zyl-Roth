package com.zalthrion.zylroth.block;

import java.util.List;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.zalthrion.zylroth.base.BlockBase;
import com.zalthrion.zylroth.entity.EntityTenebraeProtector;
import com.zalthrion.zylroth.entity.boss.EntityTenebraeGuardian;
import com.zalthrion.zylroth.lib.ModInit.BlockInit;
import com.zalthrion.zylroth.reference.Reference;

public class ChiseledTenebrae extends BlockBase {
	
	/* Constructors */
	
	public ChiseledTenebrae() {
		super(Material.ROCK);
		this.setCreativeTab();
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setNames("chiseledTenebrae");
		this.setResistance(5.0F);
		this.setSoundType(SoundType.METAL);
	}
	
	/* Overridden */
	
	@Override public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			tooltip.add(I18n.format(Reference.TOOLTIP_PREFIX + "head"));
		} else {
			tooltip.add(I18n.format(Reference.TOOLTIP_PREFIX + "shift"));
		}
	}
	
	@Override public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		
		// Boss
		
		if (worldIn.getBlockState(pos.down()).getBlock() == BlockInit.EMPOWERED_TENEBRAE_CORE && worldIn.getBlockState(pos.down(2)).getBlock() == BlockInit.INFUSED_TENEBRAE) {
			boolean flag = worldIn.getBlockState(pos.down().west()).getBlock() == BlockInit.INFUSED_TENEBRAE && worldIn.getBlockState(pos.down().east()).getBlock() == BlockInit.INFUSED_TENEBRAE;
			boolean flag1 = worldIn.getBlockState(pos.down().north()).getBlock() == BlockInit.INFUSED_TENEBRAE && worldIn.getBlockState(pos.down().south()).getBlock() == BlockInit.INFUSED_TENEBRAE;
			
			if (flag || flag1) {
				worldIn.setBlockToAir(pos);
				worldIn.setBlockToAir(pos.down());
				worldIn.setBlockToAir(pos.down(2));
				
				if (flag) {
					worldIn.setBlockToAir(pos.down().west());
					worldIn.setBlockToAir(pos.down().east());
				} else {
					worldIn.setBlockToAir(pos.down().north());
					worldIn.setBlockToAir(pos.down().south());
				}
				
				EntityTenebraeGuardian golem = new EntityTenebraeGuardian(worldIn);
				golem.setLocationAndAngles((double) pos.getX() + 0.5D, (double) pos.getY() - 1.95D, (double) pos.getZ() + 0.5D, 0.0F, 0.0F);
				worldIn.spawnEntityInWorld(golem);
				
				for (int i = 0; i < 120; i ++) {
					worldIn.spawnParticle(EnumParticleTypes.SNOWBALL, (double) pos.getX() + worldIn.rand.nextDouble(), (double) (pos.getY() - 2) + worldIn.rand.nextDouble() * 3.9D, (double) pos.getZ() + worldIn.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
		
		// Non-Boss "Golem Guardian"
		
		if (worldIn.getBlockState(pos.down()).getBlock() == BlockInit.TENEBRAE_CORE && worldIn.getBlockState(pos.down(2)).getBlock() == BlockInit.TENEBRAE_BLOCK) {
			boolean flag = worldIn.getBlockState(pos.west().down()).getBlock() == BlockInit.TENEBRAE_BLOCK && worldIn.getBlockState(pos.east().down()).getBlock() == BlockInit.TENEBRAE_BLOCK;
			boolean flag1 = worldIn.getBlockState(pos.down().north()).getBlock() == BlockInit.TENEBRAE_BLOCK && worldIn.getBlockState(pos.down().south()).getBlock() == BlockInit.TENEBRAE_BLOCK;
			
			if (flag || flag1) {
				worldIn.setBlockToAir(pos);
				worldIn.setBlockToAir(pos.down());
				worldIn.setBlockToAir(pos.down(2));
				
				if (flag) {
					worldIn.setBlockToAir(pos.west().down());
					worldIn.setBlockToAir(pos.east().down());
				} else {
					worldIn.setBlockToAir(pos.down().north());
					worldIn.setBlockToAir(pos.down().south());
				}
				
				EntityTenebraeProtector golem = new EntityTenebraeProtector(worldIn);
				golem.setPlayerCreated(true);
				golem.setLocationAndAngles((double) pos.getX() + 0.5D, (double) pos.getY() - 1.95D, (double) pos.getZ() + 0.5D, 0.0F, 0.0F);
				worldIn.spawnEntityInWorld(golem);
				
				for (int i = 0; i < 120; i ++) {
					worldIn.spawnParticle(EnumParticleTypes.SNOWBALL, (double) pos.getX() + worldIn.rand.nextDouble(), (double) (pos.getY() - 2) + worldIn.rand.nextDouble() * 3.9D, (double) pos.getZ() + worldIn.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}
}