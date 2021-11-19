package dev.marcocattaneo.androidcomposetemplate.ui.screen.common

import androidx.lifecycle.ViewModel
import dev.marcocattaneo.androidcomposetemplate.navigation.NavigationController
import dev.marcocattaneo.androidcomposetemplate.navigation.routing.NavigableRoute
import dev.marcocattaneo.androidcomposetemplate.navigation.routing.ScreenRoute

abstract class BaseViewModel: ViewModel() {

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

}