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

package dev.marcocattaneo.androidcomposetemplate.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.marcocattaneo.androidcomposetemplate.navigation.routing.ScreenRoute
import dev.marcocattaneo.androidcomposetemplate.ui.screen.common.BaseViewModel

/**
 * Navigation Component used for the routing
 * @param startRoute starting route
 * @param builder NavGraph
 */
@Composable
internal fun NavigationComponent(
    startRoute: ScreenRoute,
    navigationController: NavigationController,
    builder: NavGraphBuilder.() -> Unit
) {
    NavHost(
        navController = navigationController.getNavController(),
        startDestination = startRoute.routeDefinition.getRoutePath(),
        builder = builder
    )
}

/**
 * Wrapper used to add composable starting from a ScreenRouter
 * @param route screen's route
 * @param content content associated to the route
 */
internal inline fun <reified VM : BaseViewModel> NavGraphBuilder.composable(
    route: ScreenRoute,
    crossinline content: @Composable (NavBackStackEntry, VM) -> Unit
) {
    this.composable(
        route = route.routeDefinition.getRoutePath(),
        arguments = route.routeDefinition.getNavArguments(),
        content = { navBackStackEntry ->
            val viewModel: VM = hiltViewModel()
            content.invoke(
                navBackStackEntry,
                viewModel
            )
        }
    )
}

/**
 * Construct a nested [NavGraph]
 *
 * @param startDestination the starting destination's route for this NavGraph
 * @param route the destination's unique route
 * @param builder the builder used to construct the graph
 *
 * @return the newly constructed nested NavGraph
 */
internal inline fun NavGraphBuilder.navigation(
    startDestination: ScreenRoute,
    route: ScreenRoute,
    builder: NavGraphBuilder.() -> Unit
): Unit = navigation(
    startDestination = startDestination.routeDefinition.getRoutePath(),
    route = route.routeDefinition.getRoutePath(),
    builder = builder
)