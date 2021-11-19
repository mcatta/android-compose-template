package dev.marcocattaneo.androidcomposetemplate.di

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import dagger.hilt.EntryPoints
import dagger.hilt.android.EntryPointAccessors
import dev.marcocattaneo.androidcomposetemplate.di.component.ComposableComponentBuilderEntryPoint

fun Context.getActivity(): Activity = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> throw IllegalStateException("Cannot retrieve a valid Activity from $this")
}

@Composable
inline fun <reified T : Any> rememberComposableEntryPoint(): T {
    val context = LocalContext.current
    return remember {
        val entryPoint = EntryPointAccessors.fromActivity(
            context.getActivity(), ComposableComponentBuilderEntryPoint::class.java
        )
        EntryPoints.get(entryPoint.composableBuilder.build(), T::class.java)
    }
}