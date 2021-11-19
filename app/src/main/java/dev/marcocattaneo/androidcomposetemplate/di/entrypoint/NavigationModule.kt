package dev.marcocattaneo.androidcomposetemplate.di.entrypoint

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dev.marcocattaneo.androidcomposetemplate.di.component.ComposableComponent

@InstallIn(ComposableComponent::class)
@EntryPoint
interface ComposableEntryPoint {

}