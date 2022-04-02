package hr.ferit.ivagavran.dreamcatcher.ui.dream_list

import hr.ferit.ivagavran.dreamcatcher.model.Dream

interface OnDreamEventListener{
    fun onDreamLongPress(dream: Dream?): Boolean
}