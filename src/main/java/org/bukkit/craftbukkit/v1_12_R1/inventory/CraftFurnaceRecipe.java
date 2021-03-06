package org.bukkit.craftbukkit.v1_12_R1.inventory;

import net.minecraft.item.crafting.FurnaceRecipes;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;

public class CraftFurnaceRecipe extends FurnaceRecipe implements CraftRecipe {
    public CraftFurnaceRecipe(ItemStack result, ItemStack source) {
        super(result, source.getType(), source.getDurability());
    }

    public static CraftFurnaceRecipe fromBukkitRecipe(FurnaceRecipe recipe) {
        if (recipe instanceof CraftFurnaceRecipe) {
            return (CraftFurnaceRecipe) recipe;
        }
        return new CraftFurnaceRecipe(recipe.getResult(), recipe.getInput());
    }

    @Override
    public void addToCraftingManager() {
        ItemStack result = this.getResult();
        ItemStack input = this.getInput();
        FurnaceRecipes.instance().registerRecipe(CraftItemStack.asNMSCopy(input), CraftItemStack.asNMSCopy(result), getExperience());
    }
}
