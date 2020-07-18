package icons

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

class StudioIcons {
    private fun StudioIcons() {}

    object Shell {
        private fun load(path: String): Icon {
            return IconLoader.getIcon(path, StudioIcons::class.java)
        }
        object Menu {
            val LOGO: Icon = load("/studio/icons/android.svg")
            val AVD_MANAGER: Icon = load("/studio/icons/shell/menu/avd-manager.svg")
        }
    }
}
