package ca.keaneq.domain.model

/**
 * The current Theme of the app. Currently we have Dark, Light, and System-Default. Currently in
 * Android, System-Default is either light or dark.
 */
enum class Theme {
    Dark,
    Light,
    System,
}