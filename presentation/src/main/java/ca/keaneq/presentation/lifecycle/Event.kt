package ca.keaneq.presentation.lifecycle

open class Event<out T>(private val content: T) {
    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? = content
        .takeIf { !hasBeenHandled }
        ?.also { hasBeenHandled = true }

    fun peekContent(): T = content
}