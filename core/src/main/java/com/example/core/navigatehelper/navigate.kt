package com.example.core

import androidx.fragment.app.Fragment
import com.example.core.navigatehelper.GlobalNavigationHandler
import com.example.core.navigatehelper.NavCommand

fun Fragment.navigate(navCommand: NavCommand) {
    (requireActivity() as? GlobalNavigationHandler)?.launch(navCommand)
}