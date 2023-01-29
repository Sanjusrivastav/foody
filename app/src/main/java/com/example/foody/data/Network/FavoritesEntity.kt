package com.example.foody.data.Network

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foody.models.ApiResult
import com.example.foody.ui.fragments.Constants.Companion.FAVORITE_RECIPES_TABLE

@Entity(tableName = FAVORITE_RECIPES_TABLE)
 class FavoritesEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result:ApiResult
)