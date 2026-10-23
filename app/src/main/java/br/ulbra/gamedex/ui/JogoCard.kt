package br.ulbra.gamedex.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.ulbra.gamedex.model.Jogo
import coil3.compose.AsyncImage

@Composable
fun JogoCard(jogo: Jogo, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(onClick = onClick, modifier = modifier.fillMaxWidth()) {
        Column {
            AsyncImage(
                model = jogo.imagemUrl,
                contentDescription = jogo.titulo,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(460f / 215f),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(jogo.titulo, style = MaterialTheme.typography.titleMedium)
                Text("${jogo.ano} · ${jogo.genero}", style = MaterialTheme.typography.bodySmall)
                Text(
                    "★ ${jogo.nota}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}