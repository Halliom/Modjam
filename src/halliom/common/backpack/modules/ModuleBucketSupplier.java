package halliom.common.backpack.modules;


public class ModuleBucketSupplier extends BackpackModule 
{
	
//	private IModelCustom model = AdvancedModelLoader.loadModel("/model/Furteliser2.obj");
	
	public ModuleBucketSupplier() 
	{
		super(TYPE_DOWN);
		setNeedsUpdate(true);
	}
	
	@Override
	public void render() 
	{
//		model.renderAll();
	}
	
}
