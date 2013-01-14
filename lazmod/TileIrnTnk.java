package lazmod;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class TileIrnTnk extends TileEntity implements ITankContainer
	{
	public final LiquidTank IrnTnk = new LiquidTank(LiquidContainerRegistry.BUCKET_VOLUME * 32);

	@Override
	public void readFromNBT(NBTTagCompound data)
		{
		super.readFromNBT(data);

		if (data.hasKey("stored") && data.hasKey("liquidId"))
			{
			LiquidStack liquid = new LiquidStack(data.getInteger("liquidId"), data.getInteger("stored"), 0);
			IrnTnk.setLiquid(liquid);
			}
		else
			{
			LiquidStack liquid = new LiquidStack(0, 0, 0);
			liquid.readFromNBT(data.getCompoundTag("IrnTnk"));
			IrnTnk.setLiquid(liquid);
			}
		}
	@Override
	public void writeToNBT(NBTTagCompound data)
		{
		super.writeToNBT(data);
		if (IrnTnk.getLiquid() != null)
			{
			data.setTag("IrnTnk", IrnTnk.getLiquid().writeToNBT(new NBTTagCompound()));
			System.out.println("Fukken saved!");
			}
		}

	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		return fill(0, resource, doFill);
	}

	@Override
	public int fill(int tankIndex, LiquidStack resource, boolean doFill)
		{
		if (tankIndex != 0 || resource == null)
			{
			return 0;
			}
			
		resource = resource.copy();
		int totalUsed = 0;
		TileIrnTnk tankToFill = this;
        LiquidStack liquid = tankToFill.IrnTnk.getLiquid();

        if (liquid != null && !liquid.isLiquidEqual(resource))
        	{
            return 0;
        	}
        
		while (tankToFill != null && resource.amount > 0)
			{
			int used = tankToFill.IrnTnk.fill(resource, doFill);
			resource.amount -= used;
			totalUsed += used;
			}
		return totalUsed;
		}

	@Override
	public LiquidStack drain(ForgeDirection from, int maxEmpty, boolean doDrain) {
		return drain(0, maxEmpty, doDrain);
	}

	@Override
	public LiquidStack drain(int tankIndex, int maxEmpty, boolean doDrain) 
		{
			return null;
		}

	@Override
	public ILiquidTank[] getTanks(ForgeDirection direction)
		{
		LiquidTank compositeTank = new LiquidTank(IrnTnk.getCapacity());

		int capacity = IrnTnk.getCapacity();

		compositeTank.setCapacity(capacity);
		return new ILiquidTank[] { compositeTank };
		}

	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type)
		{
		return IrnTnk;
		}
	}
	