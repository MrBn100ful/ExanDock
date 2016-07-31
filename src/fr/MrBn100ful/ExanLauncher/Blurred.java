package fr.MrBn100ful.ExanLauncher;

/**
 *  The Blurred API.
 *  
 * @author MrBn100ful
 * 
 */

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

@SuppressWarnings("serial")
public class Blurred extends JFrame {

	public static interface Dwmapi extends StdCallLibrary {
		Dwmapi INSTANCE = (Dwmapi) Native.loadLibrary("Dwmapi", Dwmapi.class, W32APIOptions.UNICODE_OPTIONS);

		int DWM_BB_ENABLE = 0x00000001;

		boolean DwmEnableBlurBehindWindow(HWND hWnd, DWM_BLURBEHIND pBlurBehind);

		public static class DWM_BLURBEHIND extends Structure {
			public int dwFlags;
			public boolean fEnable;
			public IntByReference hRgnBlur;
			public boolean fTransitionOnMaximized;

			@SuppressWarnings("rawtypes")
			@Override
			protected List getFieldOrder() {
				return Arrays.asList("dwFlags", "fEnable", "hRgnBlur", "fTransitionOnMaximized");
			}
		}
	}

}
