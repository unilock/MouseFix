package cc.unilock.thinkdifferent;

import cc.unilock.thinkdifferent.transformer.CPlatformWindowTransformer;
import cc.unilock.thinkdifferent.transformer.ClassReaderTransformer;
import cc.unilock.thinkdifferent.transformer.LWCToolkitTransformer;
import cc.unilock.thinkdifferent.transformer.MouseEventQueueTransformer;
import nilloader.api.ClassTransformer;
import nilloader.api.ModRemapper;
import nilloader.api.NilLogger;

public class ThinkDifferentPremain implements Runnable {
	public static final NilLogger LOGGER = NilLogger.get("ThinkDifferent");

	@Override
	public void run() {
		ModRemapper.setTargetMapping("default");

		// Required for Forge compatibility
		ClassTransformer.register(new ClassReaderTransformer());

		// Fix it!
		ClassTransformer.register(new CPlatformWindowTransformer());
		ClassTransformer.register(new LWCToolkitTransformer());
		ClassTransformer.register(new MouseEventQueueTransformer());
	}
}
