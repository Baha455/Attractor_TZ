package com.example.attractor_tz.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.attractor_tz.R
import com.example.core.navigatehelper.GlobalNavigationHandler
import com.example.core.navigatehelper.NavCommand
import com.example.core.navigatehelper.NavCommands
import com.example.core.navigatehelper.NavigationProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), GlobalNavigationHandler {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.container
        ) as NavHostFragment
        navController = navHostFragment.findNavController()

        handleDeeplink()
    }

    private fun handleDeeplink() {
        val uri = intent.data
        if (uri != null)
            openDeepLink(url = uri, isModal = true, isSingleTop = true, null)
    }

    override fun onStart() {
        super.onStart()
        NavigationProvider.registerHandler(this)
    }

    override fun logout() {
    }

    override fun launch(navCommand: NavCommand) {
        when (val target = navCommand.target) {
            is NavCommands.DeepLink -> openDeepLink(
                url = target.url,
                isModal = target.isModal,
                isSingleTop = target.isSingleTop,
                navCommand.navOptions
            )
            is NavCommands.Browser ->
                Toast.makeText(applicationContext, "Не поддерживается", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openDeepLink(
        url: Uri,
        isModal: Boolean,
        isSingleTop: Boolean,
        navOptions: NavOptions?
    ) {
        val options = if (isModal) {
            navOptions
                ?: NavOptions.Builder()
                    .setLaunchSingleTop(isSingleTop)
                    .setPopUpTo(
                        if (isSingleTop) R.id.nav_graph else -1,
                        inclusive = isSingleTop
                    )
                    .build()
        } else {
            navOptions
                ?: NavOptions.Builder()
                    .setLaunchSingleTop(isSingleTop)
                    .setPopUpTo(
                        if (isSingleTop) R.id.nav_graph else -1,
                        inclusive = isSingleTop
                    )
                    .build()
        }

        navController.navigate(url, options)
    }
}