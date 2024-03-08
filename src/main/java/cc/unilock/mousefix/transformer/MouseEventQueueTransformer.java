package cc.unilock.mousefix.transformer;

import nilloader.api.lib.mini.MiniTransformer;
import nilloader.api.lib.mini.PatchContext;
import nilloader.api.lib.mini.annotation.Patch;

@Patch.Class("org.lwjgl.opengl.MouseEventQueue")
public class MouseEventQueueTransformer extends MiniTransformer {
	@Patch.Method("handleButton(Ljava/awt/event/MouseEvent;)V")
	public void patchHandleButton(PatchContext ctx) {
		ctx.search(
				INVOKEVIRTUAL("java/awt/event/MouseEvent", "isControlDown", "()Z"),
				PUTFIELD("org/lwjgl/opengl/MouseEventQueue", "saved_control_state", "Z")
		).jumpAfter();

		ctx.add(
				ALOAD(0),
				ICONST_0(),
				PUTFIELD("org/lwjgl/opengl/MouseEventQueue", "saved_control_state", "Z")
		);
	}
}
