package lazmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
	{
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
		{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		return null;
		}
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
		{
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		return null;
		}
	}
