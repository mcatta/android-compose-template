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

package dev.marcocattaneo.androidcomposetemplate.ui.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.marcocattaneo.androidcomposetemplate.navigation.NavigationController
import dev.marcocattaneo.androidcomposetemplate.ui.theme.AndroidcomposetemplateTheme

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    controller: NavigationController
) {
    val username by loginViewModel.usernameState.collectAsState()
    val navState by loginViewModel.navigationState.collectAsState()

    LaunchedEffect(navState) {
        navState?.let { controller.navigateTo(it) }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = loginViewModel::onChangeUsername
        )
        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = loginViewModel::onClickLogin) {
            Text(text = "Login")
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    AndroidcomposetemplateTheme {
        TextField(value = "", onValueChange = {})
    }
}