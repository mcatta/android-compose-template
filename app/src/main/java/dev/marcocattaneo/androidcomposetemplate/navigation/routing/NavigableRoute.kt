package dev.marcocattaneo.androidcomposetemplate.navigation.routing

interface NavigableRoute<R: ScreenRoute> {

    val screenRoute: R

    val path: String

}