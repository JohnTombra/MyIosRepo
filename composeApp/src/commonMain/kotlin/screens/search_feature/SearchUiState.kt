package screens.search_feature

data class SearchUiState(
    val query: String = "",
    val result: List<String> =  listOf(),
)
