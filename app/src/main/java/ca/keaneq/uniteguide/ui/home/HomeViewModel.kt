package ca.keaneq.uniteguide.ui.home

import androidx.annotation.IdRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.keaneq.uniteguide.R
import ca.keaneq.uniteguide.lifecycle.Event
import ca.keaneq.uniteguide.ui.model.ListItem
import ca.keaneq.uniteguide.ui.model.ListItemHome

private const val LIST_ITEM_ID_POKEMON = "Menu Item Pokemon"
private const val LIST_ITEM_ID_ITEMS = "Menu Item Items"
private const val LIST_ITEM_ID_ABOUT = "Menu Item About"

class HomeViewModel(
    private val stringGetter: (string: Int) -> String,
) : ViewModel() {

    private val _items = MutableLiveData<List<ListItem>>()
    val items: LiveData<List<ListItem>> = _items

    private val _navigate = MutableLiveData<Event<@IdRes Int>>()
    val navigate: LiveData<Event<Int>> = _navigate

    fun loadItems() {
        _items.postValue(
            listOf(
                ListItemHome(
                    id = LIST_ITEM_ID_POKEMON,
                    title = stringGetter(R.string.title_pokemon),
                    image = R.drawable.ic_pokeball_black,
                    color = R.attr.colorPrimary,
                ),
                ListItemHome(
                    id = LIST_ITEM_ID_ITEMS,
                    title = stringGetter(R.string.title_items),
                    image = R.drawable.ic_dashboard_black_24dp,
                    color = R.attr.colorPrimary,
                ),
                ListItemHome(
                    id = LIST_ITEM_ID_ABOUT,
                    title = stringGetter(R.string.title_about),
                    image = R.drawable.ic_info_black_24dp,
                    color = R.attr.colorSecondary,
                ),
            )
        )
    }

    fun onClick(idEvent: Event<String>) {
        idEvent.getContentIfNotHandled()
            ?.let { id ->
                _items.value?.firstOrNull { item -> item is ListItemHome && item.id == id } as? ListItemHome
            }
            ?.let {
                when (it.id) {
                    LIST_ITEM_ID_POKEMON -> R.id.navigation_pokemon_list
                    LIST_ITEM_ID_ITEMS -> R.id.navigation_items
                    LIST_ITEM_ID_ABOUT -> R.id.navigation_about
                    else -> null
                }
            }
            ?.let { navigationId -> Event(navigationId) }
            ?.let { event -> _navigate.postValue(event) }
    }
}