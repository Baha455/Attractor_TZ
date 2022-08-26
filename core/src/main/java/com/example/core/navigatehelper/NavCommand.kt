package com.example.core.navigatehelper

import android.os.Bundle
import androidx.navigation.NavOptions

data class NavCommand(
    val target: NavCommands,
    val navOptions: NavOptions? = null
)