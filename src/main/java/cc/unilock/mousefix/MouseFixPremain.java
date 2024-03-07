package cc.unilock.mousefix;

import cc.unilock.mousefix.transformer.ClassReaderTransformer;
import cc.unilock.mousefix.transformer.MouseEventQueueTransformer;
import nilloader.api.ClassTransformer;
import nilloader.api.ModRemapper;
import nilloader.api.NilLogger;

public class MouseFixPremain implements Runnable {
	public static final NilLogger LOGGER = NilLogger.get("MouseFix");

	@Override
	public void run() {
		ModRemapper.setTargetMapping("default");

		// Required for Forge compatibility
		ClassTransformer.register(new ClassReaderTransformer());

		// Fix it!
		ClassTransformer.register(new MouseEventQueueTransformer());
	}
}
