package lazmod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler
	{

	public ItemStack isCrafting		= new ItemStack(ScienceCraft.CraftingItem, 1, 0); //is is ItemStack.
	public ItemStack isSoul			= new ItemStack(ScienceCraft.CraftingItem, 1, 1);
	public ItemStack isSpace		= new ItemStack(ScienceCraft.CraftingItem, 1, 2);

	public ItemStack isDerivium		= new ItemStack(ScienceCraft.Derivium, 1);
	public ItemStack isEmmitium		= new ItemStack(ScienceCraft.Emmitium, 1);
	
	protected RecipeHandler() {}
	
	protected void addRecipes()
		{		
		GameRegistry.addRecipe(new ItemStack(ScienceCraft.FField, 1), new Object[]{ "111", "202", "111", Character.valueOf('0'), Block.bedrock, Character.valueOf('1'), Block.glass, Character.valueOf('2'), Item.redstone});
		GameRegistry.addRecipe(new ItemStack(ScienceCraft.IrnTnk, 1), new Object[]{ "314", "101", "#2#", Character.valueOf('0'), Block.glass, Character.valueOf('1'), Item.ingotIron, Character.valueOf('2'), Block.blockIron, Character.valueOf('3'), Item.redstone,Character.valueOf('2'), new ItemStack(Item.dyePowder, 1, 4)});

		GameRegistry.addRecipe(new ItemStack(ScienceCraft.BlockyBlock, 1, 0), new Object[]{ "wVw", "xGx", "000", Character.valueOf('w'), isDerivium, Character.valueOf('V'), isEmmitium, Character.valueOf('x'), Item.redstone, Character.valueOf('G'), Block.furnaceIdle});
	
		GameRegistry.addShapelessRecipe(new ItemStack(ScienceCraft.CraftingItem, 8, 1), new Object[]{Block.slowSand, Item.glassBottle, Item.glassBottle, Item.glassBottle, Item.glassBottle, Item.glassBottle, Item.glassBottle, Item.glassBottle, Item.glassBottle});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 55), new Object[]{ Item.slimeBall, Item.slimeBall, isSoul});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 54), new Object[]{ Item.rottenFlesh, Item.rottenFlesh, isSoul});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.monsterPlacer, 1, 51), new Object[]{ Item.arrow, Item.arrow, Item.bone, Item.bone, isSoul});
		}
	}
