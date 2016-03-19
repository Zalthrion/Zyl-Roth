package com.zalthrion.zylroth.block.machine;


public class InfuserMachine extends BlockBaseContainer {
/*	private String name = "infuserMachineActive";
	private String name_idle = "infuserMachine";
	private String oreName = "oreInfuserMachineActive";
	private String oreName_idle = "oreInfuserMachine";
	private InfuserType type;
	private static boolean keepInventory;
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyEnum<InfuserType> INFUSER_TYPE = PropertyEnum.<InfuserType>create("type", InfuserType.class);
	
	public InfuserMachine(boolean isActive, InfuserType type) {
		super(!isActive);
		this.type = type;
		this.setUnlocalizedName(isActive ? (type.isNormal() ? name : oreName) : (type.isNormal() ? name_idle : oreName_idle));
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setResistance(5.0F);
		this.setLightLevel(isActive ? 0.9F : 0.2F);
		this.setSoundType(SoundType.METAL);
		this.setParticleBlockState(type.isNormal() ? ModBlocks.tenebraeCore.getDefaultState() : Blocks.quartz_block.getDefaultState());
	}
	
	@Override public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityInfuser(this.type);
	}
	
	@Override public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) return true;
		TileEntityInfuser tile = (TileEntityInfuser) worldIn.getTileEntity(pos);
		
		if ((tile == null) || playerIn.isSneaking()) return false;
		
		playerIn.openGui(Zylroth.instance, GuiIDs.INFUSER, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@Override public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this.type.isNormal() ? ModBlocks.infuserIdle : ModBlocks.oreInfuserIdle);
	}
	
	public static void setState(InfuserType type, boolean active, World world, BlockPos pos) {
		IBlockState iblockstate = world.getBlockState(pos);
		TileEntity tileentity = world.getTileEntity(pos);
		keepInventory = true;
		
		if (active && type.isNormal()) {
			world.setBlockState(pos, ModBlocks.infuser.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
			world.setBlockState(pos, ModBlocks.infuser.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
		} else if (!active && type.isNormal()) {
			world.setBlockState(pos, ModBlocks.infuserIdle.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
			world.setBlockState(pos, ModBlocks.infuserIdle.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
		} else if (active && !type.isNormal()) {
			world.setBlockState(pos, ModBlocks.oreInfuser.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
			world.setBlockState(pos, ModBlocks.oreInfuser.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
		} else if (!active && !type.isNormal()) {
			world.setBlockState(pos, ModBlocks.oreInfuserIdle.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
			world.setBlockState(pos, ModBlocks.oreInfuserIdle.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)).withProperty(INFUSER_TYPE, type), 3);
		}

        keepInventory = false;

		if (tileentity != null) {
			tileentity.validate();
			world.setTileEntity(pos, tileentity);
		}
		
		tileentity = world.getTileEntity(pos);
		if (tileentity instanceof TileEntityInfuser) {
			((TileEntityInfuser) tileentity).setFacing(iblockstate.getValue(FACING));
		}
	}
	
	@Override public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this.type.isNormal() ? ModBlocks.infuserIdle : ModBlocks.oreInfuserIdle);
	}
	
	@Override public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}
	
	@Override public int getComparatorInputOverride(IBlockState state, World world, BlockPos pos) {
		return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(pos));
	}
	
	@Override public void breakBlock(World world, BlockPos pos, IBlockState state) {
		if (!keepInventory) {
			TileEntity tileEntity = world.getTileEntity(pos);
			if (!(tileEntity instanceof IInventory)) { return; }
			IInventory inventory = (IInventory) tileEntity;
			
			for (int i = 0; i < inventory.getSizeInventory(); ++ i) {
				ItemStack itemstack = inventory.removeStackFromSlot(i);
				
				if (itemstack != null) {
					float spawnX = pos.getX() + world.rand.nextFloat();
					float spawnY = pos.getY() + world.rand.nextFloat();
					float spawnZ = pos.getZ() + world.rand.nextFloat();
					
					EntityItem entityitem = new EntityItem(world, spawnX, spawnY, spawnZ, itemstack);
					
					float f3 = 0.05F;
					entityitem.motionX = (-0.5F + world.rand.nextGaussian()) * f3;
					entityitem.motionY = (4 + world.rand.nextGaussian()) * f3;
					entityitem.motionZ = (-0.5F + world.rand.nextGaussian()) * f3;
					
					world.spawnEntityInWorld(entityitem);
				}
			}
		}
		
		super.breakBlock(world, pos, state);
	}
	
	@Override public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(INFUSER_TYPE, this.type).withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(INFUSER_TYPE, this.type).withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
		
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof TileEntityInfuser) {
			if (stack.hasDisplayName()) {
				((TileEntityInfuser) tileentity).setCustomInventoryName(stack.getDisplayName());
			}
			((TileEntityInfuser) tileentity).setFacing(placer.getHorizontalFacing().getOpposite());
		}
	}
	
	@Override public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
		if (!this.type.isNormal()) return;
		TileEntity tile = world.getTileEntity(pos);
		TileEntityInfuser tei = (TileEntityInfuser) tile;
		
		if (tei.isBurning()) {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			for (int l = x - 2; l <= x + 2; ++ l) {
				for (int i1 = z - 2; i1 <= z + 2; ++ i1) {
					if (l > x - 2 && l < x + 2 && i1 == z - 1) {
						i1 = z + 2;
					}
					
					if (rand.nextInt(16) == 0) {
						for (int j1 = y; j1 <= y + 1; ++ j1) {
							if (!world.isAirBlock(new BlockPos((l - x) / 2 + x, j1, (i1 - z) / 2 + z))) {
								break;
							}
							
							world.spawnParticle(EnumParticleTypes.PORTAL, (double) x - -0.5F, (double) y - -0.5F, (double) z - -0.5F, (double) ((float) (l - x) + rand.nextFloat() - 0.1F), (double) ((float) (j1 - y) - rand.nextFloat() - 0.1F), (double) ((float) (i1 - z) + rand.nextFloat()) - 0.1F);
						}
					}
				}
			}
		}
	}
	
	@Override public IBlockState getStateFromMeta(int meta) {
		int i = meta & 7;
		EnumFacing facing = (i > 3) ? EnumFacing.NORTH : EnumFacing.getFront(i);
		
		return this.getDefaultState().withProperty(FACING, facing).withProperty(INFUSER_TYPE, ((meta & 8) > 0) ? InfuserType.ORE : InfuserType.NORMAL);
	}
	
	@Override public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing) state.getValue(FACING)).getIndex();
		if (!((InfuserType) state.getValue(INFUSER_TYPE)).isNormal()) {
			i |= 8;
		}
		return i;
	}
	
	@Override protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING, INFUSER_TYPE});
	}*/
}