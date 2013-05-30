package mods.lazmod;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBlocky extends ItemBlock
	{

	public ItemBlockBlocky(int id)
		{
		super(id);
		setHasSubtypes(true);
		}

		@Override
		public int getMetadata (int damageValue)
			{
			return damageValue;
			}
		
		public String getUnlocalizedName(ItemStack par1ItemStack)
			{
			return HighEnergyCraft.DateHandler.BlockyLocalization[par1ItemStack.getItemDamage()];
			}
	}
