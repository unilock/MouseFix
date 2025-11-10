package cc.unilock.thinkdifferent.transformer;

import nilloader.api.lib.mini.MiniTransformer;
import nilloader.api.lib.mini.PatchContext;
import nilloader.api.lib.mini.annotation.Patch;

@Patch.Class("sun.lwawt.macosx.CPlatformWindow")
public class CPlatformWindowTransformer extends MiniTransformer {
	// Resize game window
	@Patch.Method("deliverMoveResizeEvent(IIIIZ)V")
	public void patchDeliverMoveResizeEvent(PatchContext ctx) {
		ctx.search(
				INVOKEVIRTUAL("sun/lwawt/macosx/CPlatformWindow", "flushBuffers", "()V")
		).jumpBefore();

		ctx.add(RETURN());
	}
}
