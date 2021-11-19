package dev.marcocattaneo.androidcomposetemplate.ui.screen.login

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.marcocattaneo.androidcomposetemplate.ui.screen.common.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {

}