package com.phodal.startup

import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.extensions.ExtensionPointName
import com.intellij.openapi.fileTypes.FileTypeManager
import com.intellij.util.messages.MessageBus
import org.jetbrains.annotations.NonNls

class InitialConfigurator {
    @NonNls
    private val EP_NAME = ExtensionPointName.create<Runnable>("com.phodal.startup.studioInitializer")

    constructor(bus: MessageBus, propertiesComponent: PropertiesComponent, fileTypeManager: FileTypeManager) {
        activateStudioInitializerExtensions();
    }

    private fun activateStudioInitializerExtensions() {
        for (r in EP_NAME.getExtensionList()) {
            r.run()
        }
    }
}
