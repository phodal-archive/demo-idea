package com.phodal.startup

import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.extensions.ExtensionPointName
import com.intellij.openapi.fileTypes.FileTypeManager
import com.intellij.util.messages.MessageBus
import org.jetbrains.annotations.NonNls

/** Customize Android IDE specific experience. */
@SuppressWarnings("UtilityClassWithPublicConstructor") // Application component registered in AndroidStudioPlugin.xml
class InitialConfigurator(bus: MessageBus, propertiesComponent: PropertiesComponent, fileTypeManager: FileTypeManager) {
    @NonNls
    private val pointName = ExtensionPointName.create<Runnable>("com.phodal.studioInitializer")

    init {
        activateStudioInitializerExtensions()
    }

    private fun activateStudioInitializerExtensions() {
        for (r in pointName.    extensionList) {
            r.run()
        }
    }
}
