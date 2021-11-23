/*
 * Copyright 2021 Marco Cattaneo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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