package lazmod.blocks.tileentities.handlers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class CraftSmasherHandler implements ICraftHandler
	{
    private static final CraftSmasherHandler craftBase = new CraftSmasherHandler();
	private HashMap<List<Integer>, ItemStack> craftList = new HashMap<List<Integer>, ItemStack>();
	
	public static final ICraftHandler staticInst()
		{
		return craftBase;
		}
	
	@Override
    public ItemStack getCraftingResult(ItemStack input) 
		{
        if (input == null)
        	{
            return null;
        	}
        return (ItemStack)craftList.get(Arrays.asList(input.itemID, input.getItemDamage()));
		}

	
	@Override
	public void addResult(ItemStack input, ItemStack output)
		{
		craftList.put(Arrays.asList(input.itemID, input.getItemDamage()),output);
		}
	}