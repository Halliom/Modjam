package halliom.common.backpack.modules;

import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;


public class ModuleBucketSupplier extends BackpackModule 
{
	
	private IModelCustom model = AdvancedModelLoader.loadModel("/model/bucket2.obj");
	
	public ModuleBucketSupplier() 
	{
		super(TYPE_DOWN);
		setNeedsUpdate(true);
	}
	
	@Override
	public void render() 
	{
		model.renderAll();
	}
	
}
