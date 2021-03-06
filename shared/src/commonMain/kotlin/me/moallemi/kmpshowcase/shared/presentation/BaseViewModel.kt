package me.moallemi.kmpshowcase.shared.presentation

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

expect abstract class BaseViewModel(
    viewModelContext: CoroutineContext,
) : CoroutineScope {
    override val coroutineContext: CoroutineContext
}