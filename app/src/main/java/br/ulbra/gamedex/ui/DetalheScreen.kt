package br.ulbra.gamedex.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.ulbra.gamedex.data.JogoRepository
import coil3.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalheScreen(jogoId: Int, onVoltar: () -> Unit) {
    val jogo = JogoRepository.buscarPorId(jogoId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(jogo.titulo) },
                navigationIcon = {
                    IconButton(onClick = onVoltar) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = jogo.imagemUrl,
                contentDescription = jogo.titulo,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(460f / 215f),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(jogo.titulo, style = MaterialTheme.typography.headlineSmall)
                Spacer(Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AssistChip(onClick = { }, label = { Text(jogo.genero) })
                    AssistChip(onClick = { }, label = { Text(jogo.ano.toString()) })
                    Text("★ ${jogo.nota}", color = MaterialTheme.colorScheme.primary)
                }
                Spacer(Modifier.height(16.dp))
                Text("Sobre o jogo", fontWeight = FontWeight.Bold)
                Text(jogo.descricao, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}