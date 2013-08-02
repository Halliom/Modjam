package halliom.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

public class ItemBackPlate extends ItemArmor 
{

	public ItemBackPlate(int id, EnumArmorMaterial material, int render) 
	{
		super(id, material, render, 1);
		setCreativeTab(CreativeTabs.tabCombat);
	}

}
