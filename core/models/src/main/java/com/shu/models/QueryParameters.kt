package com.shu.models

data class QueryParameters(

    var page: Int = 1,
    var pageSize: Int = 20,
    var search: String = "", // Search query.
    var searchPrecise: Boolean = false,  // Disable fuzziness for the search query. Отключите нечеткость(расплывчатость) для поискового запроса.
    var searchExact: Boolean = false,    // Mark the search query as exact Отметьте поисковый запрос как точный.
    var parentPlatforms: String = "1",   // Filter by parent platforms, for example: 1,2,3
    var platforms: String = "1",        // Filter by platforms, for example: 4.5
    var stores: String = "1",           // Filter by stores, for example: 5,6
    var developers: String = "1",        // Filter by developers, for example: 1612,18893 or valve-software,feral-interactive.
    var publishers: String = "1",       // Filter by publishers, for example: 354,20987 or electronic-arts,microsoft-studios.
    var genres: String = "1",            // Filter by genres, for example: 4,51 or action,indie.
    var tags: String = "1",             // Filter by tags, for example: 31,7 or singleplayer,multiplayer.
    var creators: String = "1",          // Filter by creators, for example: 78,28 or cris-velasco,mike-morasky.
    var dates: String = "1",            // Filter by a release date, for example: 2010-01-01,2018-12-31.1960-01-01,1969-12-31.
    var updated: String = "1",           // Filter by an update date, for example: 2020-12-01,2020-12-31.
    var platformsCount: Int = 1,        // Filter by platforms count, for example: 1.
    var metacritic: String = "80",      // Filter by a metacritic rating, for example: 80,100.
    var excludeCollection: Int = 123,    // Exclude games from a particular collection, for example: 123. // Исключить игры из определенной коллекции
    var excludeAdditions: Boolean = false, // Exclude additions.
    var excludeParents: Boolean = false,    // Exclude games which have additions.
    var excludeGameSeries: Boolean = false, // Exclude games which included in a game series.
    var excludeStores: String = "80",        // Exclude stores, for example: 5,6.
    var ordering: String = "80",            // Available fields: name, released, added, created, updated, rating, metacritic. You can reverse the sort order adding a hyphen, for example: -released.

)
