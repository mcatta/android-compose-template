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

package dev.marcocattaneo.androidcomposetemplate.ui.screen.login

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.marcocattaneo.androidcomposetemplate.navigation.routing.generatePath
import dev.marcocattaneo.androidcomposetemplate.ui.screen.Routes
import dev.marcocattaneo.androidcomposetemplate.ui.screen.common.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel() {

    private val mUsernameState = MutableStateFlow("")
    val usernameState: StateFlow<String>
        get() = mUsernameState

    fun onChangeUsername(username: String) {
        mUsernameState.value = username
    }

    fun onClickLogin() = viewModelScope.launch {
        navigateTo(Routes.Dashboard.generatePath(
            "username" to usernameState.value
        ))
    }

}