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

package dev.marcocattaneo.androidcomposetemplate.ui.screen.common

import androidx.lifecycle.ViewModel
import dev.marcocattaneo.androidcomposetemplate.navigation.NavigationController
import dev.marcocattaneo.androidcomposetemplate.navigation.routing.NavigableRoute
import dev.marcocattaneo.androidcomposetemplate.navigation.routing.ScreenRoute

abstract class BaseViewModel : ViewModel() {

    private var mNavigationController: NavigationController? = null

    fun setNavigationController(navigationController: NavigationController) {
        mNavigationController = navigationController
    }

    /**
     * Navigate to the [destinationRoute]
     * @param destinationRoute destination
     */
    suspend fun <T : ScreenRoute> navigateTo(
        destinationRoute: NavigableRoute<T>
    ) = mNavigationController?.navigateTo(
        destinationRoute = destinationRoute
    )
        ?: IllegalStateException("NavigationController is not defined, impossible to navigate to ${destinationRoute.path}")

    /**
     * Navigate back to the [destinationRoute] with the previous route [parentRoute]
     * @param destinationRoute destination route
     * @param parentRoute previous routes
     */
    suspend fun <R : ScreenRoute, PR : ScreenRoute> navigateBackTo(
        destinationRoute: NavigableRoute<R>,
        parentRoute: NavigableRoute<PR>
    ) = mNavigationController?.navigateBackTo(
        destinationRoute = destinationRoute,
        parentRoute = parentRoute
    )
        ?: IllegalStateException("NavigationController is not defined, impossible to navigate to ${destinationRoute.path}")

}