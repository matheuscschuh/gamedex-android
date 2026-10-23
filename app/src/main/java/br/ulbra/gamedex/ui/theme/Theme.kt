package br.ulbra.gamedex.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val GameDexColors = darkColorScheme(
    primary = Verde,
    background = FundoEscuro,
    surface = Superficie,
    surfaceVariant = SuperficieCard,
    surfaceContainerHighest = SuperficieCard,
    onBackground = Texto,
    onSurface = Texto,
    onSurfaceVariant = Texto
)

@Composable
fun GameDexTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = GameDexColors,
        typography = Typography,
        content = content
    )
}