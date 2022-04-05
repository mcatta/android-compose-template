/*
 * Copyright 2022 Marco Cattaneo
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
import dev.marcocattaneo.androidcomposetemplate.navigation.routing.NavigableRoute
import dev.marcocattaneo.androidcomposetemplate.navigation.routing.ScreenRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel : ViewModel() {

    private val mNavigationState: MutableStateFlow<NavigableRoute<*>?> = MutableStateFlow(null)
    val navigationState: StateFlow<NavigableRoute<*>?>
        get() = mNavigationState

    /**
     * Navigate to the [destinationRoute]
     * @param destinationRoute destination
     */
    suspend fun <T : ScreenRoute> navigateTo(
        destinationRoute: NavigableRoute<T>
    ) = mNavigationState.emit(destinationRoute)

    /**
     * Navigate back to the [destinationRoute] with the previous route [parentRoute]
     * @param destinationRoute destination route
     * @param parentRoute previous routes
     */
    /*suspend fun <R : ScreenRoute, PR : ScreenRoute> navigateBackTo(
        destinationRoute: NavigableRoute<R>,
        parentRoute: NavigableRoute<PR>
    ) = mNavigationController?.navigateBackTo(
        destinationRoute = destinationRoute,
        parentRoute = parentRoute
    )
        ?: IllegalStateException("NavigationController is not defined, impossible to navigate to ${destinationRoute.path}")*/

}