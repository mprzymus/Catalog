package pl.mprzymus.catalog.main_list

import pl.mprzymus.catalog.R

object LikeButtonProvider {
    fun getImage(isFavourite: Boolean): Int {
        return if (isFavourite) {
            R.drawable.like_button
        } else {
            R.drawable.unlike_button
        }
    }
}