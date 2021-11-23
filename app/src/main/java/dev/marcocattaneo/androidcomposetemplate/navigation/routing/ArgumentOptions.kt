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

package dev.marcocattaneo.androidcomposetemplate.navigation.routing

import androidx.navigation.NavType

/**
 * Arguments Options specify for the argument keys used on the Screen Routes
 * @param type argument type
 * @param optional true if argument is optional
 */
class ArgumentOptions(
    var type: NavType<*> = NavType.StringType,
    var optional: Boolean = false
)