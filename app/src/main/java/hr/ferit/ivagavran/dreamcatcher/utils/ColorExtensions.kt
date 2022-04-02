package hr.ferit.ivagavran.dreamcatcher.utils

import android.content.res.Resources
import hr.ferit.ivagavran.dreamcatcher.R
import hr.ferit.ivagavran.dreamcatcher.model.DreamColor

fun Resources.getColorResource(color: DreamColor): Int{
    return when(color){
        DreamColor.Red -> R.color.red
        DreamColor.Yellow -> R.color.yellow
        DreamColor.Blue -> R.color.blue
        DreamColor.Black -> R.color.black
        else -> R.color.black
    }
}