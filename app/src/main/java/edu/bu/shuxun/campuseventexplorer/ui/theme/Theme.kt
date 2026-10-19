package edu.bu.shuxun.campuseventexplorer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFFA32635),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFF6E4E6),
    onPrimaryContainer = Color(0xFF651321),
    background = Color(0xFFFAF8F5),
    onBackground = Color(0xFF242321),
    surface = Color(0xFFFAF8F5),
    onSurface = Color(0xFF242321),
    surfaceVariant = Color(0xFFF0EDE8),
    onSurfaceVariant = Color(0xFF625D58),
    outline = Color(0xFF837C75),
    outlineVariant = Color(0xFFDED8D1)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFFFB2BA),
    onPrimary = Color(0xFF620E20),
    background = Color(0xFF1C1A19),
    onBackground = Color(0xFFECE5DF),
    surface = Color(0xFF1C1A19),
    onSurface = Color(0xFFECE5DF),
    surfaceVariant = Color(0xFF302B28),
    onSurfaceVariant = Color(0xFFCEC3BB),
    outline = Color(0xFF9A8D85),
    outlineVariant = Color(0xFF4C433E)
)

@Composable
fun CampusEventExplorerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = Typography,
        content = content
    )
}