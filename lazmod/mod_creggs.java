package lazmod;

import static cpw.mods.fml.common.Side.CLIENT;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;

public class mod_creggs extends BaseMod
	{	
	
	public static final Item soulItem = new ItemSoul(3000).setItemName("soulItem").setIconIndex(ModLoader.addOverride("/gui/items.png", "/lazmod/soul.png"));
	
	public String getVersion()
		{
		return "0.1 alpha";
		}

	public void load()
		{
		
		ModLoader.addName(soulItem, "Soul in a Bottle");

		ModLoader.addRecipe(new ItemStack(soulItem, 8), new Object[]{ "XXX", "XZX", "XXX",  Character.valueOf('X'), Item.glassBottle, Character.valueOf('Z'), Block.slowSand});
		
		ModLoader.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 55), new Object[]{ Item.slimeBall, Item.slimeBall, soulItem});
		ModLoader.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 54), new Object[]{ Item.rottenFlesh, Item.rottenFlesh, soulItem});
		ModLoader.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 51), new Object[]{ Item.arrow, Item.arrow, Item.bone, Item.bone, soulItem});
		
		}
	}