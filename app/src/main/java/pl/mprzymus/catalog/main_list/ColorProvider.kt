package pl.mprzymus.catalog.main_list

import android.content.Context
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Resources
import pl.mprzymus.catalog.R

object ColorProvider {
    fun getSecondaryColor(context: Context, resources: Resources): Int {
        return if  (resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES) {
            context.getColor(R.color.dark_color)
        } else {
            context.getColor(R.color.light_color)
        }
    }
}