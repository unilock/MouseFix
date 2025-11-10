package cc.unilock.thinkdifferent.transformer;

import nilloader.api.lib.mini.MiniTransformer;
import nilloader.api.lib.mini.PatchContext;
import nilloader.api.lib.mini.annotation.Patch;

@Patch.Class("sun.lwawt.macosx.LWCToolkit")
public class LWCToolkitTransformer extends MiniTransformer {
	// Performance
	@Patch.Method("getPlatformWindowUnderMouse()Lsun/lwawt/PlatformWindow;")
	public void patchGetPlatformWindowUnderMouse(PatchContext ctx) {
		ctx.jumpToStart();

		ctx.add(
				ACONST_NULL(),
				ARETURN()
		);
	}
}
