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

package dev.marcocattaneo.androidcomposetemplate.navigation

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import dev.marcocattaneo.androidcomposetemplate.navigation.routing.NavigableRoute
import dev.marcocattaneo.androidcomposetemplate.navigation.routing.ScreenRoute

class NavigationControllerImpl constructor(
    private val navHostController: NavHostController
) : NavigationController {

    override suspend fun <T : ScreenRoute> navigateTo(
        destinationRoute: NavigableRoute<T>
    ) {
        navHostController.safeNavigate(destinationRoute.path) { }
    }

    override suspend fun <R : ScreenRoute, PR : ScreenRoute> navigateBackTo(
        destinationRoute: NavigableRoute<R>,
        parentRoute: NavigableRoute<PR>
    ) {
        navHostController.safeNavigate(destinationRoute.path) {
            popUpTo(parentRoute.path)
        }
    }

    override fun getNavController(): NavHostController = navHostController
}

/**
 * Safe navigation used to handle unsupported routes
 * @param route destination route
 * @param builder NavOptionsBuilder associated to the route
 */
private fun NavController.safeNavigate(route: String, builder: NavOptionsBuilder.() -> Unit) {
    try {
        this.navigate(route, builder)
    } catch (e: IllegalArgumentException) {
        //TODO define your fallback
        e.printStackTrace()
    }
}