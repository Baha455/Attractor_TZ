package com.example.core.navigatehelper

object NavigationProvider {

    private var handler: GlobalNavigationHandler? = null

    fun registerHandler(handler: GlobalNavigationHandler) {
        this.handler = handler
    }

    fun unregisterHandler() {
        handler = null
    }

    fun launch(navCommand: NavCommand) {
        handler?.launch(navCommand)
    }

    fun logout() {
        handler?.logout()
    }
}

interface GlobalNavigationHandler {
    fun logout()
    fun launch(navCommand: NavCommand)
}