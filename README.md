
# Android Jetpack Compose Template
[![Android CI](https://github.com/mcatta/android-compose-template/actions/workflows/ci.yml/badge.svg)](https://github.com/mcatta/android-compose-template/actions/workflows/ci.yml) ![Language](https://img.shields.io/github/languages/top/mcatta/android-compose-template?color=green&logo=kotlin)


A template for Android application written with Jetpack Compose

### Documentations
This template is designed to allow developers to create an android project that supports Jetpack Compose. The main goal is to define a pattern to handle the Composable Screen and link them by using [Jetpack Navigation](https://developer.android.com/guide/navigation).

#### Routing
To define a new route you need to put it [here](https://github.com/mcatta/android-compose-template/blob/main/app/src/main/java/dev/marcocattaneo/androidcomposetemplate/ui/screen/Routes.kt) as below:

```kotlin
object Dashboard : ScreenRoute(
   routeDefinition = Definition("dashboard", argumentKeys = listOf(
      "username" to { type = NavType.StringType; optional = false }
   ))
)
```
by adding the route `"dashboard"` and optional parameters in `argumentKeys` . After that you need only to define the Composable Screen that you want to show on this path in the [MainActivity](https://github.com/mcatta/android-compose-template/blob/main/app/src/main/java/dev/marcocattaneo/androidcomposetemplate/MainActivity.kt) :
```kotlin
NavigationComponent(
  startRoute = Routes.Login,
  navigationController = controller
) {
    composable<DashboardViewModel>(
      route = Routes.Dashboard,
      navigationController = controller
    ) { _, vm ->
	  DashboardScreen(vm)
	}  
}
```
and the related ViewModel associated to the screen.

### Features

Status | Feature
:-------------| :-------------|  
:white_check_mark: | Jetpack Compose for UI |  
:white_check_mark: | Jetpack Navigation for Compose for routing/navigation |  
:white_check_mark: | Dagger Hilt for DI |  
:heavy_check_mark: | Improve navigation controller |  
:white_check_mark: | Provide a sample UI |  
:heavy_check_mark: | Documentation |  

### Contributions

Every contributors are welcome. We are using [this convention](https://www.conventionalcommits.org/en/v1.0.0/).

### License
```
Copyright 2021 Marco Cattaneo  
 
Licensed under the Apache License, Version 2.0 (the "License");  
you may not use this file except in compliance with the License.  
You may obtain a copy of the License at  
 
     http://www.apache.org/licenses/LICENSE-2.0  
 
Unless required by applicable law or agreed to in writing, software  
distributed under the License is distributed on an "AS IS" BASIS,  
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
See the License for the specific language governing permissions and  
limitations under the License.
```